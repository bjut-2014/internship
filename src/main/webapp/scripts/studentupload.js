$(function () {
	$('input[type="file"]').ajaxfileupload({
	      'action': 'uploadHomework',
	      'params': {
	        'extra': 'info'
	      },
	      'onComplete': function(response) {
	        console.log('custom handler for file:');
	        alert(JSON.stringify(response));
	      },
	      'onStart': function() {
	        if(weWantedTo) return false; // cancels upload
	      },
	      'onCancel': function() {
	        console.log('no file selected');
	      }
	    });

});
