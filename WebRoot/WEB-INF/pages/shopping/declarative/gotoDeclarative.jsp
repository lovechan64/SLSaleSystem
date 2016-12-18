<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">购物管理</a> <span class="divider">/</span></li>
		<li><a href="#">报单购货</a></li>
	</ul>
</div>
			<div class="row-fluid sortable">
				<div class="box span12">
				<div class="box-content" style="padding-left: 100px;">
				<form id="submitForm" action="/shopping/declarative/doDeclarative.html" method="post" >
					<div class="member-modal-body">
						<ul id="add_formtip"></ul>
						<div>
							  <label>购货会员：</label>
							  <input type="hidden" id="targetUserId" name="targetUserId" value="${targetUser.id}">
							  <input type="hidden" id="loginCode" name="loginCode" value="${targetUser.loginCode}">
							   ${targetUser.loginCode}
						</div>
						<div>
							  <label>当前余额：</label>
							  <input type="hidden" id="baseBalance" value="${account.baseBalance}">
							  ${account.baseBalance} PV
						</div>
						<div>
							<label>选择报单购物套餐：</label>
							<span style="color:red;font-weight: bold;">*</span>
							<c:if test="${packList != null}">
								<c:forEach items="${packList}" var="pack">
								  <div>
								  <label class="radio">
									<input type="radio" name="goodsPack"  value="${pack.totalPrice}" id="${pack.id}" title="${pack.goodsPackName}"/>
									${pack.goodsPackName} 消费PV:${pack.totalPrice} PV
								  </label>
								  </div>
								</c:forEach>
							</c:if>
							 <a href="/bank/recharge/gotoRecharge.html">余额不足，马上去汇款充值</a>
						</div>
						<div>
							  <label>快递类型：</label>
							  <select id="expressType" >
							  	<option value="">请选择</option>
							  	<option value="EMS" <c:if test="${ targetUser.expressType!=null && targetUser.expressType=='EMS'}">selected</c:if>>EMS</option>
							  	<option value="顺风" <c:if test="${ targetUser.expressType!=null && targetUser.expressType=='顺风'}">selected</c:if>>顺风</option>
							  	<option value="圆通" <c:if test="${ targetUser.expressType!=null && targetUser.expressType=='圆通'}">selected</c:if>>圆通</option>
							  	<option value="中通" <c:if test="${ targetUser.expressType!=null && targetUser.expressType=='中通'}">selected</c:if>>中通</option>
							  </select>
							  <span style="color:red;font-weight: bold;"> *</span>
						</div>
						<div>
							  <label>收货地址：</label>
							  <input type="text" id="userAddress" name="userAddress" value="${targetUser.userAddress}"> 
							  <span style="color:red;font-weight: bold;"> *</span>
						</div>
						<div>
							  <label>邮政编码：</label>
							  <input type="text" id="postCode" name="postCode" value="${targetUser.postCode}">
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
						<input type="button" class="btn btn-primary prevbtn" value="上一步">
						<input type="button" class="btn btn-primary nextbtn" value="下一步" >
					</div>
			</form>	
		</div>
	</div>
</div>
<div class="modal hide fade" id="viewConfirmDiv">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>确认购货信息</h3>
	</div>
	<div class="modal-body">
			<div id="confirm_loginCode"></div>
			<div id="confirm_goodsPack"></div>
			<div id="confirm_userAddress"></div>
			<div id="confirm_expressType"></div>
			<div id="confirm_postCode"></div>
	</div>
	<div class="modal-footer">
		<a href="#" class="btn viewmembercancel" id="submit" data-dismiss="modal">确定</a>
		<a href="#" class="btn viewmembercancel" id="close" data-dismiss="modal">关闭</a>
	</div>
 </div>
<div class="modal hide fade" id="successConfirmDiv">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal">×</button>
		<h3>提示</h3>
	</div>
	<div class="modal-body">
			
	</div>
	<div class="modal-footer">
		<a href="#" class="btn viewmembercancel" id="submit" data-dismiss="modal">确定</a>
		<a href="#" class="btn viewmembercancel" id="close" data-dismiss="modal">关闭</a>
	</div>
 </div>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="/statics/localjs/declarative.js"></script> 