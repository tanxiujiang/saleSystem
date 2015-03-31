require(['config'], function(){
	require(['jquery'],function($){
		$(".products").click(function(){
			$("#showContent").attr("src","showproducts");
		});
		
		
		
		
		$(".staffs").click(function(){
			$("#showContent").attr("src","showstaffs");
		});
		
		/////////////////////////////////////////////
	});
});