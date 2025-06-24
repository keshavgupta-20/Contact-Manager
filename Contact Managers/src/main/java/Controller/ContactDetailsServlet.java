package Controller;

import java.io.IOException;
import java.sql.Connection;

import Entites.ContactDetail;
import ServiceImpl.ContactServiceImpl;
import Util.JdbcUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ContactDetail")
public class ContactDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int contactId = Integer.parseInt(request.getParameter("id"));
        Connection conn = null;

        try {
            conn = JdbcUtil.getDbConnection();
            ContactServiceImpl service = new ContactServiceImpl(conn);
            ContactDetail contact = service.getContactById(contactId);

            request.setAttribute("contact", contact);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ContactDetail.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
