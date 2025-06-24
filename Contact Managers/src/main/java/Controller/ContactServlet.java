package Controller;


import Entites.Contact;
import ServiceImpl.ContactServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import DaoImple.ContactDAO;
import Util.JdbcUtil;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
		try {
			conn = JdbcUtil.getDbConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Assuming you have DBConnection class

        ContactServiceImpl service = new ContactServiceImpl(conn);
        List<Contact> contactLists = service.getAllContacts();
        System.out.println(contactLists.size());

        request.setAttribute("contactLists", contactLists);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Dashboard.jsp");
        dispatcher.forward(request, response);
    }
}

