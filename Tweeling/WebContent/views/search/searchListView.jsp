<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList, com.kh.product.model.vo.*"%>

<!DOCTYPE html>
<%
ArrayList<Product>list = (ArrayList<Product>)request.getAttribute("list");
%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>검색창</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<style>
.outer {
	width: 70%;
}

.searchForm {
	width: 500px;
	margin-left: 50%;
	margin-top: 150px
}

#search1 {
	border-bottom: 1px solid gray;
	margin-left: 90px;
}

#searchText {
	border: none;
	width: 300px;
	height: 30px;
}

.btn {
	font-size: 12px;
	color: gray;
	line-height: 25px;
	text-align: center;
	background: white;
	border: solid 1px grey;
	border-radius: 100px;
	width: 90px;
	text-decoration: none;
	margin: 1px;
}

.btn:active, .btn:hover {
	color: white;
	background: rgb(215, 191, 220);
	border: solid 1px rgb(215, 191, 220);
}

.product-list {
	margin-top: 150px;
	margin-left: 350px;
	width: 1500px;
	height: auto;
}

.product {
	display: block;
	width: 400px;
	height: 400px;
	text-align: center;
	text-decoration: none;
	color: black;
	float: left;
	margin-left: 5px;
	margin-right: 5px;
	margin-bottom: 100px;
}

.selectPd:hover {
	/* filter: brightness(0.8); */
	/*filter: grayscale(1);*/
	opacity: 0.3;
}

.celeb-name {
	color: rgb(195, 195, 195);
}

.product-name {
	margin-top: 20px;
	margin-bottom: 4px;
}

.clearfix {
	clear: both;
}

.pagination{
width: 500px;
}

.pagination > li{
float:left;
}
</style>
</head>
<body>

	<%@include file="/views/common/realMenubar.jsp"%>


	<div class="outer">

		<div class="searchForm">

			<div id="search1">
				<input id="searchText" name="searchKeyWord" type="text"
					placeholder="키워드를 입력해주세요">
				<button class="btn" id="searchBtn">Search</button>
			</div>

		</div>
		
		<script>

	document.getElementById("searchBtn").onclick = function() {

		var page = 1;                       //페이지 변수를 1로 초기화
		var keyword = '';                 //검색기능을 위해 검색 변수 초기화


		var keyword = document.getElementById('searchText').value;
		
		
		
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



		<div class="product-list">
		
		</div>





	</div>
	
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>