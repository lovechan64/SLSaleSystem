<%@page language="java" import="java.util.*,org.slsale.pojo.User,org.slsale.common.Constants" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">购物管理</a> <span class="divider">/</span></li>
		<li><a href="#">确认激活</a></li>
	</ul>
</div>
<div class="box span12">
	<div class="box-content">
		<div class="member-modal-body">
			<div>
				  <label>会员安置列表</label>               <c:if test="${sessionScope.targetPlaceUser!=null}">(待安置会员：${sessionScope.targetPlaceUser.loginCode })</c:if>
			</div>
			<div>
				<%
					List list = (List)request.getAttribute("codeList");
					Map resultMap = (Map)request.getAttribute("resultMap");
				%>
					<table class="table table-striped table-brefered bootstrap-datatable datatable"  >
					<c:if test="${codeList != null}">
						<%
						int k= 0;
						int colspan = 8;
						for(int i=0;i<list.size();i++){
							String totalCode = String.valueOf(list.get(i));
							if(i==0){
						%>	
						<tr align="center">
						<%
							}
							
						%>			
							<td colspan="<%=colspan%>" style="text-align:center;">
						<%
							User user = (User)resultMap.get(totalCode);
							if(null!=user){
						%>
							 <a href="/shopping/activate/gotoActivate.html?rootCode=<%=list.get(0)%>&totalCode=<%=totalCode%>">
								 <img src="/statics/img/o_user.png" alt="已安置用户" height="40px;"/>
							 </a>
							<p> 已安置用户：<%=user.getLoginCode() %></p>
							<% 
							}else{
								User targetPlaceUser = (User)session.getAttribute(Constants.TARGET_PLACE_USER);
								if(targetPlaceUser!=null){
									String parentCode = totalCode.substring(0,totalCode.length()-1);
									User parentUser = (User)resultMap.get(parentCode);
									if(parentUser!=null){
									%>
									<c:if test="${sessionScope.targetPlaceUser!=null}">
									 <a href="#" onclick="doActivate('<%=list.get(0)%>','<%=totalCode%>');">
										 <img src="/statics/img/user.png" alt="可安置区域" height="40px;"/>
									 </a>
									<p>可安置位置</p>
									</c:if>
									<% 
									}else{
									%>
									<img src="/statics/img/50x50.png" alt="不可安置区域" height="40px;"/>
									<p>不可安置位置</p>
									<% 
									}
								}else{
									%>
									<img src="/statics/img/50x50.png" alt="空位" height="40px;"/>
									<p>空位</p>
									<% 
								}
							}
							%>
							</td>
						<%
							if(i==k){
						%>	
						</tr>
						<%
							if(i!=list.size()-1){
						%>	
						<tr align="center">
						<%
							}		
								colspan =colspan/2;
								k=(k+1)*2;
							}
						}
						%>
					</table>
				</c:if>
			</div>
				
			<div class="clear"></div>
			<div  style="text-align:center;">
				<br>
				<input type="button" class="btn btn-primary prevbtn" value="返回">
			</div>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<script type="text/javascript" src="/statics/localjs/activate.js"></script> 