document.addEventListener('DOMContentLoaded', function () {
    const currentDate = new Date();
    let startDate = null;
    let endDate = null;

    function updateCalendar() {
        const currentMonthYearElement = document.getElementById('current-month-year');
        currentMonthYearElement.textContent = formatDate(currentDate, 'MMMM YYYY');

        const daysContainer = document.getElementById('days');
        daysContainer.innerHTML = '';

        const firstDayOfMonth = new Date(currentDate.getFullYear(), currentDate.getMonth(), 1);
        const lastDayOfMonth = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0);
        const firstDayOfWeek = firstDayOfMonth.getDay();
        const lastDateOfMonth = lastDayOfMonth.getDate();

        for (let i = firstDayOfWeek - 1; i >= 0; i--) {
            const dayCell = createDayCell(new Date(currentDate.getFullYear(), currentDate.getMonth(), -i));
            dayCell.classList.add('prev-month', 'outside-month');
            daysContainer.appendChild(dayCell);
        }

        for (let i = 1; i <= lastDateOfMonth; i++) {
            const dayCell = createDayCell(new Date(currentDate.getFullYear(), currentDate.getMonth(), i));
            daysContainer.appendChild(dayCell);
            const today = new Date();
            if (currentDate.getFullYear() === today.getFullYear() &&
                currentDate.getMonth() === today.getMonth() &&
                i === today.getDate()) {
                dayCell.classList.add('today');
            }
        }

        const lastDayOfWeek = lastDayOfMonth.getDay();
        for (let i = 1; i < 7 - lastDayOfWeek; i++) {
            const dayCell = createDayCell(new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, i));
            dayCell.classList.add('next-month', 'outside-month');
            daysContainer.appendChild(dayCell);
        }

        const totalDays = daysContainer.children.length;
        const rowsNeeded = 6;
        const additionalCellsNeeded = rowsNeeded * 7 - totalDays;

        for (let i = 0; i < additionalCellsNeeded; i++) {
            const emptyCell = document.createElement('div');
            emptyCell.classList.add('day', 'empty');
            daysContainer.appendChild(emptyCell);
        }

        updateSelectedDates();
    }

    function createDayCell(date) {
        const dayCell = document.createElement('div');
        dayCell.classList.add('day');
        dayCell.textContent = date.getUTCDate();
        dayCell.setAttribute('data-date', formatDate(date, 'YYYY-MM-DD'));

        const today = new Date();
        today.setHours(0, 0, 0, 0);
        if (date < today) {
            dayCell.classList.add('past-day');
        } else {
            dayCell.addEventListener('click', selectDate);
            dayCell.addEventListener('mouseover', highlightRange);
        }

        return dayCell;
    }

    function selectDate(event) {
        const selectedDate = event.target.getAttribute('data-date');
        const selectedDay = new Date(selectedDate + 'T00:00');
        const today = new Date();
        today.setHours(0, 0, 0, 0);
        if (selectedDay < today) {
            return;
        }

        if (!startDate || (startDate && endDate)) {
            startDate = selectedDay;
            endDate = null;
        } else if (selectedDay > startDate) {
            endDate = selectedDay;
        } else {
            endDate = startDate;
            startDate = selectedDay;
        }

        updateSelectedDates();
    }

    function highlightRange(event) {
        const target = event.target;
        const selectedDate = target.getAttribute('data-date');

        if (selectedDate && startDate && !endDate) {
            const currentDate = new Date(selectedDate);
            const highlightedCells = document.querySelectorAll('.day');

            highlightedCells.forEach(cell => {
                const cellDate = new Date(cell.getAttribute('data-date'));
                if (cellDate > startDate && cellDate <= currentDate) {
                    cell.classList.add('range-highlight');
                } else {
                    cell.classList.remove('range-highlight');
                }
            });
        }
    }

    function updateSelectedDates() {
        const dayCells = document.querySelectorAll('.day');

        dayCells.forEach(dayCell => {
            const dayCellDate = new Date(dayCell.getAttribute('data-date') + 'T00:00');
            if ((startDate && +dayCellDate === +startDate) || (endDate && +dayCellDate === +endDate) || (startDate && endDate && dayCellDate > startDate && dayCellDate < endDate)) {
                dayCell.classList.add('selected');
            } else {
                dayCell.classList.remove('selected');
            }
        });

        const startDateInput = document.querySelector('#start-date');
        const endDateInput = document.querySelector('#end-date');

        if (startDate) {
            startDateInput.value = formatDate(startDate, 'YYYY-MM-DD');
        }

        if (endDate) {
            endDateInput.value = formatDate(endDate, 'YYYY-MM-DD');
        }
    }

    function formatDate(date, format) {
        let day = date.getUTCDate();
        let month = date.getUTCMonth() + 1;
        let year = date.getUTCFullYear();

        if (day < 10) day = '0' + day;
        if (month < 10) month = '0' + month;

        if (format === 'YYYY-MM-DD') {
            return `${year}-${month}-${day}`;
        }

        return `${day}/${month}/${year}`;

    }
    // Función para reservar
    document.getElementById('reserve-button').addEventListener('click', function () {
        const startDateInput = document.getElementById('start-date');
        const endDateInput = document.getElementById('end-date');
        const startDateValue = startDateInput.value;
        const endDateValue = endDateInput.value;

        if (!startDateValue || !endDateValue) {
            alert("Por favor, selecciona una fecha de entrada y una fecha de salida.");
            return;
        }
        const fechaInicio = encodeURIComponent(startDateValue);
        const fechaFin = encodeURIComponent(endDateValue);
        const url = `/reservas/disponibles?fecha_inicio=${fechaInicio}&fecha_fin=${fechaFin}`;
        // Simplemente muestra los valores de inicio y fin en la consola para demostrar que la función se activa correctamente.
        console.log("Fecha de entrada:", startDateValue);
        console.log("Fecha de salida:", endDateValue);
        window.location.href = url;

    });

    // Función para limpiar
    document.getElementById('clear-button').addEventListener('click', function () {
        startDate = null;
        endDate = null;
        document.getElementById('start-date').value = '';
        document.getElementById('end-date').value = '';
        updateSelectedDates();
    });

    // Initialize the calendar
    updateCalendar();
});
