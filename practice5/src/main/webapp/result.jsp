<%@ include file="header.jsp" %>

<h2>Form Results</h2>
<%
  String name = request.getParameter("name");
  String surname = request.getParameter("surname");
  String sport = request.getParameter("sport");
  String dish = request.getParameter("dish");
  String color = request.getParameter("color");

  out.println("<p>First Name: " + name + "</p>");
  out.println("<p>Last Name: " + surname + "</p>");
  out.println("<p>Favorite Sport: " + sport + "</p>");
  out.println("<p>Favorite Dish: " + dish + "</p>");
  out.println("<p>Favorite Color: " + color + "</p>");
%>

<%@ include file="footer.jsp" %>
