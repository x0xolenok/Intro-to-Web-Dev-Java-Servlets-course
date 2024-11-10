<%@ include file="header.jsp" %>

<h2>Favourite Things Form</h2>
<form action="result.jsp" method="post">
  <!-- Name and surname with required fields -->
  <label>First Name: <input type="text" name="name" required /></label><br><br>
  <label>Last Name: <input type="text" name="surname" required /></label><br><br>

  <!-- Favorite Sport (multiple selection with checkboxes) -->
  <label>Favorite Sport:</label><br>
  <input type="checkbox" name="sport" value="Football"> Football<br>
  <input type="checkbox" name="sport" value="Basketball"> Basketball<br>
  <input type="checkbox" name="sport" value="Tennis"> Tennis<br>
  <input type="checkbox" name="sport" value="Swimming"> Swimming<br>
  <input type="checkbox" name="sport" value="Running"> Running<br><br>

  <!-- Favorite Dish (multiple selection with checkboxes) -->
  <label>Favorite Dish:</label><br>
  <input type="checkbox" name="dish" value="Pizza"> Pizza<br>
  <input type="checkbox" name="dish" value="Sushi"> Sushi<br>
  <input type="checkbox" name="dish" value="Burger"> Burger<br>
  <input type="checkbox" name="dish" value="Pasta"> Pasta<br>
  <input type="checkbox" name="dish" value="Salad"> Salad<br><br>

  <!-- Favorite Color (multiple selection with checkboxes) -->
  <label>Favorite Color:</label><br>
  <input type="checkbox" name="color" value="Red"> Red<br>
  <input type="checkbox" name="color" value="Blue"> Blue<br>
  <input type="checkbox" name="color" value="Green"> Green<br>
  <input type="checkbox" name="color" value="Yellow"> Yellow<br>
  <input type="checkbox" name="color" value="Purple"> Purple<br><br>

  <button type="submit">Submit</button>
</form>

<%@ include file="footer.jsp" %>
