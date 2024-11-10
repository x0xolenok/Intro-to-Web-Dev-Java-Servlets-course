<%@ include file="header.jsp" %>

<h2>Results</h2>

<p><strong>First Name:</strong> ${param.name}</p>
<p><strong>Last Name:</strong> ${param.surname}</p>

<p><strong>Favorite Sports:</strong></p>
<%
  String[] sports = request.getParameterValues("sport");
  if (sports != null) {
    for (String sport : sports) {
      out.println("<p>" + sport + "</p>");
    }
  } else {
    out.println("<p>No favorite sport selected.</p>");
  }
%>

<p><strong>Favorite Dishes:</strong></p>
<%
  String[] dishes = request.getParameterValues("dish");
  if (dishes != null) {
    for (String dish : dishes) {
      out.println("<p>" + dish + "</p>");
    }
  } else {
    out.println("<p>No favorite dish selected.</p>");
  }
%>

<p><strong>Favorite Colors:</strong></p>
<%
  String[] colors = request.getParameterValues("color");
  if (colors != null) {
    for (String color : colors) {
      out.println("<p>" + color + "</p>");
    }
  } else {
    out.println("<p>No favorite color selected.</p>");
  }
%>

<%@ include file="footer.jsp" %>
