<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<ul class="nav nav-sidebar">
  <li class="<s:if test="#request.navId == 1">active</s:if>"><a href="index"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>首页</a></li>
  <li class="<s:if test="#request.navId == 2">active</s:if>"><a href="publishInfo"><span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span>发布信息</a></li>
  <li class="<s:if test="#request.navId == 3">active</s:if>"><a href="admin-course"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>实训课程</a></li>
  <li class="<s:if test="#request.navId == 4">active</s:if>"><a href="graduation-pro-sele"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>毕业设计</a></li>
  <li class="<s:if test="#request.navId == 5">active</s:if>"><a href="internship-detail"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>工作实习</a></li>
  <li class="<s:if test="#request.navId == 6">active</s:if>"><a href="student"><span class="glyphicon glyphicon-tags" aria-hidden="true"></span>学生管理</a></li>
  <li class="<s:if test="#request.navId == 7">active</s:if>"><a href="admin-teacher"><span class="glyphicon glyphicon-bookmark" aria-hidden="true"></span>教师管理</a></li>
</ul>
<ul class="nav nav-sidebar reset-pwd-ul">
  <li class="<s:if test="#request.navId == 8">active</s:if>"><a href="reset"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span>修改密码</a></li>
</ul>