<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Home - Swimming Store</title>
</head>
<body>
<h1>Welcome to the Swimming Store</h1>

<!-- Вітання користувача, якщо він авторизований -->
<c:if test="${not empty sessionScope.user}">
  <p>Welcome, ${sessionScope.user}!</p>
  <p><a href="logout">Logout</a></p>
</c:if>

<!-- Якщо користувач не авторизований, пропонуємо увійти -->
<c:if test="${empty sessionScope.user}">
  <p>You are not logged in. <a href="login">Login here</a> or <a href="register">Register here</a>.</p>
</c:if>

<h2>Featured Products</h2>

<!-- Список продуктів з товарами для плавання -->
<ul>
  <li><a href="product?id=1">Swimming Goggles</a> - High quality goggles for your swim.</li>
  <li><a href="product?id=2">Swim Caps</a> - Comfortable and stylish swim caps.</li>
  <li><a href="product?id=3">Flotation Devices</a> - Perfect for safety in the pool.</li>
  <li><a href="product?id=4">Swimming Shorts</a> - Comfortable shorts for your swim.</li>
</ul>

<p><a href="products">Browse All Products</a></p>

<footer>
  <p>&copy; 2024 Swimming Store</p>
</footer>
</body>
</html>
