<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.product.model.vo.*, java.util.ArrayList, java.text.DecimalFormat"%>
<%
	Product p = (Product)request.getAttribute("p");
	ArrayList<PAttachment> paList = (ArrayList<PAttachment>)request.getAttribute("paList");
	
	DecimalFormat decFormat = new DecimalFormat("###,###");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <style>
        .outer{
            width: 1920px;
        }
        .productContent{
            width: 1000px;
            height: 700px;
            margin: auto;
            /* position: relative; */
        }
       .left{
        float: left;
        height: 100%;
        width: 500px;
        margin: 0px auto;
        overflow: hidden;
       }
       .right{
        float: left;
        width: 49%;
        height: 100%;
       }
       #titleImg{
        margin-top: 18%;
        margin-left: 1%;
       }
       .celeb_name{
        margin-top: 20%;
        margin-left: 8.5%;
        color: gray;
        font-size:large;
       }
       .product_title{
        /* margin-top: 0%; */
        margin-left: 8.5%;
        font-size: xx-large;
        font-weight: bold;
       }
       .product_price{
        margin-left: 9%;
        font-size: x-large;
        margin-top: 3%;
        float: left;
       }
       .share{
        float: left;
        margin-top: 3%;
        margin-left: 45%;
        margin-bottom: 4%;
       }
       .upper{
        margin-left: 8%;
       }
       .hr1{
        width: 85%;
        color: rgb(195, 195, 195);
        border: solid 0.01px;
       }
       input::-webkit-outer-spin-button,
       input::-webkit-inner-spin-button {
        -webkit-appearance: none;
        }
       #quantity{
        margin-top: 5px;
        width: 20px;
        height: 27px;
        text-align:center;
        border: none;
        background: transparent;
       }
       .product_option{
        margin-left: 14%;
        width: 350px;
       }
       #sizeList{
                margin-top: 5px;
        width: 350px;
        height: 32px;
       }
       .productImg #titleImg{
        transition: all 0.2s linear;
       }
       .productImg:hover #titleImg{
        transform: scale(1.4);
       }
       .total-area{
        margin-top: 4.3%;
        margin-left: 14%;
        float: left;
       }
       .total-pq{
        float: right;
        margin-right: 70px;
        margin-top: 3.5%;
       }
       .product-modification{
        border: none;
        background-color: rgb(78, 78, 78);
        color: white;
        padding: 5px;
        border-radius: 2em;
        width: 32%;
        height: 50px;
        margin-left: 15%;
        font-size: 18px;
       }
       .product-delete{
        border: none;
        background-color: rgb(167, 167, 167);
        color: white;
        padding: 5px;
        border-radius: 2em;
        width: 32%;
        height: 50px;
        margin-left: 5%;
        font-size: 18px;
       }
      
       .buynow:hover,.addtocart:hover{
        cursor: pointer;
       }
       #optionS{
        background-color: rgb(252, 246, 255);
        width: 100%;
        height: auto;
        margin-top: 10px;
       }
       #productComent{
        color: gray;
        font-style: italic;
        font-weight: 400;
      }
      #productCount>tbody{
        font-size: 15px;
        font-weight: 100;
        line-height: 3rem;
      }



      .bottom-area{
        margin: auto;
    }
    .bottom-list{
        margin: auto;
        margin-left: 25%;
    }

    .bottom-list{
        float: left;
        list-style: none;
        margin-right: 15%;
    }

    #detail{
        text-decoration: none;
        text-align: center;
        font-size: 20px;
        font-weight: bold;
        color: gray;
    }

    .detail-area{
        margin: auto;
    }

    .stock-area{
        margin-left: 70px;
        margin-top: 30px;
    }

    .stock-info{
        font-size: 20px;
        font-weight: bold;
    }
    
    button:hover{
    cursor:pointer;
    }
    
    </style>
</head>
<body>
<%@include file="/views/common/realMenubar.jsp" %>
    <div class="outer">
        <br><br><br><br><br>
        <div class="productContent">
            <div class="left">
                <a href="#" class="productImg">
                    <img id="titleImg" src="<%=contextPath %><%=p.getFilePath()+p.getOriginName() %>" alt="" width="500">
                </a>
            </div>
            <div class="right">
                <div class="upper">
                    <div class="celeb_name">
                        <%=p.getCelebName() %>
                    </div>
                    <div class="product_title">
                        <%=p.getProductName() %>
                    </div>
                    <div class="product_price">
                        ₩<%=decFormat.format(p.getProductPrice()) %>
                    </div>
                    <br><br>
                </div>
                <br>
                <hr class="hr1">
                <br>
                <div class="product_option">
                   
                <div id="optionS">
                    <table id="productCount">
                        <thead>
                          <tr>
                           <%if((p.getProductComment()==null) || (p.getProductComment().equals("null"))) {%>
                      	 <th></th>
                      	 <%}else{ %>
                        <th colspan="4" id="productComent" style="text-align: left;"><%=p.getProductComment()%></th>
                        	<%} %>
                          </tr>
                        </thead>
                        <tbody>
                        </tbody>
                        </table>
                </div>
                </div>
                <%if(p.getStatus().equals("Y")) {%>
                <div class="stock-area">
                   <span class="stock-info">재고수량 : <%=p.getProductStock() %>개</span>
                </div>
                
                <br clear="both">
                <br><br>
                <div class="button-area">
                <button onclick="location.href='<%=contextPath %>/modificationForm.pro?pno=<%=p.getProductNo() %>'" class="product-modification" type="button">상품정보 수정</button>
                <button onclick="deleteCheck();" class="product-delete" >상품 삭제</button>
                </div>
            
        <%}else{%>
        <br><br><br><br>
        	<h3 align="center" style="color:#D7BFDC; font-weight:bold;">삭제된 상품입니다.</h3>
        	<%} %>
        	
        	<script>
        		function deleteCheck(){
        			var question = window.confirm("정말로 삭제하시겠습니까?");
        			if(question){
        				location.href="<%=contextPath%>/delete.pro?pno=<%=p.getProductNo()%>";
        			}else{
        				location.href="<%=contextPath%>/managementDetail.pro?pno=<%=p.getProductNo()%>";
        			}
        		}
        	</script>
        	
            </div>
        </div>
        <br><br>
        <div class="bottom-area">
            <ul class="bottom-list">
                <li><a href="" id="detail">DETAIL</a></li>
            </ul>
        </div>
        <br clear="both">
        <br>
        <hr width="100%">
    
        <br>
        <br>
        <div class="detail-area" align="center">
             <%for(int i=0; i<paList.size(); i++) {%>
		      <img src="<%=contextPath %><%=(paList.get(i).getFilePath())+(paList.get(i).getOriginName()) %>" alt="">
		      <br><br>
	      	<%} %>
	      	<br><br><br>
            <pre id="contentInfo" style="font-family: 'Courier New', Courier, monospace;">
<%=p.getProductContent() %>
            </pre>
            <br><br><br> <br><br><br> <br><br><br>
        </div>





    </div>
    
    <br><br><br><br><br><br><br><br><br><br>
</body>
<%@include file="/views/common/footer.jsp" %>
</html>