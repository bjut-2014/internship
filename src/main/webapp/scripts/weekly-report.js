/**
 * 
 */

$(function () {
    var $weeklyPlanDel = $('.weekly-plan-del'),
        $weeklyPlanDelConfirm = $('.weekly-plan-del-confirm');
        
        $weeklyPlanDel.on('click', function() {
        var id = $(this).attr('data-id');

        $('#WeeklyPlanDel').attr('data-id', id);
    });
    $weeklyPlanDelConfirm.on('click', function() {
        var id = $('#WeeklyPlanDel').attr('data-id');
//        alert(id);
        $.ajax({
            url: 'weekly-report-delete',
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
