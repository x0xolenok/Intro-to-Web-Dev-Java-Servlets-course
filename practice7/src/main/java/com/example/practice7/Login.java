package com.example.practice7;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Простий приклад авторизації (небезпечно для реальних додатків)
        if ("admin".equals(username) && "password".equals(password)) {
            request.getSession().setAttribute("user", username);
            response.sendRedirect("index.jsp");  // Перенаправлення на головну сторінку
        } else {
            // Якщо пароль або логін неправильні
            String errorMessage = "Invalid username or password.";
            if (!"admin".equals(username)) {
                errorMessage = "Username not found.";
            } else if (!"password".equals(password)) {
                errorMessage = "Incorrect password.";
            }
            response.sendRedirect("login.jsp?error=true&message=" + errorMessage);  // Перенаправляємо на login.jsp з помилкою
        }
    }
}
