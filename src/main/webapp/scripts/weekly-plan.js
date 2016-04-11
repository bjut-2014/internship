/**
 * Created by surprise on 4/9/16.
 */
var $weeklyPlanDel = $('.weekly-plan-del'),
    $weeklyPlanDelConfirm = $('.weekly-plan-del-confirm'),
    $weeklyPlanEdit = $('.weekly-plan-edit'),
    $weeklyPlanEditConfirm = $('.weekly-plan-edit-confirm');

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
    
    $.ajax({
        url: 'weekly-plan-edit',
        type: 'POST',
        dataType: "JSON",
        data: {
            weeklyPlanId: id
        },
        success: function(data) {
            $('.plan-id').attr("value", data.id);
            $('.plan-title').attr("value", data.weeklyplanTitle);
            $('.plan-content').attr("value", data.weeklyplanContent).text(data.weeklyplanContent);
            $('.plan-date').attr("value", data.weeklyplanDate);
        }
    })
});
$weeklyPlanEditConfirm.on('click', function () {
    $.ajax({
        url: 'weekly-plan-update',
        type: 'POST',
        dataType: 'JSON',
        data: {
            updateId: $('.plan-id').val(),
            updateTitle: $('.plan-title').val(),
            updateContent: $('.plan-content').text()
        },
        success: function (data) {
//            window.location.reload();
        	location.replace(location.href = 'weekly-plan'); 
        }
    });
});
