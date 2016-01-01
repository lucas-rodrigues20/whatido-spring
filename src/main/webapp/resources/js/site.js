$(document).ready(function(){
	$(".checkFinalizar").change(function(){
		$(this).closest('form').submit();
	});
});