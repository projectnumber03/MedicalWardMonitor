let setStatus = () => {
    $.get("draw-alerts", alerts => {
        JSON.parse(alerts).forEach(alert => {
            let row = $('#row_' + alert.patient.id);
            let dot = $('#dot_' + alert.patient.id);
            row.off();
            if (!alert.id) {
                $(dot).removeClass("red").removeClass("blink").addClass("green");
                return;
            }
            dot.removeClass("green").addClass("red").addClass("blink");
            row.mousedown(() => row.css('background', '#868686'));
            row.mouseup(() => {
                $.get("close-alert?id=" + alert.id);
                $('#dot_' + alert.patient.id).removeClass("red").removeClass("blink").addClass("green");
                row.css('background', '#373737');
            });
        })
    });
}

$(document).ready(() => {
    setStatus();
    setInterval(() => setStatus(), 2000);
});