<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="en-us" />
		<meta http-equiv="Pragma" content="no-cache"/>    
  		<meta http-equiv="Cache-Control" content="no-cache" />
  		<meta http-equiv="Expires" content="0"/>
  		<title><decorator:title default="销售统计分析系统"/></title>
  	    <link href="${basePath }/img/girl.ico" rel="shortcut icon"/>
  		<link href="${basePath }/css/bootstrap/bootstrap.min.css" type="text/css" rel="stylesheet"/>
  		<link href="${basePath }/css/bootstrap/example-fluid-layout.css" type="text/css" rel="stylesheet"/>
  		<link href="${basePath }/css/bootstrap/bootstrap-theme.css" type="text/css" rel="stylesheet"/>
  		<link href="${basePath }/css/bootstrap/bootstrap-theme.css.map" type="text/css" rel="stylesheet"/>
  		<link href="${basePath }/css/all.css" type="text/css" rel="stylesheet"/>
  		<link />
		<decorator:head />
	</head>
    <body <decorator:getProperty property="body.class" writeEntireProperty="true" />>
		<decorator:body />													
    </body>
</html>