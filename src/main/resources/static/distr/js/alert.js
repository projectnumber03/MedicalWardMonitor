let setStatus = () => {
    $.get("draw-alerts", alerts => {
        if (!JSON.parse(alerts).length) {
            resetStatus();
            return;
        }
        JSON.parse(alerts).forEach(alert => {
            $('#dot_' + alert.patient.id).removeClass("green").addClass("red").addClass("blink");
            let row = $('#row_' + alert.patient.id);
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