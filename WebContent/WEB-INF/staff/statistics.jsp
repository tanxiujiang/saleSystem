<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计分析</title>
<script type="text/javascript" src="${basePath}/js/lib/require-2.1.14.js" language="javascript" charset="utf-8" data-main="${basePath}/js/page/statistics"></script>
</head>
<body>
	<div class="container" style="height: 500px">
		<ul class="nav nav-tabs">
		  <li role="presentation"><a href="javascript:void(0)" class="staffs">staffs</a></li>
		  <li role="presentation"><a href="javascript:void(0)" class="products">products</a></li>
		  <li role="presentation"><a href="${basePath}/sale/index">Home</a></li>
		</ul>
		<iframe src="#" id="showContent" style="width: 100%;height: 100%;border: 0px"></iframe>
	</div>
</body>
</html>