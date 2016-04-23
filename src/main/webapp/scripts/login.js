/**
 * Created by surprise on 4/23/16.
 */
$(function () {
    // checkbox
    $('.login-checkbox').on('click', function () {
        if ($(this).hasClass('checked')) {
            $(this).removeClass('checked').addClass('unchecked');
        } else {
            $(this).removeClass('unchecked').addClass('checked');
        }
    });

    // 验证码
    $('.code-link').on('click', function () {
        $(this).find('img').attr('src', 'verifyCodeAction?' + Math.random());
    });
});
