


<%@ page import="java.sql.*" %>
<%@ page import="ServiceImpl.ContactServiceImpl" %>
<%@ page import="Entites.ContactDetail" %>
<%@ page import="Util.JdbcUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
int id = Integer.parseInt(request.getParameter("id"));

    ContactDetail contact = null;
    try (Connection conn = JdbcUtil.getDbConnection()) {
        ContactServiceImpl service = new ContactServiceImpl(conn);
        contact = service.getContactById(id);
    } catch (Exception e) {
        e.printStackTrace();
    }

    if (contact == null) {
%>
    <h2>Contact not found!</h2>
    <a href="ContactServlet">← Back to Dashboard</a>
<%
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Contact</title>
    <link rel="stylesheet" href="Dashboard.css" />
    <style>
        body {
            background-color: #f0f0f5;
            font-family: Arial, sans-serif;
        }

        .card {
            width: 450px;
            margin: 50px auto;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
            background-color: #fff;
            border: 1px solid #ccc;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        form label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }

        form input[type="text"],
        form input[type="email"],
        form input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 18px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            background-color: #fafafa;
        }

        .form-actions {
            text-align: center;
        }

        .form-actions input[type="submit"] {
            padding: 10px 20px;
            border: none;
            border-radius: 8px;
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
            cursor: pointer;
        }

        .form-actions input[type="submit"]:hover {
            background-color: #45a049;
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #0066cc;
            text-decoration: none;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="card">
    <h2>Edit Contact</h2>
    <form action="UpdateContactServlet" method="post">
        <input type="hidden" name="id" value="<%= contact.getId() %>">

        <label for="name">Name:</label>
        <input type="text" name="name" id="name" value="<%= contact.getName() %>" required>

        <label for="email">Email:</label>
        <input type="email" name="email" id="email" value="<%= contact.getEmail() %>" required>

        <label for="phone">Phone:</label>
        <input type="text" name="phone" id="phone" value="<%= contact.getPhone() %>" required>

        <label for="address">Address:</label>
        <input type="text" name="address" id="address" value="<%= contact.getAddress() %>" required>

        <label for="birthday">Birthday:</label>
        <input type="date" name="birthday" id="birthday" value="<%= contact.getBirthday() %>" required>
        
         
        
        <label for="group">Group</label>
        <select name="group" id="group" required>
            <option value="">"<%= contact.getGroup() %></option>
            <option value="Friends">Friends</option>
            <option value="Family">Family</option>
            <option value="Office">Office</option>
            <option value="Relatives">Relatives</option>
        </select>
        

        <div class="form-actions">
            <input type="submit" value="Update Contact">
        </div>
    </form>
    <a class="back-link" href="ContactDetail.jsp?id=<%= contact.getId() %>">← Cancel and Go Back</a>
</div>

</body>
</html>
