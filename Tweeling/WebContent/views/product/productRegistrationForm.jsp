<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.product.model.vo.*"%>
<%
	ArrayList<PCategory>pcList = (ArrayList<PCategory>)request.getAttribute("pcList");

%>
<!DOCTYPE html>
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
        
        .registrationbtn{
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
	
	 .registrationbtn:hover{
	 cursor:pointer;
	 }

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
<%@include file="/views/common/realMenubar.jsp" %>
    <div class="outer">
        <br><br><br><br>
        <h1 align="center" style="color: #D7BFDC; font-size: 100px;">PRODUCT REGISTRATION</h1>
        <br><br>
        
        
        <form action="<%=contextPath %>/insert.pro" id="product-registration-form" method="post" enctype="multipart/form-data">
    
        <table id="pe-table">
            <tr>
                <th>Celeb Name</th>
                <td>
                    <select name="celebName">
                        <option value="Ariana Grande">Ariana Grande</option>
                        <option value="Doja Cat">Doja Cat</option>
                        <option value="Dua Lipa">Dua Lipa</option>
                        <option value="Justin Bieber">Justin Bieber</option>
                        <option value="Taylor Swift">Taylor Swift</option>
                        <option value="Why Don't We">Why Don't We</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Product Category</th>
                <td>
                    <select name="pCategory">
                    	<%for(PCategory pc : pcList) {%>
                    	<option value="<%=pc.getProductCategoryNo()%>"><%=pc.getProductCategoryName() %></option>
                    	<%} %>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Product Name</th>
                <td><input type="text" name="pName" required></td>
            </tr>
            <tr>
                <th>Product Price</th>
                <td>
                ₩ <input type="number" id="pPrice" name="pPrice" required>
                </td>
            </tr>
            <tr>
                <th>Product Stock</th>
                <td>
                <input type="number" id="stock" name="pStock" min="1" required>
                </td>
            </tr>
            <tr>
                <th>Product Comment</th>
                <td>
                    <textarea name="pComment" cols="112" rows="7" style="resize:none"></textarea>
                </td>
            </tr>
            <tr>
                <th>Product Description</th>
                <td>
                    <textarea name="pContent" cols="112" rows="30" style="resize:none" required></textarea>
                </td>
            </tr>
            <tr>
                <th>Thumbnail Image</th> <!--미리보기-->
                <td align="center">
                    <img id="titleImg" width="500" height="500">
                </td>
            </tr>
            <tr>
                <th>Content Image</th>
                <td><img id="contentImg1" width="500" height="500"></td>
                <td><img id="contentImg2" width="500" height="500"></td>
            </tr>
        </table>
            <br>
          

            <!--파일첨부 영역-->
			<div id="file-area" align="center">
				<input type="file" id="file1" name="file1" onchange="loadImg(this,1);" required>
                <br>
				<input type="file" id="file2" name="file2" onchange="loadImg(this,2);">
				<br>
				<input type="file" id="file3" name="file3" onchange="loadImg(this,3);">
			</div>		
			<br><br><br>

			<div align="center" id="product-registration">
			<button type="submit" class="registrationbtn">등록하기</button>
			</div>
			<br>
        </form>


        <script>

   
			$(function(){
                $("#file-area").hide();

				$("#titleImg").click(function(){
					$("#file1").click();
				});

				$("#contentImg1").click(function(){
					$("#file2").click();
				});

				$("#contentImg2").click(function(){
					$("#file3").click();
				});

			});

            function loadImg(inputFile,num){
				//inputFile : 현재 변화가 생긴 input type="file" 요소 객체
				//num : 몇번째 input 요소인지 확인 후 해당 영역에 미리보기를 위한 매개변수

				//files속성은 업로드된 파일의 정보를 배열의 형태로 묶어서 반환하는 속성
				//파일 선택시 length가 1을 반환 취소하면 0을 반환한다.
				// console.log(inputFile.files.length);

				if(inputFile.files.length==1){
					//선택된 파일이 존재하면
					//선택된 파일을 읽어서 해당 영역에 미리보기 띄워주기

					//파일을 읽어주기 위한 객체 FileReader
					var reader = new FileReader();

					//파일을 읽어들이는 메소드 -  어떤 파일을 읽을것인지 매개변수로 제시
					//readAsDataURL(파일);
					//파일을 읽어들이는 순간 해당 파일만의 고유 url을 부여한다.
					//부여된 url을 src속성에 추가하면 된다.
					reader.readAsDataURL(inputFile.files[0]);

					//파일 읽기가 완료되 시점에 src에 url을 부여하는 함수 만들기
					reader.onload = function(e){
						//e는 이벤트 객체
						//부여된 url은 e객체 target의 result에 들어있음.
						// console.log(e);

						//각 영역에 맞춰서 이미지 미리보기
						switch(num){
							case 1 : $("#titleImg").attr("src",e.target.result); break;
							case 2 : $("#contentImg1").attr("src",e.target.result); break;
							case 3 : $("#contentImg2").attr("src",e.target.result); break;
						}
					}
				}else{ //취소 누를 시 미리보기 없애기
					switch(num){
							case 1 : $("#titleImg").attr("src",null); break;
							case 2 : $("#contentImg1").attr("src",null); break;
							case 3 : $("#contentImg2").attr("src",null); break;
						}
				}

			}
        </script>

        <br><br>
        
    </div>
    
    <br><br><br><br><br><br><br><br><br><br>
</body>
<%@include file="/views/common/footer.jsp" %>
</html>