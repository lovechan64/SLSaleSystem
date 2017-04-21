<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">电子银行</a> <span class="divider">/</span></li>
		<li><a href="/bank/apply_cash/list.html">提现明细</a></li>
	</ul>
</div>

<div class="row-fluid sortable">		
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class="icon-user"></i>提现明细列表</h2>
			</div>
			
			<div class="box-content">
				<form action="/bank/apply_cash/list.html" method="post">
					<div class="searcharea">
					申请时间:&nbsp;&nbsp;<input class="Wdate" id="start" size="15" name="start" readonly="readonly"  type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'});" value="${start}"  />
					—&nbsp;&nbsp;&nbsp;&nbsp;<input class="Wdate" id="end" size="15" name="end" readonly="readonly"  type="text" onClick="WdatePicker({dateFmt:'yyyy-MM-dd'});" value="${end}"  />
						
	<button type="submit" class="btn btn-primary"><i class="icon-search icon-white"></i> 查询 </button>
</div>
</form>
<table class="table table-striped table-bordered bootstrap-datatable datatable">
  <thead>
	  <tr>
		  <th>申请时间</th>
		  <th>申请单号</th>
		  <th>提现状态</th>
		  <th>提现货币</th>
		  <th>PV转换率</th>
		  <th>提现金额</th>
		  <th>手续费</th>
		  <th>提现银行</th>
		  <th>银行卡号</th>
		  <th>开户人</th>
	  </tr>
  </thead>   
  <tbody>
 
	<c:choose>
   		<c:when test="${page.items != null}">
		<c:forEach items="${page.items}" var="cash">
			<tr>
				<td class="center"><fmt:formatDate value="${cash.cashTime}" pattern="yyyy-MM-dd"/></td>
				<td class="center">${cash.cashNum}</td>
				<td class="center">
				<c:choose>
					<c:when test="${cash.stat==0}">申请提现</c:when>
					<c:when test="${cash.stat==1}">审核通过</c:when>
					<c:when test="${cash.stat==2}">转账完毕</c:when>
					<c:otherwise>
						未知
					</c:otherwise>
				</c:choose>
				
				</td>
				<td class="center">${cash.currency}</td>
				<td class="center">${cash.pvRate}</td>
				<td class="center">${cash.cashMoney}</td>
				<td class="center">${cash.fee}</td>
				<td class="center">${cash.bankName}</td>
				<td class="center">${cash.bankAccount}</td>
				<td class="center">${cash.accountName}</td>
			</tr>
		</c:forEach>
   		</c:when>
		<c:otherwise>
			<tr>
				<td class="center" colspan="10"><center>没有找到数据！</center></td>
			</tr>
		</c:otherwise>
	</c:choose>
	  </tbody>
  </table>   
	<div class="pagination pagination-centered">
		  <ul>
		   <c:choose>
				<c:when test="${page.page == 1}">
				<li class="active"><a href="javascript:void();" title="首页">首页</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="/member/memberlist.html?currentpage=1&s_loginCode=${s_loginCode}&s_userName=${s_userName}" title="首页">首页</a></li>
				</c:otherwise>
				</c:choose>
				
				<c:if test="${page.prevPages!=null}">
				<c:forEach items="${page.prevPages}" var="num">
				<li><a href="/member/memberlist.html?currentpage=${num}&s_loginCode=${s_loginCode}&s_userName=${s_userName}"
				class="number" title="${num}">${num}</a></li>
				</c:forEach>
				</c:if>
				<li class="active">
				  <a href="#" title="${page.page}">${page.page}</a>
				</li>
				<c:if test="${page.nextPages!=null}">
				<c:forEach items="${page.nextPages}" var="num">
				<li><a href="/member/memberlist.html?currentpage=${num}&s_loginCode=${s_loginCode}&s_userName=${s_userName}" title="${num}">
				${num} </a></li>
				</c:forEach>
				</c:if>
				<c:if test="${page.pageCount !=null}">
				<c:choose>
				<c:when test="${page.page == page.pageCount}">
				<li class="active"><a href="javascript:void();" title="尾页">尾页</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="/member/memberlist.html?currentpage=${page.pageCount}&s_loginCode=${s_loginCode}&s_userName=${s_userName}" title="尾页">尾页</a></li>
				</c:otherwise>
				</c:choose>
				</c:if>
				<c:if test="${page.pageCount == null}">
				<li class="active"><a href="javascript:void();" title="尾页">尾页</a></li>
		 	</c:if>
		  </ul>
	  </div>
	<div>
</div>
	</div>
</div><!--/span-->
</div><!--/row-->
		

<%@include file="/WEB-INF/pages/common/foot.jsp"%>
