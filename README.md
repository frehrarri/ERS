# Employee Reimbursment System (ERS)

## Executive Summary
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. [Stretch Goal] Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement. 

**Reimbursement Types** 

Employees must select the type of reimbursement as: LODGING, TRAVEL, FOOD, or OTHER.

**State-chart Diagram (Reimbursement Statuses)** 
![](./imgs/state-chart.jpg)

**Logical Model**
![](./imgs/logical.jpg)

**Physical Model**
![](./imgs/physical.jpg)

**Use Case Diagram**
![](./imgs/use-case.jpg)

**Activity Diagram**
![](./imgs/activity.jpg)

## Technical Requirements

The back-end system shall use JDBC to connect to a PostgreSQL database. The application shall deploy onto a Tomcat Server. The middle tier shall use Servlet technology for dynamic Web application development. The front-end view shall use HTML/CSS/JavaScript to make a single-page application that can call server-side components. The middle tier shall follow proper layered architecture, have reasonable (~70%) test coverage of the service layer, and conform to general REST standards up to at least level 2 of the Richardson Maturity Model. (NOTE: All diagrams above show models with all stretch goals implemented. They may be adjusted as necessary. Datatypes shown are OracleSQL based and will need to be converted to PostgreSQL.)

**Stretch Goals:**
* Include timestamps for when reimbursements are submitted and approved. 
* Use a trigger in the database. 
* Encrypt Passwords in the backend/database.
* Use session management on the backend for security. (In this case it is acceptable to break REST.)
* Implement finance managers to approve requests. 
  * Ensure finance managers can not approve their own requests. 
* Use bootstrap for styling.
* Extreme Challenge: Allow users to upload a receipt with the reimbursement that is saved to the database and retrievable. 
