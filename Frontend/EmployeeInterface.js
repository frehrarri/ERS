const url = 'http://localhost:8080/ERS';

let status;
let statusResult;
let type;
let typeResult;

//gets employee pending requests
async function populateEmployeePendingRequests() {

    let resp = await fetch(url + '/req_pending', {
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

    //Submits http request to create a new ERS request
    let submitBtn = document.createElement("button");
    submitBtn.addEventListener('click', createRequests);


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

        let resp = await fetch(url + '/req_create', {
            method: 'POST',
            body: JSON.stringify(reimbursement)
        })

        if (resp.status === 201) {
            createRequests();
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