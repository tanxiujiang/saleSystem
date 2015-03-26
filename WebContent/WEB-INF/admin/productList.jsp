<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>products</title>
<script type="text/javascript" src="${basePath}/js/lib/require-2.1.14.js" language="javascript" charset="utf-8" data-main="${basePath}/js/page/home"></script>
<link href="${basePath }/css/bootstrap/bootstrap-combined.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>
		<div style="height: 45px;">
	         <form class="form-search" style="float: right;margin-right: 30px">
	            <input type="text" class="span2 search-query" style="height: 30px;width: 200px;">
	           <button type="submit" class="btn">查找</button>
	         </form>
         </div>
		<div class="panel panel-default">
 			 <div class="panel-heading">
 			 	Products List
 			 	<a class="btn btn-default" href="${basePath}/sale/index" role="button" style="float: right;height: 30px">返回  »</a>	
 			 </div>
				  <table class="table table-hover">
				  	<tr>
				  		<th>序号</th>
				  		<th>产品名称</th>
				  		<th>进价</th>
				  		<th>售价</th>
				  		<th>库存</th>
				  		<th>操作</th>
				  	</tr>
				  	<c:forEach items="${products}" var="product" varStatus="status"> 
					  		<tr class="${status.count%2 == 0 ? 'warning' : ''}">
					  			<td>${status.count }</td>
					  			<td>${product.product_name}</td>
					  			<td>${product.factory_price}</td>
					  			<td>${product.sell_price}</td>
					  			<td>${product.remain_amount}</td>
					  			<td>
					  				<a href="#">下架</a>
					  			</td>
					  		</tr>
				  	</c:forEach>
				  </table>
				  
				  <nav>
					  <ul class="pagination">
					    <li>
					      <a href="#" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
					    <li><a href="#">1</a></li>
					    <li><a href="#">2</a></li>
					    <li><a href="#">3</a></li>
					    <li><a href="#">4</a></li>
					    <li><a href="#">5</a></li>
					    <li>
					      <a href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					  </ul>
				</nav>
		</div>
</body>
</html>