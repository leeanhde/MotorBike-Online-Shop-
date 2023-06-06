package controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/forgot-password")
public class ResetPasswordServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Database configuration
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Shop";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Connect to database server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Step 2: Retrieve the user's email from the request
            String email = request.getParameter("email");

            // Step 3: Check if the email exists in the database
            String checkEmailQuery = "SELECT * FROM Account WHERE email=?";
            stmt = conn.prepareStatement(checkEmailQuery);
            stmt.setString(1, email);
            rs = stmt.executeQuery();
            boolean emailExists = rs.next();

            if (!emailExists) {
                // If the email does not exist in the database, notify the user
                request.setAttribute("errorMessage", "This email is not registered in our system.");
                request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            } else {
                // Step 4: Generate a random temporary password and insert it into the database
                String tempPassword = UUID.randomUUID().toString();
                Timestamp expiryTime = new Timestamp(System.currentTimeMillis() + (24 * 60 * 60 * 1000)); // Set expiry time to 24 hours from now

                String insertTempPasswordQuery = "INSERT INTO reset_password (email, temp_password, expiry_time) VALUES (?, ?, ?)";
                stmt = conn.prepareStatement(insertTempPasswordQuery);
                stmt.setString(1, email);
                stmt.setString(2, tempPassword);
                stmt.setTimestamp(3, expiryTime);
                stmt.executeUpdate();

                // Step 5: Send the temporary password to the user's email address
                sendEmail(email, tempPassword);

                // Step 6: Display success message to the user
                request.setAttribute("successMessage", "A temporary password has been sent to your email address. Please use it to log in and reset your password.");
                request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while processing your request.");
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
        } finally {
            // Step 7: Close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("changePassword.jsp");
        dispatcher.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    private void sendEmail(String email, String tempPassword) {
        // Implement code to send an email containing the temporary password to the user
        // This could be done using a library like JavaMail or Apache Commons Email
    }
}