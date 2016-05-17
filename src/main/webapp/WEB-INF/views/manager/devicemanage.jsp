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
	                       		<a href="adddevice"><span class="fa fa-plus-square rplus"></span></a>
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
		             			<tr >
		                        	<td class="rborder">D123</td>
		                        	<td class="rborder">xilinx</td>
		                        	<td class="rborder">谌云莉</td>
		                        	<td class="rborder">借出</td>
		                        	<td class="rborder">陈晓晓</td>
		                        	<td class="rborder">2016年1月10日  13：00</td>
		                        	<td class="rborder"></td>
		                            <td>
		                            	<a href="addDeviceHistory"><span class="glyphicon glyphicon-pencil Gl1"></span></a>
		                           		<button type="button" class="glyphicon glyphicon-trash myPu weekly-plan-del" data-toggle="modal" data-target="#WeeklyPlanDel"></button>
		                           	</td>
		                      	</tr>
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