package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import Entites.ContactDetail;
import ServiceImpl.ContactServiceImpl;
import Util.JdbcUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-contact")
public class ContactServlets extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String birthdayStr = request.getParameter("birthday");
        String group = request.getParameter("group");

        try {
            Date birthday = Date.valueOf(birthdayStr); // java.sql.Date
            ContactDetail contact = new ContactDetail();
            contact.setName(fullname);
            contact.setPhone(phone);
            contact.setEmail(email);
            contact.setAddress(address);
            contact.setBirthday(birthday);
            contact.setGroup(group);

            Connection conn = JdbcUtil.getDbConnection();
            ContactServiceImpl service = new ContactServiceImpl(conn);
            boolean success = service.addContact(contact);

            if (success) {
                response.sendRedirect("ContactServlet"); // or ContactServlet
            } else {
                response.getWriter().write("Failed to add contact.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}

