<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Staff</title>
<script type="text/javascript" src="${basePath}/js/lib/require-2.1.14.js" language="javascript" charset="utf-8" data-main="${basePath}/js/page/home"></script>
</head>
<body>
	<div class="panel panel-default">
   		<div class="panel-body">
   			<strong>Add Staff</strong>
   			<h4 style="float: right;color: red;">${msg}</h4>
   		</div>
		   <div class="panel-footer">
		   		<form class="form-horizontal" role="form" action="${basePath}/admin/addstaff" method="post">
					   <div class="form-group">
					      <label for="lastname" class="col-sm-2 control-label">姓名:</label>
					      <div class="col-sm-8">
					         <input type="text" class="form-control" name="name" value="${staff.name }">
					      </div>
					   </div>
					   <div class="form-group">
					      <label for="lastname" class="col-sm-2 control-label">性别:</label>
					      <div class="col-sm-8">
					         <input type="radio"  name="sex" ${staff.sex eq '男' ? 'checked':''} value="男">男
					         　　　　　
					         <input type="radio"  name="sex" ${staff.sex eq '女' ? 'checked':''}>女
					      </div>
					   </div>
					   
					   <div class="form-group">
					      <label for="lastname" class="col-sm-2 control-label">电话:</label>
					      <div class="col-sm-8">
					         <input type="text" class="form-control" name="tel" value="${staff.tel }">
					      </div>
					   </div>
					   
					   <div class="form-group">
					      <label for="lastname" class="col-sm-2 control-label">分配商店:</label>
					      <div class="col-sm-8">
					         <select name="store_id" class="form-control"></select>
					      </div>
					   </div>
					   
					   <div class="form-group">
					      <label for="lastname" class="col-sm-2 control-label">职工介绍:</label>
					      <div class="col-sm-8">
					         <textarea rows="5" class="textarea" name="introduction" >
					         	${staff.introduction }
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