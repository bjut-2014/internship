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
				<li><a href="publishInfo"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>发布信息</a></li>
				<li><a href="admin-course"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>实训课程</a></li>
				<li><a href="graduation-pro-sele"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>毕业设计</a></li>
				<li><a href="internship-detail"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>工作实习</a></li>
				<li><a href="admin-equipment"><span class="glyphicon glyphicon-hdd" aria-hidden="true"></span>设备管理</a></li>
				<li><a href="student"><span class="glyphicon glyphicon-tags" aria-hidden="true"></span>学生管理</a></li>
				<li class="active"><a href="admin-teacher"><span class="glyphicon glyphicon-bookmark" aria-hidden="true"></span>教师管理</a></li>
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
                    		<h3 class="panel-title">老师管理 Teacher Manage</h3>
                    	</div>
                    	<div class="panel-body">     		
                             	<div class="form">
                             		<form class="cmxform form-horizontal tasi-form" id="commentForm" action="admin-add-teacher" method="post" >
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">工号</label>
                             				<div class="col-lg-10">
                             					<input name="tno" class="form-control" id="tno" type="text" aria-required="true"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">老师姓名</label>
                             				<div class="col-lg-10">
                             					<input name="tname" class="form-control" id="tname" type="text" aria-required="true"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">性别</label>
                             				<div class="col-lg-10">
                             					<select name="tsex" class="form-control" id="tsex"  aria-required="true" >
                             						<option>男</option>
                             						<option>女</option>
                             					</select>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">联系电话</label>
                             				<div class="col-lg-10">
                             					<input name="tphone" class="form-control" id="tphone" type="text" aria-required="true"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">电子邮件</label>
                             				<div class="col-lg-10">
                             					<input name="temail" class="form-control" id="temail" type="text" aria-required="true"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">方向</label>
                             				<div class="col-lg-10">
                             					<input name="tmajor" class="form-control" id="tmajor" type="text" aria-required="true"/>
                             				</div>
                             			</div>
                             			
                             			<div class="form-group">
                             				
                             				<div class="col-lg-offset-2 col-lg-10">
                             					<button type="submit" class="btn btn-success">保存</button>
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