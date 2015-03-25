require( [ 'config' ],
		function() {
			require( [ 'jquery', 'bootstrap', 'echarts/echarts',
					'echarts/chart/bar' ],
					function($, bootstrap, ec, bar) {
						$(function() {

							// 点击加载商店列表信息
							$("input[name='tel']").blur(function() {
								var $current = $("select[name='store_id']");
								if(!$current.data("load")){
									$.ajax( {
										url : "loadStores",
										dataType : 'json',
										type : 'post',
										data : {},
										success : function(data) {
											selectRender($current, data);
											$current.data("load",true);
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

						});
					});
		});