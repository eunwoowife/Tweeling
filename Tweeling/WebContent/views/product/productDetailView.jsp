<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.product.model.vo.*, java.util.ArrayList, java.text.DecimalFormat, com.kh.review.model.vo.Review"%>
<%
	Product p = (Product)request.getAttribute("p");
	ArrayList<PAttachment>paList = (ArrayList<PAttachment>)request.getAttribute("paList");
	ArrayList<Review>rList = (ArrayList<Review>)request.getAttribute("rList");
	
	DecimalFormat decFormat = new DecimalFormat("###,###");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>product_detail</title>
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
    <style>
    
    
        .outer{
            width: 1920px;
        }




        body {
		font-family: "Century Gothic", 'Lato', sans-serif;
}

a {
	text-decoration: none;
}

.et-hero-tabs{
}
.et-slide {
    /* display: flex;
    flex-direction: column;
    justify-content: center; */
    align-items: center;
    /* height: 800px; */
    position: relative;
    background: rgb(255, 255, 255);
		/* text-align: center; */
		padding: 0 2em;
    /* margin-right: 280px; */
}

#tab-DETAIL{
    text-align: center;
    font-size: 20px;
    /* margin-right: 250px; */
}
#contentInfo{
    font-family: 'Courier New', Courier, monospace;
}


.et-hero-tabs-container {
    display: flex;
    flex-direction: row;
    position: absolute;
    bottom: 0;
    width: 100%;
    height: 70px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
    background: #fff;
    z-index: 10;
    /*margin-left: 180px;*/
}

.et-hero-tab {
    display: flex;
    justify-content: center;
    align-items: center;
    flex: 1;
    color: #000;
    letter-spacing: 0.1rem;
		transition: all 0.5s ease;
		font-size: 0.8rem;
	  &:hover {
			color:white;
      background: rgba(102,177,241,0.8);
			transition: all 0.5s ease;
    }
}

/* .et-hero-tab-slider {
    position: absolute;
    bottom: 0;
    width: 0;
    height: 6px;
    background: #66B1F1;
    transition: left 0.3s ease;
} */

@media (min-width: 800px) {
	.et-hero-tabs,
	.et-slide {
	}
	.et-hero-tab { 
		font-size: 1rem;
	}
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
        width: 82%;
        color: rgb(195, 195, 195);
        border: solid 0.01px;
        margin-left: 50px;
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
       .buynow{
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
       .addtocart{
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
       .soldout{
        border: none;
        background-color: rgb(0, 0, 0);
        color: rgb(255, 255, 255);
        padding: 5px;
        border-radius: 2em;
        width: 60%;
        height: 50px;
        margin-left: 20%;
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


    #deliveryInfo th{
        border-collapse: separate;
        background-color: #D7BFDC;
    }

    #returnInfo th{
        border-collapse: separate;
        background-color: #D7BFDC;
    }
    
    li{
    font-size:12px;
    }
    
    #share:hover{
    cursor:pointer;
    }
    
     #review-table{
        border-collapse: separate;
        border-spacing:50px 5px;
    }
    </style>
