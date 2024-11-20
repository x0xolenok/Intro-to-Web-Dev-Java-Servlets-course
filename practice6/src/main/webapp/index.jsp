<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>JSP Tags Demonstration</title>
</head>
<body>

<h2>1. Testing Conditional Tags</h2>

<%-- Creating variables for condition testing --%>
<c:set var="userLoggedIn" value="true" />
<c:set var="role" value="admin" />


<c:if test="${userLoggedIn}">
  <p>You are logged in as a user.</p>
</c:if>

<c:choose>
  <c:when test="${role == 'admin'}">
    <p>You have administrator access.</p>
  </c:when>
  <c:otherwise>
    <p>You are a regular user.</p>
  </c:otherwise>
</c:choose>

<h2>2. Displaying Collection Content Using Iterators</h2>

<%-- Creating a list for iteration --%>
<%
  List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");
  request.setAttribute("items", items);
%>

<ul>
  <c:forEach var="item" items="${items}">
    <li>${item}</li>
  </c:forEach>
</ul>

<h2>3. Formatting Currency, Date, Time, and Numbers</h2>

<%-- Current date for formatting --%>
<%
  java.util.Date now = new java.util.Date();
  request.setAttribute("now", now);
%>

<fmt:setLocale value="uk_UA" />  <%-- Setting the locale to Ukraine for currency formatting --%>

<p>Date and Time Formatting:</p>
<p>Current date and time (short format): <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /></p>
<p>Current date (long format): <fmt:formatDate value="${now}" type="date" dateStyle="long" /></p>

<p>Number and Currency Formatting:</p>
<p>Number with two decimal places: <fmt:formatNumber value="12345.6789" type="number" maxFractionDigits="2" /></p>
<p>Currency format: <fmt:formatNumber value="12345.6789" type="currency" /></p>

</body>
</html>
