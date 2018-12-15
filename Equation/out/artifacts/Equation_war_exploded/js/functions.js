function removeRow(event) {
    event.target.closest('tr').remove();
}

function sendTo(event) {
    event.preventDefault();
    let A = document.getElementById('coefA').value;
    let B = document.getElementById('coefB').value;
    let C = document.getElementById('coefC').value;
    let messageTo = {a:A, b:B, c:C};

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
            addRow(this.responseText);
        }
    }

    xhr.open('POST', 'MyFirstServlet', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(JSON.stringify(messageTo));    
}

function addRow(text) {
    let coeffs = JSON.parse(text);

    let tbod = document.getElementById('table');

    let row = document.createElement('tr');
    tbod.appendChild(row);

    let tdA = document.createElement('td');
    let tdB = document.createElement('td');
    let tdC = document.createElement('td');
    let tdX1 = document.createElement('td');
    let tdX2 = document.createElement('td');

    row.appendChild(tdA);
    row.appendChild(tdB);
    row.appendChild(tdC);
    row.appendChild(tdX1);
    row.appendChild(tdX2);

    tdA.innerHTML = coeffs.a;
    tdB.innerHTML = coeffs.b;
    tdC.innerHTML = coeffs.c;
    tdX1.innerHTML = coeffs.x1;
    tdX2.innerHTML = coeffs.x2;
}
