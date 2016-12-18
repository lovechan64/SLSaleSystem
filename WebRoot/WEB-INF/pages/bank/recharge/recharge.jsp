<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<%
String rechargeNum = org.slsale.common.Util.getOrderNum(org.slsale.common.Constants.ORDER_TYPE_CZ);
 %>
<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">电子银行</a> <span class="divider">/</span></li>
		<li><a href="bank/recharge/gotoRecharge.html">汇款充值</a></li>
	</ul>
</div>
			<div class="row-fluid sortable">
				<div class="box span12">
				<div class="box-content" style="padding-left: 100px;">
				<form id="myForm" action="/bank/doRecharge.html" method="post">
					<div class="member-modal-body">
						<ul id="add_formtip"></ul>
						<div>
							  <label>汇款日期：</label>
							  <input class="Wdate" id="rechargeTime" size="15" name="rechargeTime" readonly="readonly"  type="text" onClick="WdatePicker();" />
							  <span style="color:red;font-weight: bold;">*</span>
						</div>
						<div>
							  <label>汇款金额：</label>
							  <input type="text" id="rechargeMoney" name="rechargeMoney"/>
							  <span style="color:red;font-weight: bold;">*</span>
						</div>
						<div>
							  <label>摘 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;要：</label>
							  <textarea rows="" cols="" id="note" name="note"></textarea>
						</div>
						<div>
					 		  <label>单 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;号：</label>
							  <input id="rechargeNum" type="hidden" name="rechargeNum" value="${recharge.rechargeNum}"/>
							  ${recharge.rechargeNum}
							  <span style="color:red;font-weight: bold;">*</span>
						</div>
						<div class="clear"></div>
						<ul class="downul"></ul>
					</div>
					<div class="clear"></div>
					<div style="padding-left: 70px;">
						<br>
						<input type="button"  class="btn btn-primary nextbtn" value="提交" onclick="validate();" />
					</div>
			</form>	
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