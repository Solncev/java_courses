package ru.itis.kpfu.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Марат on 11.10.2016.
 */
public class
UserAuthFilter implements Filter {
    private List<String> urlList;

    public void destroy() {
        urlList = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String servletPath = request.getServletPath();
        boolean allowedRequest = false;
        for (String s : urlList) {
            if (servletPath.startsWith(s)) {
                allowedRequest = true;
            }
        }
        if (!allowedRequest) {
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("session_uname") == null) {
                response.sendRedirect("/login");
            }
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        String initParameter = config.getInitParameter("allow-urls");
        urlList = new ArrayList<String>();
        Collections.addAll(urlList, initParameter.split(","));
    }

}
