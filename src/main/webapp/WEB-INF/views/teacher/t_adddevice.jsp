<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/lib/bootstrap-reset.css"  rel="stylesheet" />
<link href="styles/publishinfo.css" rel="stylesheet"/>
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
    <div class="row">
        <div class="sidebar col-sm-3 col-md-2">
			<ul class="nav nav-sidebar">
				<li><a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a></li>
				<li><a href="tch-info"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
				<li><a href="tch-course"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>实训课程</a></li>
				<li><a href="teacher-weekly-report"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>工作实习</a></li>
				<li><a href="teacher-graduation-weekly-report"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>毕业设计</a></li>
				<li class="active"><a href="tch-equipment"><span class="glyphicon glyphicon-hdd" aria-hidden="true"></span>设备管理</a></li>
			</ul>
			<ul class="nav nav-sidebar reset-pwd-ul">
				<li><a href="reset"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码</a></li>
			</ul>
        </div>   
    </div>
    
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 mymain">
    		<div class="row">
                <div class="col-sm-12">             	
                    <div class="panel panel-default">
                    	<div class="panel-heading">
                    		<h3 class="panel-title">设备 Device</h3>
                    	</div>
                    	<div class="panel-body">     		
                             	<div class="form">
                             		<form class="cmxform form-horizontal tasi-form" id="commentForm" action="tch-addEquipment" method="post" >
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">设备编号</label>
                             				<div class="col-lg-10">
                             					<input name="eno" class="form-control" id="did" type="text" aria-required="true"/>
                             				</div>
                             			</div>
                             			<!--  <div class="form-group">
                             				<label class="control-label col-lg-2">老师</label>
                             				<div class="col-lg-10">
                             					<input name="cteacher" class="form-control" id="cteacher" type="text" aria-required="true"/>
                             				</div>
                             			</div>-->
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">设备名称</label>
                             				<div class="col-lg-10">
                             					<input name="ename" class="form-control" id="dname" type="text" aria-required="true"/>
                             				</div>
                             			</div>                            			
                             			
                             			            			
                             			<div class="form-group">
                             				
                             				<div class="col-lg-offset-2 col-lg-10">
                             					<button type="submit" class="btn btn-success">添加</button>
                             					<button type="button" class="btn btn-default">取消</button>
                             				</div>
                             			</div>
                             			
                             		
                             		</form>                   	
                    				     
	                 				
                   				</div>
                   			</div>
                    	</div>
               		</div>
        		</div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>