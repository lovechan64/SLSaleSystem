<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="pagination pagination-centered">
	<ul>
	 	<c:choose>
			<c:when test="${page.page == 1}">
				<li class="active"><a href="javascript:void();" title="首页">首页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:firstPage();" title="首页">首页</a></li>
			</c:otherwise>
		</c:choose>
		
		<c:if test="${page.prevPages!=null}">
			<c:forEach items="${page.prevPages}" var="num">
				<li><a href="javascript:previousPage();" class="number" title="${num}">${num}</a></li>
			</c:forEach>
		</c:if>
		<li class="active">
		  <a href="#" title="${page.page}">${page.page}</a>
		</li>
		<c:if test="${page.nextPages!=null}">
			<c:forEach items="${page.nextPages}" var="num">
				<li><a href="javascript:nextPage();">${num}</a></li>
			</c:forEach>
		</c:if>
		<c:choose>
			<c:when test="${page.page == page.pageCount}">
				<li class="active"><a href="javascript:void();" title="尾页">尾页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:lastPage();" title="尾页">尾页</a></li>
			</c:otherwise>
		</c:choose>
 	</ul>
 	<input type="hidden" id="currentpage" name="currentpage" value="${page.page}">
	<input type="hidden" id="pageCount" name="pageCount" value="${page.pageCount}">
</div>
<script src="/statics/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="/statics/localjs/page.js"/>