package ru.itis.kpfu.servlet.servlet;

import org.apache.commons.codec.digest.DigestUtils;
import ru.itis.kpfu.servlet.dao.CredentialsDaoImpl;
import ru.itis.kpfu.servlet.dao.factory.ConnectionFactory;
import ru.itis.kpfu.servlet.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Liia on 11.10.2016.
 */

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletConfig().getServletContext().getRequestDispatcher("/login.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String psw = req.getParameter("password");
        ConnectionFactory conFactory = new ConnectionFactory();
        String salt = DigestUtils.md5Hex(psw);

        boolean isUserExists = false;
        try {
            Connection connection = conFactory.getConnection();
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM credentials where salt = ? and login = ?");
            preparedStatement.setString(1, salt);
            preparedStatement.setString(2, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                isUserExists = true;
            }
            if (isUserExists) {
                CredentialsDaoImpl user = new CredentialsDaoImpl();
                User newUser;
                newUser = user.findByLogin(username);
                String first = newUser.getFirstName();
                String last = newUser.getLastName();
                req.getSession().setAttribute("session_username", username);
                req.setAttribute("first", first);
                req.setAttribute("last", last);
                getServletConfig().getServletContext().getRequestDispatcher("/profile.ftl").forward(req, resp);
            } else {
                req.setAttribute("error", true);
                getServletConfig().getServletContext().getRequestDispatcher("/login.ftl").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
