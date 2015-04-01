require(['config'], function(){
	require(['jquery'],function($){
		$(function(){
			//默认加载
			$("#showContent").attr("src","showstaffs");
			
			//点击加载
			$(".products").click(function(){
				$("#showContent").attr("src","showproducts");
				
			});
			
			// 点击切换
			$(".staffs").click(function(){
				$("#showContent").attr("src","showstaffs");
			});
			
			
		});
		
		/////////////////////////////////////////////
	});
});