</head>
<body>
<%@include file="/views/common/realMenubar.jsp" %>
    <div class="outer">
      
          <!-- Hero -->
          <br><br><br>
  <section class="et-hero-tabs">
   
    <div class="productContent">
        <div class="left">
            <a href="#" class="productImg">
                <img id="titleImg" src="<%=contextPath %><%=p.getTitleImg() %>" alt="" width="500">
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
                    ₩<%=decFormat.format(p.getProductPrice())%>
                </div>
                <div class="share">
                    <a onclick="clip(); return false();" id="share"><img src="resources/image/share.png" alt="" width="30px"></a>
                </div>
                
                
                <script>
                	function clip(){
                		var url = "";
                		var textarea = document.createElement("textarea");
                		
                		document.body.appendChild(textarea);
                		url = window.document.location.href;
                		textarea.value = url;
                		textarea.select();
                		document.execCommand("copy");
                		document.body.removeChild(textarea);
                		
                		alert("URL이 복사되었습니다.");
                	}
                </script>
                
                
                
            </div>
            <br><br><br>
            <hr class="hr1">
            <br>
            <div class="product_option">
                <!-- <span style="font-size: 15px;">size</span>
                <br>
                <select name="size" id="sizeList">
                    <option>30ml</option>
                    <option>50ml</option>
                    <option>100ml</option>
                </select> -->
                <br>
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
                      <tr>
                        <td width="5px"><i class="bi bi-dash-circle"id="countMinus"  onclick="countMinus();"></i></td>
                        <td width="10x"><input type="number" name="quantity" id="quantity" min="1" max="10" value="1"  disabled></td>
                        <td width="5px"><i class="bi bi-plus-circle"id="countPlus"  onclick="countPlus();"></i></td>
                        <td style="text-align: right;">₩<%=decFormat.format(p.getProductPrice()) %></td>
                      </tr>
                    </tbody>
                    </table>
            </div>
            </div>
            <div class="total-area">
                <span class="total" style="font-size: 25px; font-weight: bold;">TOTAL</span>
            </div>
            <div class="total-pq">
                <span class="total-price" style="font-size: 30px;">₩<%=decFormat.format(p.getProductPrice()) %></span>
                <span class="totla-quantity">(1개)</span>
            </div>
            <br clear="both">
            <br><br>
            <div class="button-area">
            <%if(loginUser!=null) {%>
            <%if(p.getProductStock()>0) {%>
            <button class="buynow" type="button" onclick="selectBuy();">BUY NOW</button>
            <button class="addtocart" type="button" id="addtocart">ADD TO CART</button>
 			
            <input type="hidden"  name="productNo" value="<%=p.getProductNo() %>">
 			<script>
 			$(function(){
 				$("#addtocart").click(function(){
 					$.ajax({
 						url : "insert.ca",
 						data : {productNo : <%=p.getProductNo()%>,
 								quantity : $("#quantity").val()},
 						type : "post",
 						success : function(result){
 							if(result>0){
 								console.log("장바구니 추가 성공");
 									var gogoCart = confirm("장바구니에 해당 상품이 담겼습니다. 장바구니로 이동하시겠습니까?");
 	 								if(gogoCart){
 	 									location.href="<%=contextPath%>/cart.ca";
 	 								}else{
 	 									return false;
 	 								}
 							}else{
 								console.log("장바구니 추가 실패");
 							}
 						},
 						error : function(){
 							console.log("통신 실패");
 						}
 					})
 				})
 			})
 			</script>
 
 			<script>
 			function selectBuy(){
 			   	var pno = document.querySelector('input[name=productNo]').value;
 			   	var pcount = parseInt($("#quantity").val());
 				
 			   	
 				console.log(pno);
 			   	console.log(pcount);
 			   	
 			     var form = document.createElement("form");
 			     form.setAttribute("charset", "UTF-8");
 			     form.setAttribute("method", "Post");  //Post 방식
 			     form.setAttribute("action", "./order.or"); //요청 보낼 주소
 			     var hiddenField = document.createElement("input");
 			     hiddenField.setAttribute("type", "hidden");
 			     hiddenField.setAttribute("name", "pno");
 			     hiddenField.setAttribute("value", pno);
 			     form.appendChild(hiddenField);
 			     hiddenField = document.createElement("input");
 			     hiddenField.setAttribute("type", "hidden");
 			     hiddenField.setAttribute("name", "pcount");
 			     hiddenField.setAttribute("value", pcount);
 			     form.appendChild(hiddenField);
 			     document.body.appendChild(form);
 			     console.log(form);
 			     form.submit();
 				
 			}
 			</script>
 
 
            <%}else{ %>
            
            
            <button class="soldout" type="button">SOLD OUT</button>
            <%} %>
            <%}else{ %>
            <br>
            <span style="margin-left:100px; color:gray; font-style:Italic; font-size:20px; font-weight:bold; text-decoration:underline;">로그인 후, 구매 가능한 상품입니다.</span>
            <%} %>
        </div>
        </div>
    </div>

    <div class="et-hero-tabs-container">
      <a class="et-hero-tab" href="#tab-DETAIL">DETAIL</a>
      <a class="et-hero-tab" href="#tab-REVIEW">REVIEW</a>
      <a class="et-hero-tab" href="#tab-QA">Q&A</a>
      <a class="et-hero-tab" href="#tab-RETURN">RETURN</a>
      <a class="et-hero-tab" href="#tab-DELIVERY">DELIVERY</a>
      <span class="et-hero-tab-slider"></span>
    </div>
  </section>

  <!-- Main -->
  <div class="et-main">
    <div class="et-slide" id="tab-DETAIL">
        <br><br><br><br><br><br><br><br><br><br><br><br>
        <%for(int i=0; i<paList.size(); i++) {%>
      <img src="<%=contextPath %><%=(paList.get(i).getFilePath())+(paList.get(i).getOriginName()) %>" alt="">
      <br><br>
      	<%} %>
      	<br><br><br>
      <pre id="contentInfo">
