/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="ResetPass", urlPatterns={"/ResetPass"})
public class ResetPass extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
         String username = request.getParameter("username");
        String email = request.getParameter("email");

        // Kiểm tra thông tin đăng nhập và reset mật khẩu
        boolean isResetSuccessful = resetPassword(username, email);

        // Tạo phản hồi
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Reset Password</h2>");

        if (isResetSuccessful) {
            out.println("<p>Password reset successful. Please check your email for the new password.</p>");
        } else {
            out.println("<p>Password reset failed. Please check your username and email.</p>");
        }

        out.println("</body></html>");
    }

    private boolean resetPassword(String username, String email) {
        // Logic để thiết lập lại mật khẩu dựa trên thông tin người dùng
        // Đây chỉ là một ví dụ đơn giản, bạn có thể thay thế nó với logic thực tế

        // Kiểm tra thông tin đăng nhập và reset mật khẩu
        if (username.equals("admin") && email.equals("admin@example.com")) {
            // Thiết lập lại mật khẩu cho người dùng
            // Ví dụ: userDao.resetPassword(username);

            return true;
        } else {
            return false;
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
