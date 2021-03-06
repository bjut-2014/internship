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
            <jsp:include page="../sidebar/sidebar-admin.jsp" />
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
                             		<form class="cmxform form-horizontal tasi-form" id="commentForm" action="admin-update-teacher" method="post" >
                             			<input type="hidden" name="teacherId" value="<s:property value="#request.teacher.teacherId" />">
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">工号</label>
                             				<div class="col-lg-10">
                             					<input name="tno" class="form-control" id="tno" type="text" aria-required="true" value="<s:property value="#request.teacher.tno" />"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">老师姓名</label>
                             				<div class="col-lg-10">
                             					<input name="tname" class="form-control" id="tname" type="text" aria-required="true"  value="<s:property value="#request.teacher.name" />"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">性别</label>
                             				<div class="col-lg-10">
                             					<select name="tsex" class="form-control" id="tsex"  aria-required="true" >
                             						<s:if test="#request.teacher.sex==1">
                             						<option selected="selected">男</option>
                             						<option>女</option>
                             						</s:if>
                             						<s:else>
                             						<option>男</option>
                             						<option selected="selected">女</option>
                             						</s:else>
                             					</select>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">联系电话</label>
                             				<div class="col-lg-10">
                             					<input name="tphone" class="form-control" id="tphone" type="text" aria-required="true"  value="<s:property value="#request.teacher.phone" />"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">电子邮件</label>
                             				<div class="col-lg-10">
                             					<input name="temail" class="form-control" id="temail" type="text" aria-required="true"  value="<s:property value="#request.teacher.email" />"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">方向</label>
                             				<div class="col-lg-10">
                             					<input name="tmajor" class="form-control" id="tmajor" type="text" aria-required="true"  value="<s:property value="#request.teacher.major" />"/>
                             				</div>
                             			</div>
                             			
                             			<div class="form-group">
                             				
                             				<div class="col-lg-offset-2 col-lg-10">
                             					<button type="submit" class="btn btn-success">修改</button>
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