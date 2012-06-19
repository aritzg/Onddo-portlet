/*GOOGLE MAPS*/
var canvas;
var map;

var defaultPoint =  new google.maps.LatLng(43.313188, -1.983719);

function initMap(mapaCanvas){
	var A = AUI();
	canvas=mapaCanvas;
	var page = A.getBody().get('viewportRegion');
	canvas.style.height=page.bottom-200 + 'px';
	var myOptions = {
			zoom: 11,
			center: defaultPoint,
			mapTypeId: google.maps.MapTypeId.ROADMAP 
	};

	map = new google.maps.Map(canvas,myOptions);

}