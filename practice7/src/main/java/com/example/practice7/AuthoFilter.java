package com.example.practice7;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Перевірка, чи є користувач авторизованим (якщо сесія не містить атрибут "user")
        if (httpRequest.getSession().getAttribute("user") == null) {
            // Якщо не авторизований, перенаправляємо на сторінку логіну
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            return;
        }

        // Якщо користувач авторизований, продовжуємо обробку запиту
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
