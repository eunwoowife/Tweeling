<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.product.model.vo.*, java.text.DecimalFormat"%>
    
<%
	ArrayList<Product>list = (ArrayList<Product>)request.getAttribute("list");
	
	DecimalFormat decFormat = new DecimalFormat("###,###");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productList</title>
<style>
   .outer{
	width: 1920px;
	margin: auto;
   }
  	#sort{
    width:100px;
    margin-left: 750px;
    margin-bottom: 20px;
  	}
	   
	h1{
    text-align: center;
    margin-left: 600px;
    font-size: 70px;
    color: #D7BFDC;
    }
        
    #noList{
    margin-top : 200px;
    margin-bottom : 200px;
    }
        
   	.slideshow-container {
    max-width: 1000px;
    max-height: 500px;
    position: relative;
    margin: auto;
    }
    /* .slideshow-container .mySlides img,  .prev, .next {
    height: 500px;
    margin-left: 300px;
    } */

    .slideshow-container{
        /* height: 500px; */
        width: 1000px;
        margin-left: 470px;
    }

    /* Hide the images by default */
    .mySlides {
    display: none;
    }

    /* Next & previous buttons */
    .prev, .next {
    cursor: pointer;
    position: absolute;
    top: 50%;
    width: auto;
    margin-top: -22px;
    padding: 16px;
    color: white;
    font-weight: bold;
    font-size: 18px;
    transition: 0.6s ease;
    border-radius: 0 3px 3px 0;
    user-select: none;
    height: 30px;
    } 

    /* Position the "next button" to the right */
    .next {
    right: 0;
    border-radius: 3px 0 0 3px;
    }

    /* On hover, add a black background color with a little bit see-through */
    .prev:hover, .next:hover {
    background-color: rgba(0,0,0,0.8);
    }

    /* Caption text */
    .text {
    color: #f2f2f2;
    font-size: 50px;
    padding: 8px 12px;
    position: absolute;
    bottom: 8px;
    width: 100%;
    text-align: center;
    }

    /* Number text (1/3 etc) */
    .numbertext {
    color: #f2f2f2;
    font-size: 12px;
    padding: 8px 12px;
    position: absolute;
    top: 0;
    }

    .dot-area{
        margin-left: 590px;
    }

    /* The dots/bullets/indicators */
    .dot {
    cursor: pointer;
    height: 15px;
    width: 15px;
    margin: 0 2px;
    background-color: #bbb;
    border-radius: 50%;
    display: inline-block;
    transition: background-color 0.6s ease;
    }

    .active, .dot:hover {
    background-color: #717171;
    }

    /* Fading animation */
    .fade {
    -webkit-animation-name: fade;
    -webkit-animation-duration: 1.5s;
    animation-name: fade;
    animation-duration: 1.5s;
    }

    @-webkit-keyframes fade {
    from {opacity: .4}
    to {opacity: 1}
    }

    @keyframes fade {
    from {opacity: .4}
    to {opacity: 1}
    }
   	
        
    .inner{
    width: 70%;
    
	}
	
	.header1{
	    width: 100%;
	}
	
	.together{
	    float: left;
	    position: relative;
	    margin-left: 18%;
	    
	}
	.content2{
	    margin-left: 85%;
	    margin-top: 3%;
	    position: absolute;
	}
	
	#cList{
	    list-style-type: none;
	}
	
	#cList li{
	    margin: 15px;
	}
	
	#pTitle{
	   text-align: center;
	}
	.category-list{
	    /* margin-right: 0px; */
	    text-align: right;
	    /* margin-right: 200px; */
	    /* margin-top: 500px; */
	}
	
	.category-list a{
	    text-decoration: none;
	    font-size: 20px;
	    font-weight: bold;
	    color: gray;
	}
	
	.category-list a:hover{
	    /* background-color: magenta;
	    color: white;
	    font-style:italic; */
	    text-decoration: underline 4px;
	}
	
	.product-list{
	    width: 1500px;
	    /* margin-left: 350px; */
	    margin-right: auto;
	}
	
	.products h3{
	    font-size: 50px;
	    color: #545454;
	    margin-top:60px;
	    margin-bottom: 60px;
	    /* text-align: center; */
	    text-align: left;
	}
	
	#sortList{
	    margin-left: 70%;
	}
	
	.product{
	    display: block;
	    width: 400px;
	     height: 400px;
	    text-align: center;
	    text-decoration:none;
	    color: black;
	    float:left;
	    margin-left: 5px;
	    margin-right: 5px;
	    margin-bottom: 100px;
	}
	
	.selectPd:hover{
	    /* filter: brightness(0.8); */
	    /*filter: grayscale(1);*/
	    opacity:0.3;
	}
	
	.celeb-name{
	    color: rgb(195, 195, 195);
	}
	.product-name{
	    margin-top: 20px;
	    margin-bottom: 4px;
	}
	
	.clearfix{
	    clear: both;
	}
	
	
	.page{
    text-align: center;
    width: 50%;
    margin-left: 500px;
	}
	
	.pagination{
	    list-style: none;
	    display: inline-block;
	    padding: 0;
	    margin-top: 20px;
	}
	
	.pagination li{
	    display: inline;
	    text-align: center;
	}
	
	.pagination a{
	    float: left;
	    display: block;
	    font-size: 14px;
	    text-decoration: none;
	    padding: 5px 12px;
	    color: #96a0ad;
	    line-height: 1.5;
	}
	
	.first{
	    margin-left: 15px;
	}
	
	.last{
	    margin-left: 15px;
	}
	
	.first:hover, .last:hover, .left:hover, .right:hover{
	    color: gray;
	}
	
	.pagination a.active{
	    cursor: default;
	    color: #ffffff;
	}
	
	.pagination a:active{
	    outline: none;
	}
	
	.modal .num{
	    margin-left: 3px;
	    padding: 0;
	    width: 30px;
	    height: 30px;
	    line-height: 30px;
	    -moz-border-radius: 100%;
	    -webkit-animation-radius: 100%;
	    border-radius: 100%;
	}
	
	.modal .num:hover{
	    background-color: rgb(194, 194, 194);
	    color: #ffffff;
	}
	
	.modal .num.active, .modal .num:active{
	    background-color: gray;
	    cursor: pointer;
	}
	
	.arrow-left{
	    width: 0;
	    height: 0;
	    border-top: 10px solid transparent;
	    border-bottom: 10px solid transparent;
	    border-right: 10px solid gray;
	}
	
