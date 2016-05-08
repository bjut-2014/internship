$(function () {
    var $studentDel = $('.student-del'),
        $studentDelConfirm = $('.student-del-confirm');
        
        $studentDel.on('click', function() {
        var id = $(this).attr('data-id');

        $('#StudentDel').attr('data-id', id);
    });
    $studentDelConfirm.on('click', function() {
        var id = $('#StudentDel').attr('data-id');
        $.ajax({
            url: 'student-delete',
            type: 'POST',
            
            data: {
            	deleteId: id
            },
            success: function(data) {
            	
                window.location.reload();
            },
            error:function(data){
            	
            }
        })
    });
    
});
