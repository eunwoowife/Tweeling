<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.kh.member.model.vo.Member"%>

<%
ArrayList<Member> member = (ArrayList<Member>) request.getAttribute("member");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>찾아오시는 길</title>
<style type="text/css">
 
    .outer{
        width: 70%;
    }

    #map{
        margin-top: 20px;
        width: 900px;
        height: 500px;
    }

    #title{
        margin-top: 200px;
        margin-left: 900px;
	    margin-bottom: 30px;
        color: #D2AFDA;
    }


    #maptable{
        width: 900px;
        height: 600px;
        margin-left: 550px;
        margin-bottom: 350px;

        font-style: none;
    }

    #maptable td{
        color: gray;
        font-size: 12px
    }

    #maptable th{
        color: gray;
        margin: 80px;
        background-color: rgb(241, 236, 241);
        height: 50px;
        font-size: 13px;
    }

 
</style>
<!-- <script src="http://maps.google.com/maps/api/js?key=자기가발급한키를입력&region=kr"></script> -->
<script src="http://maps.google.com/maps/api/js?key=AIzaSyCUWfJZYmGUKI2iA6ETkp9RkxDr2ULB0JY"></script>
</head>
 
<body>
<%@include file="/views/common/realMenubar.jsp" %>
    <div class="outer">

    <h1 id="title">찾아오시는 길</h1>

    <div id="mapArea">

        <table id="maptable">
              <tr>
                <th width="150px">주소</th>
                <td>서울특별시 영등포구 선유동2로 57 이레빌딩(구관) 19F, 20F (T: 1544-9970 / F: 02-2163-8560)</td>
              </tr>
              <tr>
                <th>버스</th>
                <td>선유고등학교/(구)강서세무서 <br>
                    지선 7612 <br>
                    간선 1000 / 1200 / 1300 / 1301 / 1302 / 1400 / 1500 / 1601 / M6628 / M6724 <br>
                    당산역<br>
                    지선 602 / 760 / 5620 / 5714 / 6514 / 6623 / 6631</td>
              </tr>
              <tr>
                <th>지하철</th>
                <td>지하철 2, 9호선 당산역 12번 출구 400m</td>
              </tr>
              <tr>
                <td colspan="2"><div id="map"></div></td>
    </div>
    </div>
    
 
</body>


<script type="text/javascript">
      
    var map;
    // 지도 출력
    function initMap(){
        var ll = {lat: 37.533801, lng: 126.896986};
        map = new google.maps.Map(
                document.getElementById("map"),
                {zoom: 17, center: ll}
                );
        new google.maps.Marker(
            {position: ll,
                map: map,
                label: "Tweeling"}        
        );
    }
    initMap(); // 맵 생성
    
    // 지도의 중심을 변경하는 작업
    function changeMap1(){
        var ll = {lat:37.533801, lng: 125.239803};
        map.panTo(ll);
        map.setZoom(16);
    } 

</script>

</html>