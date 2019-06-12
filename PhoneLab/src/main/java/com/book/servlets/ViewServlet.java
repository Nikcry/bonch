package com.book.servlets;

import com.book.storages.UserStorage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewServlet extends HttpServlet {
    private UserStorage storage = UserStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", storage.getAllUsers());
        req.getRequestDispatcher("/WEB-INF/views/view.jsp").forward(req, resp);
    }
}