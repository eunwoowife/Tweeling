<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.product.model.vo.*"%>
<%
	Product p = (Product)request.getAttribute("p");
	ArrayList<PCategory>pcList = (ArrayList<PCategory>)request.getAttribute("pcList");
	ArrayList<PAttachment>paList = (ArrayList<PAttachment>)request.getAttribute("paList");
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
        
        .modificationbtn{
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
        
        .modificationbtn:hover{
        cursor:pointer;
        }

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
<%@include file="/views/common/realMenubar.jsp" %>
    <div class="outer">
        <br><br><br><br>
        <h1 align="center" style="color: #D7BFDC; font-size: 100px;">PRODUCT MODIFICATION</h1>
        <br><br>
        
        
        <form action="<%=contextPath %>/modification.pro" id="product-registration-form" method="post" enctype="multipart/form-data">
    
    	<input type="hidden" name="productNo" value="<%=p.getProductNo() %>">
    
        <table id="pe-table">
            <tr>
                <th>Celeb Name</th>
                <td>
                    <select name="celebName"  id="celebName">
                        <option value="Ariana Grande">Ariana Grande</option>
                        <option value="Doja Cat">Doja Cat</option>
                        <option value="Dua Lipa">Dua Lipa</option>
                        <option value="Justin Bieber">Justin Bieber</option>
                        <option value="Taylor Swift">Taylor Swift</option>
                        <option value="Why Don't We">Why Don't We</option>
                    </select>
                    
                    <script>
                    	$(function(){
                    	$("#celebName option").each(function(){
                    		if($(this).text()=="<%=p.getCelebName()%>"){
                    			$(this).attr("selected",true);
                    		}
                    	})
                    	})
                    </script>
                </td>
            </tr>
            <tr>
                <th>Product Category</th>
                <td>
                    <select name="pCategory" id="category-list">
                    	<%for(PCategory pc : pcList) {%>
                    	<option value="<%=pc.getProductCategoryNo()%>"><%=pc.getProductCategoryName() %></option>
                    	<%} %>
                    </select>
                    
                    <script>
                    	$(function(){
                    		$("#category-list option").each(function(){
                    			if($(this).text()=="<%=p.getCategoryNo()%>"){
                    				$(this).attr("selected",true);
                    			}
                    		})
                    	})
                    </script>
                </td>
            </tr>
            <tr>
                <th>Product Name</th>
                <td><input type="text" name="pName" required value="<%=p.getProductName()%>"></td>
            </tr>
            <tr>
                <th>Product Price</th>
                <td>
                ??? <input type="number" id="pPrice" name="pPrice" required value="<%=p.getProductPrice() %>">
                </td>
            </tr>
            <tr>
                <th>Product Stock</th>
                <td>
                <input type="number" id="stock" name="pStock" min="1" required value="<%=p.getProductStock() %>">
                </td>
            </tr>
            <tr>
                <th>Product Comment</th>
                <td>
               <%if((p.getProductComment()==null) || (p.getProductComment().equals("null"))) {%>
               		<textarea name="pComment" cols="112" rows="7" style="resize:none"> </textarea>
                    <%}else{ %>
                    <textarea name="pComment" cols="112" rows="7" style="resize:none"><%=p.getProductComment() %></textarea>
                    <%} %>
                </td>
            </tr>
            <tr>
                <th>Product Description</th>
                <td>
                    <textarea name="pContent" cols="112" rows="30" style="resize:none" required><%=p.getProductContent() %></textarea>
                </td>
            </tr>
            <tr>
                <th>Thumbnail Image</th> <!--????????????-->
                <td align="center">
                    <img id="titleImg" src="<%=contextPath %><%=p.getFilePath()+p.getOriginName() %>"  width="500" height="500">

                    <input type="hidden" name="tiFileNo" value="<%=p.getFileNo() %>">
                    <input type="hidden" name="tiFileName" value="<%=p.getOriginName() %>">
                </td>
            </tr>
            <tr>
                <th>Content Image</th>
                <%if(!paList.isEmpty()) {%>
                	<%if(paList.size()==1) {%>
                		<td><img id="contentImg1"  src="<%=contextPath%><%=(paList.get(0).getFilePath())+(paList.get(0).getOriginName()) %>" width="500" height="500"></td>
                		<td><img id="contentImg2" width="500" height="500"></td>
                		<%}else{ %>
                	    <%for(int i=0; i<paList.size(); i++) {%>
              			 <td><img id="contentImg<%=i+1 %>"  src="<%=contextPath%><%=(paList.get(i).getFilePath())+(paList.get(i).getOriginName()) %>" width="500" height="500"></td>
					<%} %> 
					<%} %>           
            <%}else{ %>
            	<td><img id="contentImg1"  width="500" height="500"></td>
            	<td><img id="contentImg2" width="500" height="500"></td>
            	<%} %>
            </tr>
        </table>
            <br>
          

            <!--???????????? ??????-->
			<div id="file-area" align="center">
				<input type="file" id="file1" name="reUpfile1" onchange="loadImg(this,1);" >
                <br>
				<input type="file" id="file2" name="reUpfile2" onchange="loadImg(this,2);">
				<br>
				<input type="file" id="file3" name="reUpfile3" onchange="loadImg(this,3);">
			</div>		
			<%if(paList.size()==1) {%>
			<input type="hidden" name="ciFile1No" value="<%=paList.get(0).getFileNo()%>">
			<input type="hidden" name="ciFile1Name" value="<%=paList.get(0).getOriginName() %>">
			<%} %>
			
			<%if(paList.size()==2) {%>
			<input type="hidden" name="ciFile1No" value="<%=paList.get(0).getFileNo()%>">
			<input type="hidden" name="ciFile1Name" value="<%=paList.get(0).getOriginName() %>">
			<input type="hidden" name="ciFile2No" value="<%=paList.get(1).getFileNo()%>">
			<input type="hidden" name="ciFile2Name" value="<%=paList.get(1).getOriginName() %>">
			<%} %>
			<br><br><br>

			<div align="center" id="product-registration">
			<button type="submit" class="modificationbtn">????????????</button>
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
				//inputFile : ?????? ????????? ?????? input type="file" ?????? ??????
				//num : ????????? input ???????????? ?????? ??? ?????? ????????? ??????????????? ?????? ????????????

				//files????????? ???????????? ????????? ????????? ????????? ????????? ????????? ???????????? ??????
				//?????? ????????? length??? 1??? ?????? ???????????? 0??? ????????????.
				// console.log(inputFile.files.length);

				if(inputFile.files.length==1){
					//????????? ????????? ????????????
					//????????? ????????? ????????? ?????? ????????? ???????????? ????????????

					//????????? ???????????? ?????? ?????? FileReader
					var reader = new FileReader();

					//????????? ??????????????? ????????? -  ?????? ????????? ??????????????? ??????????????? ??????
					//readAsDataURL(??????);
					//????????? ??????????????? ?????? ?????? ???????????? ?????? url??? ????????????.
					//????????? url??? src????????? ???????????? ??????.
					reader.readAsDataURL(inputFile.files[0]);

					//?????? ????????? ????????? ????????? src??? url??? ???????????? ?????? ?????????
					reader.onload = function(e){
						//e??? ????????? ??????
						//????????? url??? e?????? target??? result??? ????????????.
						// console.log(e);

						//??? ????????? ????????? ????????? ????????????
						switch(num){
							case 1 : $("#titleImg").attr("src",e.target.result); break;
							case 2 : $("#contentImg1").attr("src",e.target.result); break;
							case 3 : $("#contentImg2").attr("src",e.target.result); break;
						}
					}
				}else{ //?????? ?????? ??? ???????????? ?????????
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