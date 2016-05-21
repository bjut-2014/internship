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
				<li class="active"><a href="publishInfo"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>发布信息</a></li>
				<li><a href="admin-course"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>实训课程</a></li>
				<li><a href="graduation-pro-sele"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>毕业设计</a></li>
				<li><a href="internship-detail"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>工作实习</a></li>
				<li><a href="student"><span class="glyphicon glyphicon-tags" aria-hidden="true"></span>学生管理</a></li>
				<li><a href="admin-teacher"><span class="glyphicon glyphicon-bookmark" aria-hidden="true"></span>教师管理</a></li>
				<li><a href="admin-equipment"><span class="glyphicon glyphicon-hdd" aria-hidden="true"></span>设备管理</a></li>
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
                    		<h3 class="panel-title">招聘信息</h3>
                    	</div>
                    	<div class="panel-body">     		
                             	<div class="form">
                             		<form class="cmxform form-horizontal tasi-form" id="commentForm" action="addRecruitInfo" method="post" >
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">标题</label>
                             				<div class="col-lg-10">
                             					<input name="recruitInfoTitle" class="form-control" id="rtitle" type="text" aria-required="true"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">内容</label>
                             				<div class="col-lg-10">
                             					<textarea name="recruitInfoContent" class="form-control" id="rcontent"  aria-required="true"></textarea>
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