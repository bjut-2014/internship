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
    	
                <div class="col-sm-12">
                <div class="mytab">
                <ul class="nav nav-tabs profile-tabs">
                    		<li class="active">
                    			<a class="first" href="#announcement" data-toggle="tab">公告栏</a>
                   			
                    		</li>
                    		<li class="">
                    			<a class="second" href="#recruitment" data-toggle="tab">招聘信息</a>
                    		</li> 
                    		<li class="">
                    			<a class="third" href="#banner" data-toggle="tab">轮播图</a>
                    		</li>
                    	</ul>
                    </div>
                    
                    <div class="panel panel-default">
                    	<div class="panel-body">
                    		<div class="row">
                             	<div class="col-md-12 col-sm-12 col-xs-12">                   	
                    				     
	                 				<div class="tab-content m-0">
	                 				
	                 					<div class="tab-pane active" id="announcement">
	                 						<div class="rposotion">
	                       						<a href="announcement"><span class="fa fa-plus-square plus"></span></a>                                              
	                 						</div>
					                 		<div class="profile-desk">
					                 			<table  class="table table-striped">
				                    				<tbody>
				                           				<tr>
				                               				<th class="rborder">标题</th>
				                                			<th class="rborder">时间</th>
				                                			<th class="thin-width">操作</th>                                                                                                      
				                            			</tr>
				                         			    
				                         			    <s:iterator value="#request.noticeBoards" var="nb">
				                         			    <tr>
				                         			    	<td class="rborder"><s:property value="#nb.title" /></td>
				                         			    	<td class="rborder"><s:property value="#nb.date" /></td>
				                         			    	<td>
				                                				<a href="updateNoticeBoard?noticeBoardId=<s:property value="#nb.id" />"><span class="glyphicon glyphicon-pencil mypencil"></span></a>
                              									<a href="deleteNoticeBoard?noticeBoardId=<s:property value="#nb.id" />"><span class="glyphicon glyphicon-trash mytrash"></span></a>
				                                			</td>
				                         			    </tr>
				                         			    </s:iterator>                        
				                    				</tbody>
				                   				</table>
					                 		</div>	                 		
					                 	</div>
					                 	<div class="tab-pane" id="recruitment">
					                 	<div class="rposotion">
	                       						<a href="recruitment"><span class="fa fa-plus-square plus"></span></a>                                                
	                 						</div>
					                 		<div class="profile-desk">
					                 			<table  class="table table-striped">
				                    				<tbody>
				                           				<tr>
				                               				<th class="rborder">标题</th>
				                                			<th class="rborder">时间</th>
				                                			<th class="thin-width">操作</th>                                                                                                      
				                            			</tr>
				                         			    <s:iterator value="#request.recruitInfos" var="ri">
				                         			    <tr>
				                         			    	<td class="rborder"><s:property value="#ri.title" /></td>
				                         			    	<td class="rborder"><s:property value="#ri.date" /></td>
				                         			    	<td>
				                                				<a href="updateRecruitInfo?recruitInfoId=<s:property value="#ri.recruitInfoId" />"><span class="glyphicon glyphicon-pencil mypencil"></span></a>
                              									<a href="deleteRecruitInfo?recruitInfoId=<s:property value="#ri.recruitInfoId" />"><span class="glyphicon glyphicon-trash mytrash"></span></a>
				                                			</td>
				                         			    </tr>
				                         			    </s:iterator>   
				                    				</tbody>
				                   				</table>
					                 		</div>	                 		
					                 	</div>
					                 	<div class="tab-pane" id="banner">
					                 	<div class="rposotion">
	                       						<a href="banner"><span class="fa fa-plus-square plus"></span></a>                                                
	                 						</div>
					                 		<div class="profile-desk">
					                 			<table  class="table table-striped">
				                    				<tbody>
				                           				<tr>
				                               				<th class="rborder">标题</th>
				                                			<th class="rborder">时间</th>
				                                			<th class="thin-width">操作</th>                                                                                                      
				                            			</tr>
														<s:iterator value="#request.carouselFigures" var="cf">
				                         			    <tr>
				                         			    	<td class="rborder"><s:property value="#cf.title" /></td>
				                         			    	<td class="rborder"><s:property value="#cf.date" /></td>
				                         			    	<td>
				                                				<a href="updateCarouselFigure?carouselFigureId=<s:property value="#cf.carouselFigureId" />"><span class="glyphicon glyphicon-pencil mypencil"></span></a>
                              									<a href="deleteCarouselFigure?carouselFigureId=<s:property value="#cf.carouselFigureId" />"><span class="glyphicon glyphicon-trash mytrash"></span></a>
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
               		</div>
        		</div>
  </div>
</div>
<jsp:include page="../footer/footer.jsp" />
</body>
</html>