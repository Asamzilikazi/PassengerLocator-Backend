<%@page import="java.sql.*" %><%
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection conn=DriverManager.getConnection("jdbc:odbc:Dream");
Statement st = conn.createStatement();
ResultSet rs=null;
%>