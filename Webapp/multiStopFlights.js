function addStop() {
    // Increments the stopCount to keep track of the number of stops
    stopCount++;

    const stopsDiv = document.getElementById('stops');

    const newStopDiv = document.createElement('div');
    newStopDiv.classList.add('stop');

    newStopDiv.innerHTML = `
        <label for="departure${stopCount}">Departure Airport:</label>
        <input type="text" id="departure${stopCount}" name="departure${stopCount}">
        <label for="destination${stopCount}">Destination Airport:</label>
        <input type="text" id="destination${stopCount}" name="destination${stopCount}">
        <label for="date${stopCount}">Date:</label>
        <input type="date" id="date${stopCount}" name="date${stopCount}">
    `;

    stopsDiv.appendChild(newStopDiv);
}

document.addEventListener("DOMContentLoaded", function() {
    const addButton = document.querySelector("#addStopButton");
    addButton.addEventListener("click", addStop);
});

function addStop() {
    
}
