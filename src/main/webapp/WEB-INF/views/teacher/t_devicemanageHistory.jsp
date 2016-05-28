<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/practice.css" rel="stylesheet" />
<meta charset="UTF-8">
<body>
<jsp:include page="../nav/nav.jsp" />
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
        <jsp:include page="../sidebar/sidebar-teacher.jsp" />
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main myMain practiceInmation">
        <div class="panel panel-default myPanel practiceinfo">
            <div class="panel-head">
            	设备历史记录
           	</div>
           
            <div class="panel-body">             
                <table id="mytable" class="table table-striped  weekReport">
                	<tbody>
                    	<tr  id="the">
                        	<th class="for-border-right">设备编号</th>                                                   
                      		<th class="for-border-right">设备名称</th>
                  			<th class="for-border-right">所属人</th> 
                  			<th class="for-border-right">设备状态</th>                                                   
                      		<th class="for-border-right">使用人</th>
                  			<th class="for-border-right">借出时间</th>
                  			<th class="for-border-right">归还时间</th>                                                   
                			<th class="position">操作</th>           					
             			</tr>
             			<s:iterator value="#request.equipmentHistories" var="equ">
             			<tr>
                        	<td class="for-border-right"><s:property value="#equ.eno"/></td>
                      		<td class="for-border-right"><s:property value="#equ.name"/></td>
                  			<td class="for-border-right"><s:property value="#equ.owner"/></td>
                  			<td class="for-border-right"><s:property value="#equ.state"/></td>
                      		<td class="for-border-right"><s:property value="#equ.people"/></td>
                  			<td class="for-border-right"><s:property value="#equ.lendDate"/></td>
                  			<td class="for-border-right"><s:property value="#equ.returnDate"/></td>
                			<td class="position">
								<a href="admin-delete-equipmentHistory?equipmentHistoryId=<s:property value="#equ.equipmentHistoryId" />"><span class="glyphicon glyphicon-trash mytrash"></span></a>
							</td>
             			</tr>
             			</s:iterator>
                 	</tbody>
               </table>
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
                <h4 class="modal-title" id="myModalLabel">确认要删除这个设备吗？</h4>
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