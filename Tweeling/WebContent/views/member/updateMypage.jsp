<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="com.kh.member.*"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!--bootstrap-->

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!--본문 폰트 -->
		
			<link rel="preconnect" href="https://fonts.googleapis.com">
			<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
			<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@500&display=swap" rel="stylesheet">
			<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
            <!--제이쿼리-->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
			
	
  <style>

body{
	font-family: 'IBM Plex Sans KR', sans-serif;
  font-size: 15px;
  background-color: white;
  line-height: 3;
  color: rgb(184, 183, 183);
  margin: 0%;
}

.title{
    font-family: 'Black Han Sans', sans-serif;
    color: #D7BFDC;
	padding-bottom: 50px; 

}.join{
    width: 500px;
    margin: auto;
    padding: 60px;
    margin-bottom: 20px;
}

.join input:not(input[type=radio]),.join select{
  border: 1px solid #F0ECEC;
  padding: 7px;
  width: 100%;
  margin-bottom: 14px;
}

.field.birth select{
  gap: 5px;
	width: 100px;
}

#nickname>button{
  position: relative;
  width: 80px;
  height: 50px;
  margin: auto ;
  bottom: 66px;
  left: 300px;
  right: 1px;
  border-color: #D7BFDC;
  color: white;
  background-color: #D7BFDC;
}
#userid>button{
  position: relative;
  width: 80px;
  height: 50px;
  margin: auto ;
  bottom: 65px;
  left: 300px;
  right: 1px;
  border-color: #D7BFDC;
  color: white;
  background-color: #D7BFDC;
}

.field-birth select{
    gap: 5px;;
	width: 100px;
}

#joinsubmit>button{
border: 1px solid #F0ECEC;
background-color: #D7BFDC;
color: white;
  padding: 7px;
  width: 100%;
  margin-bottom: 14px;

}


    </style>  
