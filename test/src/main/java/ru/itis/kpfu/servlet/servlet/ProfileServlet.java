package ru.itis.kpfu.servlet.servlet;

import org.apache.commons.codec.digest.DigestUtils;
import ru.itis.kpfu.servlet.dao.CredentialsDaoImpl;
import ru.itis.kpfu.servlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Liia on 24.10.2016.
 */
public class ProfileServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String psw = req.getParameter("password");
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5433/logindb";
        String name = "postgres";
        String password = "postgres";
        String hash =  DigestUtils.md5Hex(psw + "QxLUF1bgIAdeQX");

        boolean isUserExists = false;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Cоединение установлено");
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(
                    "UPDATE credentials SET login = ? , password = ? where login = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, DigestUtils.md5Hex(psw + "QxLUF1bgIAdeQX"));
            HttpSession session = req.getSession();
            preparedStatement.setString(3, (String) session.getAttribute("session_uname"));
            preparedStatement.executeUpdate();
            req.setAttribute("error", true);

            getServletConfig().getServletContext().getRequestDispatcher("/profile.ftl").forward(req, resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
