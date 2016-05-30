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
                    		<h3 class="panel-title">所有设备 All Device
								<a href="equipment-history"><span class="spanbtn2">设备历史记录</span></a>
	                       		<a href="show-admin-add-equipment"><button class="glyphicon glyphicon-plus myBu"></button></a>
	                       	</h3>	                                               
	                 	  </div>
                    	
                    	<div class="panel-body">
                    	 
					      <table  class="table table-striped">
				             <tbody>
		                    	<tr>
		                        	<th class="rborder">设备编号</th>                                                   
		                      		<th class="rborder">设备名称</th>
		                  			<th class="rborder">所属人</th> 
		                  			<th class="rborder">设备状态</th>                                                   
		                      		<th class="rborder">使用人</th>
		                  			<th class="rborder">借出时间</th>
		                  			<th class="rborder">归还时间</th>                                                   
		                			<th class="position">操作</th>           					
		             			</tr>
		             			<s:iterator value="#request.adminEquipments" var="equ">
		             			<tr >
		                        	<td class="rborder"><s:property value="#equ.eno" /></td>
		                        	<td class="rborder"><s:property value="#equ.name" /></td>
		                        	<td class="rborder"><s:property value="#equ.owner" /></td>
		                        	<td class="rborder"><s:property value="#equ.state" /></td>
		                        	<td class="rborder"><s:property value="#equ.people" /></td>
		                        	<td class="rborder"><s:date name="#equ.lendDate" format="yyyy-MM-dd" /> </td>
			                        <td class="rborder"><s:date name="#equ.returnDate" format="yyyy-MM-dd" /></td>
		                            <td>
		                            	<a href="show-admin-add-equipmentHistory?equipmentId=<s:property value="#equ.equipmentId" />"><span class="glyphicon glyphicon-pencil Gl1"></span></a>
		                           		<!--  <button type="button" class="glyphicon glyphicon-trash myPu weekly-plan-del" data-toggle="modal" data-target="#WeeklyPlanDel"></button>-->
		                           		<a href="admin-delete-equipment?equipmentId=<s:property value="#equ.equipmentId" />"><span class="glyphicon glyphicon-trash mytrash"></span></a>
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
</body>
</html>