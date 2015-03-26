require(['config'],function() {
			require(['jquery', 'bootstrap', 'echarts/echarts','echarts/chart/bar' ],function($, bootstrap, ec, bar) {
						$(function() {
							// 点击加载商店列表信息
							$("input[name='tel']").blur(function() {
								var $current = $("select[name='store_id']");
								if (!$current.data("load")) {
									$.ajax( {
										url : "loadStores",
										dataType : 'json',
										type : 'post',
										data : {},
										success : function(data) {
											selectRender($current, data);
											$current.data("load", true);
										}
									});
								}
							});

							// 显示商店下拉列表
							var selectRender = function(current, data) {
								var optionHtml;
								for ( var i = 0; i < data.length; i++) {

									optionHtml += "<option value="
											+ data[i]["id"] + ">"
											+ data[i]["store_name"]
											+ "</option>";
								}
								current.append(optionHtml);
							};

							/**
							 * 加载员工销售产品信息
							 */
							$(".loadPerformanceByStaffId").click(function() {
								var currentElement = $(this);
								var id = $(this).attr("value");
								
								$.ajax( {
									url : "loadPerformanceByStaffId",
									dataType : 'json',
									type : 'post',
									data : {
										staffId : id
									},
									success : function(data) {
										renderReports(data,currentElement);
									}
								});
							});

							// 展示职工销售图表
							var renderReports = function(data,currentElement) {
								var names = new Array(); 
								var datas = new Array();
								for ( var i = 0; i < data.length; i++) {
									var products = data[i]["products"];
									for(var j = 0;j<products.length;j++){
										names.push(products[j]["product_name"]);
										datas.push(products[j]["group_amount"]);
									}
								}
								
								var title = new Array();
								title.push('销售业绩');
								var containerElement = document.getElementById('main');
								
								// 判断是否隐藏
								if(!$(containerElement).is(":visible")){
									$(containerElement).show();
								}
								
								var position = currentElement.position();
								$(containerElement).css("position","absolute");
								$(containerElement).css("left",position.left - 920);
								$(containerElement).css("top",position.top - 100);
								
								renderByHistogram(containerElement,title,names,datas);
							};

							// 柱状图
							var renderByHistogram  = function(containerElement,title,names,datas){
								var myChart = ec.init(containerElement); 
								// 参数设置
								 var option = {
						                    tooltip: {
						                        show: true
						                    },
						                    legend: {
						                        data:['销量']
						                    },
						                    xAxis : [
						                        {
						                            type : 'category',
						                            data : names
						                        }
						                    ],
						                    yAxis : [
						                        {
						                            type : 'value'
						                        }
						                    ],
						                    series : [
						                        {
						                            "name":"销量",
						                            "type":"bar",
						                            "data":datas
						                        }
						                    ]
						                };
								  
								  	// 为echarts对象加载数据 
								  myChart.setOption(option); 
							};
							
							
							//双击隐藏弹出层div
							$("#main").dblclick(function(){
								$(this).hide();
							});
			               
					// ////////////////////////////////////////////////////////////////////////////////	
						});
					});
		});