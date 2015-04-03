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
				var names = []; 
				var amounts = [];
				var prices = [];
				for(var i=0;i<data.length;i++){
					names.push(data[i]['product_name']);
					amounts.push(data[i]['amount']);
					prices.push(data[i]['sell_price']);
				}
			
				var containerElement = document.getElementById('main');
				
				//渲染
				showImageByBar(containerElement,names,amounts,prices);
			};
			
			
			// 图标展示销售信息
			var showImageByBar = function(containerElement,names,amounts,prices){
				 var myChart = ec.init(containerElement);
				 var option = {
				            tooltip : {
				                trigger: 'axis'
				            },
				            legend: {
				                data:['销售量','销售金额']
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
				                    data : names
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
				                    name:'销量',
				                    type:'bar',
				                    data:amounts
				                },
				                {
				                    name:'总价',
				                    type:'bar',
				                    data:prices
				                }
				            ]
				        };
				        
				 
				// 为echarts对象加载数据 
	            myChart.setOption(option); 
			};
			
			/////////////////////////////////////////////////////////////////
    	});
    }
);