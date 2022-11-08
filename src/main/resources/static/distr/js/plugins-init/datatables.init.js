(function ($) {
    "use strict"
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        $.fn.dataTable.tables({visible: true, api: true})
            .columns.adjust()
            .responsive.recalc();
    });

    $('.devices-table').DataTable({
        responsive: true,
        "order": [[0, "desc"]],
        "scrollY": 800,
        "scrollCollapse": true,
        "paging": true,
        "bInfo": false,
        "language": {
            "emptyTable": "Отсутствуют данные"
        }
    });

    $('.events-table').DataTable({
        responsive: true,
        "order": [[0, "desc"]],
        "scrollY": 800,
        "scrollCollapse": true,
        "paging": true,
        "bInfo": false,
        "language": {
            "emptyTable": "Отсутствуют данные"
        },
        "columnDefs": [
            {
                "targets": [0],
                "visible": false,
                "searchable": false
            }
        ]
    });

    $('.devices-table').DataTable().search('').draw();

    var table2 = $('#example2').DataTable({
        createdRow: function (row, data, index) {
            $(row).addClass('selected')
        },

        "scrollY": "42vh",
        "scrollCollapse": true,
        "paging": false
    });

    table2.on('click', 'tbody tr', function () {
        var $row = table2.row(this).nodes().to$();
        var hasClass = $row.hasClass('selected');
        if (hasClass) {
            $row.removeClass('selected')
        } else {
            $row.addClass('selected')
        }
    })

    table2.rows().every(function () {
        this.nodes().to$().removeClass('selected')
    });

})(jQuery);