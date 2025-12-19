package com.bank.controller;

import com.bank.dao.UserDAO;
import com.bank.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("profile".equals(action)) {
            User user = (User) request.getSession().getAttribute("user");
            if (user != null) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
            } else {
                response.sendRedirect("pages/register.jsp");
            }
        } else {
            response.sendRedirect("pages/register.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("register".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            User user = new User(name, email, password);
            userDAO.saveUser(user);
            request.getSession().setAttribute("user", user);

            response.sendRedirect("user?action=profile");
        }
    }
}
