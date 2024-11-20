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

<h2> <a href="products"> Our products </a> </h2>

<footer>
  <p>&copy; 2024 Swimming Store</p>
</footer>
</body>
</html>
