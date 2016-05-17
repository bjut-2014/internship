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
        <div class="panel panel-default myPanel">
            <div class="panel-head">
            	持有设备 Holding Device
            	
           	</div>
           
            <div class="panel-body">             
                <table id="mytable" class="table table-striped  weekReport">
                	<tbody>
                    	<tr  id="the">
                        	<th class="for-border-right">设备编号</th>                                                   
                      		<th class="for-border-right">设备名称</th>
                  			<th class="for-border-right">所属人</th> 
                  			<th >设备状态</th>                                                   
                      						
             			</tr>
             			<tr >
                        	<td class="for-border-right">D123</td>
                        	<td class="for-border-right">xilinx</td>
                        	<td class="for-border-right">谌云莉</td>
                        	<td >借出</td>
                        	
                      	</tr>
             			
                 	</tbody>
               </table>
            </div>
        </div>

        
    </div>
  </div>
</div>


<jsp:include page="../footer/footer.jsp" />
<script src="scripts/weekly-report.js"></script>
</body>
</html>