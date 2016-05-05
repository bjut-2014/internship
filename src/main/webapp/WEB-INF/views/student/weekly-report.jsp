<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
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
            <div class="panel-head-1">实习信息 Practice Information</div>
            <div class="panel-body">
                <s:if test="#request.internshipdetail!=null">
                <table class="table table-striped">
                    <tbody>
                        <tr>
                            <td class="for-border-right">姓名：<s:property value="#session.currentUser.name" /></td>
                            <td>实习时间：<s:property value="#request.internshipdetail.company_date" /></td>

                        </tr>
                        <tr>
                            <td class="for-border-right">实习公司：<s:property value="#request.internshipdetail.company_name" /></td>
                            <td>公司地址：<s:property value="#request.internshipdetail.company_address" /></td>
                        </tr>
                        <tr>
                            <td class="for-border-right">校外导师：<s:property value="#request.internshipdetail.company_teacher" /></td>
                            <td>实习分数：<s:property value="#request.internshipdetail.company_score" /></td>
                        </tr>
                    </tbody>
                </table>
                </s:if>
                <s:else>
                	<p>暂无实习信息</p>
                </s:else>
            </div>
        </div>
    </div>
      <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main myMain weekReport">
        <div class="panel panel-default myPanel weekReport1">
            <div class="panel-head-1">周报 weekly Report
                <a href="weekly-report-save"><button class="glyphicon glyphicon-plus myBu"></button></a>
            </div>
            <div class="panel-body">
                <s:if test="#request.weeklyplan.size()!=0">
                <table class="table table-striped weekTable">
                  <tbody>
                      <tr id="the">
                          <th>标题</th>
                          <th>时间</th>
                          <th>操作</th>
                      </tr>
                      <s:iterator value="#request.weeklyplan" var="list">
                          <tr>
                              <td><a href="weekly-report-view?weeklyReportId=${list.id}">${list.title}</a></td>
                              <td>${list.date }</td>
                              <td>
                              <a href="weekly-report-edit?weeklyReportId=${list.id}"><span class="glyphicon glyphicon-pencil Gl1"></span></a>
                              <button type="button" class="glyphicon glyphicon-trash myPu weekly-plan-del" data-toggle="modal" data-target="#WeeklyPlanDel" data-id=${list.id}></button>
                              </td>
                           </tr>
                      </s:iterator>
                  </tbody>
                </table>
                </s:if>
                <s:else>
                    <p>暂无周报</p>
                </s:else>
            </div>
        </div>
    </div>
      <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main myMain practiceRerort">
        <div class="panel panel-default myPanel practiceRerort1">
            <div class="panel-head">实习报告 Practice Report
            </div>
            <div class="panel-body">
                <s:if test="#request.result==null">
                    <p class="file-title">暂无实习报告</p>
                    <!-- 
                    <form action="upload" method="post" enctype="multipart/form-data">
                        <input class="myBu" type="submit" value="提交报告">
                        <input type="file" name="upload">
                    </form>
                     -->
                     <input type="file" name="uploadfile" class="uploadInternshipReport"/>
                </s:if>
                <s:else>
                    <p><s:property value="#request.result.title"/></p>
                </s:else>
            </div>
        </div>
    </div>
  </div>
</div>
<%--删除弹窗--%>
<div class="modal fade" id="WeeklyPlanDel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-id>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">确认要删除这篇周报吗？</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary weekly-plan-del-confirm"  data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../footer/footer.jsp" />
<script src="scripts/weekly-report.js"></script>
</body>
</html>