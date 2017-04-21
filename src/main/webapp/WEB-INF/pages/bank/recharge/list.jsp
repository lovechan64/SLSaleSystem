<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<div>
	<ul class="breadcrumb">
		<li><a href="#">电子银行</a> <span class="divider">/</span></li>
		<li><a href="/bank/base_account/rechargeBill.html">联系客服</a></li>
	</ul>
</div>

<div class="row-fluid sortable">		
	<div class="box span12">
		<div class="box-header well" data-original-title>
			<h2><i class="icon-user"></i>汇款单</h2>
		</div>
		
		<div class="box-content">
			<form name="myform" id="myform" method="post">
			<table class="table table-striped table-bordered bootstrap-datatable datatable">
			  	<thead>
				  <tr>
					  <th>单号</th>
					  <th>汇款金额</th>
					  <th>日期</th>
					  <th>充值银行</th>
					  <th>充值卡号</th>
				  </tr>
			  	</thead>   
			  	<tbody>
					<c:choose>
				   		<c:when test="${page.items != null}">
						<c:forEach items="${page.items}" var="log">
							<tr>
								<td class="center">${log.rechargeNum}</td>
								<td class="center">${log.rechargeMoney}</td>
								<td class="center"><fmt:formatDate value="${log.rechargeTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td class="center">
									${log.bankName}
								</td>
								<td class="center">
									${log.bankAccount}
								</td>
								<td class="center">
									<a class="btn btn-success viewRecharge" href="#" id="${log.rechargeId}">
										<i class="icon-zoom-in icon-white"></i>  
										通知客服                                    
									</a>
								</td>
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
			</form>
		</div>
	</div><!--/span-->
</div><!--/row-->
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="/statics/localjs/rechargeList.js"></script>
