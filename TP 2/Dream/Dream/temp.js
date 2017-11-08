function Schedule(id,cinema,screenno,showdate,movie){
	this.id=id;this.cinema=cinema;this.screenno=screenno;this.showdate=showdate;this.movie=movie;
}
function editSchedule(sch){
	if(currentSchedule==null){
		var c=sch.childNodes;
		currentSchedule=new Schedule(c[1].innerHTML,c[3].innerHTML,c[5].innerHTML,c[7].innerHTML,c[9].innerHTML)
		c[3].innerHTML="<td id='Cinemas'></td>";
		c[5].innerHTML="<td id='Screens'></td>";
		c[7].innerHTML="<input type='text' value='"+c[7].innerHTML+"'/>";
		c[9].innerHTML="<td id='Movies'></td>";
		c[11].innerHTML="<a href='javascript:saveSchedule("+sch.id+")'>save</a> <a href='javascript:cancelSchedule("+sch.id+")'>cancel</a>";
		showmessage("scheduleadmin.jsp?showby=Cinema&showid=Screens","Cinema");
		if(currentSchedule.cinema=="") Cinemas.childNodes[1].value=0;

		for(i=0;i<Cinemas.childNodes[1].length;i++){
			if(currentSchedule.cinema==Cinemas.childNodes[1].options[i].text){
				Cities.childNodes[1].selectedIndex=i;
				break;
			}
		}
		showmessage("scheduleadmin.jsp?showby=Screen&showvalue=Cinemas.childNodes[1]","Screen");
		showmessage("scheduleadmin.jsp?showby=Movie","Movies");		
	}else
		alert("Another Schedule record is in edit mode.\n Please save or exit that record to continue.");
}
function cancelSchedule(sch){
	restoreSchedule(sch,currentSchedule);
	currentSchedule=null;
}
function restoreSchedule(sch,movObj){
		if(movObj!=null){
		var c=sch.childNodes;
		c[3].innerHTML=movObj.cinema;
		c[5].innerHTML=movObj.screenno;
		c[7].innerHTML=movObj.showdate;
		c[9].innerHTML=movObj.movie;
		c[15].innerHTML="<a href='javascript:editSchedule("+sch.id+")'>edit</a>";
	}
}
function insertSchedule(){
	c=document.getElementById("insert").childNodes;
	var query="insert into Schedule(screenid,showdate,filmid)values("+c[2].childNodes[1].value+",'"+c[3].childNodes[0].value+"',"+c[4].childNodes[1].value+")";	
	querytest=query;
/*	var location="transaction.jsp?query="+encodeURI(query);;
	xmlHttp.open("POST",location,false);
	xmlHttp.onreadystatechange=function(){
		if(xmlHttp.readyState==4){
			response=xmlHttp.responseText;					
			if(response.indexOf("not")==-1)
				viewSchedule();
			else
				alert(response);
		}
	}
	xmlHttp.send(null);	*/
}
function saveSchedule(sch){	
	query="update schedule set ";
	len=query.length;
	tempSchedule=new Schedule(currentSchedule.id,currentSchedule.cinema,currentSchedule.screenno,currentSchedule.showdate,currentSchedule.movie);
	try{
		var c=sch.childNodes;
		if(c[3].childNodes[0].childNodes[1].options[c[3].childNodes[0].childNodes[1].selectedIndex].text!=tempSchedule.cinema||c[5].childNodes[0].childNodes[1].options[c[5].childNodes[0].childNodes[1].selectedIndex].text!=tempSchedule.screenno){
			tempSchedule.cinema=c[3].childNodes[0].childNodes[1].options[c[3].childNodes[0].childNodes[1].selectedIndex].text;
			tempSchedule.screeno=c[5].childNodes[0].childNodes[1].options[c[5].childNodes[0].childNodes[1].selectedIndex].text;
			query+="screenid="+c[5].childNodes[0].childNodes[1].value+", ";
		}
		if(c[7].childNodes[0].value!=tempSchedule.showdate){
			tempSchedule.showdate=c[7].childNodes[0].value;
			query+=" showdate='"+tempSchedule.showdate+"', ";
		}
		if(c[9].childNodes[0].childNodes[1].options[c[9].childNodes[0].childNodes[1].selectedIndex].text!=tempSchedule.movie){
			tempSchedule.movie=c[9].childNodes[0].childNodes[1].options[c[9].childNodes[0].childNodes[1].selectedIndex].text;
			query+="filmid="+c[9].childNodes[0].childNodes[1].value+", ";
		}
		
		if(query.length>len){			// if modified
			query=query.substring(0,query.length-2); //remove extra comma
			query+=" where id="+tempSchedule.id;
		}else
			query="";		

		querytest=query;
		//--------------------------------------------Update Request-------------------------------------------------
/*		if(query.length==0)
			alert("You must make changes to update the record")
		else{
			var location="transaction.jsp?query="+encodeURI(query);			
			xmlHttp.open("POST",location,false);
			xmlHttp.onreadystatechange=function(){
				if(xmlHttp.readyState==4){
					response=xmlHttp.responseText;					
					if(response.indexOf("not")==-1){
						restoreSchedule(sch,tempSchedule);
						currentSchedule=null;
					}else
						alert(response);
				}
			}
			xmlHttp.send(null);
		}*/
	}catch(exception){alert("Update unsuccessful due to exception"+exception)}
}
