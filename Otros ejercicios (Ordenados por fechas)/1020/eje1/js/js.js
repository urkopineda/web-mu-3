function calcular_numero_dni() {
	alert("Tu DNI es el "+document.getElementById("dni").value);
}
function calcular_numero_dni1() {
	alert("Tu DNI es el "+document.getElementById("dni1").value);
}
function calcular_numero_dni2(dni) {
	alert("Tu DNI es el "+dni.value);
}
function pass() {
	document.getElementById("text2").value = document.getElementById("text1").value;
	document.getElementById("text1").value = "";
}
function invertedPass() {
	document.getElementById("text1").value = document.getElementById("text2").value;
	document.getElementById("text2").value = "";
}
function pass1() {
	document.getElementById("text4").value = document.getElementById("text3").value;
	document.getElementById("text3").value = "";
	check(9);
}
function invertedPass1() {
	document.getElementById("text3").value = document.getElementById("text4").value;
	document.getElementById("text4").value = "";
	check(9);
}
function check(min) {
	if (document.getElementById("text3").value == "") {
		if (document.getElementById("text4").value.length > min) {
			document.getElementById("text4").style.backgroundColor = "#FF0000";
			document.getElementById("text3").style.backgroundColor = "#FFFFFF";
		} else {
			document.getElementById("text4").style.backgroundColor = "#FFFFFF";
		}
	} else if (document.getElementById("text4").value == "") {
		if (document.getElementById("text3").value.length > min) {
			document.getElementById("text3").style.backgroundColor = "#FF0000";
			document.getElementById("text4").style.backgroundColor = "#FFFFFF";
		} else {
			document.getElementById("text3").style.backgroundColor = "#FFFFFF";
		}
	} else {
		document.getElementById("text3").style.backgroundColor = "#FFFFFF";
		document.getElementById("text4").style.backgroundColor = "#FFFFFF";
	}
}
function checkEmail(emailO, i) {
	var email = emailO.value;
	var condition1 = "@";
	var condition21 = "com";
	var condition22 = "es";
	var condition23 = "org";
	var condition3 = ".";
	var result = 0;
	if (email.indexOf(condition1) == -1) {
		result = 0;
		alert("ERROR, email inválido (No contiene @)");
	} else if (email.indexOf(condition3) == -1) {
		result = 0;
		alert("ERROR, email inválido (No contiene .)");
	} else if ((email.indexOf(condition21) == -1) && (email.indexOf(condition22) == -1) && (email.indexOf(condition23) == -1)) {
		result = 0;
		alert("ERROR, email inválido (No contiene un dominio válido (.COM / .ES / .ORG)");
	} else {
		result = 1;
	}
	if (result == 0) {
		if (i == 0) document.getElementById("email").style.borderColor = "#FF0000";
		else if (i == 1) document.getElementById("email1").style.borderColor = "#FF0000";
		else if (i == 2) document.getElementById("email2").style.borderColor = "#FF0000";
	} else {
		alert("¡Email válido!");
		if (i == 0) document.getElementById("email").style.borderColor = "#FFFFFF";
		else if (i == 1) document.getElementById("email1").style.borderColor = "#FFFFFF";
		else if (i == 2) document.getElementById("email2").style.borderColor = "#FFFFFF";
	} 
}
