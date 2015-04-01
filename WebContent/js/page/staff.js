require(['config'], function(){
	require(['jquery'],function($){
		$(function(){
			// 加载下拉列表
			$(".store-list").click(function(){
				var $this = $(this);
				
				if(!$this.data("show")){
					$.ajax({
						dataType:"json",
						url:'loadstores',
						data:{},
						type:'post',
						success:function(data){
							renderStoreSelect($this,data);
							$this.data("show",true);
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
				
				$.ajax({
					dataType:"json",
					url:'loadstaffs',
					data:{
						staffId:staffId,
						queryDate:queryDate
					},
					type:'post',
					success:function(data){
						renderStaffSelect($(".staff-list"),data);
					}
				});
			});
			
		// 默认document	
		});
	});
});