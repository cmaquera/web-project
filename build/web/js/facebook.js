$(function() {

	var app_id = '482297845294285';
	var scopes = 'email, user_friends, user_online_presence';

	var btn_login = '<button id="login" type="button" class="btn btn-social btn-facebook"><i class="fa fa-facebook" style="padding-top: 9px;"></i>Facebook</button>';

/*
	var div_session = "<div id='facebook-session'>"+
					  "<strong></strong>"+
					  "<img>"+
					  "<a href='#' id='logout' class='btn btn-danger'>Cerrar sesión</a>"+
					  "</div>"; */ 

	window.fbAsyncInit = function() {

	  	FB.init({
	    	appId      : app_id,
	    	status     : true,
	    	cookie     : true, 
	    	xfbml      : true, 
	    	version    : 'v2.6'
	  	});


	  	FB.getLoginStatus(function(response) {
	    	statusChangeCallback(response, function() {});
	  	});
  	};

  	var statusChangeCallback = function(response, callback) {
  		console.log(response);
   		
    	if (response.status === 'connected') {
      		getFacebookData();
    	} else {
     		callback(false);
    	}
  	}

  	var checkLoginState = function(callback) {
    	FB.getLoginStatus(function(response) {
      		callback(response);
    	});
  	}
    
    /*mostrar informacion del perfil*/
  	var getFacebookData =  function() {
  		FB.api('/me', function(response) {
  			console.log("modifico el html");
	  		$('#login').after(btn_login);
	  		$('#login').remove();
	  		$('#iemail').val(response.name);
	  		console.log("termino de moficar");
	  		//$('#facebook-session img').attr('src','http://graph.facebook.com/'+response.id+'/picture?type=large');
	  	});
  	}

  	var facebookLogin = function() {
  		checkLoginState(function(data) {
  			if (data.status !== 'connected') {
  				FB.login(function(response) {
  					if (response.status === 'connected')
  						getFacebookData();
  				}, {scopes: scopes});
  			}
  		})
  	}

  	var facebookLogout = function() {
  		checkLoginState(function(data) {
  			if (data.status === 'connected') {
				FB.logout(function(response) {
				    /*volver al botton inicial de facebook login*/
				    console.log("salgo del facebook");
					$('#loginForm').before(btn_login);
					$('#email').text('Se perdio :(');
					//$('#email').remove();
				})
			}
  		})

  	}


		
  	$(document).on('click', '#login', function(e) {
  		console.log("has hecho clik en facebook");
  		e.preventDefault();

  		facebookLogin();
  	})

  	$(document).on('click', '#logout', function(e) {
  		e.preventDefault();

  		if (confirm("¿Está seguro?"))
  			facebookLogout();
  		else 
  			return false;
  	})

})