$(document).ready(function() {
	$( ".login-icon" ).bind( "click", showLoginDialog);

	$( ".loginForm" ).bind("submit", function( event ) {

		// Stop form from submitting normally
		event.preventDefault();
		// Get some values from elements on the page:
		var $form = $( this );

		// Send the data using post
		var url = "rest/users/login";
		var posting = $.post( url, $(".loginForm").serialize());

		// Put the results in a div
		posting.done(function( data ) {
			alert("done");
		});
	});


});

function showLoginDialog() {
	$( "#logindialog" ).dialog({"resize" : "auto"});
}


