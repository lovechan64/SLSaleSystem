<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">电子银行</a> <span class="divider">/</span></li>
		<li><a href="/bank/repeated_account/list.html">重销账户</a></li>
	</ul>
</div>

<form id="myForm" action="/bank/repeated_account/list.html" method="post">
<div class="row-fluid sortable">		
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class="icon-user"></i>重销账户列表</h2>
			</div>
			
			<div class="box-content">
					<div class="searcharea">
						月份:&nbsp;&nbsp;<input class="Wdate" id="start" size="15" name="start" readonly="readonly"  type="text" onClick="WdatePicker({dateFmt:'yyyy-MM'});" value="${start}"  />
						<button type="submit" class="btn btn-primary"><i class="icon-search icon-white"></i> 查询 </button>
					</div>
				<table class="table table-striped table-bordered bootstrap-datatable datatable">
				  <thead>
					  <tr>
						  <th>时间</th>
						  <th>摘要</th>
						  <th>入账金额</th>
						  <th>出账金额</th>
						  <th>余额</th>
					  </tr>
				  </thead>   
				  <tbody>
					<c:choose>
				   		<c:when test="${page.items != null}">
						<c:forEach items="${page.items}" var="log">
							<tr>
								<td class="center"><fmt:formatDate value="${log.actionTime}" pattern="yyyy-MM-dd"/></td>
								<td class="center">${log.actionDesc}</td>
								<td class="center">${log.repeatIn}</td>
								<td class="center">${log.repeatOut}</td>
								<td class="center">${log.repeatBalance}</td>
							</tr>
						</c:forEach>
				   		</c:when>
						<c:otherwise>
							<tr>
								<td class="center" colspan="5"><center>没有找到数据！</center></td>
							</tr>
						</c:otherwise>
					</c:choose>
					</tbody>
				</table>   
	<div>
</div>
	</div>
</div><!--/span-->
</div><!--/row-->
<%@include file="/WEB-INF/pages/common/page.jsp"%>
</form>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
