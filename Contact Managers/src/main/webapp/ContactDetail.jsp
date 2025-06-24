<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entites.ContactDetail" %>
<%
    ContactDetail contact = (ContactDetail) request.getAttribute("contact");
    if (contact == null) {
%>
    <h2 style="color:red; text-align:center;">Contact not found</h2>
    <div style="text-align:center;">
        <a href="ContactServlet">← Back to Dashboard</a>
    </div>
<%
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Details</title>
    <link rel="stylesheet" href="ContactDetail.css" />
    <script>
        function toggleDropdown() {
            const menu = document.getElementById("dropdownMenu");
            menu.style.display = menu.style.display === "block" ? "none" : "block";
        }

        function confirmDelete(contactId) {
            if (confirm("Are you sure you want to delete this contact?")) {
                window.location.href = 'DeleteContact?id=' + contactId;
            }
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
    <div class="card">
        <div class="ellipsis" onclick="toggleDropdown()">&#8942;</div>

        <div id="dropdownMenu" class="dropdown">
            <a href="UpdateContact.jsp?id=<%= contact.getId() %>">Edit</a>
            <a href="javascript:void(0);" onclick="confirmDelete(<%= contact.getId() %>)">Delete</a>
        </div>

        <h2>Contact Details</h2>

        <div class="detail-box"><strong>Name:</strong> <%= contact.getName() %></div>
        <div class="detail-box"><strong>Email:</strong> <%= contact.getEmail() %></div>
        <div class="detail-box"><strong>Phone:</strong> <%= contact.getPhone() %></div>
        <div class="detail-box"><strong>Address:</strong> <%= contact.getAddress() %></div>
        <div class="detail-box"><strong>Birthday:</strong> <%= contact.getBirthday() %></div>
        <div class="detail-box"><strong>Group:</strong> <%= contact.getGroup() %></div>

        <a class="back-link" href="ContactServlet">← Back to Dashboard</a>
    </div>
</div>

</body>
</html>
