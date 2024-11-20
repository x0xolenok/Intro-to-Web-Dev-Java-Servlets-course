<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<%@ taglib uri="http://www.swimshop.com/tags" prefix="product" %>

<html>
<head>
    <title>Product List</title>
</head>
<body>
<a href="<%= request.getContextPath() %>/logout">Logout</a>

<h2>Add a New Product</h2>
<form action="${pageContext.request.contextPath}/products" method="POST">
    <label for="name">Product Name:</label>
    <input type="text" id="name" name="name" required />
    <br>
    <label for="price">Price (USD):</label>
    <input type="number" id="price" name="price" required />
    <br>
    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea>
    <br>
    <button type="submit">Add Product</button>
</form>

<h2>Available Products</h2>
<product:productInfo products="${productList}" />
</body>
</html>
