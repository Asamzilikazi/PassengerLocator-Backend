<%@include file="connect.jsp"%>
<%
String fname=request.getParameter("fname");
String mname=request.getParameter("mname");
String lname=request.getParameter("lname");
String email=request.getParameter("email");
String phno=request.getParameter("phno");
String address=request.getParameter("address");
String city=request.getParameter("City");
String crno=request.getParameter("crno");
String uid=(String)session.getAttribute("uid");
String crid=(String)session.getAttribute("crid");
if(uid!=null){
	st.executeUpdate("update credit set crno ='"+crno+"' where id="+crid);
	String sql="update Customer set fname='"+fname+"', mname='"+mname+"',lname='"+lname+"',email='"+email+"',phno='"+phno+"',address='"+address+"',cityid="+city;
	sql+=" where id="+ uid;
	st.executeUpdate(sql);
	conn.close();%>
	<div style="color:cyan">Your profile have been saved</div>
<%}else{%>
	<div style="color:red">You are not logged in</div>
<%}%>