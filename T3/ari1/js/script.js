function preguntarMes() {
	calcularMes(prompt("Introduce el número del mes:"));
}
function calcularMes(mes) {
	var num = parseInt(mes) - 1;
	var arrayMes = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
	alert(arrayMes[num]);
}
