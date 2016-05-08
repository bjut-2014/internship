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
        <div class="sidebar">
            <jsp:include page="../sidebar/sidebar-student.jsp" />
        </div>   
    </div>
    
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 mymain">
    	
               <div class="row">
                <div class="col-sm-12">             	
                    <div class="panel panel-default">
                    	<div class="panel-heading">                  		
                    		<h3 class="panel-title">教师管理 Teacher Manage
                    			<a href="#"><span class="spanbtn">批量导入</span></a> 
	                       		<a href="teacheradd"><span class="fa fa-plus-square rplus"></span></a>
	                       	</h3>	                                               
	                 	  </div>
                    	
                    	<div class="panel-body">
                    	 
					      <table  class="table table-striped">
				              <tbody>
				                  <tr>
				                     <th class="rborder">工号</th>
				                     <th class="rborder">老师姓名</th>
				                     <th class="rborder">性别</th>
				                     <th class="rborder">联系电话</th>
				                     <th class="rborder">电子邮件</th>
				                     <th class="rborder">方向</th>
				                     <th class="thin-width">操作</th>                                                                                                      
				                  </tr>
				                  <tr>
				                     <td class="rborder">T2014</td>
				                     <td class="rborder">谌云莉</td>
				                     <td class="rborder">女</td>
				                     <td class="rborder"></td>
				                     <td class="rborder"></td>
				                     <td class="rborder">无线网络</td>	
				                     <td>
				                         <a href="teacheradd"><span class="glyphicon glyphicon-pencil mypencil"></span></a>
                              			 <a href="#"><span class="glyphicon glyphicon-trash mytrash"></span></a>
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
<jsp:include page="../footer/footer.jsp" />
</body>
</html>