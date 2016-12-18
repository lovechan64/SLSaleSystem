<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">信息查询</a> <span class="divider">/</span></li>
		<li><a href="/search/bonus_search.html">奖励查询</a></li>
	</ul>
</div>

<div class=" sortable">		
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-user"></i>个人信息</h2>
		</div>
		<div class="box-content">
			<table style="width: 500px;">
				<tr>
					<th>用户级别：</th>
					<td>${sessionUser.userTypeName}</td>
					<th>推荐会员数：</th>
					<td>${sessionUser.referNum}</td>
				</tr>
			</table>
		</div>
		<div class="box-header well">
			<ul class="nav nav-tabs" id="myTab" >
				<li class="active"><a href="#info">十日内结算明细</a></li>
				<li><a href="#custom">奖金明细表</a></li>
				<li><a href="#messages">月结算</a></li>
			</ul>
		</div> 
		<div class="box-content">
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane active" id="info">
					<table border="2px;" width="1000px;">
						<tr>
							<th width="10%" rowspan="2">日期</th>
							<th width="10%" rowspan="2">新增推荐人数</th>
							<th width="10%" rowspan="2">总碰局数</th>
							<th width="35%" colspan="3">区域网左区</th>
							<th width="35%" colspan="3">区域网右区</th>
						</tr>
						<tr>
							<th width="11%">总人数</th>
							<th width="11%">新安置人数</th>
							<th width="13%">剩余碰数</th>
							<th width="11%">总人数</th>
							<th width="11%">新安置人数</th>
							<th width="13%">剩余碰数</th>
						</tr>
						<c:choose>
					   		<c:when test="${obj1List != null && obj1List !='[]'}">
								<c:forEach items="${obj1List}" var="obj1">
								<tr>
									<td class="center">${obj1[0]}</td>
									<td class="center">${obj1[1]}</td>
									<td class="center">${obj1[2]}</td>
									<td class="center">${obj1[3]}</td>
									<td class="center">${obj1[4]}</td>
									<td class="center">${obj1[5]}</td>
									<td class="center">${obj1[6]}</td>
									<td class="center">${obj1[7]}</td>
									<td class="center">${obj1[8]}</td>
								</tr>
								</c:forEach>
					   		</c:when>
							<c:otherwise>
								<tr>
									<td class="center" colspan="9"><center>没有找到数据！</center></td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>					
				</div>
				<div class="tab-pane" id="custom">
					<table border="2px;" width="1000px;">
						<tr>
							<th width="18%" >日期</th>
							<th width="16%" >推荐奖</th>
							<th width="16%" >安置奖</th>
							<th width="16%" >对碰奖</th>
							<th width="18%" >实发合计</th>
						</tr>
						<c:choose>
					   		<c:when test="${obj2List != null && obj2List !='[]'}">
								<c:forEach items="${obj2List}" var="obj2">
								<tr>
									<td class="center">${obj2[0]}</td>
									<td class="center">${obj2[1]}</td>
									<td class="center">${obj2[2]}</td>
									<td class="center">${obj2[3]}</td>
									<td class="center">${obj2[5]}</td>
								</tr>
								</c:forEach>
								<c:if test="${heji != null}">
									<td class="center">${heji[0]}</td>
									<td class="center">${heji[1]}</td>
									<td class="center">${heji[2]}</td>
									<td class="center">${heji[3]}</td>
									<td class="center">${heji[5]}</td>
								</c:if>
					   		</c:when>
							<c:otherwise>
								<tr>
									<td class="center" colspan="6"><center>没有找到数据！</center></td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
				</div>
				<div class="tab-pane" id="messages">
					<table border="2px;" width="1000px;">
						<tr>
							<th width="20%" >月份</th>
							<th width="20%" >重复消费款</th>
							<th width="20%" >重复消费奖</th>
							<th width="20%" >实发合计</th>
						</tr>
						<c:choose>
					   		<c:when test="${bonus != null}">
								<tr>
									<td class="center">${bonus.bonusMonth}</td>
									<td class="center">${bonus.buyPV}</td>
									<td class="center">${bonus.bonusPV}</td>
									<td class="center">${bonus.bonusPV}</td>
								</tr>
					   		</c:when>
							<c:otherwise>
								<tr>
									<td class="center" colspan="5"><center>没有找到数据！</center></td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
				</div>
			</div>
		</div><!--/span-->
	</div><!--/span-->
</div><!--/row-->
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="/statics/localjs/activate.js"></script>