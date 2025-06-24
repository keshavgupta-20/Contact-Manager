package Filterss;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebFilter("/*") 
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        String uri = req.getRequestURI();

        boolean isLoginPage = uri.endsWith("LoginPage.jsp") || uri.endsWith("LoginController");
        boolean isStatic = uri.contains("css") || uri.contains("js") || uri.contains("images");

        if (loggedIn || isLoginPage || isStatic) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect("LoginPage.jsp");
        }
    }
}

