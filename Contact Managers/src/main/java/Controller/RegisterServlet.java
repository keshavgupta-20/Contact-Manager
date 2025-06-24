package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Entites.User;
import Service.UserService;
import ServiceImpl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String email = request.getParameter("email");
	        String password = request.getParameter("password");

	        UserServiceImpl userService = new UserServiceImpl();
	        User user = userService.Login(email, password);
	        if (!"null".equals(user)) {
	            HttpSession session = request.getSession();
	            session.setAttribute("currentUser", user);
	            response.sendRedirect("Dashboard.jsp");
	        } else {
	            request.setAttribute("error", "Invalid email or password.");
	            request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
	        }
	    }
	}
	


