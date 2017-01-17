var map;

function buytogetherMap() {
	
	var searchBuyTogether = {};
	var myPosition = [];
	var myBound = [];
	var myLat, myLng, bounds, swLatlng, neLatlng, level;
	var refresh = 0;
	
	this.geoLocation = function(callback) {

		if(navigator.geolocation) {
			
			navigator.geolocation.getCurrentPosition(function(position){
				
				myLat = position.coords.latitude;
				myLng = position.coords.longitude;
				
				showMap();
				
				myBound = [swLatlng.gb, swLatlng.hb, neLatlng.gb, neLatlng.hb];

				callback(myBound);
				
			});
			
		} else {
			alert("Geolocation is not supported by this browser");
		}
		
	};

	function showMap() {	
		
		var mapContainer = document.getElementById('map');
		var mapOption = { center: new daum.maps.LatLng(myLat, myLng) };
		
		if(refresh == 0) {
			
			mapOption.level = 8;
			
		} else {
			
			mapOption.level = map.getLevel();
			
		}
		
		map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		var zoomControl = new daum.maps.ZoomControl(); // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
		map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);
		
		bounds = map.getBounds();
		swLatlng = bounds.getSouthWest(); // 영역정보의 남서쪽 정보를 얻어옵니다 		    
		neLatlng = bounds.getNorthEast(); // 영역정보의 북동쪽 정보를 얻어옵니다

	}
	
	this.showMarker = function(data) {
		
		searchBuyTogether = data;

		var markerImage = [];
		var positions = [];
		var imageSize = new daum.maps.Size(64, 69); 
		var imageOprion = {offset: new daum.maps.Point(27, 69)};
		var background = ['#32C739', '#FFDA44', '#E330B3', '#C73234', '#933EC5'];
		var imageSrc = [
			'http://localhost:8098/resources/img/category_1.png',
			'http://localhost:8098/resources/img/category_2.png',
			'http://localhost:8098/resources/img/category_3.png',
			'http://localhost:8098/resources/img/category_4.png',
			'http://localhost:8098/resources/img/category_5.png'
		];
		
		//현재 위치에 마커 설정
		markerImage[0] = new daum.maps.MarkerImage('http://localhost:8098/resources/img/myPosition.png', imageSize, imageOprion);
		positions[0] = { content: '<div class="customoverlay">' 
	    		+ '<a style="background:#2364F8;">'
	    		+ '<span class="title">여기 계신가요?</span></a></div>', 
				latlng: new daum.maps.LatLng(myLat, myLng), img:markerImage[0] };
		//카테고리별 마커 이미지 설정
		for(var i=1; i<6; i++) {
			
			markerImage[i] = new daum.maps.MarkerImage(imageSrc[i-1], imageSize, imageOprion);
			
		}

		// 여러개의 마커
		for(var i=1; i<searchBuyTogether.length; i++){
			
			positions[i] = {
					content: '<div class="customoverlay">' 
					+ '<a href="http://localhost:8098/buyTogether/read?buytogether_number=' + searchBuyTogether[i].buyTogether_number + '" style="background:' + background[searchBuyTogether[i].category_number-1] + ';">'
					+ '<span class="title">' + searchBuyTogether[i].title.substring(0,8) + '...' + '</span></a></div>', 
					latlng: new daum.maps.LatLng(searchBuyTogether[i].latitude, searchBuyTogether[i].longitude),
					img: markerImage[searchBuyTogether[i].category_number]
			};
				
		}
		
		for (var i = 0; i < positions.length; i ++) {
		    // 마커를 생성합니다
		    var marker = new daum.maps.Marker({
		    	
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng, // 마커의 위치
		        image: positions[i].img
		        
		    });
		    
			var customOverlay = new daum.maps.CustomOverlay({
				
			    map: map,
			    position: positions[i].latlng,
			    content: positions[i].content,
			    yAnchor: 1
			    
			});
			
			refresh = 1;
		}
		
	};
	
}
