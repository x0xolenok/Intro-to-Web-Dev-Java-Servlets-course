package org.example.individual;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    private static Connection connection;

    static {
        try {
            // Завантажуємо драйвер PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Підключення до PostgreSQL
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/individual", "postgres", "root");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO products (name, brand, price, description) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getBrand());
            statement.setInt(3, product.getPrice());
            statement.setString(4, product.getDescription());
            statement.executeUpdate();
        }
    }

    public static void updateProduct(int id, Product product) throws SQLException {
        String query = "UPDATE products SET name = ?, brand = ?, price = ?, description = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getBrand());
            statement.setInt(3, product.getPrice());
            statement.setString(4, product.getDescription());
            statement.setInt(5, id);
            statement.executeUpdate();
        }
    }

    public static void deleteProduct(int id) throws SQLException {
        String query = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public static List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String brand = resultSet.getString("brand");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");

                Product product = new Product(id, name, brand, price, description);
                products.add(product);
            }
        }
        return products;
    }

    public static Product getProductById(int id) throws SQLException {
        String query = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Product(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("brand"),
                            resultSet.getInt("price"),
                            resultSet.getString("description")
                    );
                }
            }
        }
        return null;
    }
}
