<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">购物管理</a> <span class="divider">/</span></li>
		<li><a href="#">结算</a></li>
	</ul>
</div>

<form id="myForm" action="/bank/repeated_account/list.html" method="post">
	<div class="row-fluid sortable">		
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class="icon-user"></i>订单明细</h2>
			</div>
			
			<div class="box-content">
					<div class="searcharea">
					<table>
						<tr>
							<td>订&nbsp;&nbsp;单&nbsp;&nbsp;号：${order.orderNum}</td>
						<tr>
						</tr>
							<td>购买会员：${sessionUser.loginCode}</td>
						</tr>
						<tr>
							<td>购&nbsp;&nbsp;买&nbsp;&nbsp;人：${sessionUser.userName}</td>
						</tr>
						<tr>
							<td>购买类型：
							<c:choose>
								<c:when test="${order.type=='CX'}">重消购货</c:when>
								<c:otherwise>辅消购货</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</table>
					</div>
			</div>
			<div class="box-header well" data-original-title>
				<h2><i class="icon-user"></i>商品详情</h2>
			</div>
			<div class="box-content">
				<div>
				<table class="table table-striped table-bordered bootstrap-datatable datatable">
				  <thead>
					  <tr>
						  <th>套餐编号</th>
						  <th>套餐名称</th>
						  <th>套餐价格</th>
						  <th>购买数量</th>
						  <th>总消费PV</th>
					  </tr>
				  </thead>   
				  <tbody>
					<c:choose>
				   	<c:when test="${orderList != null}">
				   		<c:set var="sum" value="0"></c:set>
						<c:forEach items="${orderList}" var="ol">
							<tr>
								<td class="center">${ol.goodsSN}</td>
								<td class="center">${ol.goodsName}</td>
								<td class="center">${ol.sumPrice}</td>
								<td class="center">${ol.goodsNum}</td>
								<td class="center">${ol.sumPrice * ol.goodsNum}</td>
							</tr>
							<c:set var="sum" value="${sum + ol.sumPrice * ol.goodsNum}"></c:set>
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
				</div>
				<div>
					<label>当前余额：  </label>
					<font style="color: red;">
					<c:choose>
						<c:when test="${order.type=='CX'}"> ${account.repeatBalance}</c:when>
						<c:otherwise>${account.baseBalance}</c:otherwise>
					</c:choose>
					</font>
					<a href="/bank/recharge/gotoRecharge.html" style="margin-left:2%;">余额不足，马上去汇款充值</a>
					<label style="margin-left: 44.5%;">合计总价：</label>
					<font style="color: red;">${sum}</font>
				</div>
				<div id="userInfo">
					<div>
					  <label>快递类型：</label>${ user.expressType}
					  <input type="button" class="btn btn-primary modify" style="margin-left:21%;" value="修改">
					</div>
					<div>
						  <label>收货地址：</label>${user.userAddress}
					</div>
					<div>
						  <label>邮政编码：</label>${user.postCode}
					</div>
				</div>
				<div class="hide" id="viewConfirmDiv">
					<div>
					  <label>快递类型：</label>
					  <select id="expressType" >
					  	<option value="" >请选择</option>
					  	<option value="EMS" <c:if test="${ user.expressType=='EMS'}">selected</c:if>>EMS</option>
					  	<option value="顺风" <c:if test="${ user.expressType=='顺风'}">selected</c:if>>顺风</option>
					  	<option value="圆通" <c:if test="${ user.expressType=='圆通'}">selected</c:if>>圆通</option>
					  	<option value="中通" <c:if test="${ user.expressType=='中通'}">selected</c:if>>中通</option>
					  </select>
					  <span style="color:red;font-weight: bold;"> *</span>
					  <input type="button" class="btn btn-primary saveUserInfo" style="margin-left:1%;" value="保存">
					</div>
					<div>
						  <label>收货地址：</label>
						  <input type="text" id="userAddress" name="userAddress" value="${user.userAddress}" > 
						  <span style="color:red;font-weight: bold;"> *</span>
					</div>
					<div>
						  <label>邮政编码：</label>
						  <input type="text" id="postCode" name="postCode" value="${user.postCode}" >
					</div>
				</div>
				<div>
			 		<label>二级密码：</label>
					<input type="hidden" id="orderNum" value="${order.orderNum}">
					<input type="hidden" id="sumPV" value="${sum}">
					<input type="hidden" id="buyNums" name="buyNums">
					<input type="hidden" id="type" name="type" value="${order.type}">
					<input type="password" id="password" name="password">
					<span style="color:red;font-weight: bold;">*</span>
					<input type="button" class="btn btn-primary paymentbtn" style="margin-left:1%;" value="支付">
					<ul id="add_formtip"></ul>
				</div>
			</div>
		</div><!--/span-->
	</div><!--/row-->
</form>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script src="/statics/localjs/repeated.js"></script>