<%@include file="connect.jsp"%>
<%
	String uid =(String)session.getAttribute("uid");
	if(uid!=null){
		try {
			session.removeAttribute("uid");
			session.removeAttribute("messagecenter");
			session.removeAttribute("messageright");
			}catch (Exception ex){
				System.out.println(ex);
			}
		conn.close();
%>
<div style="color:cyan;">You have logged Out Successfully</div>
<%}else{%>
<div style="color:red;">You are not logged in now.</div>
<% } %>
