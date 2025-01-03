package com.voting.servlets;

import com.voting.utils.DatabaseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String candidate = request.getParameter("candidate");
        
        if (candidate != null) {
            DatabaseUtil.vote(candidate);  // Increment vote for the candidate
            response.sendRedirect("pages/results.jsp");
        } else {
            request.setAttribute("message", "Please select a candidate.");
            request.getRequestDispatcher("pages/vote.jsp").forward(request, response);
        }
    }
}