</head>
<body>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

	<%@ include file="../common/realMenubar.jsp" %>
	
		<% 
			String userId=loginUser.getUserId();
			String userName = loginUser.getUserName();
			String phone=loginUser.getPhone();
			String email=loginUser.getEmail();
			String userNick=loginUser.getUserNinkname();
			String gender=loginUser.getGender();
			String userBias=loginUser.getUserBias();
			String address=loginUser.getAddress();
			
			
		%>
		
	<div class="joinOuter">
		<div class="join">
			<div class="header">
			</div>
    		<!--회원가입 제목 -->
    		<div class="title">
        		<br>
        		<h1 align="center">회원정보 변경 </h1>
    		</div> 

    		<form action="<%=contextPath%>/updatemy.me" method="post" id="">

		        <!--1. 아이디/비밀번호/이름-->
		        <div class="field" id="">
		            <b>이름</b>
		            <span class="placehold-text"><input type="text"  value="<%=userName%>" name="userName"></span> 
		        </div>
		        
		        <div class="field" id="nickname">
		            <b>닉네임</b>
		            <span class="placehold-text"><input type="text" name="userNickname" required id="enrollNick" value="<%=userNick%>"></span>
		             <button type="button" onclick="nickCheck();">중복확인</button>
		
		        </div>
		        <div class="field" id="userid">
		            <b>아이디</b>
		            <span class="placehold-text"><input type="text" value="<%=userId%>" name="userId" required id="enrollId" ></span>
		         
		        </div> 
		
		        <div class="field">
		            <b>비밀번호</b>
		            <input type="password" name="userPwd" required class="pw" id="password_1">
		        </div>
		        
		        <div class="field">
		            <b>비밀번호 확인</b>
		            <input type="password" name="userpwcheck" required id="password_2" class="pw">
		       <span id="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
   			 <span id="alert-danger" style="display: none; color: #d92742; font-weight: bold; ">비밀번호가 일치하지 않습니다.</span>
		        </div>
		        
		       
		        <!--3.성별-->
		        <div class="field gender">
		            <b>성별</b>
		            <div>
		                <input type="radio" name="gender" value="M" > 남 자ㅤㅤㅤㅤ
		                <input type="radio" name="gender" value="F"> 여 자
		            </div>
		           
		        </div>
		        
		        <br>
		        <!--4.주소-->
				        
							            <b>주소</b>
				<input type="text" id="sample6_postcode" name="address" value="<%=address%>">
			
				        
		        
		        <!--5.이메일 전화번호-->
		        <div class="field">
		            <b>이메일</b>
		            <input type="email" placeholder="이메일 주소" name="email" required  value="<%=email%>">
		        </div>
		        
		        <div class="field">
		            <b>휴대폰 번호</b>
		            <input type="tel" placeholder="전화번호 입력" name="Phone" required value="<%=phone%>">
		        </div>
		        
		        <!--6.선호아티스트-->
		        <b>선호아티스트</b>

		        <div class="field Artist">
		            
		            <div style="float: left;">
						<input type="radio" value="테일러스위프트" name="userbias">
						<label for="check1"><img src="resources/member_upfiles/테일러스위프트.png" width="120px"></label>
						<p style="text-align: center;">테일러스위프트</p>
					</div>
					<div style="float: left;">
						<input type="radio" value="저스틴" name="userbias">
						<label for="check2"><img src="resources/member_upfiles/저스틴.png" width="130px"></label>
						<p style="text-align: center;">저스틴비버</p>
					</div>
					<div style="float: left;">
						<input type="radio" value="dojacat" name="userbias">
						<label for="check3"><img src="resources/member_upfiles/dojacat.png" width="130px"></label>
						<p style="text-align: center;">도자캣</p>
					</div>
					<div style="float: left;">
						<input type="radio" value="아리아나그란데" name="userbias">
						<label for="check4"><img src="resources/member_upfiles/아리아나그란데.png" width="130px"></label>
						<p style="text-align: center;">아리아나그란데</p>
					</div>
					<div style="float: left;">
						<input type="radio" value="와돈위" name="userbias">
						<label for="check5"><img src="resources/member_upfiles/와돈위.png" width="130px"></label>
						<p style="text-align: center;">와이돈위</p>
					</div>
					<div style="float: left;">
						<input type="radio" value="두아리파" name="userbias">
						<label for="check6"><img src="resources/member_upfiles/두아리파.png" width="130px" ></label>
						<p style="text-align: center;">두아리파</p>
					</div>
		            
		            <div id="joinsubmit">
		                <button type="submit" value="가입하기" id="joinbutton"  >변경하기</button>
		            </div>
		     </form>
        </div>
	</div>
    

 
 
 <script>
 
 			//성별 체크 
            	$(function(){
            	
            
            	
            		var gender="<%=gender%>";
            	
            		$("input[type=radio]").each(function(){
            	
            		if(gender.search($(this).val()) != -1 ){
            		
            			$(this).attr("checked",true); 
            		}
            		});
            		
            	
            		
            	})
            
            </script>
            
            
           
            
             <script>
             //관심 셀럽 체크 
             
            	$(function(){
            	
            		
            	
            		var userBias="<%=userBias%>";
            	
            		$("input[type=radio]").each(function(){
            	
            		if(userBias.search($(this).val()) != -1 ){
            		
            			$(this).attr("checked",true); 
            		}
            		});
            		
            	
            		
            	})
            
            </script>
            
              
            
            
    
    <script>	
        
        	function nickCheck(){
        		//닉네
        		var userNick = $("#enrollNick").val();
        		
        		if(userNick==""){
        			alert("공백은 입력할 수 없습니다.");
        			return;
        		}
        		
        		$.ajax({
        			url : "nickCheck.me",
        			data : {checkNick : userNick},
        			success : function(result){
        				
        				if(result=="NNNNN"){//사용불가
        					alert("이미 존재하거나 탈퇴한 회원의 닉네임입니다.");
        					$("#enrollNick").focus();
        				}else{//사용가능
        					if(confirm("사용가능한 닉네임입니다. 사용하시겠습니까?")){
            					$("#enrollNick").attr("readonly",true); 
        					}else{
        						$("#enrollNick").focus();
        					}
        				}
        			},
        			error : function(){
        			
        			}
        		});
        		
        		
        	}
        
        
        </script>
    
 
    
	<script>
    $('.pw').focusout(function () {
        var pwd1 = $("#password_1").val();
        var pwd2 = $("#password_2").val();
  
        if ( pwd1 != '' && pwd2 == '' ) {
            null;
        } else if (pwd1 != "" || pwd2 != "") {
            if (pwd1 == pwd2) {
                $("#alert-success").css('display', 'inline-block');
                $("#alert-danger").css('display', 'none');
            } else {
                alert("비밀번호가 일치하지 않습니다. 비밀번호를 재확인해주세요.");
                $("#alert-success").css('display', 'none');
                $("#alert-danger").css('display', 'inline-block');
            }
        }
    });
	</script>
    
    
    
    
    


</body>

</html>