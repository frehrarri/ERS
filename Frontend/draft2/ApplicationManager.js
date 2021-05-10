const url = 'http://localhost:8080/ERS';

let usernamePass = localStorage.getItem("username");
let roleId = localStorage.getItem("role_id");
let User_Id = localStorage.getItem("user_id");
let userParam = String(usernamePass);
let reqtype = 2;
let reimbParam;
let status;
let statusResult;
let type;
let typeResult;
let flag;

console.log(usernamePass);

//gets table data
assembleFunc();

//submits request to add data
let submitBtn = document.getElementById("submit-btn");
submitBtn.addEventListener("click", addFunc);

//Reimbursement
let reimbBtn = document.getElementById("reimbursement-btn");
reimbBtn.addEventListener("click", GoTo);

//applies filter
let filterBtn = document.getElementById("reimb_status_filter");
filterBtn.addEventListener("change", assembleFuncFilter);


async function GoTo() {
    console.log(usernamePass);
    // UPassing = localStorage.setItem("username",usernamePass);
    window.location.replace('file:///C:/Users/HP%20G3/Desktop/Java%20Course/Visual%20Studios/ERS_RmbtApp.html');
}

//gets data with filter
async function assembleFuncFilter() {

    var table = document.getElementById("reimb_table");

    for (var i = 0, row; row = table.rows[i]; i++) {
        row.style.visibility = "visible";
    }

    if (document.getElementById("reimb_status_filter").value == "All") {
        for (var i = 0, row; row = table.rows[i]; i++) {
            row.style.visibility = "visible";
        }
    } else {

        for (var i = 1, row; row = table.rows[i]; i++) {
            if (row.cells[7].innerText == document.getElementById("reimb_status_filter").value) {
                row.style.visibility = "visible";
            } else {
                console.log(row.innerText);
                row.style.visibility = "collapse";
            }
        }
    }
}
//adds 
async function addFunc() {
    flag = 0;

    let table = document.getElementById("reimb_table");

    for (var i = 1; i < table.rows.length; i++) {
        row = table.rows[i];

        if ((row.cells[10].innerText == usernamePass) && (row.cells[0].innerText == document.getElementById("reimb_id").value)) {

            flag = 1;
            break;

        }
    }

    reimb_id_be = document.getElementById("reimb_id");
    if (flag == 0) {

        if ((reimb_id_be != 0)) {
            reimb_id_be = document.getElementById("reimb_id").value;

            let status_txt = document.getElementById("reimb_status").value;
            let reimb_status_id_request = convertStatus(status_txt);
            let time_resolved_be = Date.now();

            let reimbursement = {
                reimb_id: reimb_id_be,
                time_resolved: time_resolved_be,
                reimb_resolver: User_Id,
                reimb_status_id: reimb_status_id_request

            }

            let resp = await fetch(api, {
                method: 'POST',
                body: JSON.stringify(reimbursement)
            });

            if (resp.status === 201) {
                document.getElementById('formdiv').innerHTML = 'It was added';
            } else {
                document.getElementById('formdiv').innerHTML = 'Something went wrong. Reload the page';
            }

        } else {
            reimb_id_be.innerText = "Not valid";
        }
    }
}
//gets table data 
async function assembleFunc() {

    let req = await fetch(url + '/req_completed', {
        method: 'GET',
    })
    if (req.status === 200) {
        console.log(req);

        let data = await req.json();

        for (let reimbursement of data) {
            console.log(reimbursement);

            let row = document.createElement('tr');

            let cell = document.createElement('td');
            cell.innerText = reimbursement.reimb_id;
            row.appendChild(cell);

            let cell1 = document.createElement('td');
            if (reimbursement.reimb_author == 0) {
                cell1.innerText = ' ';
                row.appendChild(cell1);
            } else {
                cell1.innerText = reimbursement.firstName + " " + reimbursement.lastName;
                row.appendChild(cell1);
            }

            let cell1_1 = document.createElement('td');
            if (reimbursement.reimb_author == 0) {
                cell1_1.innerText = ' ';
                row.appendChild(cell1_1);
            } else {
                cell1_1.innerText = reimbursement.email;
                row.appendChild(cell1_1);
            }

            let cell2 = document.createElement('td');
            cell2.innerText = ('$' + reimbursement.reimb_amount);
            row.appendChild(cell2);
            cell2.style = "text-align:right";

            let cell3 = document.createElement('td');
            cell3.innerText = reimbursement.description;
            row.appendChild(cell3);
            cell3.style = "text-align:left";

            let cell4 = document.createElement('td');
            cell4.innerText = convertType(reimbursement.reimb_type_id);
            row.appendChild(cell4);

            let dateSub = new Date(reimbursement.time_submitted);
            let date = dateSub.getFullYear() + '-' + (dateSub.getMonth() + 1) + '-' + dateSub.getDate() + "  " + dateSub.getHours() + ":" + dateSub.getMinutes();

            let cell5 = document.createElement('td');
            cell5.innerText = (date);
            row.appendChild(cell5);

            let cell6 = document.createElement('td');
            cell6.innerText = convertStatus(reimbursement.reimb_status_id);
            let status = reimbursement.reimb_status_id;

            switch (status) {
                case 1:
                    cell6.style = "color:yellow;font-weight: bold";
                    break;
                case 2:
                    cell6.style = "color:MediumSeaGreen";
                    break;
                case 3:
                    cell6.style = "color:red";
                    break;
            }

            row.appendChild(cell6);

            let cell7 = document.createElement('td');
            if (reimbursement.resolver_name == 0) {
                cell7.innerText = ' ';
                row.appendChild(cell7);
            } else {
                cell7.innerText = reimbursement.resolver_name;
                row.appendChild(cell7);
            }

            dateRes = new Date(reimbursement.time_resolved);
            dateResolved = dateRes.getFullYear() + '-' + (dateRes.getMonth() + 1) + '-' + dateRes.getDate() + "  " + dateRes.getHours() + ":" + dateRes.getMinutes();

            let cell8 = document.createElement('td');
            if (reimbursement.time_resolved == null) {
                cell8.innerText = ' ';
                row.appendChild(cell8);
            } else {
                cell8.innerText = dateResolved;
                row.appendChild(cell8);
            }

            let cell9 = document.createElement('td');
            if (reimbursement.username == 0) {
                cell9.innerText = ' ';
                row.appendChild(cell9);
            } else {
                cell9.innerText = reimbursement.username;
                row.appendChild(cell9);
            }
            document.getElementById('reimb_body').appendChild(row);
        }
    }
}




function convertType(type) {
    switch (type) {

        case "Lodging":
            typeResult = 1;
            break;
        case "Travel":
            typeResult = 2;
            break;
        case "Food":
            typeResult = 3;
            break;
        case "Other":
            typeResult = 4;
            break;
        case 1:
            typeResult = "Lodging";
            break;
        case 2:
            typeResult = "Travel";
            break;
        case 3:
            typeResult = "Food";
            break;
        case 4:
            typeResult = "Other";
            break;
        default:
            break;
    }
    return typeResult;
}

function convertStatus(status) {
    switch (status) {

        case "Pending":
            statusResult = 1;
            break;
        case "Approved":
            statusResult = 2;
            break;
        case "Denied":
            statusResult = 3;
            break;
        case 1:
            statusResult = "Pending";
            break;
        case 2:
            statusResult = "Approved";
            break;
        case 3:
            statusResult = "Denied";
            break;
        default:
            break;
    }
    return statusResult;
}

async function Validate() {
    var table = document.getElementById("reimb_table");
    var flag = 0;
    for (var i = 0, row; row = table.rows[i]; i++) {
        if (row.cells[0].innerText == document.getElementById("reimb_id").value) {
            flag = 1;
            break;
        }
    }
    return flag;
}