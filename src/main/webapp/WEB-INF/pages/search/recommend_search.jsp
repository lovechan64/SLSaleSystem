<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/head.jsp"%>
<link href='/statics/localcss/recharge.css' rel='stylesheet'>
<div>
	<ul class="breadcrumb">
		<li><a href="#">信息查询</a> <span class="divider">/</span></li>
		<li><a href="/search/recommend_search.html">推荐查询</a></li>
	</ul>
</div>
<script type="text/javascript">
var userListJOSN = '${userListJOSN}';
//alert(userListJOSN);
var loginCode = '${sessionUser.loginCode}';
</script>
<div class="row-fluid sortable">
	<div class="span2 main-menu-span">
		<div class="well nav-collapse sidebar-nav">
			<ul class="nav nav-tabs nav-stacked main-menu" id="recommend"></ul>
		</div>
	</div>
	<div class="span2 main-menu-span">
		<div class="well nav-collapse" style="display:none;width: 500px;" id="show">
		</div>
	</div>
</div>

<%@include file="/WEB-INF/pages/common/foot.jsp"%>
<!-- 
<script type="text/javascript" src="/statics/localjs/ordermanagement.js"/>
<script type="text/javascript" src="/statics/localjs/recommend.js"/>
 -->
<script src="/statics/localjs/recommends.js"></script>