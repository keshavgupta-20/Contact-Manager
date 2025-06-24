<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Login - Contact Manager</title>
 <link rel="stylesheet" href="LoginPage.css" />
</head>
<body>

  <div class="main-content">
    <div class="login-container">
      <h2>Login</h2>
      <form class="login-form" action="LoginController" method="post">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" required placeholder="Enter your email" />

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required placeholder="Enter your password" />


        <button type="submit">Login</button>
      </form>

        
      <div class="login-links">
        <p>Don't have an account? <a href="Register.jsp">Register here</a></p>
      </div>
    </div>
  </div>

  <div class="footer">
    <p>© 2025 Contact Manager™ | <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a></p>
  </div>

</body>
</html>
