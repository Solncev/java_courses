package ru.itis.kpfu.calc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Марат on 10.10.2016.
 */
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(
                "<form method=\"POST\" action=\"/calc\">\n" +
                "    <input type=\"int\" name=\"username\"/>\n" +
                "    <input type=\"int\" name=\"password\"/>\n" +
                "    <input type=\"submit\" value=\"sum\"/>\n" +
                "</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
