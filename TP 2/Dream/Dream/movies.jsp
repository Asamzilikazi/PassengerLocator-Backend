<%@include file="connect.jsp" %><%
rs=st.executeQuery("select id, Name from Film");
%>
<select  onchange="loadfilmdesc(this.value)">
	<option value=0>Select A Movie</option>
	<%while(rs.next()){%>
	<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
<%}
conn.close();
%>
</select>