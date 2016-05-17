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
            	持有设备 Holding Device
            	 <a href="t_adddevice"><button class="glyphicon glyphicon-plus myBu"></button></a>
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
             			<tr >
                        	<td class="for-border-right">D123</td>
                        	<td class="for-border-right">xilinx</td>
                        	<td class="for-border-right">谌云莉</td>
                        	<td class="for-border-right">借出</td>
                        	<td class="for-border-right">陈晓晓</td>
                        	<td class="for-border-right">2016年1月10日  13：00</td>
                        	<td class="for-border-right"></td>
                            <td>
                            	<a href="t_addDeviceHistory"><span class="glyphicon glyphicon-pencil Gl1"></span></a>
                           		<button type="button" class="glyphicon glyphicon-trash myPu weekly-plan-del" data-toggle="modal" data-target="#WeeklyPlanDel"></button>
                           	</td>
                      	</tr>
             			
                 	</tbody>
               </table>
            </div>
        </div>
        <div class="panel panel-default myPanel weekReport1">
            <div class="panel-head">设备持有人 Device Holder
               
            </div>
            <div class="panel-body">          
                    <table class="table table-striped weekTable">
                        <tbody>
                        <tr id="the">
                            <th>姓名</th>                           
                            <th>查看</th>
                        </tr>
                       
                            <tr>
                                <td  class="for-border-right">谌云莉</td>                              
                                <td>
                                    <a href="t_otherdevice"><span class="glyphicon glyphicon-eye-open Gl2"></span></a>                                    
                                </td>
                            </tr>
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