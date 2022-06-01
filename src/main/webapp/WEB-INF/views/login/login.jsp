<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<jsp:include page="../includes/head.jsp"></jsp:include>
  <meta charset="UTF-8">
  <title>Join</title>
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
  <h2>Login</h2>
    <div class="user-box">
      <input class="form-control" id="id" type="text" name="id" required="">
      <label>Username</label>
    </div>
    <div class="user-box">
      <input class="form-control" id="password" type="password" name="password" required="">
      <label>Password</label>
    </div>
    <button class="btn btn-primary" data-action="submit">SUMBIT</button>
    <button class="btn btn-info"  data-action="sign">SIGN UP</button>
</div>
  <script type="text/javascript">
    $(function () {
   	  $('button').on("click", function (e) { 
      let action = $(this).data("action");
      if (action==="submit") {
    	var formdata = new FormData();
        let loginId = $("#id").val();
        let loginPw = $("#password").val();
    	  formdata.append("loginId", loginId);
    	  formdata.append("loginPw", loginPw);

    	  var requestOptions = {
    	    method: 'POST',
    	    body: formdata,
    	    redirect: 'follow'
    	  };

    	  fetch("http://localhost:8080/api/login", requestOptions)
    	    .then(response => response.json())
    	    .then(result => {
            if (result.result === true) {
              location.href ="/";
            }else{
              alert(result.message);
            }
          })
    	    .catch(error => console.log('error', error));
      }
      if (action==="sign") {
        alert("회원 가입으로 이동");
        location.href = "/sgin";
      }
     });
    });
  </script>
</body>

</html>