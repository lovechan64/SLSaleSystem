<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">购物管理</a> <span class="divider">/</span></li>
		<li><a href="/shopping/activate/list.html">确认激活</a></li>
	</ul>
</div>

<form id="myForm" action="/shopping/activate/list.html">
<div class="row-fluid sortable">		
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class="icon-user"></i>待激活会员列表</h2>
			</div>
			
			<div class="box-content">
					<div class="searcharea">
						用户名：<input name="userName" id="userName" value="${userName}"/>
						时间:&nbsp;&nbsp;<input class="Wdate" id="start" size="15" name="start" readonly="readonly"  type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'});" value="${start}"  />
						&nbsp;-&nbsp;<input class="Wdate" id="start" size="15" name="end" readonly="readonly"  type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'});" value="${end}"  />
						<button type="submit" class="btn btn-primary"><i class="icon-search icon-white"></i> 查询 </button>
					</div>
				<table class="table table-striped table-brefered bootstrap-datatable datatable">
				  <thead>
					  <tr>
						<th>选择</th>
						<th>用户名</th>
						<th>注册日期</th>
						<th>推荐人</th>
						<th>推荐时间</th>
						<th>激活状态</th>
					  </tr>
				  </thead>   
				  <tbody>
					<c:choose>
				   		<c:when test="${page.items != null && page.items !='[]'}">
						<c:forEach items="${page.items}" var="refer">
							<tr>
								<td class="center">
								<label class="radio">
									<input type="radio" name="userId"  value="${refer.userId}" />
								</label>
								</td>
								<td class="center">${refer.loginCode}</td>
								<td class="center"><fmt:formatDate value="${refer.createTime}" pattern="yyyy-MM-dd"/></td>
								<td class="center">${refer.referUserName}</td>
								<td class="center"><fmt:formatDate value="${refer.referTime}" pattern="yyyy-MM-dd"/></td>
								<td class="center">
									<c:choose>
										<c:when test="${refer.activeStatus == 0}">待激活</c:when>
										<c:when test="${refer.activeStatus == 1}">已激活</c:when>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
				   		</c:when>
						<c:otherwise>
							<tr>
								<td class="center" colspan="6"><center>没有找到数据！</center></td>
							</tr>
						</c:otherwise>
					</c:choose>
					</tbody>
				</table>   
			<div>
		</div>
		<div>
			<font color="#006699">请认真核待激活用户信息，然后确认、激活会员，一旦确认激活不能更改。</font>
			<input type="button" class="btn btn-primary nextbtn" value="下一步">
			<ul id="confirm_formtip"></ul>
		</div>
	</div>
</div><!--/span-->
</div><!--/row-->
<div class="modal hide fade" id="viewConfirmDiv">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>提示</h3>
	</div>
	<div class="modal-body">
		<ul id="add_formtip"></ul>
		<label>请输入二级密码：</label>
		<input type="password" name="password" id="password" value=""/>
		<input type="hidden" name="searchFlag" value="goto"/>
		
	</div>
	<div class="modal-footer">
		<a href="#" class="btn btn-primary" id="submit" >确定</a>
		<a href="#" class="btn btn-primary" id="close" data-dismiss="modal">关闭</a>
	</div>
 </div>
<%@include file="/WEB-INF/pages/common/page.jsp"%>
</form>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="/statics/localjs/activate.js"></script>