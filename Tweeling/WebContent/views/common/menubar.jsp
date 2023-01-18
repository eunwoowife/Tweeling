<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
<%
String contextPath = request.getContextPath();
String alertMsg = (String)session.getAttribute("alertMsg");
Member loginUser = (Member)session.getAttribute("loginUser");
Cookie[] cookies = request.getCookies();
String id = null;
if (cookies != null){
	for (int i = 0; i < cookies.length; i++){
		if(cookies[i].getName().equals("userId")){
			id = cookies[i].getValue();
		}
	}
}
%>
<!DOCTYPE html>
<html lang="en">
<style>
</style>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>NAVBAR</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700,900&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="css/menubar2.css">
</head>

<body>

<script>
		var msg = "<%=alertMsg%>";
		if(msg!="null"){
			alert(msg);
			<%session.removeAttribute("alertMsg");%>
		}
	</script>
	
  <div class="container">

    <nav class="navbar navbar-down navbar-expand-lg fixed-top navbar-light bg-custom">

      <a id="tweelingLogo1" class="navbar-brand d-lg-none" href="/Tweeling">Tweeling</a>

      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="collapsibleNavbar">

        <ul id="navbar-left" class="navbar-nav mx-left">

          <li class="nav-item dropdown position-static">
            <a class="nav-link" href="#" id="navbardrop" data-toggle="dropdown">
              CELEB
            </a>

            <div class="dropdown-menu mega w-100" style="text-align:center">

              <div class="container">

                <div class="row">

                  <div class="col">

                    <ul>
                      <li><a href="<%=contextPath%>/agAllList.pro"><b>ARIANA GRANDE</b></a></li>
                    </ul>

                  </div>

                  <div class="col">

                    <ul>
                      <li><a href="<%=contextPath%>/dcAllList.pro"><b>DOJA CAT</b></a></li>
                    </ul>

                  </div>

                  <div class="col">

                    <ul>
                      <li><a href="<%=contextPath%>/dlAllList.pro"><b>DUA LIPA</b></a></li>
                    </ul>

                  </div>

                  <div class="col">

                    <ul>                     
                      <li><a href="<%=contextPath%>/jbAllList.pro"><b>JUSTIN BIEBER</b></a></li>
                    </ul>

                  </div>

                  <div class="col">

                    <ul>
                      <li><a href="<%=contextPath%>/tsAllList.pro"><b>TAYLOR SWIFT</b></a></li>
                    </ul>

                  </div>

                  <div class="col">

                    <ul>
                      <li><a href="<%=contextPath%>/wdwAllList.pro"><b>WHY DON'T WE</b></a></li>
                    </ul>

                  </div>

                </div>

              </div>

            </div>

          </li>

          <li class="nav-item dropdown position-static">
            <a class="nav-link" href="#" id="navbardrop" data-toggle="dropdown">
              PRODUCT
            </a>

            <div class="dropdown-menu mega w-100" style="text-align: center;">

              <div class="container">

                <div class="row">

                  <div class="col">

                    <ul>
                      <li><a href="<%=contextPath%>/allList.pro"><b>ALL</b></a></li>
                    </ul>

                  </div>

                  <div class="col">

                    <ul>
                      <li><a href="<%=contextPath%>/musicList.pro"><b>MUSIC</b></a></li>
                    </ul>

                  </div>

                  <div class="col">

                    <ul>
                      <li><a href="<%=contextPath%>/clothingList.pro"><b>CLOTHING</b></a></li>
                    </ul>

                  </div>

                  <div class="col">

                    <ul>
                      <li><a href="<%=contextPath%>/beautyList.pro"><b>BEAUTY</b></a></li>
                    </ul>

                  </div>

                  <div class="col">

                    <ul>
                      <li><a href="<%=contextPath%>/accList.pro"><b>ACC</b></a></li>
                    </ul>

                  </div>

                </div>

              </div>

            </div>

          </li>

          <li class="nav-item">
            <a class="nav-link" href="/Tweeling/eventListView.event">EVENT</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="#">ANNOUNCEMENT</a>
          </li>

        </ul>

        <ul id="navbar-center" class="navbar-nav mx-auto">
          <li classs="nav-link">
            <a id="tweelingLogo2" class="navbar-brand d-none d-lg-block" href="/Tweeling">Tweeling</a>
          </li>
        </ul>


        <ul id="navbar-right" class="navbar-nav mx-right">

          <li class="nav-item dropdown position-static">
            <a class="nav-link" href="#" id="navbardrop" data-toggle="dropdown">
              <i class="bi bi-person-circle"></i>
            </a>

            <div class="dropdown-menu mega w-100 loginbar">

              <div class="container">

                <div class="row" style="text-align: center;">

                  <div class="col-md-4">

                    <ul>
                      <li><a href="<%=contextPath%>/loginForm.me"><b>LOGIN</b></a></li>
                    </ul>

                  </div>

                  <div class="col-md-4">

                    <ul>
                      <li><a href="<%=contextPath%>/joinForm.me"><b>JOIN</b></a></li>
                    </ul>

                  </div>

                  <div class="col-md-4">

                    <ul>
                      <li><a href="<%=contextPath%>/view.mp"><b>MY PAGE</b></a></li>
                    </ul>

                  </div>

                </div>

              </div>

            </div>

          </li>

          <li class="nav-item dropdown position-static">
            <a class="nav-link" href="#" id="navbardrop" data-toggle="dropdown">
              <i class="bi bi-search"></i>
            </a>

            <div class="dropdown-menu mega w-100 searchbar">

              <div class="container">

                  <form class="search" action="#">
                    <input id="searchInput" type="search" placeholder="검색어를 입력해주세요" required>
                    <button type="button" id="searchButton" onclick="goSearch();">SEARCH</button>
                  </form>

              </div>

            </div>

          </li>

          <li class="nav-item">
            <a class="nav-link" href="#"><i class="bi bi-bag" onclick="goCart();"></i></a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="#"><i class="bi bi-heart"></i></a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="/Tweeling/productManagement.pro"><i class="bi bi-gear"></i></a>
          </li>

        </ul>

      </div>

		<script>
  		
    
    	function goCart(){
    		<%if(loginUser!=null) {%>
    		location.href="<%=contextPath%>/cart.ca";
    		<%}else{%>
    		alert("로그인 후, 이용 가능한 서비스입니다.");
    		location.href="<%=contextPath%>/loginForm.me";
    		<%}%>
    	}
		</script>



		<script>

		document.getElementById("searchButton").onclick = function() {

			var page = 1;                       //페이지 변수를 1로 초기화
			var keyword = '';                 //검색기능을 위해 검색 변수 초기화


			var keyword = document.getElementById('searchInput').value;
			
			
			
			$.ajax({
				url: "searchListView.se",
				data : {
					keyword : keyword
				},
				type : "post",
				success : function(list){
					 console.log("통신 완료");
					 console.log(list[2]);
					 
					 var str = "";
						  
						  if(list.length!=0){
							  for(var i=0; i<list.length; i++){
								 str+="<a href='<%=contextPath%>/detail.pro?pno="+list[i].productNo+"' class='product'>"
								 		+"<input type='hidden' value='"+list[i].productNo+"'>"
								 	+"<img src='<%=contextPath%>"+list[i].titleImg+"' width='300' class='selectPd'>"
								 	+"<div class='celeb-name'>"+list[i].celebName+"</div>"
								 	+"<div class='product-name'>"+list[i].productName+"</div>"
								 	+"<div class='product-price'>￦"+list[i].productPrice+"</div>"
								 	+"</a>";	 	
						 	 	
							  }
							  console.log($(".product-list"));
							  $(".product-list").html(str);
							  
						  }else{
							  str+="<h1 style='color:#D7BFDC; margin-left:400px;''>키워드와 일치하는 상품이 없습니다.</h1>"
								$(".product-list").html(str);

	           
						  }
				
					  
						 

						},
						error : function() {
							console.log("notonsin")
						}
					});

		};
	</script>

    </nav>

  </div>

  <div class="container">

  </div>
  
	<%@ include file="/views/common/mainView.jsp" %>
	<br><br>
	<%@ include file="/views/common/footer.jsp" %>

</body>

</html>