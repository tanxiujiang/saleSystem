<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加产品</title>
</head>
<body>
	<div class="panel panel-default">
   		<div class="panel-body">
   			<strong>Add product</strong>
   			<h4 style="float: right;color: red;">${msg}</h4>
   		</div>
		   <div class="panel-footer">
		   		<form class="form-horizontal" role="form" action="${basePath}/admin/addproduct" method="post">
					   <div class="form-group">
					      <label for="lastname" class="col-sm-2 control-label">名称:</label>
					      <div class="col-sm-8">
					         <input type="text" class="form-control" name="product_name" value="${product.product_name }">
					      </div>
					   </div>
					   <div class="form-group">
					      <label for="lastname" class="col-sm-2 control-label">进价:</label>
					      <div class="col-sm-8">
					         <input type="text" class="form-control"  name="factory_price" value="${product.factory_price }">
					      </div>
					   </div>
					   
					   <div class="form-group">
					      <label for="lastname" class="col-sm-2 control-label">售价:</label>
					      <div class="col-sm-8">
					         <input type="text" class="form-control" name="sell_price" value="${product.sell_price }">
					      </div>
					   </div>
					   
					   <div class="form-group">
					      <label for="lastname" class="col-sm-2 control-label">库存:</label>
					      <div class="col-sm-8">
					         <input type="text" class="form-control" name="total_amount" value="${product.total_amount }">
					      </div>
					   </div>
					   
					   <div class="form-group">
					      <label for="lastname" class="col-sm-2 control-label">产品详细:</label>
					      <div class="col-sm-8">
					         <textarea rows="5" class="textarea" name="introduction" >
					         	${product.introduction }
					         </textarea>
					      </div>
					   </div>
					   
					   <div class="form-group">
					      <div class="col-sm-offset-2 col-sm-10">
					         <button type="submit" class="btn btn-default">添加</button>
					         <a class="btn btn-default" href="${basePath}/sale/index" role="button">返回  »</a>
					      </div>
					   </div>
				</form>
		   </div>
</div>
</body>
</html>