$(document).ready(function(){
	$(".checkFinalizar").change(function(){
		$(this).closest('form').submit();
	});
	
	window.setTimeout(function() {
		$(".alert-dismissible").alert('close');
	}, 4000);
});