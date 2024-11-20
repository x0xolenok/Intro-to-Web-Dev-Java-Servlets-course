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

<!-- Якщо є помилка, то вивести повідомлення -->
<c:if test="${param.error != null}">
    <p style="color:red;">Invalid username or password. Please try again.</p>
</c:if>

<!-- Посилання на сторінку реєстрації -->
<p>Don't have an account? <a href="register">Register here</a></p>

</body>
</html>
