<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:url var="UserUrl" value="/"/>
<form action="${UserUrl}" method="POST">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Username">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>
    <button type="submit" class="btn btn-default">Login</button>
  	<a href="/Module-3-Capstone-Team-2/UserLoginPage">Forget Your Password?</a>
  	<a href="/Module-3-Capstone-Team-2/UserRegistrationPage">Need to Register?</a>
</form>



</body>
</html>