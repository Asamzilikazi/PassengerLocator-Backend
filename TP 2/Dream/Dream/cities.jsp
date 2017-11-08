<%@include file="connect.jsp" %>
<%
String sql="select id, Name from City";
String name=request.getParameter("name");
if(name==null || name.equals("") ) //empty name
	name="City"; //default value
try{
	System.out.println (sql);
	rs=st.executeQuery(sql);%>
	<select name="<%=name%>">
<%	while(rs.next()){%>
		<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option><%
	}
}
catch(Exception e){
	System.out.println(e);
}
conn.close();
%>
		<option value=0>Other</option>
	</select>