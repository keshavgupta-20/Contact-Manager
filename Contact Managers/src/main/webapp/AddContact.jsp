<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("LoginPage.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Contact</title>
    <link rel="stylesheet" href="Dashboard.css" />
    <link rel="stylesheet" href="AddContact.css" />
</head>
<body>

<div class="sidebar">
    <h2>Contact Manager</h2>
    <a href="ContactServlet">Dashboard</a>
    <a href="AddContact.jsp">Add Contact</a>
    <a href="groups.jsp">Groups</a>
    <a href="settings.jsp">Settings</a>
    <a href="Logout">Logout</a>
</div>

<div class="main">
    <div class="header">
        <h1>Add New Contact</h1>
    </div>

    <form action="add-contact" method="post">
        <label for="fullname">Full Name</label>
        <input type="text" name="fullname" id="fullname" required>

        <label for="phone">Phone Number</label>
        <input type="tel" name="phone" id="phone" required>

        <label for="email">Email Address</label>
        <input type="email" name="email" id="email" required>

        <label for="address">Address</label>
        <textarea name="address" id="address" rows="3" required></textarea>

        <label for="birthday">Birthday</label>
        <input type="date" name="birthday" id="birthday" required>

        <label for="group">Group</label>
        <select name="group" id="group" required>
            <option value="">-- Select Group --</option>
            <option value="Friends">Friends</option>
            <option value="Family">Family</option>
            <option value="Office">Office</option>
            <option value="Relatives">Relatives</option>
        </select>

        <button type="submit" class="btn-submit">
            Add Contact
        </button>
    </form>
</div>

</body>
</html>
