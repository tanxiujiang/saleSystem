<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Staffs</title>
<script type="text/javascript" src="${basePath}/js/lib/require-2.1.14.js" language="javascript" charset="utf-8" data-main="${basePath}/js/page/home"></script>
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
 			 		Staffs List
 			 		<a class="btn btn-default" href="${basePath}/sale/index" role="button" style="float: right;height: 30px">返回  »</a>	
 			 </div>
				  <table class="table table-hover">
				  	<tr>
				  		<th>序号</th>
				  		<th>姓名</th>
				  		<th>性别</th>
				  		<th>电话</th>
				  		<th>商店</th>
				  		<th>操作</th>
				  	</tr>
				  	<c:forEach items="${staffs}" var="staff" varStatus="status"> 
				  		<tr class="${status.count%2 == 0 ? 'warning' : ''}">
				  			<td>${status.count }</td>
				  			<td>${staff.name}</td>
				  			<td>${staff.sex}</td>
				  			<td>${staff.tel}</td>
				  			<td>国美电器</td>
				  			<td>
				  				<a href="javascript:void(0)" class="shutDownStaff" value="${staff.id}">解雇</a>
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
		
		<div id="main" style="height:400px;width: 600px"></div>
</body>
</html>