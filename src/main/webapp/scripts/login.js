/**
 * Created by surprise on 4/23/16.
 */
$(function () {
    // checkbox
    $('.login-checkbox').on('click', function () {
        if ($(this).hasClass('checkbox-checked')) {
            $(this).removeClass('checkbox-checked').addClass('checkbox-unchecked');
        } else {
            $(this).removeClass('checkbox-unchecked').addClass('checkbox-checked');
        }
    });

    // radio
    $('.login-radio').on('click', function () {
        if ($(this).hasClass('radio-unchecked')) {
            $(this).addClass('radio-checked').removeClass('radio-unchecked');
            $(this).siblings().removeClass('radio-checked').addClass('radio-unchecked');
        }
    });

    // 验证码
    $('.code-link').on('click', function () {
        $(this).find('img').attr('src', 'verifyCodeAction?' + Math.random());
    });
});
