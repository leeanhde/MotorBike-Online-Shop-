/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOAccount;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Account;

/**
 *
 * @author leede
 */
@WebServlet(name = "UpdateProfile")
public class UpdateProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DAOAccount db = new DAOAccount();
        Account a = db.getUserById(id);
        if (a != null) {
            request.setAttribute("profile", a);
            request.getRequestDispatcher("updateProfile.jsp").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOAccount db = new DAOAccount();
        Account a = new Account();
        a.setUsername(request.getParameter("username"));
        a.setEmail(request.getParameter("email"));
        a.setPhoneNum(request.getParameter("phoneNum"));
        a.setId(Integer.parseInt(request.getParameter("id")));

        db.updateProfile(a);

        response.sendRedirect("home.jsp");
    }

}
