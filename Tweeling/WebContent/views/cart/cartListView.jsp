<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.ArrayList
			    				,com.kh.cart.model.vo.Cart
			    				,com.kh.common.JDBCTemplate"%>

<%
	ArrayList<Cart> cart = (ArrayList<Cart>) request.getAttribute("cart");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>장바구니</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<style>
.outer {
	margin: auto;
	width: 70%;
	text-align: center;
	position: relative;
}

hr {
	border: 0px;
	border-top: 1px solid gray;
}

#title {
	margin-top: 100px;
	margin-bottom: 30px;
	text-align: center;
}

.basketdiv {
	width: 100%;
	border-top: 1px solid #e0e0e0;
	float: left;
	font-size: 0.9375em;
	margin-bottom: 20px;
	margin-top: 25px;
}

.basketdiv .row.head {
	box-sizing: border-box;
	font-weight: bold;
	color: gray;
	font-size: 13px;
}

.basketdiv .data {
	border-bottom: 1px dashed #888;
	box-sizing: border-box;
	cursor: pointer;
	float: left;
	width: 100%;
	height: 200px;
}

.basketdiv .data .empty {
	text-align: center;
	padding: 12px 0;
}

.basketdiv .row>.subdiv {
	display: block;
	float: left;
}

.basketdiv .row>.subdiv:nth-child(1) {
	width: 50%;
}

.basketdiv .row>.subdiv:nth-child(2) {
	width: 40%;
}

.basketdiv .row>.subdiv:nth-child(3) {
	width: 10%;
}

.basketdiv2 .row>.subdiv:nth-child(1) {
	width: 60%;
}

.basketdiv2 .row>.subdiv:nth-child(2) {
	width: 40%;
}

.basketdiv .row>div>div {
	display: block;
	float: left;
	text-align: center;
	margin: 0;
	padding: 12px 0;
}

.basketdiv .row.data>div>div {
	height: 60px;
	line-height: 60px;
	margin-top: 55px;
}

.basketdiv .data .num .updown {
	font-size: 15px;
}

.basketdiv .check {
	width: 5%;
}

.basketdiv .check input[type=checkbox] {
	transform: scale(1.5);
}

.basketdiv .img {
	width: 25%;
}

.thumbnail {
	width: 100px;
	height: 100px;
}

.basketdiv .pname {
	width: 70%;
}

.basketdiv2 .pname {
	width: 80%;
}

.basketdiv .basketprice {
	width: 33%;
}

.basketdiv .num {
	width: 33%;
	min-width: 105px;
}

.basketdiv .point {
	width: 50%;
}

.basketdiv2 .basketprice {
	width: 25%;
}

.basketdiv2 .num {
	width: 25%;
}

.basketdiv2 .point {
	width: 25%;
}

.basketdiv .basketcmd {
	width: 100%;
}

.basketdiv .data .pname {
	text-align: left !important;
	line-height: 1.2 !important;
}

.basketdiv .data .price, .basketdiv .data .basketdiv .data .point {
	text-align: right;
}

.baseform>tbody>tr>td:first-child {
	width: 100px;
}

.sum {
	width: 20%;
	text-align: center;
}

.buttongroup {
	padding: 11px 0;
	margin: 50px 0;
}

.narrowbuttongroup {
	margin: 15px 0;
}

.buttongroup.center {
	text-align: center;
}

.buttongroup input[type=text], .buttongroup input[type=password] {
	height: 30px;
}

.buttongroup button, .buttongroup a {
	margin-right: 5px;
}

.buttongroup button:last-child, .buttongroup a:last-child {
	margin-right: 0;
}

.abutton {
	background: white;
	border: solid 1px gray;
	color: gray;
	padding: 3px 5px;
	margin: 1px;
	width: 80px;
	word-break: keep-all;
	border-radius: 100px;
	text-decoration: none;
	font-size: 12px;
	float: inherit;
}

.abutton:hover {
	color: white;
	background: rgb(215, 191, 220);
	border: solid 1px rgb(215, 191, 220);
	float: inherit;
}

