 require(['config'],function() {
			require(['jquery', 'bootstrap'],function($) {
						$(function() {
							
							// 产品下架
							$(".shutDownProduct").click(function(){
								var $this = $(this);
								var id = $this.attr("value");
								$.ajax({
									type:'post',
									dataType:'text',
									url:'deleteProduct',
									data:{id:id},
									success:function(data){
										alert(data);
										if(data == 'success'){
											
											// 移除当前元素
											$this.closest("tr").remove();
										}
										
									}
									
								});
							});
							
							// 解雇职工
							$(".shutDownStaff").click(function(){
								var $this = $(this);
								var id = $this.attr("value");
								$.ajax({
									type:'post',
									dataType:'text',
									url:'deleteStaff',
									data:{id:id},
									success:function(data){
										alert(data);
										if(data == 'success'){
											
											// 移除当前元素
											$this.closest("tr").remove();
										}
										
									}
								});
							});
							
							
							//////////////////////////////////////////////////////////////////////////////////	
						});
					});
		});