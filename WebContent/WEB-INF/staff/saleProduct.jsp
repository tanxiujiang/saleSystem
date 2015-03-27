<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出售产品</title>
<script type="text/javascript" src="${basePath}/js/lib/require-2.1.14.js" language="javascript" charset="utf-8" data-main="${basePath}/js/page/saleProduct"></script>
</head>
<body>
	<div class="well well-lg" style="height: 600px;margin-left: 50px;margin-right: 50px;">
			<div class="row">
				<form action="queryproduct" method="post">
					  <div class="col-lg-4">
					    <div class="input-group">
						      <input type="text" class="form-control" placeholder="Search for..." name="id">
						      <span class="input-group-btn">
						        <button class="btn btn-default" type="submit"">Go!</button>
						      </span>
					    </div>
					  </div>
				  </form>
			</div>
			<c:if test="${not empty product}">
				<table class="table" style="width: 60%">
					<tr>
						<th>商品名称</th>
						<th>库存</th>
						<th>售价</th>
						<th>购买数量</th>
						<th>操作</th>
					</tr>
				
					<tr>
						<td>${product.product_name }</td>
						<td>${product.remain_amount }</td>
						<td>${product.sell_price }</td>
						<td>
							<form class="hiden">
								<input type="hidden" value="${product.id}" name="id">
								<input type="hidden" value="${product.product_name}" name="product_name">
								<input type="hidden" value="${product.sell_price}" name=sell_price>
								<input type="text" class="qty" name="qty">
							</form>
						</td>
						<td><a href="javascript:void(0)" class="buyProduct">购买</a></td>
					</tr>
				</table>
			</c:if>
	</div>
</body>
</html>