<%@include file="connect.jsp"%><% 
String uid= (String)session.getAttribute("uid");
String query[]=request.getParameterValues("query");
if(uid!=null&&uid.equals("1")){
	if(query!=null){
		try {
			for (int i=0; i<query.length; i++)			st.executeUpdate(query[i]);
			out.println("Your request has been processed successfully");
		}
		catch (Exception e) {
			System.out.println(e); 
			out.println("Update could not be completed successfully.\nThere may be oner or more problems.");
			out.println("(1)Use of ' (Apostrophe) in data.");
			out.println("(2)Data type mismatch.e.g typing characters in numeric data");
			out.println("(3)Data may be out of the range.");
			out.println("Consider reloading the current page to see the partial updates (if any)");
		}
	}else{
		out.println("You must supply some query.\nEmpty request cannot be processed");
	}
}else{
	out.println("You should be logged in as Administrator to call this function.\nYour request cannot be permitted");
}
conn.close();
%>
