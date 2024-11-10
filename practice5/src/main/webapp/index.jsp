<%@ include file="header.jsp" %>

<h2>Favourite Things Form</h2>
<form action="result.jsp" method="post">
  <!-- Name and surname with required fields -->
  <label>First Name: <input type="text" name="name" required /></label><br><br>
  <label>Last Name: <input type="text" name="surname" required /></label><br><br>

  <!-- Favorite Sport (single selection with radio buttons) -->
  <label>Favorite Sport:</label><br>
  <input type="radio" name="sport" value="Football" required> Football<br>
  <input type="radio" name="sport" value="Basketball" required> Basketball<br>
  <input type="radio" name="sport" value="Tennis" required> Tennis<br>
  <input type="radio" name="sport" value="Swimming" required> Swimming<br>
  <input type="radio" name="sport" value="Running" required> Running<br><br>


  <!-- Favorite Dish (single selection with radio buttons) -->
  <label>Favorite Dish:</label><br>
  <input type="radio" name="dish" value="Pizza" required> Pizza<br>
  <input type="radio" name="dish" value="Sushi" required> Sushi<br>
  <input type="radio" name="dish" value="Burger" required> Burger<br>
  <input type="radio" name="dish" value="Pasta" required> Pasta<br>
  <input type="radio" name="dish" value="Salad" required> Salad<br><br>


  <!-- Favorite Color (single selection with radio buttons) -->
  <label>Favorite Color:</label><br>
  <input type="radio" name="color" value="Red" required> Red<br>
  <input type="radio" name="color" value="Blue" required> Blue<br>
  <input type="radio" name="color" value="Green" required> Green<br>
  <input type="radio" name="color" value="Yellow" required> Yellow<br>
  <input type="radio" name="color" value="Purple" required> Purple<br><br>


  <button type="submit">Submit</button>
</form>

<%@ include file="footer.jsp" %>