<%=p.getProductContent() %>
      </pre>
      <br><br><br><br><br>
    </div>
    <div class="et-slide" id="tab-REVIEW">
        <br><br><br><br><br>
        <hr>
      <h1>REVIEW</h1>
       <table id="review-table">
            <tbody>
            
            <%if(!rList.isEmpty()) {%>
            <%for(int i=0; i<rList.size(); i++) {%>
            <%String star = ""; %>
            	<%switch(rList.get(i).getReviewScore()) {
            	case 1 : star="★☆☆☆☆";
            	break;
            	case 2 : star="★★☆☆☆";
            	break; 
            	case 3 : star="★★★☆☆";
            	break;
            	case 4 : star="★★★★☆";
            	break;
            	case 5 : star="★★★★★";
            	%>
            	<%} %>
            	<tr>
            	<td style="width: 300px; text-align:center"><span style="font-size:30px; color: #D7BFDC;"><%=star %></span></td>
                <td style="width: 800px; text-align:center"><span><%=rList.get(i).getReviewContent() %></span></td>
                <td style="width: 300px; text-align:center"><span><%=rList.get(i).getUserNo() %></span></td>
                <td style="width: 200px; text-align:center"><span><%=rList.get(i).getCreateDate() %></span></td>
                </tr>
                <%} %>
                <%}else{ %>
                	<h4>등록된 리뷰가 없습니다.</h4>
                <%} %>
            </tbody>
        </table>
    </div>
    <div class="et-slide" id="tab-QA">
        <br><br><br><br><br>
        <hr>
      <h1>Q&A</h1>
      <h3>something about react</h3>
      <br><br><br><br><br>
    </div>
    <hr>
    <div class="et-slide" id="tab-RETURN">
        <br><br><br><br><br>
        <h3>교환/반품/AS 관련 유의사항</h3>
        <p>상품상세설명에 교환/반품/취소 관련 안내가 기재된 경우 다음 안내사항보다 우선 적용됩니다.</p>
        <br>
        <hr>
        <table id="returnInfo">
        <colgroup>
        <col width="270">
        </colgroup>
        <tbody>
            <tr>
                <th>취소/반품/교환 안내</th>
                <td>
                    <ul>
                        <br><li>상품하자 이외 사이즈, 색상교환 등 단순 변심에 의한 교환/반품 택배비 고객부담으로 왕복택배비가 발생합니다. (전자상거래 등에서의 소비자보호에 관한 법률 제18조(청약 철회등)9항에 의거 소비자의 사정에 의한 청약 철회 시 택배비는 소비자 부담입니다.)</li>
                        <li>결제완료 직후 즉시 주문취소는 "마이페이지"에서 직접 처리 가능합니다.</li>
                        <li>주문완료 후 재고 부족 등으로 인해 주문 취소 처리가 될 수도 있는 점 양해 부탁드립니다.</li>
                        <li>주문상태가 상품준비중인 경우 취소신청이 가능하며 판매자의 승인 여부(이미 배송을 했거나 포장을 완료한 경우)에 따라 취소가 불가능할 수 있습니다</li>
                        <li>교환 신청은 최초 1회에 한하며, 교환 배송 완료 후에는 추가 교환 신청은 불가합니다</li>
                        <li>반품/교환은 미사용 제품에 한해 배송완료 후 7일 이내 접수하여 주십시오.</li>
                        <li>임의반품은 불가하오니 반드시 고객센터나 "마이페이지"를 통해서 신청접수를 하시기 바랍니다.</li>
                        <li>상품하자, 오배송의 경우 택배비 무료로 교환/반품이 가능하지만 모니터의 색상차이, 착용감, 사이즈의 개인의 선호도는 상품의 하자 사유가 아닙니다.</li>
                        <li>고객 부주의로 상품이 훼손, 변경된 경우 반품 / 교환이 불가능 합니다.</li>
                        <li>취소/반품 대금환불이 지연 시 전자상거래법에 의거하여 환불지연 배상처리 절차가 진행됩니다.</li><br>
                    </ul>
                </td>
            </tr>
            <tr>
                <th>반품/교환 불가능한 경우</th>
                <td>
                    <ul>
                        <br><li>	
                            제품을 사용 또는 훼손한 경우, 사은품 누락, 상품 TAG, 보증서, 상품 부자재가 제거 혹은 분실된 경우</li>
                        <li>밀봉포장을 개봉했거나 내부 포장재를 훼손 또는 분실한 경우(단, 제품확인을 위한 개봉 제외)</li>
                        <li>시간이 경과되어 재판매가 어려울 정도로 상품가치가 상실된 경우</li>
                        <li>고객님의 요청에 따라 주문 제작되어 고객님 외에 사용이 어려운 경우</li>
                        <li>기타 전자상거래 등에서의 소비자보호에 관한 법률이 정하는 청약철회 제한사유에 해당하는 경우</li><br>
                    </ul>
                </td>
            </tr>
            <tr>
                <th>A/S 안내</th>
                <td>
                    <ul>
                        <br><li>A/S 기준이나 가능여부는 브랜드와 상품에 따라 다르므로 관련 문의는 트윌링 고객센터를 통해 부탁드립니다.</li>
                        <li>상품불량에 의한 반품, 교환, A/S, 환불, 품질보증 및 피해보상 등에 관한 사항은 소비자분쟁해결기준(공정거래위원회 고시)에 따라 받으실 수 있습니다.</li><br>
                    </ul>
                </td>
            </tr>
        </tbody>
        </table>
    </div>
    </div>
    <br><br><br><br><br>
    <div class="et-slide" id="tab-DELIVERY">
        <hr>
        <br><br><br><br><br>
        <h3>배송 관련 유의사항</h3>
        <p>상품상세설명에 배송 관련 안내가 기재된 경우 다음 안내사항보다 우선 적용됩니다.</p><br>
       <table id="deliveryInfo">
        <colgroup>
        <col width="270">
        </colgroup>
        <tbody>
            <tr>
                <th>배송정보</th>
                <td>
                    <ul>
                        <li>상품별로 상품 특성 및 배송지에 따라 배송유형 및 소요기간이 달라집니다.</li>
                        <li>일부 주문상품 또는 예약상품의 경우 기본 배송일 외에 추가 배송 소요일이 발생될 수 있습니다.</li>
                        <li>동일 셀럽의 상품이라도 상품별 출고일시가 달라 각각 배송될 수 있습니다.</li>
                        <li>제주 및 도서산간 지역은 출고, 반품, 교환시 추가 배송비(항공, 도선료)가 부과 될 수 있습니다.</li>
                        <li>상품의 배송비는 공급업체의 정책에 따라 다르오며 공휴일 및 휴일은 배송이 불가합니다.</li>
                    </ul>
                </td>
            </tr>
        </tbody>
       </table>
       <br><br><br><br><br>
    </div>
  </div>





    </div>
    <br><br>
    <script>
        function countPlus(){
            var count = parseInt($("#quantity").val());
            count++;
            if(count>10){
                count=10;
            }
            $("#quantity").val(count);
            counting();
            if(count><%=p.getProductStock()%>){
            	$("#countPlus").attr('onclick', '');
            	alert("재고가 없습니다.");
            	$("#quantity").val(<%=p.getProductStock()%>);
            	$("#quantity").val(count-1);
                counting();
            	
            	if(count<=<%=p.getProductStock()%>){
            		$("#countPlus").attr('onclick','countPlus()')
            		  var count = parseInt($("#quantity").val());
                      count++;
                      if(count>10){
                          count=10;
                      }
            	}
            }
        }
        

        
        
        
        function countMinus(){
        	$("#countPlus").attr('onclick','countPlus()');
            console.log($("#quantity").val());
            var count = parseInt($("#quantity").val());
            count--;
            if(count<=1){
                count=1;
            }
            $("#quantity").val(count);
            counting();
        }
         function counting(){
                var sum = $("#quantity").val();
                console.log(sum);
                $(".totla-quantity").html("("+sum+")개");
                var onePrice = <%=p.getProductPrice()%>;
                var commaOnePrice = onePrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
                var totalPriceComma = (sum*onePrice).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
                $(".total-price").html("₩"+totalPriceComma);
        }





        class StickyNavigation {
	




    
	constructor() {
		this.currentId = null;
		this.currentTab = null;
		this.tabContainerHeight = 70;
		let self = this;
		$('.et-hero-tab').click(function() { 
			self.onTabClick(event, $(this)); 
		});
		$(window).scroll(() => { this.onScroll(); });
		$(window).resize(() => { this.onResize(); });
	}
	
	onTabClick(event, element) {
		event.preventDefault();
		let scrollTop = $(element.attr('href')).offset().top - this.tabContainerHeight + 1;
		$('html, body').animate({ scrollTop: scrollTop }, 600);
	}
	
	onScroll() {
		this.checkTabContainerPosition();
    this.findCurrentTabSelector();
	}
	
	onResize() {
		if(this.currentId) {
			this.setSliderCss();
		}
	}
	
	checkTabContainerPosition() {
		let offset = $('.et-hero-tabs').offset().top + $('.et-hero-tabs').height() - this.tabContainerHeight;
		if($(window).scrollTop() > offset) {
			$('.et-hero-tabs-container').addClass('et-hero-tabs-container--top');
		} 
		else {
			$('.et-hero-tabs-container').removeClass('et-hero-tabs-container--top');
		}
	}
	
	findCurrentTabSelector(element) {
		let newCurrentId;
		let newCurrentTab;
		let self = this;
		$('.et-hero-tab').each(function() {
			let id = $(this).attr('href');
			let offsetTop = $(id).offset().top - self.tabContainerHeight;
			let offsetBottom = $(id).offset().top + $(id).height() - self.tabContainerHeight;
			if($(window).scrollTop() > offsetTop && $(window).scrollTop() < offsetBottom) {
				newCurrentId = id;
				newCurrentTab = $(this);
			}
		});
		if(this.currentId != newCurrentId || this.currentId === null) {
			this.currentId = newCurrentId;
			this.currentTab = newCurrentTab;
			this.setSliderCss();
		}
	}
	
	setSliderCss() {
		let width = 0;
		let left = 0;
		if(this.currentTab) {
			width = this.currentTab.css('width');
			left = this.currentTab.offset().left;
		}
		$('.et-hero-tab-slider').css('width', width);
		$('.et-hero-tab-slider').css('left', left);
	}
	
}

new StickyNavigation();
    </script>
    <br><br><br><br><br><br><br><br><br><br>
</body>
<%@include file="/views/common/footer.jsp" %>
</html>