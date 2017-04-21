<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">电子银行</a> <span class="divider">/</span></li>
		<li><a href="/bank/transfer_accounts/transfer.html">内部转账</a></li>
	</ul>
</div>
			<div class="row-fluid sortable">
				<div class="box span12">
				<div class="box-content" style="padding-left: 100px;">
				<form id="transferForm" action="/bank/doInternalTransfer.html" method="get" >
					<div class="member-modal-body">
						<ul id="add_formtip"></ul>
						<div>
							  <label>当前余额：</label>
							  <input type="hidden" id="baseBalance" value="${account.baseBalance}">
							  ${account.baseBalance}元
						</div>
						<div>
							  <label>转账目标：</label>
							  <input id="targetUser" name="targetUser" type="text" >
							  <span style="color:red;font-weight: bold;">*（请仔细检查接受转账的会员登录名，不能给注册会员转账）</span>
						</div>
						<div>
							  <label>转账金额：</label>
							  <input type="text" id="transferMoney" name="transferMoney">元 
							  <span style="color:red;font-weight: bold;"> *</span>
							  <a href="/bank/recharge/gotoRecharge.html">余额不足，马上去汇款充值</a>
						</div>
						<div>
					 		  <label>二级密码：</label>
							  <input type="password" id="password" name="password">
							  <span style="color:red;font-weight: bold;">*</span>
						</div>
						<div>
							  <label>摘要信息：</label>
							  <textarea rows="" cols="" id="note" name="note"></textarea>
						</div>
						<div class="clear"></div>
						<ul class="downul"></ul>
					</div>
					<div class="clear"></div>
					<div style="padding-left: 70px;">
						<br>
						<input type="button" class="btn btn-primary nextbtn" value="提交">
					</div>
			</form>	
		</div>
	</div>
</div>
<div class="modal hide fade" id="viewConfirmDiv">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>确认转账信息</h3>
	</div>
	<div class="modal-body">
			<div id="confirm_targetUser"></div>
			<div id="confirm_transferMoney"></div>
			<div id="confirm_note"></div>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn viewmembercancel" id="submit" data-dismiss="modal">确定</a>
		<a href="#" class="btn viewmembercancel" id="close" data-dismiss="modal">关闭</a>
	</div>
 </div>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="/statics/localjs/transfer.js"></script> 