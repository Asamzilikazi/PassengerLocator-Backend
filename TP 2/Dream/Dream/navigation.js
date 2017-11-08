var xmlHttp=getXmlHttpObject();
var currentLocation;
var callcount=0;

function navtologin(){
	showdata("login.html","databar");
	document.title="Login -"+title;
}
function navtoregister(){
	showdata("register.html","databar");
	showmessage("cities.jsp","citycombo");
}
function navtohome(){
	showdata("flash.html","databar");
}
function navtoschedule(){
	showdata("schedule.html","databar");
	initschedule();
}
function navtobookticket(){
	showdata("bookticket.html","databar");
	initschedule();
}
function navtoaboutus(){
	showdata("aboutus.html","databar");
}
function navtocontactus(){
	showdata("contactus.html","databar");
}
function navtodisclaimer(){
	showdata("disclaimer.html","databar");
}
function navtoprivacy(){
	showdata("privacypolicy.html","databar");
}
function navtopassw(){
	showdata("password.html","databar");
}
function navtomovies(){
	document.getElementById("databar").innerHTML="<table><tr><td>Movie</td><td id='Film'></td></tr><tr><td id='Filmdesc' colspan='2'></td></tr></table>";
	showmessage("movies.jsp","Film");
}
function handleNavigation(){
	var page=location.hash;
	callcount++;
	if(page!=currentLocation){	
		switch (page) {
		case "":
		case "#":
			navtohome();
			break;
		case "#login":
			navtologin();
			break;
		case "#register":	
			navtoregister();
			break;
		case "#schedule":
			navtoschedule();
			break;
		case "#ticket":
			navtobookticket();
			break;	
		case "#aboutus":	
			navtoaboutus();
			break;
		case "#contactus":	
			navtocontactus();
			break;
		case "#disclaimer":	
			navtodisclaimer();
			break;
		case "#privacy":	
			navtoprivacy();
			break;		
		case "#movies":	
			navtomovies();
			break;
		}
		currentLocation=page;
	}		
}	