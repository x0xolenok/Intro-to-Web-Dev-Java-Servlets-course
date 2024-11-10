package com.example.practice2;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;


public class FirstServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Servlet initialized.");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");


        String parameter = request.getParameter("exampleParam");
        Enumeration<String> parameterNames = request.getParameterNames();


        PrintWriter out = response.getWriter();


        out.println("<html><head><title>Servlet Test</title></head><body>");
        out.println("<h1>Servlet Test</h1>");

        if (parameter != null) {
            out.println("<p>Parameter 'exampleParam' = " + parameter + "</p>");
        } else {
            out.println("<p>Parameter 'exampleParam' not found.</p>");
        }

        out.println("<h2>All Parameters:</h2>");
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String[] values = request.getParameterValues(name);
            out.print("<p>" + name + " = ");
            for (String value : values) {
                out.print(value + " ");
            }
            out.println("</p>");
        }


        out.println("</body></html>");
        out.close();
    }

    @Override
    public void destroy() {
    }
}