.basketrowcmd {
	text-align: left;
	margin-bottom: 100px;
}

.sumcount, .summoney {
	text-align: right;
	margin-bottom: 10px;
}

.sumcount, .summoney {
	font-size: 1.25em;
	font-weight: bold;
}

.buttongroup {
	text-align: center;
}

.buttongroup a {
	text-decoration: none;
}

.cmd a, .cmd span {
	padding: 12px 30px;
	box-sizing: border-box;
	margin-top: 10px;
	font-size: 1.2em;
	color: #000;
	background-color: #f4f4f4;
	border: 1px solid #e0e0e0;
	text-align: center;
}

.cmd.small a, .cmd.small span {
	padding: 6px 20px;
	font-size: 0.8125em;
}

.orderform .p_num {
	text-align: center;
	width: 20px;
	font-size: 15px;
	border: none;
}

#allprice tr>td {
	text-align: center;
	font-size: 30px;
	height: 20px;
}

.total {
	color: rgb(255, 0, 0);
	font-weight: bold;
}

#allprice {
	margin: auto;
	margin-top: 20px;
	margin-bottom: 20px;
}

#text1 tr>td {
	color: gray;
	font-size: 12px;
}

.selebName {
	font-size: 13px;
	color: gray;
	margin-left: 20px;
}

.ProductSelectName {
	font-size: 14px;
	margin-left: 20px;
}

#bt .abutton {
	width: 150px;
	height: 50px;
	font-size: 15px;
	margin-top: 20px;
	margin-bottom: 50px;
}

