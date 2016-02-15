function alertOp() {
	var i = document.getElementById("operacion").selectedIndex;
	var op1 = parseInt(document.getElementById("op1").value);
	var op2 = parseInt(document.getElementById("op2").value);
	if (i == 0) {
		alert(suma(op1, op2));
	} else if (i == 1) {
		alert(resta(op1, op2));
	} else if (i == 2) {
		alert(div(op1, op2));
	} else if (i == 3) {
		alert(multi(op1, op2));
	} else alert("ERROR: Operación no válida.")
}
function alertOpPrompt() {
	var i = document.getElementById("operacion").selectedIndex;
	var op1 = parseInt(prompt("Introduce el primer valor:"));
	var op2 = parseInt(prompt("Introduce el primer valor:"));
	if (i == 0) {
		alert(suma(op1, op2));
	} else if (i == 1) {
		alert(resta(op1, op2));
	} else if (i == 2) {
		alert(div(op1, op2));
	} else if (i == 3) {
		alert(multi(op1, op2));
	} else alert("ERROR: Operación no válida.")
}
function suma(param1, param2) {
	var c = param1 + param2;
	return c;
}
function resta(param1, param2) {
	var c;
	if (param1 < param2) {
		c = param1 - param2;
	} else {
		c = param2 - param1;
	}
	return c;
}
function div(param1, param2) {
	var c;
	if (param2 == 0) {
		c = "No se puede dividir entre 0";
	} else {
		c = param1 / param2;
	}
	return c;
}
function multi(param1, param2) {
	var c = param1 * param2;
	return c;
}
