package org.example.individual;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("productList", ProductDB.getAllProducts());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String brand = request.getParameter("brand");
        int price = Integer.parseInt(request.getParameter("price"));

        Product newProduct = new Product(name, brand, price, description);
        try {
            ProductDB.addProduct(newProduct);
            response.sendRedirect("products");
        } catch (SQLException e) {
            throw new ServletException("Error creating a product", e);
        }
    }
}
