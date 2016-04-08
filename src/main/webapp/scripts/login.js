var $captcha = $('.captcha'),
    $captchaLink = $('.captcha-link'),
    $captchaImg = $('.captcha-img');

$captchaLink.on('click', function () {
    $captchaImg.attr('src', 'createImageAction.action?' + Math.random());
});