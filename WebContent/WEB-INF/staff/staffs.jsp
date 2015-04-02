<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>职工统计</title>
<script language="javascript" type="text/javascript" src="${basePath}/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}/js/echarts.js" language="javascript" charset="utf-8"></script>
<script type="text/javascript" src="${basePath}/js/page/staff.js" language="javascript" charset="utf-8"></script>
</head>
<body>
	<form class="navbar-form navbar-left" role="search">
		<div class="form-group">
			<select class="form-control store-list" style="width: 120px"></select>
			<select class="form-control staff-list" style="width: 120px"></select>
	    	<input type="text" class="form-control" placeholder="Search" onClick="WdatePicker({dateFmt:'yyyy-M',minDate:'2014-12',maxDate:'%y-%M'})" name="queryDate">
	 	</div>
	  <button type="button" class="btn btn-default statisticsByStaffId">统计查询</button>
	</form>
	
	<div id="main" style="height:600px;width: 1100px;margin-top: 45px"></div>
</body>
</html>