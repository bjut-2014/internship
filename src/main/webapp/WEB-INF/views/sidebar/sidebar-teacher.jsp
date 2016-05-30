<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul class="nav nav-sidebar">
  <li class="<s:if test="#request.navId == 1">active</s:if>"><a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页<i class="fa fa-chevron-right"></i></a></li>
  <li class="<s:if test="#request.navId == 2">active</s:if>"><a href="tch-info"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>个人信息<i class="fa fa-chevron-right"></i></a></li>
  <li class="<s:if test="#request.navId == 3">active</s:if>"><a href="tch-course"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>实训课程<i class="fa fa-chevron-right"></i></a></li>
  <li class="<s:if test="#request.navId == 4">active</s:if>"><a href="teacher-weekly-report"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>工作实习<i class="fa fa-chevron-right"></i></a></li>
  <li class="<s:if test="#request.navId == 5">active</s:if>"><a href="teacher-graduation-weekly-report"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>毕业设计<i class="fa fa-chevron-right"></i></a></li>
  <li class="<s:if test="#request.navId == 7">active</s:if>"><a href="tch-equipment"><span class="glyphicon glyphicon-hdd" aria-hidden="true"></span>设备管理<i class="fa fa-chevron-right"></i></a></li>
</ul>
<ul class="nav nav-sidebar reset-pwd-ul">
  <li class="<s:if test="#request.navId == 6">active</s:if>"><a href="reset"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码<i class="fa fa-chevron-right"></i></a></li>
</ul>