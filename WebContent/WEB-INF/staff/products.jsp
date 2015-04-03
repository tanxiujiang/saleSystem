<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="${basePath}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}/js/echarts.js" language="javascript" charset="utf-8"></script>
<script language="javascript" type="text/javascript" src="${basePath}/js/page/product.js"></script>
<title>产品统计</title>
</head>
<body>
	<form class="navbar-form navbar-left" role="search">
		<div class="form-group">
	    	<input type="text" class="form-control" placeholder="Search" onClick="WdatePicker({dateFmt:'yyyy-MM',minDate:'2014-12',maxDate:'%y-%M'})" name="queryDate">
	 	</div>
	  <button type="button"" class="btn btn-default productStatisticsByMonth">查询</button>
	</form>
	
	<div id="main" style="height:600px;width: 1100px;margin-top: 45px"></div>
</body>
</html>