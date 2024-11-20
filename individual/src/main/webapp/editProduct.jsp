<%@ page import="org.example.individual.Product" %>
<%@ page import="java.util.List" %>

<jsp:useBean id="product" scope="request" type="org.example.individual.Product" />

<html>
<head>
  <title>Edit Product</title>
</head>
<body>
<h2>Edit Product</h2>

<form action="editProduct" method="post">
  <input type="hidden" name="id" value="${param.id}" />

  <label for="name">Product Name:</label>
  <input type="text" id="name" name="name" value="${product.name}" required />
  <br/>
  <label for="brand">Brand:</label>
  <input type="text" id="brand" name="brand" value="${product.brand}" required />
  <br/>
  <label for="price">Price (USD):</label>
  <input type="number" id="price" name="price" value="${product.price}" required />
  <br/>
  <label for="description">Description:</label>
  <textarea id="description" name="description" required>${product.description}</textarea>
  <br/>
  <button type="submit">Update Product</button>
</form>

<form action="deleteProduct" method="post" onsubmit="return confirm('Are you sure you want to delete this product?');">
  <input type="hidden" name="id" value="${param.id}" />
  <button type="submit">Delete Product</button>
</form>

<br/>
<a href="products">Back to Product List</a>
</body>
</html>
