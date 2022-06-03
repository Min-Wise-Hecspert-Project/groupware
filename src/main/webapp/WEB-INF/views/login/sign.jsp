<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<jsp:include page="../includes/head.jsp"></jsp:include>
  <meta charset="UTF-8">
  <title>Sign up</title>
  <style type="text/css">
   	html {
  height: 100%;
}
body {
  margin:0;
  padding:0;
  font-family: sans-serif;
  background: linear-gradient(#141e30, #243b55);
}


.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: rgba(0,0,0,.5);
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0,0,0,.6);
  border-radius: 10px;
}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}
.login-box .user-box label {
  position: absolute;
  top:0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #03e9f4;
  font-size: 12px;
} 	


  </style>
</head>

<body>
  <div class="login-box">
  <h2>Sign up</h2>
    <div class="user-box">
      <div class="hintId"></div>
      <input class="form-control" id="id" type="text" placeholder="3자 이상 ~ 15자 이하 영문 숫자 조합">
      <label>ID</label>
    </div>
    <div class="user-box">
      <div class="hintPw"></div>
      <input class="form-control" id="password" type="password" placeholder="8자 이상 ~ 15자 이하 영문 숫자 조합">
      <label>Password</label>
    </div>
    <div class="user-box">
    	<div class="hintPwCheck"></div>
      <input class="col form-control" id="passwordCheck" type="password">
      <label>Password Check</label>
      
    </div>
    <div class="user-box">
      <input class="form-control" id="name" type="text" name="password" placeholder="코난">
      <label>이름</label>
    </div>
    <div class="user-box">
      <input class="form-control" id="enName" type="text" name="password" placeholder="conan">
      <label>영문 이름</label>
    </div>
    <button class="btn btn-primary" data-action="submit">SUMBIT</button>
</div>
  <script type="text/javascript">
    $(function () {
      $("#id").keyup(function (e) { 
        e.preventDefault();
        let loginId = $("#id").val();
        let hintId = $(".hintId");

        const idReg = "^(?=.*[a-z])(?=.*\\d)[a-z\\d]{3,15}$";
        if (!loginId.match(idReg)) {
        	$(".hintId *").remove();
        	hintId.append("<i class='bi bi-x' style='color:red;'></i>");
        }else {
          $(".hintId *").remove();
          hintId.append("<i class='bi bi-check' style='color:green;'></i>");
        }
      });
      $("#password").keyup(function (e) { 
        e.preventDefault();
        let loginPw = $("#password").val();
        let hintPw = $(".hintPw");
        const pwReg = "^(?=.*[a-z])(?=.*\\d)[a-z\\d]{8,15}$";
        if (!loginPw.match(pwReg)) {
        	$(".hintPw *").remove();
        	hintPw.append("<i class='bi bi-x' style='color:red;'></i>");
        }else {
          $(".hintPw *").remove();
          hintPw.append("<i class='bi bi-check' style='color:green;'></i>");
        }
      });
      $("#passwordCheck").keyup(function (e) { 
        e.preventDefault();
        let loginPw = $("#password").val();
        let PwCheck = $("#passwordCheck").val();
        let hintPwCheck = $(".hintPwCheck");
        if (loginPw!=PwCheck) {
        	$(".hintPwCheck *").remove();
        	hintPwCheck.append("<i class='bi bi-x' style='color:red;'></i>");
        }else {
          $(".hintPwCheck *").remove();
          hintPwCheck.append("<i class='bi bi-check' style='color:green;'></i>");
        }
      });
   	  $('button').on("click", function (e) { 
      let action = $(this).data("action");
      if (action==="submit") {
    	var formdata = new FormData();
        let loginId = $("#id").val();
        let loginPw = $("#password").val();
        let PwCheck = $("#passwordCheck").val();
        let name = $("#name").val();
        let enName = $("#enName").val();
        
    	formdata.append("loginId", loginId);
    	formdata.append("loginPw", loginPw);
      formdata.append("loginPwCheck", PwCheck);
    	formdata.append("name", name);
      formdata.append("enName", enName);

       

    	  var requestOptions = {
    	    method: 'POST',
    	    body: formdata,
    	    redirect: 'follow'
    	  };

    	  fetch("http://localhost:8080/api/join", requestOptions)
    	    .then(response => response.json())
    	    .then(result => {
    	    	console.log(result);
            if (result.result === true) {
              location.href ="/login";
            }else{
              alert(result.message);
            }
          })
    	    .catch(error => console.log('error', error));
      }
     });
    });
  </script>
</body>

</html>