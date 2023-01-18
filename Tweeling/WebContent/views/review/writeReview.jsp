<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int productNo = (int)request.getAttribute("productNo");
int orderNo = (int)request.getAttribute("orderNo");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
         .outer{
            width: 1920px;
            margin: auto;
        }

        #pe-table select{
            width: 300px;
            height: 30px;
            border: none;
        }

        #pe-table input[type=text]{
            width: 800px;
            height: 30px;
            border: 1px solid rgb(216, 216, 216);
            padding-left: 10px;
        }

        #pe-table input[type=number]{
            width: 100px;
            height: 30px;
            font-size: 16px;
        }

        #pe-table{
           border-spacing: 80px;
           margin-left: 100px;
        }

        #pe-table textarea{
            border: 1px solid rgb(216, 216, 216);
            padding: 20px;
        }
        
        #pe-table th{
            color: gray;
        }

        #product-registration{
            margin-left: 100px;
        }
        
        #satisfaction-level input{
            margin-left: 50px;
        }

        #satisfaction-level label{
            font-size: 20px;
        }

        .reviewbtn{
            background-color: #D7BFDC;
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 15px;
        }

        .reviewbtn:hover{
            cursor: pointer;
        }




        #reveiwform fieldset{
            display: inline-block;
            direction: rtl;
            border:0;
        }
        #reveiwform fieldset legend{
            text-align: right;
        }
        #reveiwform input[type=radio]{
            display: none;
        }
        #reveiwform label{
            font-size: 3em;
            color: transparent;
            text-shadow: 0 0 0 #f0f0f0;
        }
        #reveiwform label:hover{
            text-shadow: 0 0 0 #D7BFDC;
        }
        #reveiwform label:hover ~ label{
            text-shadow: 0 0 0 #D7BFDC;
        }
        #reveiwform input[type=radio]:checked ~ label{
            text-shadow: 0 0 0 #D7BFDC;
        }
        #reviewContents {
            width: 100%;
            height: 150px;
            padding: 10px;
            box-sizing: border-box;
            border: solid 1.5px #D3D3D3;
            border-radius: 5px;
            font-size: 16px;
            resize: none;
        }

   

    </style>
</head>
<body>
<%@include file="/views/common/realMenubar.jsp" %>
    <div class="outer">
        <br><br><br><br>
        <h1 align="center" style="color: #D7BFDC; font-size: 100px;">WRITE A REVIEW</h1>
        <br><br>
        <form action="<%=contextPath %>/insert.rev" id="reveiwform" method="post">
    
    	<input type="hidden" name="productNo" value="<%=productNo %>">
    	<input type="hidden" name="userNo" value="<%=loginUser.getUserNo() %>">
    	<input type="hidden" name="orderNo" value="<%=orderNo %>">
    	
        <table id="pe-table">
            <tr>
                <th>Satisfaction</th>
                <td>
                    <fieldset>
                        <input type="radio" name="reviewStar" value="5" id="rate1" checked><label
                            for="rate1">★</label>
                        <input type="radio" name="reviewStar" value="4" id="rate2"><label
                            for="rate2">★</label>
                        <input type="radio" name="reviewStar" value="3" id="rate3"><label
                            for="rate3">★</label>
                        <input type="radio" name="reviewStar" value="2" id="rate4"><label
                            for="rate4">★</label>
                        <input type="radio" name="reviewStar" value="1" id="rate5"><label
                            for="rate5">★</label>
                    </fieldset>
                </td>
                <!-- <td id="satisfaction-level">
                    <input type="radio" name="satisfaction" value="1" id="satisfaction1" style="margin-left: 0;"><label for="satisfaction1">★</label>
                    <input type="radio" name="satisfaction" value="2" id="satisfaction2"><label for="satisfaction2">★★</label>
                    <input type="radio" name="satisfaction" value="3" id="satisfaction3"><label for="satisfaction3">★★★</label>
                    <input type="radio" name="satisfaction" value="4" id="satisfaction4"><label for="satisfaction4">★★★★</label>
                    <input type="radio" name="satisfaction" value="5" id="satisfaction5" checked><label for="satisfaction5">★★★★★</label>
                </td> -->
            </tr>
            <tr>
                <th>Product Review <br><p style="font-size:11px; font-weight: lighter;">150자 이내로 작성하시오.</p></th>
                <td>
                    <p style="font-size: 13px; font-style: italic;">-상품평과 관계없는 부적합한 게시물은 관리자 확인 후, 노출 제한이 될 수 있습니다.</p>
                    <p style="font-size: 13px; font-style: italic;">-상품평 작성 후 반품하는 경우, 작성한 상품평은 비전시처리 되며 지급되었던 포인트는 회수됩니다.</p>
                    <p style="font-size: 13px; font-style: italic;">-상품평은 작성 후, 수정 및 삭제가 불가능하기에 신중하게 작성해주시기 바랍니다.</p>
                    <br>
                    <textarea id="reviewbox" name="reviewcontent" cols="112" rows="20" style="resize:none" maxlength="150" required></textarea>
                    <br>
                    <span id="writingcount">0</span> / 150
                    <br><br>
                    <p style="font-size: 12px;">부적합 게시물의 기준은 다음과 같습니다.</p>
                    <p style="font-size: 11px;">(1) 상품과 기타 서비스에 대한 사실과 무관한 내용 또는 검증되지 않은 불명확한 내용을 게시함으로서 분쟁초래의 우려가 있는 경우,
                        또는 분쟁해결을 위해 객관적 검증과 사실 판단이 필요한 경우</p>
                    <p style="font-size: 11px;">(2) 교환/반품/환불관련 게시물로 CS상담이 필요한 경우</p>
                    <p style="font-size: 11px;">(3) 트윌링에서 구매한 사실이 없거나 법에 의거하여 법적 제재를 받을 수 있는 게시물의 경우 (허위사실 유포, 욕설, 비방, 명예훼손, 저작권/초상권 침해 등)</p>
                    <p style="font-size: 11px;">(4) 회원의 개인정보(전화번호, 이메일 등) 외 불성실한 내용, 반복문자, 타 사이트 홍보 및 가격비교, 특정 효능에 있어 오해의 소지가 있는 게시물의 경우</p>
                </td>
            </tr>

            <script>
                $(function(){
                    $("#reviewbox").keyup(function(){
                        $("#writingcount").text($(this).val().length);
                    });
                });
            </script>

        </table>
            <br>
            <div id="completeReview" align="center">
              <button type="submit" class="reviewbtn">상품평 등록</button>
            </div>
        <br><br><br><br>
        </form>

    </div>
    
    <br><br><br><br><br><br><br><br><br><br>
</body>
<%@include file="/views/common/footer.jsp" %>
</html>