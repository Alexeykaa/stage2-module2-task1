package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<User> users = getUsers();
        save(req, users);
        forward(req, resp);
    }

    private void save(HttpServletRequest req, Set<User> users) {
        req.setAttribute(AppConstant.USERS_REQUEST_ATTRIBUTE, users);
    }

    private Set<User> getUsers() {
        Warehouse store = Warehouse.getInstance();
        return store.getUsers();
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(AppConstant.USERS_JSP);
        dispatcher.forward(req, resp);
    }
}
