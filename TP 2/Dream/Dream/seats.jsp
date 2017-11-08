<%@include file="connect.jsp"%><%
String schid =request.getParameter("scheduleid");
String slot=request.getParameter("timeslot");
if(schid!=null && slot!=null){
	String sql="select seats from ticket where scheduleid="+schid+" and timeslot="+ slot;
	try{
		System.out.println (sql);
		rs=st.executeQuery(sql);
		while(rs.next())
			out.print(rs.getString(1));
	}catch(Exception e){
		System.out.println (e);
	}		
}
conn.close();
%>