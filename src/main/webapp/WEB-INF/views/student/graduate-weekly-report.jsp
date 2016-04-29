<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css"  rel="stylesheet" />
<link href="styles/graduation.css" rel="stylesheet" />
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
                 <li>
                    <a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a>
                </li>
                <li><a href=""><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息</a></li>
                <li><a href=""><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>课程</a></li>
                <li><a href="weekly-report"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>实习</a></li>
                <li class="active"><a href="graduate-weekly-report"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>毕设</a></li>
            </ul>
            <ul class="nav nav-sidebar reset-pwd-ul">
                <li><a href=""><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码</a></li>
            </ul>
        </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main myMain practiceInmation">
        <div class="panel panel-default myPanel">
            <div class="panel-head">毕设信息</div>
            <div class="panel-body">
                <p>暂无毕设信息</p>
                <!--<s:property value="#session.currentUser.studentName" />  -->
            </div>
        </div>
    </div>
       <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main myMain weekReport">
        <div class="panel panel-default myPanel weekReport">
            <div class="panel-head">毕设周报 Graduation Weekly Report<a href="graduation-weekly-report-save"><button class="glyphicon glyphicon-plus myBu"></button></a></div>
            <div class="panel-body">
                <table class="table weekTable">
                  <thead>
                     <tr id="the">
                        <th>标题</th>
                        <th>时间</th>
                        <th>操作</th>
                     </tr>
                  </thead>
                  <tbody>
                  <s:if test="#request.graduationWeeklyReport!=null">
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
                       </s:if>
                       
                     </tbody>
               </table>             
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