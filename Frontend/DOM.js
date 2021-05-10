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

let userId;
let role;

// //variables to get entered values to get data from database
// let username = document.getElementById("username");
// let password = document.getElementById("password");

// //allows a user to log in
// let loginbtn = document.getElementById("loginbtn");

// loginbtn.addEventListener('click', loginFunc);

// async function loginFunc() {
//     let uName = document.getElementById('username').value;
//     let uPass = document.getElementById('password').value;

//     let user = {
//         username: uName,
//         password: uPass
//     }

//     let resp = await fetch(url + "/login", {
//         method: "POST",
//         body: JSON.stringify(user)
//     })


async function addFunc() {

    let reimb_amount_be = document.getElementById("reimb_amount").value;
    if (reimb_amount_be > 0) {
        let reimb_amount_be = document.getElementById("reimb_amount").value;
        let description_be = document.getElementById("description").value;
        let reimb_type_id_txt = document.getElementById("reimb_type_id_txt").value;
        let reimb_type_id_be = convertType(reimb_type_id_txt);
        let reimb_status_id_request = 1;
        let time_submitted = Date.now();

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

    //gets employee pending requests
    async function populateEmployeePendingRequests() {

        let resp = await fetch(url + '/req_completed', {
            method: 'GET'
        });

        if (resp.status === 200) {

            let data = await resp.json();

            for (let ers_reimbursement of data) {

                let row = document.createElement('tr');

                let cell = document.createElement('td');
                cell.innerText = ers_reimbursement.reimb_id;
                row.appendChild(cell);

                let cell2 = document.createElement('td');
                cell2.innerText = ers_reimbursement.reimb_status_id;
                row.appendChild(cell2);

                let status = ers_reimbursement.reimb_status_id;

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

                let cell3 = document.createElement('td');
                cell3.innerText = ers_reimbursement.reimb_type_id;
                row.appendChild(cell3);

                let cell4 = document.createElement('td');
                cell4.innerText = ers_reimbursement.reimb_amount;
                row.appendChild(cell4);

                let cell5 = document.createElement('td');
                cell5.innerText = ers_reimbursement.reimb_description;
                row.appendChild(cell5);

                let cell6 = document.createElement('td');
                cell6.innerText = ers_reimbursement.reimb_author;
                row.appendChild(cell6);

                let cell7 = document.createElement('td');
                cell7.innerText = ers_reimbursement.reimb_resolver;
                row.appendChild(cell7);

                let cell8 = document.createElement('td');
                cell8.innerText = ers_reimbursement.reimb_submitted;
                row.appendChild(cell8);

                let cell9 = document.createElement('td');
                cell9.innerText = ers_reimbursement.reimb_resolved;
                row.appendChild(cell9);

                document.getElementById('addreq').appendChild(row);

            }
        }
    }

    //gets employee completed requests
    async function populateEmployeeCompletedRequests() {

        let resp = await fetch(url + '/req_completed', {
            method: 'GET'
        });

        if (resp.status === 200) {

            let data = await resp.json();

            for (let ers_reimbursement of data) {

                let row = document.createElement('tr');

                let cell = document.createElement('td');
                cell.innerText = ers_reimbursement.reimb_id;
                row.appendChild(cell);

                let cell2 = document.createElement('td');
                cell2.innerText = ers_reimbursement.reimb_status_id;
                row.appendChild(cell2);

                let status = ers_reimbursement.reimb_status_id;

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

                let cell3 = document.createElement('td');
                cell3.innerText = ers_reimbursement.reimb_type_id;
                row.appendChild(cell3);

                let cell4 = document.createElement('td');
                cell4.innerText = ers_reimbursement.reimb_amount;
                row.appendChild(cell4);

                let cell5 = document.createElement('td');
                cell5.innerText = ers_reimbursement.reimb_description;
                row.appendChild(cell5);

                let cell6 = document.createElement('td');
                cell6.innerText = ers_reimbursement.reimb_author;
                row.appendChild(cell6);

                let cell7 = document.createElement('td');
                cell7.innerText = ers_reimbursement.reimb_resolver;
                row.appendChild(cell7);

                let cell8 = document.createElement('td');
                cell8.innerText = ers_reimbursement.reimb_submitted;
                row.appendChild(cell8);

                let cell9 = document.createElement('td');
                cell9.innerText = ers_reimbursement.reimb_resolved;
                row.appendChild(cell9);

                document.getElementById('addreq').appendChild(row);

            }
        }

    }

    //gets manager pending requests
    async function populateManagerPendingRequests() {

        let resp = await fetch(url + '/req_completed', {
            method: 'GET'
        });

        if (resp.status === 200) {

            let data = await resp.json();

            for (let ers_reimbursement of data) {

                let row = document.createElement('tr');

                let cell = document.createElement('td');
                cell.innerText = ers_reimbursement.reimb_id;
                row.appendChild(cell);

                let cell2 = document.createElement('td');
                cell2.innerText = ers_reimbursement.reimb_status_id;
                row.appendChild(cell2);

                let status = ers_reimbursement.reimb_status_id;

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

                let cell3 = document.createElement('td');
                cell3.innerText = ers_reimbursement.reimb_type_id;
                row.appendChild(cell3);

                let cell4 = document.createElement('td');
                cell4.innerText = ers_reimbursement.reimb_amount;
                row.appendChild(cell4);

                let cell5 = document.createElement('td');
                cell5.innerText = ers_reimbursement.reimb_description;
                row.appendChild(cell5);

                let cell6 = document.createElement('td');
                cell6.innerText = ers_reimbursement.reimb_author;
                row.appendChild(cell6);

                let cell7 = document.createElement('td');
                cell7.innerText = ers_reimbursement.reimb_resolver;
                row.appendChild(cell7);

                let cell8 = document.createElement('td');
                cell8.innerText = ers_reimbursement.reimb_submitted;
                row.appendChild(cell8);

                let cell9 = document.createElement('td');
                cell9.innerText = ers_reimbursement.reimb_resolved;
                row.appendChild(cell9);

                document.getElementById('addreq').appendChild(row);

            }
        }

    }

    //gets managers completed requests
    async function populateManagerCompletedRequests() {

        let resp = await fetch(url + '/req_completed', {
            method: 'GET'
        });

        if (resp.status === 200) {

            let data = await resp.json();

            for (let ers_reimbursement of data) {

                let row = document.createElement('tr');

                let cell = document.createElement('td');
                cell.innerText = ers_reimbursement.reimb_id;
                row.appendChild(cell);

                let cell2 = document.createElement('td');
                cell2.innerText = ers_reimbursement.reimb_status_id;
                row.appendChild(cell2);

                let status = ers_reimbursement.reimb_status_id;

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

                let cell3 = document.createElement('td');
                cell3.innerText = ers_reimbursement.reimb_type_id;
                row.appendChild(cell3);

                let cell4 = document.createElement('td');
                cell4.innerText = ers_reimbursement.reimb_amount;
                row.appendChild(cell4);

                let cell5 = document.createElement('td');
                cell5.innerText = ers_reimbursement.reimb_description;
                row.appendChild(cell5);

                let cell6 = document.createElement('td');
                cell6.innerText = ers_reimbursement.reimb_author;
                row.appendChild(cell6);

                let cell7 = document.createElement('td');
                cell7.innerText = ers_reimbursement.reimb_resolver;
                row.appendChild(cell7);

                let cell8 = document.createElement('td');
                cell8.innerText = ers_reimbursement.reimb_submitted;
                row.appendChild(cell8);

                let cell9 = document.createElement('td');
                cell9.innerText = ers_reimbursement.reimb_resolved;
                row.appendChild(cell9);

                document.getElementById('addreq').appendChild(row);

            }
        }

    }

    //creates a button for the createRequest function to work with
    async function createReqBtn() {
        let submitBtn = document.createElement("button");
        submitBtn.addEventListener('click', createRequests);
    }

    //creates a new request
    async function createRequests() {

        let requestID = document.getElementById('ID').value;
        let requestStatus = document.getElementById('reqStatus').value;
        let requestType = document.getElementById('reqType').value;
        let requestAmount = document.getElementById('amount').value;
        let requestDesc = document.getElementById('desc').value;
        let requestee = document.getElementById('employee').value;
        let resolver = document.getElementById('supervisor').value;
        let requestedDate = document.getElementById('reqDate').value;
        let decisionDate = document.getElementById('decDate').value;

        let reimbursement = {
            ID: requestID,
            reqStatus: requestStatus,
            reqType: requestType,
            amount: requestAmount,
            desc: requestDesc,
            employee: requestee,
            supervisor: resolver,
            reqDate: requestedDate,
            decDate: decisionDate
        }

        let resp = await fetch(url + 'req_create', {
            method: 'POST',
            body: JSON.stringify(reimbursement)
        })

        if (resp.status === 201) {
            createRequests();
        } else {
            document.getElementById('formdiv').innerHTML = 'Something went wrong. Reload the page and try again.';
        }

    }

    //updates status of request
    async function updateRequests() {

        let requestStatus = document.getElementById('reqStatus').value;

        let updateStatus = {
            reqStatus: requestStatus
        }

        let resp = await fetch(url + 'req_pending', {
            method: 'PATCH',
            body: JSON.stringify(updateStatus)
        });

        if (resp.status === 201) {
            updateRequests();
        } else {
            document.getElementById('formdiv').innerHTML = 'Something went wrong. Reload the page and try again.';
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




}


