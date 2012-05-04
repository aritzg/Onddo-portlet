<%@include file="/jsp/init.jsp"%>
<div id="main-stage">
	<div id="main-map">
		<%@ include file="/jsp/listportlet/map.jsp" %>
	</div>
	<div id="side-show">
		<%@ include file="/jsp/listportlet/sideshow.jsp" %>
	</div>
	<div style="clear:both"></div>
</div>

<aui:script>
	alert(Liferay.Browser.browser());
</aui:script>
