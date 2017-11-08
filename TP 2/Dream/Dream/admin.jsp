<%@include file="connect.jsp"%>
<%
String req=request.getParameter("do");
String uid= (String)session.getAttribute("uid");
if(uid!=null&&req!=null&&uid.equals("1")){%>
<form name="frmAdmin">
	<table>
		<tr><td height="20px"></td>	</tr>
		<tr><td id='datainfo'  align="center" class="pageName"></td></tr>
		<tr><td><table id='admintable'>
<%	if(req.equals("viewcustomers")){
		rs=st.executeQuery("select * from viewcustomer");%>
		<tr><th>ID</th><th>User Name</th><th>Email-ID</th><th>Address</th><th>Phone</th><th>City</th><th>Credit card No.</th><th>Balance</th><th>Last Visited</th><th>No of Visits</th><th>Tickets Bought</th><th></th></tr>
		<tr id='insert'></tr>		
<%		while(rs.next()){
				String id=rs.getString(1);
				out.println("<tr id=c"+id+" class='adminRow'>");
				out.println("<td>"+id+"</td>");
				for(int i=2;i<=11;i++){
					String data=rs.getString(i);
					if(data==null) data="";
					out.println("<td>"+data+"</td>");
				}
				out.println("<td><a href=\"javascript:editCustomer('c"+id+"')\">edit</a> <a href=\"javascript:deleteCustomer('c"+id+"')\">delete</a></td>");
				out.println("</tr>");
			}%>
<%		}else if(req.equals("viewcinema")){
		rs=st.executeQuery("select *from viewcinema");%>
		<tr><th>ID</th><th>Name</th><th>Address</th><th>City</th><th>No of Screens</th><th>Capacity</th><th>Established</th><th></th></tr>
		<tr id='insert'></tr>
<%		while(rs.next()){
			String id=rs.getString(1);
			out.println("<tr id=c"+id+" class='adminRow'>");
			out.println("<td>"+id+"</td>");
			for(int i=2;i<=7;i++){
				String data=rs.getString(i);
				if(data==null) data="";
				out.println("<td>"+data+"</td>");
			}
			out.println("<td><a href=\"javascript:editCinema('c"+id+"')\">edit</a> <a href=\"javascript:deleteCinema('c"+id+"')\">delete</a></td>");
			out.println("</tr>");
		}
	}else if(req.equals("viewmovie")){
		rs=st.executeQuery("select * from viewmovie");%>
		<tr><th>ID</th><th>Name</th><th>Story line</th><th>Image File</th><th>Trailer File</th><th>Casting</th><th>Category</th><th></th></tr>
		<tr id='insert'></tr>
<%		while(rs.next()){
			String id=rs.getString(1);
			out.println("<tr id=m"+id+" class='adminRow'>");
			out.println("<td>"+id+"</td>");
			for(int i=2;i<=7;i++){
				String data=rs.getString(i);
				if(data==null) data="";
				out.println("<td>"+data+"</td>");
			}
			out.println("<td><a href=\"javascript:editMovie('m"+id+"')\">edit</a> <a href=\"javascript:deleteMovie('m"+id+"')\">delete</a></td>");
			out.println("</tr>");
		}
	}else if(req.equals("viewschedule")){
		rs=st.executeQuery("SELECT * from viewschedule");%>
		<tr><th>ID</th><th>Cinema</th><th>Screen No</th><th>Show date</th><th>Movie</th><th></th></tr>
		<tr id='insert'></tr>
<%		while(rs.next()){
			String id=rs.getString(1);
			out.println("<tr id=s"+id+" class='adminRow'>");
			out.println("<td>"+id+"</td>");
			for(int i=2;i<=5;i++){
				String data=rs.getString(i);
				if(data==null) data="";
				out.println("<td>"+data+"</td>");
			}
			out.println("<td><a href=\"javascript:editSchedule('s"+id+"')\">edit</a>");
			out.println("</tr>");
		}
	}else if(req.equals("viewtimeslot")){
		rs=st.executeQuery("SELECT ID,slotno from tTime where id=(select max(id) from tTime)");
		rs.next();
		int maxid=rs.getInt(1),count=1;
		while(rs.next()) count++;
		if(count==4) maxid++;
		rs=st.executeQuery("SELECT ID,SlotNo,Format(Slot,'hh:nn AM/PM') from tTime order by id,slotno");%>
		<tr><th>ID</th><th>Slot No</th><th>Time</th><th></th></tr>
		<tr id='insert'><td><%=maxid%></td></tr>
<%		while(rs.next()){
			String id=rs.getString(1);
			String sno=rs.getString(2);
			out.println("<tr id='t"+id+"s"+sno+"' class='adminRow'>");
			out.println("<td>"+id+"</td>");
			out.println("<td>"+sno+"</td>");
			out.println("<td>"+rs.getString(3)+"</td>");
			out.println("<td><a href=\"javascript:editTimeslot('t"+id+"s"+sno+"')\">edit</a>");
			out.println("</tr>");
		}
	}else if(req.equals("viewticket")){
		rs=st.executeQuery("SELECT * from viewticket");%>
		<tr><th>ID</th><th>Customer</th><th>Cinema</th><th>Screen No</th><th>Show Date</th><th>Show Time</th><th>Movie</th><th>Seats</th><th>Quantity</th><th>Amount</th><th>Sold Date</th></tr>		
<%		while(rs.next()){
			out.println("<tr class='adminRow'>");
			for(int i=1;i<=11;i++){
				String data=rs.getString(i);
				if(data==null) data="";
				out.println("<td>"+data+"</td>");
			}
			out.println("</tr>");
		}
	}
%>
	</table></td></tr></table>
</form>
<%}else{%>
	<div style="color:red;"><h2>You should be logged in as Administrator</h2></div>
<%}
conn.close();
%>