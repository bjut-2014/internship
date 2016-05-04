/**
 * 
 */
/**
 * 
 */

$(function () {
    var $graduationWeeklyPlanDel = $('.graduation-weekly-plan-del'),
        $graduationWeeklyPlanDelConfirm = $('.graduation-weekly-plan-del-confirm');
        
        $graduationWeeklyPlanDel.on('click', function() {
        var id = $(this).attr('data-id');

        $('#GraduationWeeklyPlanDel').attr('data-id', id);
    });
    $graduationWeeklyPlanDelConfirm.on('click', function() {
        var id = $('#GraduationWeeklyPlanDel').attr('data-id');
//        alert(id);
        $.ajax({
            url: 'graduate-weekly-report-delete',
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
