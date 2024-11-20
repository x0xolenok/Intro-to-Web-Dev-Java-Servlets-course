<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
<h2>Register</h2>

<!-- Форма для реєстрації нового користувача -->
<form action="register" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required /><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required /><br><br>

    <button type="submit">Register</button>
</form>

<!-- Якщо є помилка, показуємо повідомлення -->
<c:if test="${param.error != null}">
    <p style="color:red;">Error: ${param.error}</p>
</c:if>

<!-- Посилання на сторінку входу, якщо користувач уже має акаунт -->
<p>Already have an account? <a href="login">Login here</a></p>

</body>
</html>
