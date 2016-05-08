/**
 * 
 */

$(function () {
    var $internshipDetailDel = $('.internship-detail-del'),
        $internshipDetailDelConfirm = $('.internship-detail-del-confirm');
        
        $internshipDetailDel.on('click', function() {
        var id = $(this).attr('data-id');

        $('#InternshipDetailDel').attr('data-id', id);
    });
    $internshipDetailDelConfirm.on('click', function() {
        var id = $('#InternshipDetailDel').attr('data-id');
//        alert(id);
        $.ajax({
            url: 'internship-detail-delete',
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
