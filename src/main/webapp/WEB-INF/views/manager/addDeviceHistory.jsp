<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE>
<html>
<jsp:include page="../header/header.jsp" />
<link href="styles/lib/font-awesome.css" rel="stylesheet" />
<link href="styles/lib/bootstrap-reset.css"  rel="stylesheet" />
<link href="styles/lib/bootstrap-datepicker.min.css"  rel="stylesheet" />
<link href="styles/publishinfo.css" rel="stylesheet"/>
<style>
	.copyright {
		bottom: inherit;
	}
</style>
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
                    		<h3 class="panel-title">设备 Device</h3>
                    	</div>
                    	<div class="panel-body">     		
                             	<div class="form">
                             		<form class="cmxform form-horizontal tasi-form" id="commentForm" action="admin-add-equipmentHistory" method="post" >
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">设备编号</label>                            				
                             				<label class="content"><s:property value="#request.equipment.eno"/></label>                            				
                             			</div>
                             			<!--  <div class="form-group">
                             				<label class="control-label col-lg-2">老师</label>
                             				<div class="col-lg-10">
                             					<input name="cteacher" class="form-control" id="cteacher" type="text" aria-required="true"/>
                             				</div>
                             			</div>-->
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">设备名称</label>
                             					<label  class="content"><s:property value="#request.equipment.name"/></label>
                             			</div>
                             			                      
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">所属人</label>
                             					<label  class="content"><s:property value="#request.equipment.owner"/></label>
                             			</div>
                             			<input type="hidden" name="eno" value="<s:property value="#request.equipment.eno" />">
                             			<input type="hidden" name="ename" value="<s:property value="#request.equipment.name" />">  
                             			<input type="hidden" name="teacherId" value="<s:property value="#request.equipment.teacherId" />">                             			                             				
                             			<!--  	
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">所属人</label>
                             				<div class="col-lg-10">
                             					<select name="dteacher" class="form-control" id="dteacher"  aria-required="true" >
                             						<option></option>
                             						<s:iterator value="#request.teachers" var="tch">
                             							<option value="<s:property value="#tch.teacherId" />"><s:property value="#tch.name" /></option>
                             						</s:iterator>
                             					</select>
                             				</div>
                             			</div>		
                             			-->
                             			
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">状态</label>
                             				<div class="col-lg-10">
                             					<input name="estate" class="form-control"  type="text" aria-required="true" value="<s:property value="#request.equipment.state"/>"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">借出人</label>
                             				<div class="col-lg-10">
                             					<input name="epeople" class="form-control" id="dborrow" type="text" aria-required="true" value="<s:property value="#request.equipment.people"/>"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">借出时间</label>
                             				<div class="col-lg-10">
                             					<input name="elendDate" class="form-control" id="datepicker1"  aria-required="true" value="<s:date name="#request.equipment.lendDate" format="yyyy-MM-dd" />"/>
                             				</div>
                             			</div>
                             			<div class="form-group">
                             				<label class="control-label col-lg-2">归还时间</label>
                             				<div class="col-lg-10">
                             					<input name="ereturnDate" class="form-control" id="datepicker2"  aria-required="true" value="<s:date name="#request.equipment.returnDate" format="yyyy-MM-dd" />"/>
                             				</div>
                             			</div>
                             			            			
                             			<div class="form-group">
                             				
                             				<div class="col-lg-offset-2 col-lg-10">
                             					<button type="submit" class="btn btn-success">添加</button>
                             					<button type="button" class="btn btn-default">取消</button>
                             				</div>
                             			</div>
                             			
                             		
                             		</form>                   	
                    				     
	                 				
                   				</div>
                   			</div>
                    	</div>
               		</div>
        		</div>
        		<div class="row">
                <div class="col-sm-12">             	
                    <div class="panel panel-default">
                    	<div class="panel-heading">
                    		<h3 class="panel-title">借出历史  History</h3>
                    	</div>
                    	<div class="panel-body">     
                    		<table id="mytable" class="table table-striped">
			                	<tbody>
			                    	<tr  id="the">
			                        	<th class="rborder">设备编号</th>                                                   
			                      		<th class="rborder">设备名称</th>
			                  			<th class="rborder">所属人</th> 
			                  			<th class="rborder">设备状态</th>                                                   
			                      		<th class="rborder">使用人</th>
			                  			<th class="rborder">借出时间</th>
			                  			<th class="">归还时间</th>                                                   
			             			</tr>
			             			<s:iterator value="#request.equipmentHistories" var="equh">
			             			<tr >
			                        	<td class="rborder"><s:property value="#equh.eno" /></td>
			                        	<td class="rborder"><s:property value="#equh.name" /></td>
			                        	<td class="rborder"><s:property value="#equh.owner" /></td>
			                        	<td class="rborder"><s:property value="#equh.state" /></td>
			                        	<td class="rborder"><s:property value="#equh.people" /></td>
			                        	<td class="rborder"><s:date name="#equh.lendDate" format="yyyy-MM-dd" /> </td>
			                        	<td class=""><s:date name="#equh.returnDate" format="yyyy-MM-dd" /></td>
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
<jsp:include page="../footer/footer.jsp" />
<script>
$(document).ready(function(){
$("#datepicker1").datepicker({
	format:"yyyy-mm-dd"
});
$("#datepicker2").datepicker({
	format:"yyyy-mm-dd"
});
});
</script>
<script src="scripts/lib/bootstrap-datepicker.min.js"></script>
</body>
</html>