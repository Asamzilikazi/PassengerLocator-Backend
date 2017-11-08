<%
String location=request.getParameter("loc");
if(location!=null){
	String message =(String)session.getAttribute("message"+location);
	if(message!=null){out.println(message);System.out.println(message);}
	else{
		if(location.equals("center")){
			session.setAttribute("messagecenter","You are not logged in now");
			out.println("You are not logged in now");
		}else if(location.equals("right")){
			session.setAttribute("messageright","<a href='#login' onclick='navtologin()'>Login</a> | <a href='#register'onclick='navtoregister()'>Register</a>");
			out.println("<a href='#login' onclick='navtologin()'>Login</a> | <a href='#register'onclick='navtoregister()'>Register</a>");
		}
	}
}%>
