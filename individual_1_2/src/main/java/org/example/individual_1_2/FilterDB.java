package org.example.individual_1_2;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebFilter("/protected/*")
public class FilterDB implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(jakarta.servlet.ServletRequest request, jakarta.servlet.ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/individual", "postgres", "root")) {
            // Якщо підключення не вдалося
            if (connection == null || connection.isClosed()) {
                ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/dbError.jsp");
            } else {
                // Якщо з'єднання успішне, продовжуємо обробку запиту
                chain.doFilter(request, response);
            }
        } catch (SQLException e) {
            // В разі помилки підключення, перенаправляємо на сторінку помилки
            ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/dbError.jsp");
        }
    }

    @Override
    public void destroy() {}
}
