<%@include file="connect.jsp" %>
<% 
String filmid =request.getParameter("Filmid");
if(filmid==null || filmid.equals("0")){%>
<table border=1 height=50px width=100%><tr align=center><td>No Movie Selected</td></tr></table>
<%
}else{
	rs=st.executeQuery("select image,trailer,Name,Story,cast,category from film where id="+filmid);
	if(rs.next()){
		String image=rs.getString(1);
	 %>
	<table>
	<tr>
		<td>
		<input id="flashvars"  type="hidden" value="file=trailer/<%=rs.getString(2)%>&image=cover/<%=image%>">
		<div id="container"><img src="cover/<%=image%>"><br>
		<a href="http://www.macromedia.com/go/getflashplayer">Get the Flash Player</a> to view the trailer.</div>		
		</td>
		<td><table>
		<tr><td class="pagename"><%=rs.getString(3)%></td></tr>
		<tr><td><div class="subtitle">Story:</div><%=rs.getString(4)%></td></tr>
		<tr><td><div class="subtitle">Casting:</div><%=rs.getString(5)%></td></tr>
		<tr><td style="font-size:18px;">Category:<%=rs.getString(6)%></td></tr>
		</table></td>
	</tr>
	</table>
	<%}
}
conn.close();
%>