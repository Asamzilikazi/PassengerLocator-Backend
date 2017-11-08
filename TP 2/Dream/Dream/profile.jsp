<%@include file="connect.jsp"%>
<%
String data[]=new String[8];
String uid=(String)session.getAttribute("uid");
String crid=(String)session.getAttribute("crid");
if(uid!=null){
	rs=st.executeQuery("select fname,mname,lname,uname,email,phno,address,cityid from customer where id=" + uid);
	rs.next();
	for(int i=1;i<=8;i++) data[i-1]=rs.getString(i);
	rs=st.executeQuery("select crno from credit where id="+crid);
	rs.next();
	crid=rs.getString(1);
	conn.close();
%>
<form name="regform">
<table id="register">
	<tr><td colspan="2" id="profileMessage"></td></tr>
	<tr>		
		<td align="right" valign="top" style="padding-top: 5px">Name</td>
		<td>
		<table>
			<tr>
				<td><input type="text" name="fname" value="<%=data[0]%>"/></td>
				<td><input name="mname" type="text" value="<%=data[1]%>"/></td>
				<td><input name="lname" type="text" value="<%=data[2]%>"/></td>
			</tr>
			<tr>
				<td align="center">(First name)</td>
				<td align="center">(Middle name)</td>
				<td align="center">(Last name)</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td align="right">User Name</td>
		<td><%=data[3]%></td>
	</tr>
	<tr>
		<td align="right">Password</td>
		<td><a href="javascript:navtopassw()">Change Password</a></td>
	</tr>	
	<tr>
		<td align="right">Email-Id</td>
		<td><input name="email" type="text"	onkeyup="javascript:checkemail()" value="<%=data[4]%>"/>
		<label id="m_email"></label></td>
	</tr>
	<tr>
		<td align="right">Phone No.</td>
		<td><input name="phno" type="text" value="<%=data[5]%>"
			onkeyup="javascript:checkphno()"/><label id="m_phno"></label></td>
	</tr>
	<tr>
		<td align="right">Address</td>
		<td><textarea name="address"><%=data[6]%></textarea></td>
	</tr>
	<tr>
		<td align="right">City <input name="hcity" type="hidden" value="<%=data[7]%>"></td>
		<td id="citycombo"></td>
	</tr>
	<tr>
		<td align="right">Credit Card No.</td>
		<td><input name="crno" type="text" value="<%=crid%>"
			onkeyup="javascript:checkcrno()" /><label id="m_crno"></label></td>
	</tr>
</table>
<table>
	<tr align="center">
		<td width="105"><a href="javascript:saveProfile()" class="navigation"> Save </a></td>
		<td width="169"><a href="javascript:navtohome()" class="navigation">Cancel</a></td>
	</tr>
</table>
</form>
<%}else{%>
	<div style="color:red;"><h2>You are not logged in Now</h2></div>
<%}%>