package com.example.practice3;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Enumeration;

public class MyServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Servlet initialized.");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(300); // Тривалість сесії в секундах (5 хвилин)


        String sessionAttribute = (String) session.getAttribute("userAttribute");
        if (sessionAttribute == null) {
            session.setAttribute("userAttribute", "sessionValue");
            sessionAttribute = "New session created, attribute set!";
        } else {
            sessionAttribute = "Session attribute exists: " + sessionAttribute;
        }

        out.println("<html><head><title>Servlet Session and Cookies Test</title></head><body>");
        out.println("<h1>Servlet Test</h1>");


        out.println("<h2>HTTP Session</h2>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Session Attribute: " + sessionAttribute + "</p>");
        out.println("<p>Session Creation Time: " + session.getCreationTime() + "</p>");
        out.println("<p>Session Last Accessed Time: " + session.getLastAccessedTime() + "</p>");
        out.println("<p>Session Max Inactive Interval: " + session.getMaxInactiveInterval() + " seconds</p>");


        Cookie[] cookies = request.getCookies();
        String cookieValue = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("exampleCookie".equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                    break;
                }
            }
        }

        if (cookieValue == null) {
            Cookie newCookie = new Cookie("exampleCookie", "cookieValue123");
            newCookie.setMaxAge(60 * 60); // Тривалість cookie - 1 година
            response.addCookie(newCookie);
            cookieValue = "New cookie created!";
        } else {
            cookieValue = "Cookie value: " + cookieValue;
        }


        out.println("<h2>Cookies</h2>");
        out.println("<p>" + cookieValue + "</p>");

        out.println("</body></html>");
        out.close();
    }

    @Override
    public void destroy() {

    }

}

