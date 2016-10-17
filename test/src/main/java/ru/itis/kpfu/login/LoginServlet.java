package ru.itis.kpfu.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


/**
 * Created by Марат on 27.09.2016.
 */

public class LoginServlet extends HttpServlet {
    ResultSet rs = null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Users",
                    "postgres",
                    "postgres");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PreparedStatement ps = null;
        try {
            assert connection != null;
            ps = connection.prepareStatement("SELECT * from credentials WHERE login=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs.next()) {
//                if (password.equals(rs.getString("password"))) {
//                    request.getSession().setAttribute("current_user", username);
//                    response.sendRedirect("/profile");
//
//                }
                if ("admin".equals(username) && "123".equals(password)) {
                    request.getSession().setAttribute("session_uname", username);
                    response.sendRedirect("/profile");

                }
                else {
                    request.setAttribute("error", true);
                    getServletConfig().getServletContext().getRequestDispatcher("/login.ftl").forward(request, response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletConfig().getServletContext().getRequestDispatcher("/login.ftl").forward(request, response);
    }
}
