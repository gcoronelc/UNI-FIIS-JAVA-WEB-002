
$(function () {
   
   $("#btnEjemplo1").click(fnBtnEjemplo1);
   $("#btnEjemplo2").click(fnBtnEjemplo2);

});


function fnBtnEjemplo1(){
	$("#divWork").load("ejemplo1.html");
}
function fnBtnEjemplo2(){
	$("#divWork").load("ejemplo2.html");
}