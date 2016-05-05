 $(function () {
    $(".uploadfile").change(function () {
        var $this = $(this);
        var homeworkFile = this.files[0];
        var form = new FormData();
        form.append('courseId', $this.siblings("input[name='courseId']").val());
        form.append('upload', homeworkFile);
        form.append('uploadFileName', homeworkFile.name);
        $.ajax({
            dataType: 'JSON',
            url: 'uploadHomework',
            type: 'POST',
            data: form,
            processData: false,
            contentType: false,
            success: function (data) {
                window.location.reload();
            }
        });
    });
 });
