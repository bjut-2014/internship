<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/student.css" rel="stylesheet">
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li><a href="index">首页 <span class="sr-only">(current)</span></a></li>
        <li><a href="stu-info">个人信息</a></li>
        <li class="active"><a href="weekly-plan">周计划</a></li>
        <li><a href="practical-reports">实训报告</a></li>
        <li><a href="internship-reports">实习报告</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="reset-pwd">修改密码</a></li>
      </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <button type="button" class="btn btn-success fr" aria-label="Left Align" data-toggle="modal" data-target="#WeeklyPlanAdd">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
        </button>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>编号</th>
                <th>标题</th>
                <th>时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="#request.weeklyplan" var="list">
            <tr>
                <th scope="row">${list.id}</th>
                <td>${list.weeklyplanTitle}</td>
                <td>${list.weeklyplanDate}</td>
                <td>
                    <button type="button" class="btn btn-default weekly-plan-edit" data-toggle="modal" data-target="#WeeklyPlanModify" data-id=${list.id}>修改</button>
                    <button type="button" class="btn btn-default weekly-plan-del" data-toggle="modal" data-target="#WeeklyPlanDel" data-id=${list.id}>删除</button>
                </td>
            </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>
  </div>
</div>
<%--添加弹窗--%>
<div class="modal fade" id="WeeklyPlanAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3">
    <div class="modal-dialog" role="document">
    	<form action="weekly-plan-add" method="post">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                <h4 class="modal-title" id="myModalLabel3">添加周计划</h4>
	            </div>
	            <div class="modal-body">
	                <div>标题：<input name="addTitle" type="text" class="form-control" value=""></div>
	                <div>内容：<textarea name="addContent" class="form-control" rows="5" placeholder="1000个字以上"></textarea></div>
	            </div>
	            <div class="modal-footer">
	               <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	               <button type="submit" class="btn btn-primary">添加</button>
	            </div>
	        </div>
        </form>
    </div>
</div>
<%--修改弹窗--%>
<div class="modal fade" id="WeeklyPlanModify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" role="document">
        <form action="weekly-plan-update" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel2">修改周计划</h4>
                </div>
                <div class="modal-body">
                    <div>编号：<input name="updateId" type="text" class="form-control plan-id" value="" disabled></div>
                    <div>标题：<input name="updateTitle" type="text" class="form-control plan-title" value=""></div>
                    <div>内容：<textarea name="updateContent" class="form-control plan-content" rows="5" placeholder="1000个字以上"></textarea></div>
                    <div>时间：<input type="text" class="form-control plan-date" value="" disabled></div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">修改</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%--删除弹窗--%>
<div class="modal fade" id="WeeklyPlanDel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-id>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">确认要删除这篇周计划吗？</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary weekly-plan-del-confirm"  data-dismiss="modal">确认</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer/footer.jsp" />
<script src="scripts/weekly-plan.js"></script>
</body>
</html>