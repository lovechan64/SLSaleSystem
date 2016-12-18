<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">购物管理</a> <span class="divider">/</span></li>
		<li><a href="/shopping/declarative/prompt.html">报单购货</a></li>
	</ul>
</div>
<style>
.mybox{padding:38px 20px 20px 110px;}
.mybtn{ margin-bottom:17px;margin-left:-30px ;}
</style>
<div class="row-fluid sortable">
	<div class="box span12">
		<form id="submitForm" action="/shopping/declarative/gotoDeclarative.html" method="post" >
			<div class="member-modal-body">
				<div class="control-group mybox">
					 
					<c:choose>
					<c:when test="${userList != null && userList!='[]'}">
						<label>报单购货会员：</label>
						<select id="targetUserId" name="targetUserId" data-rel="chosen" style="width:100px;margin-top: 30px;">
						<c:forEach items="${userList}" var="u">
							<option value="${u.id}">${u.loginCode}</option>
						</c:forEach>
						</select>
						<span style="color:red;font-weight: bold;">*</span>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="btn btn-primary mybtn" value="下一步">
					</c:when>
					<c:otherwise>
						无可报单会员，请推荐新会员
					</c:otherwise>
					</c:choose>
					 
				</div>
				<div class="clear"></div>
				<ul class="downul"></ul>
			</div>
			<div class="clear"></div>
		</form>	
	</div>
</div>
<div class="modal hide fade" id="viewInfoDiv">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>说明：</h3>
	</div>
	<div class="modal-body">
		<div>
			<pre>
<h4>
购物分
㈠  “报单购货”：使用基本账户中的款项，“报单购货”后一定要“确认激活”此购货单才有效。
㈡  “重消购物”：使用消费账户中的款项，“重消购物”后不需要“确认激活”。
㈢  “辅消购物”：使用基本账户中的款项，“辅消购物”后不需要“确认激活”。

 ◆ “确认激活”完成两项工作：1、确认“报单购货”的购货单有效；2、为新会员安排左右区位置。
 ◆ 购货单一旦确认、左右区位置一旦安排将不能更改，因此请慎重操作。
 ◆ “确认激活”前要检查基本账户的余额是否大于等于购货款，如果不足要及时为基本账户汇款充值。</h4>
			</pre>
		</div>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn viewmembercancel" id="close" data-dismiss="modal">好的，继续</a>
	</div>
 </div>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="/statics/localjs/declarative.js"></script> 