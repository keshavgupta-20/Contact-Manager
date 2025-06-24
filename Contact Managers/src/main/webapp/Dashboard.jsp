<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Entites.Contact" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("LoginPage.jsp"); // or wherever your login page is
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Contact Manager - Dashboard</title>
    <link rel="stylesheet" href="Dashboard.css" />
     <script>
        function goToDetails(contactId) {
        	window.location.href = 'ContactDetail?id=' + contactId;
        }
    </script>
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
        <h1>My Contacts</h1>
        <input type="text" class="search" placeholder="Search Contacts..." />
    </div>

    <table class="contact-table">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
        </thead>
        <tbody>
<%
    List<Contact> contactLists = (List<Contact>) request.getAttribute("contactLists");
    if (contactLists != null) {
        for (Contact c : contactLists) {
%>

<tr onclick="goToDetails(<%= c.getId() %>)">
    <td><%= c.getName() %></td>
    <td><%= c.getEmail() %></td>
    <td><%= c.getPhone() %></td>
</tr>
<%
        }
    } else {
%>
<tr>
    <td colspan="3">No contacts available.</td>
</tr>
<%
    }
%>
</tbody>

    </table>
</div>
</body>
</html>
