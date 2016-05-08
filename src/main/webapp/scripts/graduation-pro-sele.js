/**
 * 
 */

$(function () {
    var $graduationProSeleDel = $('.graduation-pro-sele-del'),
        $graduationProSeleDelConfirm = $('.graduation-pro-sele-del-confirm');
        
        $graduationProSeleDel.on('click', function() {
        var id = $(this).attr('data-id');

        $('#GraduationProSeleDel').attr('data-id', id);
    });
    $graduationProSeleDelConfirm.on('click', function() {
        var id = $('#GraduationProSeleDel').attr('data-id');
        $.ajax({
            url: 'graduation-pro-sele-delete',
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
