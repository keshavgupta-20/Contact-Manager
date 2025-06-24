package Controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

import ServiceImpl.ContactServiceImpl;
import Util.JdbcUtil;

@WebServlet("/DeleteContact")
public class DeleteContactServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");

        if (idStr == null || idStr.isEmpty()) {
            response.getWriter().write("Missing contact ID");
            return;
        }

        try {
            int contactId = Integer.parseInt(idStr);
            Connection conn = JdbcUtil.getDbConnection();
            ContactServiceImpl service = new ContactServiceImpl(conn);

            boolean deleted = service.deleteContactById(contactId);

            if (deleted) {
                response.sendRedirect("ContactServlet"); // or Dashboard.jsp
            } else {
                response.getWriter().write("Contact not found or could not be deleted.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error occurred while deleting contact.");
        }
    }
}

