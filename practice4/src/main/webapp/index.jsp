<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.temporal.ChronoUnit" %>

<!DOCTYPE html>
<html>
<head>
    <title>Birth Date</title>
</head>
<body>
<h2>Current Date and Time:</h2>
<%

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentDateAndTime = formatter.format(new Date());
    out.println("<p>" + currentDateAndTime + "</p>");
%>

<h2>Enter Your Birth Date:</h2>
<form action="index.jsp" method="post">
    <label for="birthDate">Birth Date (yyyy-mm-dd):</label>
    <input type="date" id="birthDate" name="birthDate" required>
    <button type="submit">Calculate Days Lived</button>
</form>

<%

    String birthDateString = request.getParameter("birthDate");
    if (birthDateString != null) {
        LocalDate birthDate = LocalDate.parse(birthDateString);
        LocalDate currentDate = LocalDate.now();

        if (birthDate.isAfter(currentDate)) {
            out.println("<h2>Error:</h2>");
            out.println("<p>The birth date cannot be in the future. Please enter a valid date.</p>");
        } else {
            long daysLived = ChronoUnit.DAYS.between(birthDate, currentDate);
            out.println("<h2>Days Lived:</h2>");
            out.println("<p>" + daysLived + " days</p>");
        }
    }
%>
</body>
</html>
