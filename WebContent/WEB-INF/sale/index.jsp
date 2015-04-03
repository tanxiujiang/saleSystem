<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>销售统计分析系统</title>
<script type="text/javascript" src="${basePath}/js/lib/require-2.1.14.js" language="javascript" charset="utf-8" data-main="${basePath}/js/page/home"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index">销售统计分析系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form class="navbar-form navbar-right" action="${basePath}/admin/login" method="post">
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control" name="email">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control" name="pwd">
            </div>
            <button type="submit" class="btn btn-success">登陆</button>
            <c:if test="${not empty staff }">
            	<span style="color: red;">欢迎你：${staff.name}</span>
            </c:if>
          </form>
        </div>
      </div>
    </nav>
    
    <div class="jumbotron">
      <div class="container">
        <h3><strong>销售统计分析系统</strong></h3>
        <p class="text-indent: 5em;">
        	随着世界经济与商务模式的发展与变革，销售统计分析概念被应用到现实的企业交易中，通过网络通信技术，实现企业的电子商务模式，对企业的经济业务具有着重要的价值，
        	能够有效地提高企业交易的效率，增强企业的竞争力，并降低企业的运营成本。同时，销售数据分析成了一个值得高度重视的话题。销售统计分析系统就是将销售的数据进行挖掘,
        	将其有用的信息展示出来给销售的主管做参考，以此为依据对销售的进货，以及是否盈利进行评估。用更直观的图形展示代替冗余大数量的数据。既节省了时间，又更清晰准确。
        	它不仅能够方便地进行图形分析和表格处理，其更强大的功能还体现在数据的统计分析研究方面。电子商务运营商方便控制库存、实现网络交易，
                                随时随地进行电子商务交易信息化，为领导经营决策提供科学依据，让金融企业在合理降低经营成本、加快资金周转等方面取得进步,使金融企业的竞争力增强。
		</p>
<!--        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more »</a></p>-->
      </div>
    </div>
    
    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
		<!--      职工-->
      <c:if test="${not empty staff && staff.role == 0 }">
				 <div class="col-md-4">
			          <h2>出售</h2>
			          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
			          <p><a class="btn btn-default" href="${basePath}/staff/salepage" role="button">Go to page »</a></p>
       			 </div>
		        <div class="col-md-4">
		          <h2>统计查询</h2>
		          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
		          <p><a class="btn btn-default" href="${basePath}/staff/statistics" role="button">Go to page »</a></p>
		        </div>		
      </c:if>
      
      <!--      	管理员-->
      <c:if test="${not empty staff && staff.role == 2 }">
      			 <div class="col-md-6">
			          <h2>添加商品</h2>
			          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.</p>
			          <p><a class="btn btn-default" href="${basePath}/admin/goproduct" role="button">Go to page »</a></p>
		        </div>
		        <div class="col-md-6">
			          <h2>添加职工</h2>
			          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
			          <p><a class="btn btn-default" href="${basePath}/admin/gostaff" role="button">Go to page »</a></p>
		       </div>
		        <div class="col-md-6">
			          <h2>商品查询</h2>
			          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
			          <p><a class="btn btn-default" href="${basePath}/admin/productlist" role="button">Go to page »</a></p>
		        </div>
		        <div class="col-md-6">
			          <h2>职工查询</h2>
			          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
			          <p><a class="btn btn-default" href="${basePath}/admin/stafflist" role="button">Go to page »</a></p>
		        </div>
		         <div class="col-md-6">
			          <h2>出售</h2>
			          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
			          <p><a class="btn btn-default" href="${basePath}/staff/salepage" role="button">Go to page »</a></p>
       			 </div>
		        <div class="col-md-6">
		          <h2>统计查询</h2>
		          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
		          <p><a class="btn btn-default" href="${basePath}/staff/statistics" role="button">Go to page »</a></p>
		        </div>	
     	 </c:if>
      </div>
      <hr>
      <footer>
        <p>© 四川成都信息工程大学(航空港校区)</p>
      </footer>
    </div>
</html>