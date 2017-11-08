<%@include file="connect.jsp"%>
<%
String fname=request.getParameter("fname");
String mname=request.getParameter("mname");
String lname=request.getParameter("lname");
String uname=request.getParameter("uname");
String passw=request.getParameter("passw");
String email=request.getParameter("email");
String phno=request.getParameter("phno");
String address=request.getParameter("address");
String city=request.getParameter("City");
String crno=request.getParameter("crno");
boolean valid=true;

st.executeUpdate("insert into credit(crno) values('"+crno+"')");
rs=st.executeQuery("select id from credit where crno='"+ crno +"'");
rs.next();
int crid=rs.getInt(1);
String sql="insert into Customer(fname,mname,lname,uname,passw,email,phno,address,cityid,crid) values(";
sql+="'"+fname+"','"+ mname+"','"+lname+"','"+uname+"','"+passw+"','"+email+"',"
		+phno+",'"+address+"',"+city+","+crid+")";
//out.println(sql);
try{
	st.executeUpdate(sql);%>
<h1>You Have registered successfully.Now you may login.</h1>
<%}
catch(Exception e){
	System.out.println(e);
}
conn.close();
%>
