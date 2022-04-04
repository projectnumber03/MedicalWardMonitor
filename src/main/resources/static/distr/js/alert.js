let setStatus = () => {
    $.get("draw-alerts", alerts => {
        if (!JSON.parse(alerts).length) {
            resetStatus();
            return;
        }
        JSON.parse(alerts).forEach(alert => {
            let row = $('#row_' + alert.patient.id);
            let dot = $('#dot_' + alert.patient.id);
            if (!alert.id) {
                row.off();
                $(dot).removeClass("red").removeClass("blink").addClass("green");
                return;
            }
            dot.removeClass("green").addClass("red").addClass("blink");
            row.off();
            row.mousedown(() => row.css('background', '#868686'));
            row.mouseup(() => {
                $.get("close-alert?id=" + alert.id);
                $('#dot_' + alert.patient.id).removeClass("red").removeClass("blink").addClass("green");
                row.css('background', '#373737');
            });
        })
    });
}

let resetStatus = () => {
    $('.patientRow').each((i, row) => {
        $(row).off();
    })
    $('.dot').each((i, dot) => {
        $(dot).removeClass("red").removeClass("blink").addClass("green");
    })
}

$(document).ready(() => {
    setStatus();
    setInterval(() => setStatus(), 10000);
});