//关于图标工具的配置
// 路径配置
require.config({
    paths: {
		jquery:'/saleSystem/js/lib/jquery-2.1.3.min',
		echarts: '/saleSystem/js'
    }
});


//使用
require(
    [
     	'jquery',
        'echarts',
        'echarts/chart/bar',
        'echarts/chart/line',
        'echarts/chart/map',
        'echarts/chart/pie',
        'echarts/chart/funnel',
    ],
    function ($,ec) {
    	$(function(){
    		
    		// 显示
    		var showChart = function(names,amounts,prices){
    			var myChart = ec.init(document.getElementById('main'));
    			var option = switchOption('optionNumber',names,amounts,prices);
    			
    			// 为echarts对象加载数据 
                myChart.setOption(option); 
                 
               var ecConfig = require('echarts/config');
               // 添加事件
              var changeShow = function (){
	           	   if(myChart.getOption().title.text == '商品销售数量(台)'){
	           		   var optionPrice = switchOption('optionPrice',names,amounts,prices);
	           		   myChart.setOption(optionPrice); 
	           	   }
	           	   else
	       		   {
	           		   var optionNumber = switchOption('optionNumber',names,amounts,prices);
	           		   myChart.setOption(optionNumber); 
	       		   }
	           	   
               };
               
               myChart.on(ecConfig.EVENT.CLICK, changeShow);
                 
    		};
    		
    		//　参数对象构建
    		var switchOption = function(whichName,names,amounts,prices){
    			if(whichName == 'optionNumber'){
	    				var optionNumber = {
	                    	    title : {
	            	        text: '商品销售数量(台)',
	            	        subtext: '官方数据',
	            	        x:'center'
	            	    },
	            	    tooltip : {
	            	        trigger: 'item',
	            	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	            	    },
	            	    legend: {
	            	        orient : 'vertical',
	            	        x : 'left',
	            	        data:names
	            	    },
	            	    toolbox: {
	            	        show : true,
	            	        feature : {
	            	            mark : {show: true},
	            	            dataView : {show: true, readOnly: false},
	            	            magicType : {
	            	                show: true, 
	            	                type: ['pie', 'funnel'],
	            	                option: {
	            	                    funnel: {
	            	                        x: '25%',
	            	                        width: '50%',
	            	                        funnelAlign: 'left',
	            	                        max: 1548
	            	                    }
	            	                }
	            	            },
	            	            restore : {show: true},
	            	            saveAsImage : {show: true}
	            	        }
	            	    },
	            	    calculable : true,
	            	    series : [
	            	        {
	            	            name:'点击切换',
	            	            type:'pie',
	            	            radius : '55%',
	            	            center: ['50%', '60%'],
	            	            data:amounts
	            	        }
	            	    ]
	            	};	
	    				
	    		return optionNumber;
    			}
    			else
				{
    				var optionPrice = {
    	            	    title : {
            	        text: '商品销售总价(元)',
            	        subtext: '官方数据',
            	        x:'center'
            	    },
            	    tooltip : {
            	        trigger: 'item',
            	        formatter: "{a} <br/>{b} : {c} ({d}%)"
            	    },
            	    legend: {
            	        orient : 'vertical',
            	        x : 'left',
            	        data:names
            	    },
            	    toolbox: {
            	        show : true,
            	        feature : {
            	            mark : {show: true},
            	            dataView : {show: true, readOnly: false},
            	            magicType : {
            	                show: true, 
            	                type: ['pie', 'funnel'],
            	                option: {
            	                    funnel: {
            	                        x: '25%',
            	                        width: '50%',
            	                        funnelAlign: 'left',
            	                        max: 1548
            	                    }
            	                }
            	            },
            	            restore : {show: true},
            	            saveAsImage : {show: true}
            	        }
            	    },
            	    calculable : true,
            	    series : [
            	        {
            	            name:'点击切换',
            	            type:'pie',
            	            radius : '55%',
            	            center: ['50%', '60%'],
            	            data:prices
            	        }
            	    ]
    				};
    				
    			return optionPrice;
				}
    		};
            
                // 点击查询事件
                
                $(".productStatisticsByMonth").click(function(){
                	var $this = $(this);
                	var queryDate = $("input[name='queryDate']").val();
                	if(!queryDate){
                		alert('请输入查询月份');
                		return;
                	}
                	$.ajax({
                		type:'post',
                		dataType:'json',
                		url:'loadProductStatisticsByMonth',
                		data:{queryDate:queryDate},
                		success:function(data){
                			assemblyData(data);
                		}
                	});
                });
                
                var assemblyData = function(data){
                	var names = [];
                	var amounts = [];
                	var prices = [];
                	for ( var i = 0; i < data.length; i++) {
                		names.push(data[i]['product_name']);
                		var amount  =
                	     {
                	         value : data[i]['amount'],
                	         name : data[i]['product_name']
                	     };
                		amounts.push(amount);
                		
                		var price ={
                			value:data[i]['sell_price'],
                			name : data[i]['product_name']
                		};
                		prices.push(price);
					}
                	
                	showChart(names,amounts,prices);
                };
                
                
			/////////////////////////////////////////////////////////////////
    	});
    }
);
