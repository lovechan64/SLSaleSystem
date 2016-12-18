<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">电子银行</a> <span class="divider">/</span></li>
		<li><a href="/bank/apply_cash/apply.html">申请提现</a></li>
	</ul>
</div>
			<div class="row-fluid sortable">
				<div class="box span12">
				<div class="box-content" style="padding-left: 100px;">
				<form id="applyForm" action="/bank/apply_cash/doApply.html" method="get" >
					<div class="member-modal-body">
						<ul id="add_formtip"></ul>
						<div>
							  <label>剩&nbsp;余&nbsp;P&nbsp;V：</label>
							  <input type="hidden" id="baseBalance" value="${account.baseBalance}">
							  ${account.baseBalance}
						</div>
						<div>
							  <label>提&nbsp;现&nbsp;P&nbsp;V：</label>
							  <input type="text" id="cashPV" name="cashPV"> 
							  <span style="color:red;font-weight: bold;"> *</span>
						</div>
						<div>
							  <label>银行名称：</label>
							  <select name="bankName" id="bankName" style="width:100px;">
				 				<option value="" selected="selected">请选择</option>
				 				<option value="中国银行">中国银行</option>
				 				<option value="农业银行">农业银行</option>
				 				<option value="工商银行">工商银行</option>
				 				<option value="建设银行">建设银行</option>
				 				<option value="民生银行">民生银行</option>
				 				<option value="中信银行">中信银行</option>
				 			  </select> 
							  <span style="color:red;font-weight: bold;">*</span>
						</div>
						<div>
							  <label>支行名称：</label>
							  <input type="text" id="bankBrance" name="bankBrance"> 
							  <span style="color:red;font-weight: bold;"> *</span>
						</div>
						<div>
							  <label>开&nbsp;&nbsp;户&nbsp;&nbsp;人：</label>
							  <input type="text" id="accountName" name="accountName"> 
							  <span style="color:red;font-weight: bold;"> *</span>
						</div>
						<div>
							  <label>银行卡号：</label>
							  <input type="text" id="bankAccount" name="bankAccount">
							  <span style="color:red;font-weight: bold;"> *</span>
						</div>
						<div>
					 		  <label>二级密码：</label>
							  <input type="password" id="password" name="password">
							  <span style="color:red;font-weight: bold;">*</span>
						</div>
						<div class="clear"></div>
						<ul class="downul"></ul>
					</div>
					<div class="clear"></div>
					<div style="padding-left: 70px;">
						<br>
						<input type="button" class="btn btn-primary nextbtn" value="提交申请">
					</div>
			</form>	
		</div>
	</div>
</div>
<div class="modal hide fade" id="viewInfoDiv">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>提示</h3>
	</div>
	<div class="modal-body">
		<div>
			你好，根据公司的提现规定，每月10号之前申请提现，30号发放；20号之前申请提现，次月10好发放；每月月底之前申请提现，次月20号发放。提现有5%手续费（国际汇款费用，汇率差）。谢谢！
		</div>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn viewmembercancel" id="close" data-dismiss="modal">好的，继续</a>
	</div>
 </div>
<div class="modal hide fade" id="viewConfirmDiv">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>确认提现信息</h3>
	</div>
	<div class="modal-body">
			<div id="confirm_cashPV"></div>
			<div id="confirm_bankName"></div>
			<div id="confirm_bankBrance"></div>
			<div id="confirm_accountName"></div>
			<div id="confirm_bankAccount"></div>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn viewmembercancel" id="submit" data-dismiss="modal">确定</a>
		<a href="#" class="btn viewmembercancel" id="close" data-dismiss="modal">关闭</a>
	</div>
 </div>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="/statics/localjs/apply.js"></script> 