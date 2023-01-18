<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.product.model.vo.*, java.text.DecimalFormat"%>
<%
	ArrayList<Product>pList = (ArrayList<Product>)request.getAttribute("pList");

	DecimalFormat decFormat = new DecimalFormat("###,###");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>allCelebProduct</title>
    <link rel="stylesheet" href="CSS/all_celeb_product.css">
    <style>
        .outer{
            width: 1920px;
            margin: auto;
        }

        /* .navbar{
            height: 60px;
            padding-left: 30px;
            padding-right: 30px;

        }
              
        .navbar #logo{
            line-height: 60px;
        } */
        /* 
        .navbar img{
            vertical-align: top;
            border: blanchedalmond 5px solid;
        } */

        /* .navbar #menu{
            float: right;
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        .navbar #menu li{
            float: left;
            margin-left: 50px;
            line-height: 60px;
        }

        .navbar #menu li a{
            color: #545454;
            font-size: 13px;
            text-decoration: none;
        } */
        .inner{
            width: 70%;
            margin-left: 18%;
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
          margin-right:100px;
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
            height: 500px;
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
            filter: grayscale(1);
        }

        .celeb-name{
            color: rgb(195, 195, 195);
        }
        .product-name{
            margin-top: 20px;
            margin-bottom: 4px;
        }

        #addProduct{
          margin-left: 80%;
        }
        
          .deleted-product p{
          background-color: gray;
          color: white;	
          /* font-weight: bold; */
          font-size: 20px;
        }
        
        #sortList{
        margin-left:75%;}
        
        .btn {
  border: none;
  display: block;
  text-align: center;
  cursor: pointer;
  text-transform: uppercase;
  outline: none;
  overflow: hidden;
  position: relative;
  color: black;
  font-weight: 700;
  font-size: 15px;
  background-color: #gray;
  padding: 17px 60px;
  margin: 0 auto;
  box-shadow: 0 5px 15px rgba(0,0,0,0.20);
  border-radius: 10px;
}

.btn span {
  position: relative; 
  z-index: 1;
}

.btn:after {
  content: "";
  position: absolute;
  left: 0;
  top: 0;
  height: 490%;
  width: 140%;
  background: #D7BFDC;
  -webkit-transition: all .5s ease-in-out;
  transition: all .5s ease-in-out;
  -webkit-transform: translateX(-98%) translateY(-25%) rotate(45deg);
  transform: translateX(-98%) translateY(-25%) rotate(45deg);
}

.btn:hover:after {
  -webkit-transform: translateX(-9%) translateY(-25%) rotate(45deg);
  transform: translateX(-9%) translateY(-25%) rotate(45deg);
}
       
    </style>
</head>
<body>
<%@include file="/views/common/realMenubar.jsp" %>
    <div class="outer">
      <div class="inner">
        <br><br><br><br><br>
            <div class="products">
              <h3 id="pTitle" align="center">ALL PRODUCT</h3>
              <button onclick="addProduct();" id="addProduct" type="button" class="btn">상품추가</button>
              <br><br><br><br>
				
				<script>
					function addProduct(){
						location.href="<%=contextPath%>/registrationForm.pro";
					}
				</script>
				
				   <select name="sort" id="sortList">
                <option value="new">최신순</option>
                <option value="lowprice">가격낮은순</option>
                <option value="highprice">가격높은순</option>
                <option value="names">아티스트 이름순</option>
              </select>
              <br><br><br>
              
              
                   <script>
              $(function(){
            	  $("#sortList").on("change",function(){
            		  var value = $(this).val();
            		  //alert(value);
          			  //alert("성공");
          			  $.ajax({
          				  url : "sortLineup2.pro",
          				  data : {lineup : value},
          				  type : "get",
          				  success : function(list){
          					  console.log("통신 완료");
          					 console.log(list);
							  var str = "";
          					  
          					  if(list.length!=0){
          						  for(var i=0; i<list.length; i++){
          							 str+="<a href='<%=contextPath%>/detail.pro?pno="+list[i].productNo+"' class='product'>"
          							 		+"<input type='hidden' value='"+list[i].productNo+"'>"
          							 	+"<img src='<%=contextPath%>"+list[i].titleImg+"' width='300' class='selectPd'>"
          							 	+"<div class='celeb-name'>"+list[i].celebName+"</div>"
          							 	+"<div class='product-name'>"+list[i].productName+"</div>"
          							 	+"<div class='product-price'>￦"+AddComma(list[i].productPrice)+"</div>"
          							 	if(list[i].status==='N'){
          							 		str+="<div class='deleted-product'><p>삭제된 상품</p></div>"
          							 	}
          							 	str+="</a>";
          						  }
          						  console.log($(".product-list"));
          						  $(".product-list").html(str);
          						  console.log(list[2].status);
          					  }else{
          						  str+="<h1 align='center' style='color:#D7BFDC;''>등록된 상품이 없습니다.</h1>"
          							$(".product-list").html(str);
          					  }
          					  },
          				  error : function(){
          					  console.log("통신 실패");
          				  }
          			  });
            	  });
              });
              
              
              function AddComma(num)
              {
                  var regexp = /\B(?=(\d{3})+(?!\d))/g;
                  return num.toString().replace(regexp, ',');
              }
   				var nData = AddComma(nData);
              </script>
              
              
              
          
               
			<%if(!pList.isEmpty()) {%>
				<%for(Product p : pList) {%>
              <div class="product-list">
                  <a href="<%=contextPath %>/managementDetail.pro?pno=<%=p.getProductNo()%>" class="product">
                  	<input type="hidden" value="<%=p.getProductNo()%>">
                  
                      <img src="<%=contextPath %><%=p.getTitleImg() %>" width="300" class="selectPd">
                      <div class="celeb-name">
						<%=p.getCelebName() %>
                      </div>
                      <div class="product-name">
                          <%=p.getProductName() %>
                      </div>
                      <div class="product-price">
                        ₩<%=decFormat.format(p.getProductPrice()) %>
                      </div>
                      <%if(p.getStatus().equals("N")) {%>
                        <div class="deleted-product">
                      		<p>삭제된 상품</p>
                  		 </div>
                      	<%} %>
                  </a>
      				<%} %>
      				<%}else{ %>
      				<h1 align="center">등록된 상품이 없습니다.</h1>
					<%} %>

              </div>
            </div>

            </div>
        </div>
        