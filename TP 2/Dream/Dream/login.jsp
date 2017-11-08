<%@include file="connect.jsp"%>

<%
String uname=request.getParameter("uname");
String passw =request.getParameter("passw");
String suid =(String)session.getAttribute("uid");
Boolean isLogin=false;
String last="";

rs=st.executeQuery("select uname ,passw,id,Format(lastvisit,'dd mmmm,yyyy hh:nn AM/PM'),crid from Customer where uname='"+uname +"'");
if(rs.next()){
	if(rs.getString(1).equals(uname) && rs.getString(2).equals(passw)){
		String uid=rs.getString(3);
		if(uid.equals(suid)){%>			
<div style='color:cyan'>You Are Already Logged In</div>
<%		}else{
			session.setAttribute("uid",uid);
			last=rs.getString(4);
			session.setAttribute("crid",rs.getString(5));
			st.executeUpdate("update Customer set noofvisits=noofvisits+1 where id=" +uid);
			java.util.Date dt=new java.util.Date();			
			st.executeUpdate("update Customer set lastvisit='"+ dt.toLocaleString() + "' where id=" +uid);
			rs=st.executeQuery("select fname,mname,lname from Customer where id="+uid);
			if(rs.next()){
				String name=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3);
				System.out.println(name);				
				name="Welcome "+name;
				String messageright="<div>Last Visit : " + last +"&nbsp;| &nbsp;<a href='javascript:editProfile()'>Edit Profile</a>&nbsp; |&nbsp; " ;
				messageright+="<a href='javascript:logout()'>Logout</a>";
				session.setAttribute("messagecenter",name);
				session.setAttribute("messageright",messageright);
			}%>		
			<div style="color:cyan">You Have succesfully Logged in.<br>You last visited on <%=last%></div>
<%		}
	}else{%>
		<div style="color:red;">Username Or Password is Incorrect</div>	
<%	}
}else{%>
			<div style="color:red;">Username Or Password is Incorrect</div>
<%}
conn.close();
%>