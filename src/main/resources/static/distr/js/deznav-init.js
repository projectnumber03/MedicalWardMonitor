(function ($) {

    var direction = getUrlParams('dir');
    if (direction != 'rtl') {
        direction = 'ltr';
    }

    var dezSettingsOptions = {
        typography: "poppins",
        version: "light",
        layout: "Vertical",
        headerBg: "color_1",
        navheaderBg: "color_1",
        sidebarBg: "color_1",
        sidebarStyle: "full",
        sidebarPosition: "fixed",
        headerPosition: "fixed",
        containerLayout: "full",
        direction: direction
    };

    new dezSettings(dezSettingsOptions);

    jQuery(window).on('resize', function () {
        new dezSettings(dezSettingsOptions);
    });

    $("#login_form").submit(function (event) {
        if ($("#val-password").val() === "test01" & $("#val-username").val() === "test01") {
            $("#wrong-login-or-pass-alert").hide();
            $("#good-login-or-pass-alert").hide().fadeIn().removeClass('d-none');
            setTimeout(function () {
                window.open('index.html');
                window.close();
            }, 2000);
        } else {
            $("#wrong-login-or-pass-alert").hide().fadeIn().removeClass('d-none');
        }
        event.preventDefault();
    });

    setInterval(function () {
        $(".timeline").append("<li>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"timeline-panel\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"media mr-2 media-danger\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\tER\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"media-body\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h6 class=\"mb-1\">Сервер БД недоступен!</h6>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small class=\"d-block\">" + moment().format('HH:mm:ss DD-MM-YYYY') + "</small>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t</li>");

        $(".timeline").append("<li>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"timeline-panel\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"media mr-2 media-danger\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\tER\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"media-body\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h6 class=\"mb-1\">Головное устройство недоступно!</h6>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small class=\"d-block\">" + moment().format('HH:mm:ss DD-MM-YYYY') + "</small>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t</li>");

        $(".timeline").append("<li>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"timeline-panel\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"media mr-2 media-danger\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\tER\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"media-body\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h6 class=\"mb-1\">Главный сетевой ретранслятор недоступен!</h6>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<small class=\"d-block\">" + moment().format('HH:mm:ss DD-MM-YYYY') + "</small>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t</li>");
    }, 2000);


})(jQuery);