package ru.itis.kpfu.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Liia on 27.09.2016.
 */
public class SimpleServlet extends HttpServlet {
    private static Map<String,String> LOGINS = new HashMap();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        req.setAttribute("message", "Hey " + username);
        boolean flag = false;

        if(LOGINS.containsKey(username))
        if(LOGINS.get(username).equals(password)){
            flag = true;
        }

        req.setAttribute("isLogged", flag);
        req.setAttribute("message", "Hey " + username);
        getServletConfig().getServletContext().getRequestDispatcher("/jsp/hello.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        LOGINS.put("123", "123");
            }
}
