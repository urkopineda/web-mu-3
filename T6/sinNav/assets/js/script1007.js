var valores = [true, 5, false, "hola", "adios", 2];
function preguntarMes() {
	calcularMes(prompt("Introduce el número del mes:"));
}
function calcularMes(mes) {
	if (mes.length < 2) {
		alert("Debes introducir 2 cifras.");
		preguntarMes();
	} else {
		var num = parseInt(mes) - 1;
		if ((num < 0) || (num > 11)) {
			alert("El número introducido no es válido.");
			preguntarMes();
		} else {
			var arrayMes = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
			alert(arrayMes[num]);
		}
	}
}
function valoresMostrar() {
	alert(valores[3]);
	if (valores[1] > valores[5]) {
		alert(valores[1]+" es más grande que "+valores[5]);
	} else {
		alert(valores[5]+" es más grande que "+valores[1]);
	}
	alert(valores[0]+" AND "+valores[2]+": "+bool(valores[0], valores[2], "AND"));
	alert(valores[0]+" OR "+valores[2]+": "+bool(valores[0], valores[2], "OR"));
	alert("Suma de "+valores[1]+" y "+valores[5]+" es "+suma(valores[1], valores[5]));
	alert("Resta de "+valores[1]+" y "+valores[5]+" es "+resta(valores[1], valores[5]));
	alert("División de "+valores[1]+" y "+valores[5]+" es "+div(valores[1], valores[5]));
	alert("Multiplicación de "+valores[1]+" y "+valores[5]+" es "+multi(valores[1], valores[5]));
	alert(valores[4]);
}
function bool(bool1, bool2, op) {
	if (op == "AND") return bool1 && bool2;
	else if (op == "OR") return bool1 || bool2;
}
function suma(param1, param2) {
	var c = param1 + param2;
	return c;
}
function resta(param1, param2) {
	var c;
	if (param1 < param2) {
		c = param2 - param1;
	} else {
		c = param1 - param2;
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

