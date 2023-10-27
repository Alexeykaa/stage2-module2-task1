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

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = parseUser(req);
        save(req, user);
        forward(req, resp);
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher(AppConstant.ADD_USER_JSP);
        dispatcher.forward(req, resp);
    }

    private void save(HttpServletRequest req, User user) {
        Warehouse store = Warehouse.getInstance();
        store.addUser(user);
        req.setAttribute(AppConstant.USER_REQUEST_ATTRIBUTE, user);
    }

    private User parseUser(HttpServletRequest req) {
        User user = new User();
        user.setFirstName(req.getParameter(AppConstant.FIRST_NAME_USER_REQUEST_PARAM));
        user.setLastName(req.getParameter(AppConstant.LAST_NAME_USER_REQUEST_PARAM));
        return user;
    }
}
