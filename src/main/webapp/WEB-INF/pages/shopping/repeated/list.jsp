<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">购物管理</a> <span class="divider">/</span></li>
		<li><a href="/shopping/repeated/list.html">重消购货</a></li>
	</ul>
</div>

<form id="myForm" action="/shopping/repeated/list.html" method="post">
	<div class="row-fluid sortable">		
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class="icon-user"></i>重消套餐列表</h2>
			</div>
			
			<div class="box-content">
					<div class="searcharea">
						编号：<input name="code" id="code" value="${code}"/>
						套餐名称：<input name="packName" id="packName" value="${packName}"/>
						<input type="hidden" id="checkedIds" name="checkedIds">
						<input type="hidden" id="buyNums" name="buyNums">
						<input type="hidden" id="type" name="type" value="repeated">
						<button type="submit" class="btn btn-primary"><i class="icon-search icon-white"></i> 查询 </button>
						<button type="button" class="btn btn-primary gotobtn"><i class="icon-shopping-cart icon-white"></i>去结算</button>
						<button type="button" class="btn btn-primary nextbtn"><i class="icon-shopping-cart icon-white"></i>加入购物车</button>
					</div>
				<table class="table table-striped table-bordered bootstrap-datatable datatable">
				  <thead>
					  <tr>
						  <th>选择</th>
						  <th>套餐编号</th>
						  <th>套餐名称</th>
						  <th>套餐价格</th>
						  <th>说明</th>
						  <th>库存数量</th>
						  <th>购买数量</th>
					  </tr>
				  </thead>   
				  <tbody>
				   		<c:choose>
				   		<c:when test="${page.items != null}">
						<c:forEach items="${page.items}" var="pack">
							<tr>
								<td class="td">
								  <label class="checkbox">
									<input type="checkbox" name="cks" value="${pack.id}">
								  </label>
								</td>
								<td>${pack.goodsPackCode}</td>
								<td>${pack.goodsPackName}</td>
								<td>${pack.totalPrice}</td>
								<td>${pack.note}</td>
								<td>${pack.num}</td>
								<td><input type="text" id="${pack.id}" name="buyNum" num="${pack.num}" ></td>
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
<script src="/statics/localjs/repeated.js"></script>