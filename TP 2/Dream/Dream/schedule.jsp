<%@include file="connect.jsp" %>
<%
String showby =request.getParameter("showby");
String showvalue=request.getParameter("showvalue");
String sql="select id, Name from "+showby+" ";
String show ="";

if(showby.equals("Country")){
		show="State";
}else if(showvalue!=null){
	if(showby.equals("State")){
		sql+=" where countryid="+showvalue;
		show="City";
	}else if(showby.equals("City")){
		sql+=" where stateid="+showvalue;
		show="Cinema";
	}else if(showby.equals("Cinema")){
		sql+=" where cityid="+showvalue;
		show="Film";
	}else if(showby.equals("Film")){	
		String subquery="(Select filmid  FROM Schedule where showdate>=Date() and screenid in(select id from screen where cinemaid ="+showvalue+"))";
		sql+="where id in"+ subquery+"";
		session.setAttribute("cinema",showvalue);
		show="Date";
	}else if(showby.equals("Date")){
		sql="select id , Format(Showdate,'dd mmmm,yyyy') from schedule where showdate>= Date() and filmid="+showvalue +"and screenid in (select id from screen where cinemaid="+session.getAttribute("cinema")+")";
		show="Time";
	}else if(showby.equals("Time")){
		sql="select SlotNo ,Format(Slot,'hh nn AM/PM') from  ttime where id =(select timeid from screen where id=(select screenid from schedule where id="+showvalue+")) order by slot";
	}
}
try{
	System.out.println (sql);
	rs=st.executeQuery(sql);
	String eventhandler="";
	if(showby.equals("Time"))	
		eventhandler="onchange=\"loadseat()\"";
	else
		eventhandler="onchange=\"loadschedule('"+ show +"',this.value)\"";
	System.out.println (eventhandler);
%>
	<select name=<%=showby%>  <%=eventhandler%> >
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