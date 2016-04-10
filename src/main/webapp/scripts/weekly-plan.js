/**
 * Created by surprise on 4/9/16.
 */
var $weeklyPlanDel = $('.weekly-plan-del'),
    $weeklyPlanDelConfirm = $('.weekly-plan-del-confirm'),
    $weeklyPlanEdit = $('.weekly-plan-edit');

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
            $('.plan-id').val(data[0].id);
            $('.plan-title').val(data[0].weeklyplanTitle);
            $('.plan-content').val(data[0].weeklyplanContent);
            $('.plan-date').val(data[0].weeklyplanDate);
        }
    })
});