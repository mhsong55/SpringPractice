<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="css/top.css" type="text/css" rel="stylesheet"/>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>PNF 리조트 - 오시는 길</title>
</head>
<body>
	<jsp:include page="top.jsp" flush="false"/>
    <div class="container">
   	   	<div class="map">
             <div class="daumMap">
                 <div id="map" style="width:100%; height:500px"></div>
                 <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a45d18c31798869b90c3a416c70b0adc"></script>
                 <script>
                     var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
                     var options = { //지도를 생성할 때 필요한 기본 옵션
                         center: new kakao.maps.LatLng(37.3860521, 127.1214038), //지도의 중심좌표.
                         level: 3 //지도의 레벨(확대, 축소 정도)
                     };

                     var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

                     // 마커 표시 위치
                     var markerPosition = new kakao.maps.LatLng(37.3860521, 127.1214038);

                     // 마커 생성
                     var marker = new kakao.maps.Marker({
                         position: markerPosition
                     });

                     // 마커가 지도 위에 표시되도록 설정
                     marker.setMap(map);

                     // 아래 코드는 지도 위의 마커를 제거하는 코드
                     // marker.setMap(null);
                 </script>
             </div>
        </div>
        <br>
        <div style="display: flex; justify-content: center;">
			<h2>조아리조트의 위치: 위도(37.3860521), 경도(127.1214038)</h2>
		</div>
    </div>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.bundle.min.js"></script>
    <script type="text/javascript" src="js/top.js"></script>
</body>
</html>