</style>
</head>
<body>
<%@include file="/views/common/realMenubar.jsp" %>
	 <div class="outer">
      <div class="inner">
        <br><br><br><br><br>
        <div id="header1">
            <h1>Doja Cat</h1>
        </div>
        <br>
        
        <!--슬라이더이미지-->
        <div class="slideshow-container">

            <!-- Full-width images with number and caption text -->
            <div class="mySlides fade">
              <!-- <div class="numbertext">1 / 6</div> -->
              <img src="resources/image/doja5.jpg" style="width:100%">
              <!-- <div class="text">Ariana Grande</div> -->
            </div>
      
            <div class="mySlides fade">
              <!-- <div class="numbertext">2 / 6</div> -->
              <img src="resources/image/doja1.jpg" style="width:100%">
              <!-- <div class="text">Ariana Grande</div> -->
            </div>
      
            <div class="mySlides fade">
              <!-- <div class="numbertext">3 / 6</div> -->
              <img src="resources/image/doja4.jpg" style="width:100%">
              <!-- <div class="text">Ariana Grande</div> -->
            </div>
      
            <div class="mySlides fade">
              <!-- <div class="numbertext">4 / 6</div> -->
              <img src="resources/image/doja2.jpg" style="width:100%">
              <!-- <div class="text">Ariana Grande</div> -->
            </div>
      
            <div class="mySlides fade">
              <!-- <div class="numbertext">5 / 6</div> -->
              <img src="resources/image/doja3.jpg" style="width:100%">
              <!-- <div class="text">Ariana Grande</div> -->
            </div>
      
            <div class="mySlides fade">
              <!-- <div class="numbertext">6 / 6</div> -->
              <img src="resources/image/doja6.jpg" style="width:100%">
              <!-- <div class="text">Ariana Grande</div> -->
            </div>
      
            <!-- Next and previous buttons -->
            <a class="prev" onclick="moveSlides(-1)">&#10094;</a>
            <a class="next" onclick="moveSlides(1)">&#10095;</a>
          </div>
          <br/>
      
          <!-- The dots/circles -->
          <div class="dot-area" style="text-align:center">
            <span class="dot" onclick="currentSlide(0)"></span>
            <span class="dot" onclick="currentSlide(1)"></span>
            <span class="dot" onclick="currentSlide(2)"></span>
            <span class="dot" onclick="currentSlide(3)"></span>
            <span class="dot" onclick="currentSlide(4)"></span>
            <span class="dot" onclick="currentSlide(5)"></span>
          </div>



            <!-- <div class="navbar">
              <ul id="menu">
                  <li><a href="#"><b>Contact</b></a></li>
                  <li><a href="#"><b>Shop</b></a></li>
                  <li><a href="#"><b>Cart</b></a></li>
                  <li><a href="#"><b>Login</b></a></li>
              </ul>
          </div> -->
          <br><br><br>
        
        <div class="together">

          <div class="content1">
            <div class="products">
              <h3 id="pTitle">MUSIC</h3>
              <select name="sort" id="sortList">
                <option>최신순</option>
                <option>가격낮은순</option>
                <option>가격높은순</option>
                <option>판매순</option>
              </select>
              <br><br><br>

                <div class="content2">
                  <div class="category-list">
                      <ul id="cList">
                          <li>
                              <a href="<%=contextPath%>/dcAllList.pro">ALL</a>
                              <br><br>
                          </li>
                          <li>
                              <a href="<%=contextPath%>/dcMusicList.pro">MUSIC</a>
                              <br><br>
                          </li>
                          <li>
                              <a href="<%=contextPath%>/dcClothingList.pro">CLOTHING</a>
                              <br><br>
                          </li>
                          <li>
                              <a href="<%=contextPath%>/dcBeautyList.pro">BEAUTY</a>
                              <br><br>
                          </li>
                          <li>
                              <a href="<%=contextPath%>/dcAccList.pro">ACC</a>
                              <br><br>
                          </li>
                      </ul>
                  </div>
            </div>
               

              <div class="product-list">
                  <%if(!list.isEmpty()) {%>
                  	<%for(Product p : list) {%>
                  	
                  	<a href="<%=contextPath%>/detail.pro?pno=<%=p.getProductNo() %>" class="product">
						<input type="hidden" value="<%=p.getProductNo()%>">
						
                      <img src="<%=contextPath %><%=p.getTitleImg() %>" width="300" class="selectPd">
                      <div class="celeb-name">
                        <%=p.getCelebName() %>
                      </div>
                      <div class="product-name">
						<%=p.getProductName() %>
                      </div>
                      <div class="product-price">
                        ₩<%=decFormat.format(p.getProductPrice())%>
                      </div>
                  </a>
                  <%} %>
                  <%}else {%>
                  <div id="noList">
                  	<h2 align="center" style="color:#D7BFDC">등록된 상품이 없습니다.</h2>
                  </div>
                  	<%} %>
      
                  

                  <div class="clearfix"></div>
              </div>
            </div>

            </div>
        </div>

           <div class="page">
            <ul class="pagination modal">
              <li><a href="#" class="first">처음 페이지</a></li>
              <li><a href="#" class="arrow left"><<</a></li>
              <li><a href="#" class="active num">1</a></li>
              <li><a href="#" class="num">2</a></li>
              <li><a href="#" class="num">3</a></li>
              <li><a href="#" class="num">4</a></li>
              <li><a href="#" class="num">5</a></li>
              <li><a href="#" class="num">6</a></li>
              <li><a href="#" class="num">7</a></li>
              <li><a href="#" class="num">8</a></li>
              <li><a href="#" class="num">9</a></li>
              <li><a href="#" class="num">10</a></li>
              <li><a href="#" class="arrow right">>></a></li>
              <li><a href="#" class="last">끝 페이지</a></li>
            </ul>
           </div>

           <script>
           var slideIndex = 0; //slide index

        // HTML 로드가 끝난 후 동작
        window.onload=function(){
          showSlides(slideIndex);

          // Auto Move Slide
          var sec = 1300;
          setInterval(function(){
            slideIndex++;
            showSlides(slideIndex);

          }, sec);
        }


        // Next/previous controls
        function moveSlides(n) {
          slideIndex = slideIndex + n
          showSlides(slideIndex);
        }

        // Thumbnail image controls
        function currentSlide(n) {
          slideIndex = n;
          showSlides(slideIndex);
        }

        function showSlides(n) {

          var slides = document.getElementsByClassName("mySlides");
          var dots = document.getElementsByClassName("dot");
          var size = slides.length;

          if ((n+1) > size) {
            slideIndex = 0; n = 0;
          }else if (n < 0) {
            slideIndex = (size-1);
            n = (size-1);
          }

          for (i = 0; i < slides.length; i++) {
              slides[i].style.display = "none";
          }
          for (i = 0; i < dots.length; i++) {
              dots[i].className = dots[i].className.replace(" active", "");
          }

          slides[n].style.display = "block";
          dots[n].className += " active";
        }
           </script>

          </div>
        </div>
        <br><br><br><br><br><br><br><br><br><br>
</body>
<%@include file="/views/common/footer.jsp" %>
</html>