#sum_p_num {
	font-size: small;
	color: gray;
	float: right;
}
</style>
</head>
<body>
	<%@include file="/views/common/realMenubar.jsp"%>
	<div class="outer">
		<div class="title">
			<h1 id="title">Cart</h1>
		</div>

		<form name="orderform" id="orderform" method="post" class="orderform"
			action="./order.or">

			<div class="basketdiv" id="basket">
				<div class="row head">
					<div class="subdiv">
						<div class="check"></div>
						<div class="img"></div>
						<div class="pname">상품명</div>
					</div>
					<div class="subdiv">
						<div class="basketprice">가격</div>
						<div class="num">수량</div>
						<div class="sum">합계</div>
					</div>
					<div class="subdiv">

						<div class="basketcmd"></div>
					</div>
					<div class="split"></div>
				</div>


				<%
					if (cart.isEmpty()) {
				%>
				<div class="row data">
					<h1 style="color: rgb(215, 191, 220)">장바구니에 상품이 존재하지 않습니다</h1>
				</div>
				<%
					} else if (!cart.isEmpty()) {
				%>


				<%
					for (int i = 0; i < cart.size(); i++) {
				%>
				<div class="row data">

					<div class="subdiv">
						<div class="check">
							<input type="checkbox" name="buy" value="<%=260 + i%>" checked=""
								onclick="javascript:basket.checkItem();">&nbsp;
						</div>
						<div class="thumbnail">
							<img src="<%=contextPath%><%=cart.get(i).getTitleImg()%>"
								width="80px" height="80px">
						</div>
						<div class="pname">
							<p class="selebName"><%=cart.get(i).getCelebName()%></p>
							<p class="ProductSelectName"><%=cart.get(i).getProductName()%></p>
						</div>
					</div>
					<div class="subdiv">
						<div class="basketprice">
							<input type="hidden" name="p_price" id="p_price1" class="p_price"
								value='<%=cart.get(i).getProductPrice()%>'>₩<%=cart.get(i).getProductPrice()%></div>
						<div class="num">
							<div class="updown">
								<span onclick='javascript:basket.changePNum(<%=i + 1%>);'><i
									class="bi bi-dash-circle down"></i></span> <input type="text"
									name="p_num<%=i + 1%>" id="p_num<%=i + 1%>" size="2" maxlength="10"
									class="p_num" value='<%=cart.get(i).getProductQuality()%>'
									disabled> <span
									onclick='javascript:basket.changePNum(<%=i + 1%>);'><i
									class="bi bi-plus-circle up"></i></span>
							</div>
						</div>
						<div class="sum" id="selectSum">
							₩<%=(Integer.parseInt(cart.get(i).getProductPrice())) * (cart.get(i).getProductQuality())%></div>
					</div>
					<div class="subdiv">
						<div class="basketcmd">

							<input type="button" value="주문하기" class="abutton"	onclick="javascript:basket.selectOneBuy();"> 
							<input type="button" value="관심상품" class="abutton" onclick="javascript:basket.addWish();">
							<input type="hidden" name="pp_No" class="p_price" value='<%=cart.get(i).getProductNo()%>'>
							<input type="hidden" name="pp_Count" class="p_price" value='<%=cart.get(i).getProductQuality()%>'>
							<input type="button" value="삭제" class="abutton" onclick="javascript:basket.delItem();">
						</div>
					</div>
				</div>
				<div>
					<input type="hidden" name="productNo<%=i + 1%>" class="p_price"
						value='<%=cart.get(i).getProductNo()%>'> <input
						type="hidden" name="pp_num<%=i + 1%>"
						value='<%=cart.get(i).getProductQuality()%>'>
				</div>
				<%
					}
				%>

			</div>

			<div class="basketrowcmd">
				<a href="javascript:void(0)" class="abutton"
					onclick="javascript:basket.delCheckedItem();">선택상품삭제</a> <a
					href="javascript:void(0)" class="abutton"
					onclick="javascript:basket.delAllItem();">장바구니비우기</a>
			</div>

			<div class="price">
				<table id="allprice">
					<thead>
						<tr>
							<td>₩</td>
							<td id="sum_p_price">20,000</td>
							<!-- 아직 초기값 안넣어놨음 -->
							<td width="80px">+</td>
							<td>₩</td>
							<td>3,000</td>
							<td width="80px">=</td>
							<td class="total">₩</td>
							<td class="total" id="total_p_price">29,000</td>
						</tr>
					</thead>
					<tbody id="text1">
						<tr>
							<td colspan="2">총 상품금액</td>
							<td colspan="4">배송비</td>
							<td colspan="2">결제금액</td>
						</tr>
					</tbody>
				</table>
			</div>


			<%
				}
			%>

			<hr id="last">
			<div class="clear"></div>
			<div id="bt">
				<%
					if (cart.isEmpty()) {
				%>
				<input type="button" value="되돌아가기" class="abutton"
					onclick="history.back();">
				<%
					} else if (!cart.isEmpty()) {
				%>
				<input type="submit" value="전체상품 주문" class="abutton">
				<input type="button" value="선택상품 주문" class="abutton" 	onclick="javascript:basket.selectBuy();">
				<%
					}
				%>
			</div>

		</form>
	</div>



</body>


<!-- 윈도우 온로드용  스크립트 -->
<script>

window.onload=function(){

	<%int productSum = 0;%>
	<%int[] productSelectSum = null;%>
	<%for (int i = 0; i < cart.size(); i++) {%>
	<%productSum += (Integer.parseInt(cart.get(i).getProductPrice())) * (cart.get(i).getProductQuality());%>
	<%}%>
	var productSum = <%=productSum%>;
	console.log((productSum).formatNumber());
	document.querySelector('#sum_p_price').textContent = (productSum).formatNumber();

	var productTotal = productSum+3000;
	
	document.querySelector('#total_p_price').textContent = (productTotal).formatNumber();
	
};

</script>


<script>
var arr = new Array();

