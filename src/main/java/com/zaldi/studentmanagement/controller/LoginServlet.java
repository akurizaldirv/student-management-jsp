package com.zaldi.studentmanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "")
public class LoginServlet extends HttpServlet {
    private String userId;
    private String password;

    @Override
    public void init() throws ServletException {
        this.userId = "admin";
        this.password = "password";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "");
        req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("userId");
        String pass = req.getParameter("password");
        HttpSession session = req.getSession();

        if (user.equals(this.userId) && pass.equals(this.password)) {
            session.setAttribute("userId", user);
            resp.sendRedirect("students");
        } else {
            session.setAttribute("alertMessage", "User ID/Password tidak sesuai");
            req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
        }
    }
}
