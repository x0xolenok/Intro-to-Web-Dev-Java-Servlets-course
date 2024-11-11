
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<h1>Welcome to the Home Page</h1>
<p>You are logged in as <%= session.getAttribute("user") %></p>
<a href="logout">Logout</a>
