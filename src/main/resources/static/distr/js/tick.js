let setTime = () => {
    $.get("time", time => $("#timer").html(time));
}

$(document).ready(() => {
    setTime();
    setInterval(() => setTime(), 60000);
});

