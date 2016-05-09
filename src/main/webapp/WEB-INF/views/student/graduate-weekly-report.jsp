<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css"  rel="stylesheet" />
<link href="styles/practice.css" rel="stylesheet" />
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
        <jsp:include page="../sidebar/sidebar-student.jsp" />
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main myMain practiceInmation">
        <div class="panel panel-default myPanel practiceinfo">
            <div class="panel-head">毕设信息 Graduation Information</div>
            <div class="panel-body">
                <s:if test="">

                </s:if>
                <s:else>
                    <p>暂无毕设信息</p>
                </s:else>
            </div>
        </div>
        <div class="panel panel-default myPanel weekReport1">
            <div class="panel-head-1">毕设周报 Graduation Weekly Report<a href="graduation-weekly-report-save"><button class="glyphicon glyphicon-plus myBu"></button></a></div>
            <div class="panel-body">
                <s:if test="#request.graduationWeeklyReport.size()!=0">
                    <table class="table table-striped weekTable">
                        <tbody>
                        <tr id="the">
                            <th>标题</th>
                            <th>时间</th>
                            <th>操作</th>
                        </tr>
                        <s:iterator value="#request.graduationWeeklyReport" var="list">
                            <tr>
                                <td><a href="graduate-weekly-report-view?graduationWeeklyReportId=${list.id}">${list.title}</a></td>
                                <td>${list.date }</td>
                                <td>
                                    <a href="graduate-weekly-report-edit?graduationWeeklyReportId=${list.id}"><span class="glyphicon glyphicon-pencil Gl1"></span></a>
                                    <button type="button" class="glyphicon glyphicon-trash myPu graduation-weekly-plan-del" data-toggle="modal" data-target="#GraduationWeeklyPlanDel" data-id=${list.id}></button>

                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </s:if>
                <s:else>
                    <p>暂无毕设周报</p>
                </s:else>
            </div>
        </div>
    </div>
</div>


<%--删除弹窗--%>
<div class="modal fade" id="GraduationWeeklyPlanDel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-id>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">确认要删除这篇周报吗？</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary graduation-weekly-plan-del-confirm"  data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../footer/footer.jsp" />
<script src="scripts/graduation-weekly-report.js"></script>
</body>
</html>