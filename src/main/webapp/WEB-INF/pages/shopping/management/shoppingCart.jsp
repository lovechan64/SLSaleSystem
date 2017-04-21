<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">购物管理</a> <span class="divider">/</span></li>
		<li><a href="/shopping/management/list.html">购物车</a></li>
	</ul>
</div>

<form id="myForm" action="/shopping/management/settlement.html" method="post">
	<div class="row-fluid sortable">		
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class="icon-shopping-cart"></i>购物车列表</h2>
			</div>
			
			<div class="box-content">
				<table id="_w_table_rownum" class="table table-striped table-bordered bootstrap-datatable datatable" >
				  <thead>
					  <tr>
						  <th style="text-align: center;width: 2%;" >选择</th>
						  <th style="text-align: center;width: 5%;">订单编号</th>
						  <th style="text-align: center;width: 5%;">套餐编号</th>
						  <th style="text-align: center;width: 5%;">套餐名称</th>
						  <th style="text-align: center;width: 5%;">套餐价格</th>
						  <th style="text-align: center;width: 5%;">购买数量</th>
						  <th style="text-align: center;width: 5%;">总价</th>
					  </tr>
				  </thead>   
				  <tbody>
				   		<c:choose>
						   	<c:when test="${list != null && list!='[]'}">
						   		<c:set var="sum" value="0"></c:set>
								<c:forEach items="${list}" var="order">
									<c:if test="${order.olList!=null}">
									<c:forEach items="${order.olList}" var="ol" varStatus="varStatus">
									<tr>
										<c:if test="${varStatus.index==0}">
										<td style="text-align: center;" rowspan="${order.olList.size()}">
										  <label class="radio" >
											<input type="radio" name="cks" value="${order.orderId}">
										  </label>
										</td>
										</c:if>
										<c:if test="${varStatus.index==0}">
											<td  style="text-align: center;"  rowspan="${order.olList.size()}">
											<input type="hidden" id="${order.orderId}" value="${order.orderNum}">
											${order.orderNum}</td>
										</c:if>
										<td  style="text-align: center;">${ol.goodsSN}</td>
										<td  style="text-align: center;">${ol.goodsName}</td>
										<td  style="text-align: center;">${ol.sumPrice}</td>
										<td  style="text-align: center;">
											<input type="text" name="${order.orderId}buyNum" value="${ol.goodsNum}" >
										</td>
										<td style="text-align: center;">${ol.sumPrice * ol.goodsNum}</td>
									</tr>
									<c:set var="sum" value="${sum + ol.sumPrice * ol.goodsNum}"></c:set>
									</c:forEach>
									</c:if>
								</c:forEach>
						   		</c:when>
						   		<c:otherwise>
									<tr>
										<td style="text-align: center;" colspan="8"><center>没有找到数据！</center></td>
									</tr>
						   		</c:otherwise>
				   		</c:choose>
					</tbody>
				</table>   
			</div>
			<div style="margin-left: 89%;">
				<c:if test="${list != null && list!='[]'}">
					<label>合计总价：</label>
					<font style="color: red;">${sum}</font>
				</c:if>
			</div>
		</div><!--/span-->
	</div><!--/row-->
	<div style="text-align:right">
		<input type="hidden" id="checkedIds" name="checkedIds">
		<input type="hidden" id="buyNums" name="buyNums">
		<input type="hidden" name="flag" value="chart">
		<button type="button" class="btn btn-danger delCart" ><i class="icon-trash icon-white"></i>删除 </button>
		<input type="button" class="btn btn-primary gotoSettlement"  value="去结算">
	</div>
</form>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script src="/statics/localjs/ordermanagement.js"></script>
