<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">购物管理</a> <span class="divider">/</span></li>
		<li><a href="/shopping/management/list.html">订单管理</a></li>
	</ul>
</div>
<form id="myForm" action="/shopping/management/list.html" method="post">
	<div class="row-fluid sortable">		
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class=" icon-th-list"></i>订单列表列表</h2>
			</div>
			
			<div class="box-content">
					<div class="searcharea">
						订单编号：<input name="orderNum" id="orderNum" value="${orderNum}"/>
						订单类别：<select name="orderType" style="width:100px;">
					 			<option value="" selected>--请选择--</option>
					 			<option <c:if test="${orderType == 'BD'}">selected</c:if> value="BD">报单购货</option>
					 			<option <c:if test="${orderType == 'CX'}">selected</c:if> value="CX">重消购货</option>
					 			<option <c:if test="${orderType == 'FX'}">selected</c:if> value="FX">辅消购货</option>
					 		</select>
						<button type="submit" class="btn btn-primary"><i class="icon-search icon-white"></i> 查询 </button>
					</div>
				<table class="table table-striped table-bordered bootstrap-datatable datatable">
				  <thead>
					  <tr>
						  <th>订单编号</th>
						  <th>订单日期</th>
						  <th>订单类型</th>
						  <th>收货人</th>
						  <th>订单金额(PV)</th>
						  <th>操作</th>
					  </tr>
				  </thead>   
				  <tbody>
				   		<c:choose>
				   		<c:when test="${page.items != null && page.items!='[]'}">
						<c:forEach items="${page.items}" var="order">
							<tr>
								<td>${order.orderNum}</td>
								<td><fmt:formatDate value="${order.orderTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>
									<c:choose>
									<c:when test="${order.type=='BD'}">报单购货</c:when>
									<c:when test="${order.type=='CX'}">重消购货</c:when>
									<c:when test="${order.type=='FX'}">辅消购货</c:when>
									<c:otherwise>未知</c:otherwise>
									</c:choose>
								</td>
								<td>${order.pickUserName}</td>
								<td>${order.totalPrice}</td>
								<td>
									<button type="button" class="btn btn-danger delorder" id="${order.orderId}" orderNum="${order.orderNum}"><i class="icon-trash icon-white"></i>删除 </button>
								</td>
							</tr>
						</c:forEach>
				   		</c:when>
						<c:otherwise>
							<tr>
								<td class="center" colspan="7"><center>没有找到数据！</center></td>
							</tr>
						</c:otherwise>
				   		</c:choose>
					</tbody>
				</table>   
			</div>
		</div><!--/span-->
	</div><!--/row-->
<%@include file="/WEB-INF/pages/common/page.jsp"%>
</form>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script src="/statics/localjs/ordermanagement.js"></script>