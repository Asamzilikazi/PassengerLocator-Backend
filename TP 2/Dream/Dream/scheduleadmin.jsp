<%@include file="connect.jsp" %>
<%
String showby=request.getParameter("showby");
String showvalue=request.getParameter("showvalue");
String showid=request.getParameter("showid");
String name=request.getParameter("name");
String showName=request.getParameter("showName");
if(name==null||name.equals("")) name=showby;
String sql="";
if(showby.equals("Cinema")){
	sql="select * from cinemanames";
}else if(showby.equals("Movie")){
	sql="select id,name from film";
}else if(showvalue!=null){
	if(showby.equals("Screen")){
		sql="SELECT Screen.ID, Screen.[No] FROM Screen WHERE Screen.CinemaID="+showvalue;
	}
} 
try{
	System.out.println (sql);
	rs=st.executeQuery(sql);
	String eventhandler="";
	if(showby.equals("Cinema"))
		eventhandler="onchange=\"showmessage('scheduleadmin.jsp?showby=Screen&name="+showName+"&showvalue='+this.value,'"+showid+"')\"";
	System.out.println (eventhandler);
%>
	<select name=<%=name%>  <%=eventhandler%> >
	<option value=0>Select A <%=showby%></option>
	<%while(rs.next()){%>
	<option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>
<%}
}
catch(Exception e){
	System.out.println(e);
}
conn.close();
%>
</select>