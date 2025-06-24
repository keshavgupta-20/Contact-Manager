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

@WebServlet("/UpdateContactServlet")
public class UpdateContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String group  = request.getParameter("group");

        ContactDetail contact = new ContactDetail(id, name, email, phone, address, birthday, group);

        try (Connection conn = JdbcUtil.getDbConnection()) {
            ContactServiceImpl service = new ContactServiceImpl(conn);
            boolean success = service.updateContact(contact);

            if (success) {
                response.sendRedirect("ContactDetail?id=" + id);
            } else {
                response.getWriter().println("<h2>Update failed!</h2>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error occurred!</h2>");
        }
    }
}
