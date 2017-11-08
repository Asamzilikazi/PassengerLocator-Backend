<%@include file="connect.jsp"%>
<%
String uname=request.getParameter("name");
if(uname!=null&&uname.length()!=0){
	rs=st.executeQuery("select id from Customer where uname='"+uname+"'");
	out.println(!rs.next());
}
conn.close();
%>