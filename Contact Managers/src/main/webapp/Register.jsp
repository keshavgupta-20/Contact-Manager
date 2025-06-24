<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Register - Contact Manager</title>
   <link rel="stylesheet" href="Register.css" />
</head>
<body>

  <div class="main-content">
    <div class="register-container">
      <h2>Create Account</h2>
      <form class="register-form" action="LoginController" method="post">
        <label for="name">Full Name</label>
        <input type="text" id="name" name="name" required placeholder="Your full name" />

        <label for="email">Email</label>
        <input type="email" id="email" name="email" required placeholder="Your email address" />

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required placeholder="Create a password" />

        <label for="confirm">Confirm Password</label>
        <input type="password" id="confirm" name="confirm" required placeholder="Repeat your password" />
        
        

        <button type="submit">Register</button>
      </form>
      <% String error = (String) request.getAttribute("error"); %>
		<% if (error != null) { %>
  		<div class="error-message" style="color:red;"><%= error %></div>
		<% } %>

      <div class="register-links">
        <p>Already have an account? <a href="LoginPage.jsp">Login here</a></p>
      </div>
    </div>
  </div>

  <div class="footer">
    <p>© 2025 Contact Manager™ | <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a></p>
  </div>

</body>
</html>
