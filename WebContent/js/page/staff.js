//关于图标工具的配置
// 路径配置
require.config({
    paths: {
		jquery:'/saleSystem/js/lib/jquery-2.1.3.min',
        echarts: '/saleSystem/js'
    }
});

// 使用
require(
    [
     	'jquery',
        'echarts',
        'echarts/chart/bar', // 使用柱状图就加载bar模块，按需加载
        'echarts/chart/line',
    ],
    function ($,ec) {
    	$(function(){
    		// 加载下拉列表
			$(".store-list").click(function(){
				var $this = $(this);
				if($this.html() === ''){
					$.ajax({
						dataType:"json",
						url:'loadstores',
						data:{},
						type:'post',
						success:function(data){
							renderStoreSelect($this,data);
						}
					});
				}
				else
				{
					return ;
				}
			});
				
			var renderStoreSelect = function(current,data){
				var optionHtml = '';
				for(var i=0;i<data.length;i++){
					optionHtml += "<option value="
						+ data[i]["id"] + ">"
						+ data[i]["store_name"]
						+ "</option>";
				}
				
				current.append(optionHtml);
			};
    		
			var renderStaffSelect = function(current,data){
				var optionHtml = '';
				for(var i=0;i<data.length;i++){
					optionHtml += "<option value="
						+ data[i]["id"] + ">"
						+ data[i]["name"]
						+ "</option>";
				}
				
				current.append(optionHtml);
			};
			
			$(".store-list").change(function(){
				var $this = $(this);
				var store_id = $this.val();
				$(".staff-list").empty();
				if(store_id){
					$.ajax({
						dataType:"json",
						url:'loadstaffs',
						data:{store_id:store_id},
						type:'post',
						success:function(data){
							renderStaffSelect($(".staff-list"),data);
						}
					});
				}
			});
    		
			
			$(".statisticsByStaffId").click(function(){
				//参数信息
				var staffId = $(".staff-list").val();
				// 如果queryDate是空就查寻该员工所有的销售记录
				var queryDate = $("input[name='queryDate']").val();
				var containerElement = document.getElementById('main');
				if(!staffId){
					alert("请选择查询员工信息");
					return;
				}
				$.ajax({
					dataType:"json",
					url:'loadStatisticByStaffId',
					data:{
						staffId:staffId,
						queryDate:queryDate
					},
					type:'post',
					success:function(data){
						renderReports(data,containerElement);
					}
				});
			});
			
			
			//  解析返回json数据
			var renderReports = function(data,currentElement){
				var names = new Array(); 
				var datas = new Array();
				for(var i=0;i<data.length;i++){
					names.push(data[i]['product_name']);
					datas.push(data[i]['amount']);
				}
			
				var title = ['员工销量统计'];
				var containerElement = document.getElementById('main');
				
				//渲染
				showImageByBar(containerElement,title,names,datas);
			};
			
			
			// 图标展示销售信息
			var showImageByBar = function(containerElement,title,names,datas){
				 var myChart = ec.init(containerElement);
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
				 
				 var option2 = {
				            tooltip : {
				                trigger: 'axis'
				            },
				            legend: {
				                data:['蒸发量','降水量']
				            },
				            toolbox: {
				                show : true,
				                feature : {
				                    mark : {show: true},
				                    dataView : {show: true, readOnly: false},
				                    magicType : {show: true, type: ['line', 'bar']},
				                    restore : {show: true},
				                    saveAsImage : {show: true}
				                }
				            },
				            calculable : true,
				            xAxis : [
				                {
				                    type : 'category',
				                    data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
				                }
				            ],
				            yAxis : [
				                {
				                    type : 'value',
				                    splitArea : {show : true}
				                }
				            ],
				            series : [
				                {
				                    name:'蒸发量',
				                    type:'bar',
				                    data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
				                },
				                {
				                    name:'降水量',
				                    type:'bar',
				                    data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
				                }
				            ]
				        };
				        
				 
				// 为echarts对象加载数据 
	            myChart.setOption(option2); 
			};
			
			/////////////////////////////////////////////////////////////////
    	});
    }
);