let basket = {
	    totalCount: 0, 
	    totalPrice: 0,
	    //체크한 장바구니 상품 비우기
	    delCheckedItem: function(){
	        document.querySelectorAll("input[name=buy]:checked").forEach(function (item) {
	        	var cnt = $("input[name=buy]:checked").length;
                
                arr.push(item.parentElement.parentElement.parentElement.querySelector('input[name=pp_No]').value);
   				console.log(arr);
	
	        
	        //AJAX 서버 업데이트 전송
	        
		        $.ajax({
					url: "checkDelete.ca",
					data : {
						productNo : arr,
					},
					type : "post",
					traditional : true,
					success :function(){
						console.log("상품번호 잘 갓나?");
						location.reload();	
					},
					error : function (){
						console.log("상품번호 잘 안감 ㅠ")
					}
				});
		        
	        
	        });
	        
	        
	    },
	    //장바구니 전체 비우기
	    delAllItem: function(){
	        document.querySelectorAll('.row.data').forEach(function (item) {
	            item.remove();
	          });
	          //AJAX 서버 업데이트 전송
				
				$.ajax({
				url: "allDeleteCart.ca",
				data : {
					result : "YYYY",
					<%if (cart.isEmpty()) {%>
					userNo: 1
					<%} else {%>
					userNo: <%=cart.get(0).getUserNo()%>
					<%}%>
				},
				type : "post",
				success :function(){
					console.log("장바구니 비워졌나?");
					alert("장바구니 삭제가 완료되었습니다.");
					history.back();
					
				},
				error : function (){
					console.log("장바구니 비우기 실패함ㅠ")
				}
			});
	          
	          //전송 처리 결과가 성공이면
	          this.totalCount = 0;
	          this.totalPrice = 0;
	          this.reCalc();
	          this.updateUI();
	    },

	    clickreCalc: function(){
	        this.reCalc();
	        this.updateUI();

	    },
	    //재계산
	    reCalc: function(){
	        this.totalCount = 0;
	        this.totalPrice = 0;
	        document.querySelectorAll(".p_num").forEach(function (item) {
	            if(item.parentElement.parentElement.parentElement.previousElementSibling.firstElementChild.firstElementChild.checked == true){
	                var count = parseInt(item.getAttribute('value'));
	                this.totalCount += count;

	                var price = item.parentElement.parentElement.previousElementSibling.firstElementChild.getAttribute('value');
	                this.totalPrice += count * price;
	            }
	        }, this); // forEach 2번째 파라메터로 객체를 넘겨서 this 가 객체리터럴을 가리키도록 함. - thisArg
	    },
	    //화면 업데이트
	    updateUI: function () {
	        document.querySelector('#sum_p_price').textContent = this.totalPrice.formatNumber();
	        var total1 = this.totalPrice;
	        var total2 = 3000;
	        document.querySelector('#total_p_price').textContent = (total1+total2).formatNumber();;
	    },
	    //개별 수량 변경
	    changePNum: function (pos) {
	        var item = document.querySelector('input[name=p_num'+pos+']');
	        var p_num = parseInt(item.getAttribute('value'));
	        var newval = event.target.classList.contains('up') ? p_num+1 : event.target.classList.contains('down') ? p_num-1 : event.target.value;
	        
	        if (parseInt(newval) < 1 || parseInt(newval) > 10) { return false; }

	        item.setAttribute('value', newval);
	        item.value = newval;
	        
	        var price = item.parentElement.parentElement.previousElementSibling.firstElementChild.getAttribute('value');
	        item.parentElement.parentElement.nextElementSibling.textContent = "₩"+(newval * price);
	        //AJAX 업데이트 전송
	        
	         var pno = document.querySelector('input[name=productNo'+pos+']').value; //상품 넘버
	      	 var pqu = document.querySelector('input[name=p_num'+pos+']').value;
	         
	      	$.ajax({
				url: "updateCount.ca",
				data : {
					productNo : pno,
					count: pqu
				},
				type : "post",
				success :function(){
					console.log("일단 통신은 됫구여")
					
				},
				error : function (){
					console.log("수량 변경이 불가능함")
				}
			});
	      	
	      	
	        //전송 처리 결과가 성공이면    
	        this.reCalc();
	        this.updateUI();
	        
	        location.reload();
	    },
	    checkItem: function () {
	        this.reCalc();
	        this.updateUI();
	    },
	    
	    //개별삭제 비동기통신
	    delItem: function (pos) {
	        event.target.parentElement.parentElement.parentElement.remove();
	       	var pno = event.target.parentElement.parentElement.querySelector('input[name=pp_No]').value;
	       	
	       	
	      
	       	$.ajax({
				url: "selectDelete.ca",
				data : {
					productNo : pno
				},
				type : "post",
				success :function(){
					console.log("일단 통신은 됫구여")
					
				},
				error : function (){
					console.log("개별삭제가 불가능함")
				}
			});
	       	
	       	location.reload();
	       	
	        this.reCalc();
	        this.updateUI();
	    },
	    
	    
	    
	  //개별 관심상품 등록
	    addWish: function (pos1) {
	       	var pno = event.target.parentElement.parentElement.querySelector('input[name=pp_No]').value;
	       	
	       	$.ajax({
				url: "wishAdd.wi",
				data : {
					productNo : pno
				},
				type : "post",
				success :function(result){
					console.log("일단 통신은 됫구여");
					if (result==="YYYY"){
						alert("관심상품이 등록되었습니다");
					}else{
						alert("이미 관심상품으로 등록되어있습니다.");
					}
				},
				error : function (){
					console.log("위시리스트 통신 안됨...")
				}
			});
	        
	       	
	    },
	    
	    //개별주문
	    selectOneBuy: function(){
	    	
	       	var pno = event.target.parentElement.parentElement.querySelector('input[name=pp_No]').value;
	       	var pcount = event.target.parentElement.parentElement.querySelector('input[name=pp_Count]').value;
	    	
	       	
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
	    	
	    	
	    },
	    
	    
	    //선택상품주문하기
			selectBuy: function(){
				
				
			var pno = new Array();	
			var pcount =  new Array();
			var p_price =  new Array();
			var cnt = $("input[name=buy]:checked").length;
            
			document.querySelectorAll("input[name=buy]:checked").forEach(function (item) {
	       	pno.push(item.parentElement.parentElement.parentElement.querySelector('input[name=pp_No]').value);
	       	pcount.push(item.parentElement.parentElement.parentElement.querySelector('input[name=pp_Count]').value);
	       	p_price.push(item.parentElement.parentElement.parentElement.querySelector('input[name=pp_Count]').value);
	       	
	    	console.log(pno);
	       	console.log(pcount);
	       	console.log(p_price);
	       	
	         var form = document.createElement("form");
	         form.setAttribute("charset", "UTF-8");
	         form.setAttribute("method", "Post");  //Post 방식
	         form.setAttribute("action", "./order2.or"); //요청 보낼 주소

	         var hiddenField = document.createElement("input");
	         hiddenField.setAttribute("type", "hidden");
	         hiddenField.setAttribute("name", "selectpno");
	         hiddenField.setAttribute("value", pno);
	         form.appendChild(hiddenField);
	         
	         hiddenField = document.createElement("input");
	         hiddenField.setAttribute("type", "hidden");
	         hiddenField.setAttribute("name", "selectpcount");
	         hiddenField.setAttribute("value", pcount);
	         form.appendChild(hiddenField);
	         
	         hiddenField = document.createElement("input");
	         hiddenField.setAttribute("type", "hidden");
	         hiddenField.setAttribute("name", "selectprice");
	         hiddenField.setAttribute("value", p_price);
	         form.appendChild(hiddenField);


	         document.body.appendChild(form);
	         
	         console.log(form);
	         form.submit();
			})
	    }
	    
	    
	}

	// 숫자 3자리 콤마찍기
	Number.prototype.formatNumber = function(){
	    if(this==0) return 0;
	    let regex = /(^[+-]?\d+)(\d{3})/;
	    let nstr = (this + '');
	    while (regex.test(nstr)) nstr = nstr.replace(regex, '$1' + ',' + '$2');
	    return nstr;
	};
</script>

</html>


