<%@include file="connect.jsp"%>
<%
String passw=request.getParameter("passw");
String oldpassw=request.getParameter("oldPassw");
String uid=(String)session.getAttribute("uid");

if(uid!=null){
	rs=st.executeQuery("select passw from Customer where id="+ uid);
	rs.next();
	if(oldpassw.equals(rs.getString(1))){
		st.executeUpdate("update Customer set passw='"+passw+"' where id="+uid);%>
		<div style="color:green;">Your password has been updated</div>
<%	}else{%>
		<div style="color:red;">Your old password did not match.</div>
<%	}
}else{%>
		<div style="color:red;">You are not logged in now</div>
<%}
conn.close();
%>
