<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  

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
	<div class="joinOuter">
		<div class="join">
			<div class="header">
			</div>
    		<!--회원가입 제목 -->
    		<div class="title">
        		<br>
        		<h1 align="center">회원가입</h1>
    		</div> 

    		<form action="<%=contextPath%>/join.me" method="post" id="">

		        <!--1. 아이디/비밀번호/이름-->
		        <div class="field" id="">
		            <b>이름</b>
		            <span class="placehold-text"><input type="text" name="userName" required></span> 
		        </div>
		        
		        <div class="field" id="nickname">
		            <b>닉네임</b>
		            <span class="placehold-text"><input type="text" name="userNickname" required id="enrollNick"></span>
		             <button type="button" onclick="nickCheck();">중복확인</button>
		
		        </div>
		        <div class="field" id="userid">
		            <b>아이디</b>
		            <span class="placehold-text"><input type="text" maxlength="12" name="userId" placeholder="12자 이내로 입력해주세요" required id="enrollId"></span>
		            <button type="button" onclick="idcheck();">중복확인</button>
		        </div> 
		
		        <div class="field">
		            <b>비밀번호</b>
		            <input type="password" name="userPwd" required class="pw" id="password_1">
		        </div>
		        
		        <div class="field">
		            <b>비밀번호 확인</b>
		            <input type="password" name="userpwcheck" required id="password_2"  class="pw">
		       <span id="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
   			 <span id="alert-danger" style="display: none; color: #d92742; font-weight: bold; ">비밀번호가 일치하지 않습니다.</span>
		        </div>
		        
		        <!--2. 생년월일 -->
		        <div class="field-birth" name="userBday">
		            <b>생년월일</b> <br>
		            <select class="box" id="memberyear" name="byear">  
		                <option  selected></option>
		            </select> 년
		            <select class="box" id="membermonth" name="bmonth">
		                <option  selected></option>
		            </select> 월
		            <select class="box" id="memberday" name="bday">
		                <option  selected></option>
		            </select> 일
		            
		        </div>
		        
		        <!--3.성별-->
		        <div class="field gender">
		            <b>성별</b>
		            <div>
		                <input type="radio" name="gender" value="M"> 남 자ㅤㅤㅤㅤ
		                <input type="radio" name="gender" value="F"> 여 자
		            </div>
		           
		        </div>
		        
		        <!--4.주소-->
				        
				<input type="button" onclick="sample6_execDaumPostcode()" value="주소 검색"><br>
				<input type="text" id="sample6_postcode" placeholder="우편번호"name="zipcode">
				<input type="text" id="sample6_address" placeholder="주소" name="add1"><br>
				<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="add2">
				<input type="text" id="sample6_extraAddress" placeholder="참고항목" name="add3">
				        
		        
		        <!--5.이메일 전화번호-->
		        <div class="field">
		            <b>이메일</b>
		            <input type="email" placeholder="이메일 주소" name="email" required>
		        </div>
		        
		        <div class="field">
		            <b>휴대폰 번호</b>
		            <input type="tel" placeholder="전화번호 입력" name="Phone" required>
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
		                <button type="submit" value="가입하기" id="joinbutton" disabled >가입하기</button>
		            </div>
		     </form>
        </div>
	</div>
    
     <script>	
        
        	function idcheck(){
        		//아이디 입력란에 있는 value 꺼내기
        		var userId = $("#enrollId").val();
        		
        		if(userId==""){
        			alert("공백은 입력할 수 없습니다.");
        			return;
        		}
        		
        		$.ajax({
        			url : "idCheck.me",
        			data : {checkId : userId},
        			success : function(result){
        			
        				if(result=="NNNNN"){//사용불가
        					alert("이미 존재하거나 탈퇴한 회원입니다.");
        					$("#enrollId").focus();
        				}else{//사용가능
        					if(confirm("사용가능한 아이디입니다. 사용하시겠습니까?")){
            					$("#joinbutton").removeAttr("disabled"); //버튼비활성화 제거
            					$("#enrollId").attr("readonly",true); //아이디입력란 읽기전용
        					}else{
        						$("#enrollId").focus();
        					}
        				}
        			},
        			error : function(){
        			
        			}
        		});
        		
        		
        	}
        
        
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
    
    
    
    
    <script>
    
   
  
        
        //생년월일 제이쿼리 
		
         $(document).ready(
        		  function () {
        		    for (var i = 2022; i > 1930; i--) {
        		      $('#memberyear').append('<option value="' + i + '">' + i + '</option>');
        		    }
        		    for (var i = 1; i < 13; i++) {
        		    	var mm = i > 9 ? i : "0"+i ;
        		      $('#membermonth').append('<option value="' + mm + '">' + mm + '</option>');
        		    }
        		    for (var i = 1; i < 32; i++) {
        		    	var dd = i > 9 ? i : "0"+i ;  
        		      $('#memberday').append('<option value="' + dd + '">' + dd + '</option>');
        		  	  }
        		  		 }
        				);
        
        
        
        			
        //생년월일 값 가져오기 
        
        $("select[name=byear]").change(function(){

        	  console.log($(this).val()); 
        	  console.log($("select[name=byear] option:selected").text());
     
        	});
        
        $("select[name=bmonth]").change(function(){
      	  console.log($(this).val()); 
      	  console.log($("select[name=bmonth] option:selected").text()); 
      	});
        
        $("select[name=bday]").change(function(){
        	  console.log($(this).val()); 
        	  console.log($("select[name=bday] option:selected").text()); 
        	});
        
  

    </script>
    
    
    <script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
    
    
    <script>
    
    
    
    </script>

</body>

</html>