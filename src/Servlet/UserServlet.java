package com.voting.servlets;

import com.voting.models.User;
import com.voting.utils.DatabaseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = DatabaseUtil.getUser(username);
        request.setAttribute("user", user);
        request.getRequestDispatcher("pages/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username.isEmpty() || password.isEmpty()) {
            request.setAttribute("message", "All fields are required!");
            request.getRequestDispatcher("pages/register.jsp").forward(request, response);
            return;
        }

        User newUser = new User(username, password);
        DatabaseUtil.addUser(newUser);
        request.setAttribute("message", "Registration successful!");
        request.getRequestDispatcher("pages/register.jsp").forward(request, response);
    }
}
