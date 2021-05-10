const url = 'http://localhost:8080/ERS';

let usernamePass = localStorage.getItem("username");
let roleId = localStorage.getItem("role_id");
let User_Id = localStorage.getItem("user_id");
let userParam = String(usernamePass);
let reqtype = 1;
let status;
let statusResult;
let type;
let typeResult;
let data;
let welcomeName;


console.log(usernamePass);
//Assemble data for table
assembleFunc();

//Submit
let submitBtn = document.getElementById("submit-btn");
submitBtn.addEventListener("click", addFunc);



async function addFunc() {

    let reimb_amount_be = document.getElementById("reimb_amount").value;

    if (reimb_amount_be > 0) {
        let reimb_amount_be = document.getElementById("reimb_amount").value;
        let description_be = document.getElementById("description").value;
        let reimb_type_id_txt = document.getElementById("reimb_type_id_txt").value;
        let reimb_type_id_be = convertType(reimb_type_id_txt);
        let reimb_status_id_request = 1;
        let time_submitted = Date.now();

        //creates json object
        let reimbursement = {
            reimb_amount: reimb_amount_be,
            time_submitted: time_submitted,
            description: description_be,
            reimb_type_id: reimb_type_id_be,
            reimb_author: User_Id,
            reimb_status_id: reimb_status_id_request
        }

        let resp = await fetch(api, {
            method: 'POST',
            body: JSON.stringify(reimbursement)
        })

        if (resp.status === 201) {
            document.getElementById('formdiv').innerHTML = 'It was added';
        } else {
            document.getElementById('formdiv').innerHTML = 'Something went wrong. Reload the page';
        }
    }
}


async function assembleFunc() {

    console.log(userParam);
    let req = await fetch(url + '/req_completed', {
        method: 'GET',
    })
    if (req.status === 200) {
        console.log(req);

        let data = await req.json();
        console.log(data);

        for (let reimbursement of data) {

            let row = document.createElement('tr');

            let cell = document.createElement('td');
            cell.innerText = reimbursement.reimb_id;
            row.appendChild(cell);

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
                    cell6.style = "color:yellow;text-align:center";

                    break;
                case 2:
                    cell6.style = "color:MediumSeaGreen;text-align:center";
                    break;
                case 3:
                    cell6.style = "color:red;font-weight: bold;text-align:center";
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
            welcomeName = reimbursement.firstName;

        }

    }

    if (welcomeName) {
        document.getElementById('Welcome_lb').innerText = "Welcome " + welcomeName + "!";
    } else {
        document.getElementById('Welcome_lb').innerText = "Welcome " + userParam + "!";
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