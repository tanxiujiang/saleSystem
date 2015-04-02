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
    		var myChart = ec.init(document.getElementById('main'));
            
            optionNumber = {
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
            	        data:['U盘(小米)','红米(2)','红米(note)','小米(3)','小米(4)']
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
            	            data:[
            	                {value:100, name:'U盘(小米)'},
            	                {value:300, name:'红米(2)'},
            	                {value:350, name:'红米(note)'},
            	                {value:60, name:'小米(3)'},
            	                {value:40, name:'小米(4)'}
            	            ]
            	        }
            	    ]
            	};
            	   
            optionPrice = {
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
            	        data:['U盘(小米)','红米(2)','红米(note)','小米(3)','小米(4)']
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
            	            data:[
            	                {value:880, name:'U盘(小米)'},
            	                {value:1500, name:'红米(2)'},
            	                {value:6000, name:'红米(note)'},
            	                {value:4561, name:'小米(3)'},
            	                {value:8624, name:'小米(4)'}
            	            ]
            	        }
            	    ]
            	};
            
    			 // 为echarts对象加载数据 
                myChart.setOption(optionNumber); 
                
               var ecConfig = require('echarts/config');
                // 添加事件
               var changeShow = function (){
            	   if(myChart.getOption().title.text == '商品销售数量(台)'){
            		   myChart.setOption(optionPrice); 
            	   }
            	   else
        		   {
            		   myChart.setOption(optionNumber); 
        		   }
                };
                
                myChart.on(ecConfig.EVENT.CLICK, changeShow);
			/////////////////////////////////////////////////////////////////
    	});
    }
);
