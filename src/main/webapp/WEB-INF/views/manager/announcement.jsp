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
        <div class="sidebar">
            <jsp:include page="../sidebar/sidebar-student.jsp" />
        </div>   
    </div>
    
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 mymain">
    		<div class="row">
                <div class="col-sm-12">             	
                    <div class="panel panel-default">
                    	<div class="panel-heading">
                    		<h3 class="panel-title">公告栏</h3>
                    	</div>
                    	<div class="panel-body">     		
                             	<div class="form">
                             		<form class="cmxform form-horizontal tasi-form" id="commentForm" action="addNoticeBoard" method="post" >
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">标题</label>
                             				<div class="col-lg-10">
                             					<input name="noticeBoardTitle" class="form-control" id="atitle" type="text" aria-required="true"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">内容</label>
                             				<div class="col-lg-10">
                             					<textarea name="noticeBoardContent" class="form-control" id="acontent"  aria-required="true"></textarea>
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