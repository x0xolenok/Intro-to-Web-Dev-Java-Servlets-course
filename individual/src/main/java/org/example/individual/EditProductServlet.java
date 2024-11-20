package org.example.individual;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        try {
            Product product = ProductDB.getProductById(productId);
            request.setAttribute("product", product);
            request.getRequestDispatcher("/editProduct.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error fetching product details", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String brand = request.getParameter("brand");
        int price = Integer.parseInt(request.getParameter("price"));

        Product updatedProduct = new Product(name, brand, price, description);
        try {
            ProductDB.updateProduct(productId,updatedProduct);
            response.sendRedirect("products");
        } catch (SQLException e) {
            throw new ServletException("Error updating product", e);
        }
    }
}
