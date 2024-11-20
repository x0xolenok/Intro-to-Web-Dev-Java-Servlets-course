<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
</head>
<body>
<h2>Login</h2>

<!-- Форма для введення даних для входу -->
<form action="login" method="post">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username" required /><br><br>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required /><br><br>

  <button type="submit">Login</button>
</form>

<!-- Посилання на сторінку реєстрації -->
<p>Don't have an account? <a href="register.jsp">Register here</a></p>

</body>
</html>
