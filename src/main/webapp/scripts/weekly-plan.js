/**
 * Created by surprise on 4/9/16.
 */
var $weeklyPlanDel = $('.weekly-plan-del'),
    $weeklyPlanDelConfirm = $('.weekly-plan-del-confirm'),
    $weeklyPlanEdit = $('.weekly-plan-edit'),
    $weeklyPlanEditConfirm = $('.weekly-plan-update-confirm');

$weeklyPlanDel.on('click', function() {
    var id = $(this).attr('data-id');

    $('#WeeklyPlanDel').attr('data-id', id);
});
$weeklyPlanDelConfirm.on('click', function() {
    var id = $('#WeeklyPlanDel').attr('data-id');

    $.ajax({
        url: 'weekly-plan-delete',
        type: 'POST',
        data: {
            deleteId: id
        },
        success: function(data) {
            window.location.reload();
        }
    })
});
$weeklyPlanEdit.on('click', function() {
    var id = $(this).attr('data-id');
    
    $('#WeeklyPlanModify').attr('data-id', id);
    
    $.ajax({
        url: 'weekly-plan-edit',
        type: 'POST',
        dataType: "JSON",
        data: {
            weeklyPlanId: id
        },
        success: function(data) {
            $('.plan-id').val(data.id);
            $('.plan-title').val(data.weeklyplanTitle);
            $('.plan-content').val(data.weeklyplanContent);
            $('.plan-date').val(data.weeklyplanDate);
        }
    })
});
$weeklyPlanEditConfirm.on('click',function(){
	var id = $('#WeeklyPlanModify').attr('data-id');
//	var title = $('#updateTitle')val();
//    var content = $('#updateContent')val();
    
	$.ajax({
        url: 'weekly-plan-update',
        type: 'POST',
        dataType: 'JSON',
        data: {
        	updateId: id,
        	updateTitle : $('.plan-title').val(),
        	updateContent : $('.plan-content').val()
        },
        success: function(data) {
//            window.location.reload();
        	url:weekly-plan
        }
    })
});