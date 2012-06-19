<%@include file="/jsp/init.jsp"%>
<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
<div id="main-stage">
	<div id="main-map">
		<%@ include file="/jsp/listportlet/map.jsp" %>
	</div>
	<div id="side-show">
		<%@ include file="/jsp/listportlet/sideshow.jsp" %>
	</div>
</div>

<aui:script>
	initMap(document.getElementById('map_canvas'));
</aui:script>
