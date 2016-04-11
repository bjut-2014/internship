/**
 * Created by surprise on 4/11/16.
 */
var $practicalReportsDel = $('.practical-reports-del'),
    $practicalReportsDelConfirm = $('.practical-reports-del-confirm'),
    $practicalReportsEdit = $('.practical-reports-edit'),
    $practicalReportsEditConfirm = $('.practical-reports-edit-confirm');

$practicalReportsDel.on('click', function() {
    var id = $(this).attr('data-id');

    $('#PracticalReportsDel').attr('data-id', id);
});
$practicalReportsDelConfirm.on('click', function() {
    var id = $('#PracticalReportsDel').attr('data-id');

    $.ajax({
        url: 'practical-reports-delete',
        type: 'POST',
        data: {
            deleteId: id
        },
        success: function(data) {
            window.location.reload();
        }
    })
});
$practicalReportsEdit.on('click', function() {
    var id = $(this).attr('data-id');

    $.ajax({
        url: 'practical-reports-edit',
        type: 'POST',
        dataType: "JSON",
        data: {
            practicalReportId: id
        },
        success: function(data) {
            $('.reports-id').attr("value", data.id);
            $('.reports-title').attr("value", data.practicalReportsTitle);
            $('.reports-content').attr("value", data.practicalReportsContent).text(data.practicalReportsContent);
            $('.reports-date').attr("value", data.practicalReportsDate);
        }
    })
});
$practicalReportsEditConfirm.on('click', function () {
    $.ajax({
        url: 'practical-reports-update',
        type: 'POST',
        dataType: 'JSON',
        data: {
            updateId: $('.reports-id').val(),
            updateTitle: $('.reports-title').val(),
            updateContent: $('.reports-content').text()
        },
        success: function (data) {
            window.location.reload();
        }
    });
});