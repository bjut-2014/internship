<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
                <li><a href="weekly-plan">周计划</a></li>
                <li class="active"><a href="practical-reports">实训报告</a></li>
                <li><a href="internship-reports">实习报告</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="reset-pwd">修改密码</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <button type="button" class="btn btn-success fr" aria-label="Left Align" data-toggle="modal" data-target="#PracticalReportsAdd">
                <span class="glyphicon glyphicon-plus" aria-hidden="true" style="top:-1px"></span>
            </button>
            <table class="table table-hover">
                <thead>
                <tr>
                    <%--<th>编号</th>--%>
                    <th>标题</th>
                    <th>时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="#request.practicalreports" var="list">
                    <tr>
                        <%--<th scope="row">${list.id}</th>--%>
                        <td><a href="practical-report-view?practicalReportsId=${list.id}">${list.practicalReportsTitle}</a></td>
                        <td>${list.practicalReportsDate}</td>
                        <td>
                            <button type="button" class="btn btn-default practical-reports-edit" data-toggle="modal" data-target="#PracticalReportsModify" data-id=${list.id}>修改</button>
                            <button type="button" class="btn btn-default practical-reports-del" data-toggle="modal" data-target="#PracticalReportsDel" data-id=${list.id}>删除</button>
                        </td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%--添加弹窗--%>
<div class="modal fade" id="PracticalReportsAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3">
    <div class="modal-dialog" role="document">
        <form action="practical-reports-add" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel3">添加实训报告</h4>
                </div>
                <div class="modal-body">
                    <div>标题：<input name="addTitle" type="text" class="form-control" value=""></div>
                    <div>内容：<textarea name="addContent" class="form-control" rows="5" placeholder="1000个字以上"></textarea></div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%--修改弹窗--%>
<div class="modal fade" id="PracticalReportsModify" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" data-id>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">修改实训报告</h4>
            </div>
            <div class="modal-body">
                <input type="hidden" class="form-control reports-id" value="">
                <div>标题：<input type="text" class="form-control reports-title" value=""></div>
                <div>内容：<textarea class="form-control reports-content" rows="5" placeholder="1000个字以上" value=""></textarea></div>
                <%--<div>时间：<input type="text" class="form-control reports-date" value="" disabled></div>--%>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary practical-reports-edit-confirm" data-dismiss="modal">修改</button>
            </div>
        </div>
    </div>
</div>
<%--删除弹窗--%>
<div class="modal fade" id="PracticalReportsDel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-id>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">确认要删除这篇实训报告吗？</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary practical-reports-del-confirm" data-dismiss="modal">确认</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../footer/footer.jsp" />
<script src="scripts/practical-reports.js"></script>
</body>
</html>