const initMonitoring = () => {
    setInterval(() => {
        $.get("/draw-alerts", data => {
            let alertTable = $(".alert-table");
            alertTable.html('');
            JSON.parse(data).forEach(alert => {
                let alertRowTable = $('.alert-row-table');
                const alertRow = `
                <div style="padding: 5px;background-color: ${(alertRowTable.length + 1) % 2 === 0 ? '#e5e5e5' : '#f2f2f2'}">
                    <table class="alert-row-table">
                        <tbody>
                        <tr>
                            <td rowspan="3" class="alert-number-cell">${alertRowTable.length + 1}</td>
                            <td colspan="2" class="alert-time-cell">Время вызова: ${alert.date}</td>
                            <td class="alert-patient-cell"><i class="fa fa-user"></i> ${alert.patient ? alert.patient.fio : 'не указан'}</td>
                        </tr>
                        <tr>
                            <td class="alert-zone-cell">${alert.zone ? alert.zone : 'Палата не указана'}</td>
                            <td class="alert-bed-cell">${alert.bed ? 'Койка №' + alert.bed : 'Койка не указана'}</td>
                            <td class="alert-close-cell" rowspan="2">
                                <button class="btn btn-success alert-close-btn" onclick="closeAlert('${alert.id}')">Завершить вызов</button>
                            </td>
                        </tr>
                        <tr>
                            <td class="alert-department-cell" colspan="2">${alert.department ? 'Отделение: ' + alert.department.name : 'Отделение не указано'}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
		        `;
                alertTable.append(alertRow);
            });
        });
    }, 1000);
}

const closeAlert = (id) => $.get("close-alert?id=" + id);
