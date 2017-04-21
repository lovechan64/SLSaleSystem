<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<%
String rechargeNum = org.slsale.common.Util.getOrderNum();
 %>

<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">电子银行</a> <span class="divider">/</span></li>
		<li><a href="/bank/gotoRecharge.html">汇款充值</a> <span class="divider">/</span></li>
		<li><a href="#">支付页</a></li>
	</ul>
</div>
<div class="row-fluid sortable">
	<div class="box span12">
		<div class="box-content" style="padding-left: 100px;">
			<div>汇款金额：${recharge.rechargeMoney}</div>
			<div>单 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;号：${recharge.rechargeNum}</div>
			<div>点击下面图标进入在线支付系统，在线支付可能要花费一些时间，请您在提交个人卡信息后，一定要等看到我们的系统显示支付返回结果充值成功提示后再关闭支付页面，否则您所支付的款将不能自动充值到您的“基本账户”。</div>
			<div id="header">
				<div class="header-container fn-clear" >
				   	<h1 class="fn-left logo">
				   	<span seed="link-logo">
						<a href="/bank/recharge/doPay.html?rechargeId=${recharge.rechargeId}">
							<img alt="" src="/statics/img/alipayLogo.jpg" onclick="">
						</a>
					</span>
					</h1>
				</div>
			</div>		
		</div>
	</div><!--/span-->
</div><!--/row-->
<div class="modal hide fade" id="viewConfirmDiv">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>确认汇款信息</h3>
	</div>
	<div class="modal-body">
		<input id="v_id" type="hidden" value=""/>
		<div>
			<div id="confirm_rechargeTime">汇款日期：</div>
		</div>
		<div>
			<div id="confirm_rechargeMoney">汇款金额：</div>
		</div>
		<div>
			<div id="confirm_note">摘 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;要：</div>
		</div>
		<div>
			<div id="confirm_rechargeNum">单 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;号：</div>
		</div>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn viewmembercancel" data-dismiss="modal" onclick="doRecharge();">确定</a>
		<a href="#" class="btn viewmembercancel" data-dismiss="modal">关闭</a>
	</div>
 </div>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="/statics/localjs/doRecharge.js"></script> 