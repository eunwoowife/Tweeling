<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/97edb96f4d.js" crossorigin="anonymous"></script>
    <title>footer</title>
    <style>
        #container-fluid {
            height: 350px;
            background-color: rgb(203, 203, 203);
        }

        #linksb1 {
            padding-top: 20px;
            padding-bottom: 20px;
        }

        #linksb1>span{
            padding-left: 80px;
            padding-right: 80px;
        }

        #linksb3 {
            padding-left: 300px;
        }

        #linksb1>span>a,
        #logo>a,
        #socialLink1>a,
        #socialLink2>a,
        #socialLink3>a {
            color: #000;
            text-decoration: none;
        }

        #logo2 a{
            font-family: 'Cinzel', serif;
            font-size: 50px;
            color : black;
        }

        .socialLink {
            padding-left: 20px;
            padding-right: 20px;
        }
    </style>
</head>

<footer>
    <div id="container-fluid" class="container-fluid">
        <div id="linksb1" align="center">
            <span id="linksb1a" class="linksb1"><a href="#">제휴문의</a></span>
            <span id="linksb1b" class="linksb1"><a href="#">이용약관</a></span>
            <span id="linksb1c" class="linksb1"><a href="#">개인정보처리방침</a></span>
            <span id="linksb1d" class="linksb1"><a href="#">이용안내</a></span>
            <span id="linksb1e" class="linksb1"><a href="#">공지사항</a></span>
            <span id="linksb1f" class="linksb1"><a href="<%=request.getContextPath()%>/view.ma">찾아오시는 길</a></span>
        </div>
        <div id="linksb2" align="center">
            <span id="logo2"><a href="#">Tweeling</a></span>
        </div>
        <div id="linksb3">
            <pre id="linksb3-contents">
프로젝트명: Tweeling
조원: 김병주 김병철 노윤석 배주현 이민경 홍진휘
프로젝트 기간: 2022.10.31 ~ 2022.11.18
주소: 서울특별시 영등포구 선유동2로 57 이레빌딩(구관) 19F, 20F

Tweeling의 모든 콘텐츠는 저작권의 보호를 받고 있습니다.
            </pre>
        </div>
        <div id="linksb4" align="center">
            <span id="socialLink1" class="socialLink"><a href="#"><i class="fa-brands fa-twitter"></i></a></span>
            <span id="socialLink2" class="socialLink"><a href="#"><i class="fa-brands fa-facebook"></i></a></span>
            <span id="socialLink3" class="socialLink"><a href="#"><i class="fa-brands fa-instagram"></i></a></span>
        </div>
    </div>
</footer>

</html>