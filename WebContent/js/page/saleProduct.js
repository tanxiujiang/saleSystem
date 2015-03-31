require(['config'],function() {
	require(['jquery'],function($){
		$(function(){
			// 针对数量数量的一个简单验证
			$(".qty").blur(function(){
				var $this = $(this);
				var amount = parseInt($this.val());
				var remainAmount = parseInt($this.parent().parent().parent().children("td").eq(1).text());
				if(amount > remainAmount){
					alert("购买数量必须小于等于"+remainAmount);
				}
				
				if(amount <= 0){
					alert("购买数量必须大于0");
				}
			});
			
			// 点击卖出产品
			$(".buyProduct").click(function(){
				var data = $("form.hiden").serialize();
				$.ajax({
					url : "buyproduct",
					dataType : 'text',
					type : 'post',
					data : data,
					success:function(data){
						if(data == "login"){
							window.location.href="/saleSystem/sale/index";
						}
						else
						{
							alert(data);
						}
					}
				});
				
			});
		});
		
		/////
	});
});