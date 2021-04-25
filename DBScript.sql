-- CREATE DATABASE ERS;

CREATE TABLE ers_reimbursement_status(
reimb_status_id SERIAL PRIMARY KEY,
reimb_status VARCHAR(20)
);

CREATE TABLE ers_reimbursement_type(
reimb_type_id SERIAL PRIMARY KEY,
reimb_type VARCHAR(20)
);

CREATE TABLE ers_user_roles(
ers_user_role_id SERIAL PRIMARY KEY,
user_role VARCHAR(10)
);

CREATE TABLE ers_users(
ers_users_id SERIAL PRIMARY KEY,
ers_username VARCHAR(50) UNIQUE,
ers_password VARCHAR(50),
user_first_name VARCHAR(100),
user_last_name VARCHAR(100),
user_email VARCHAR(50) UNIQUE,
user_role_id INTEGER
);

CREATE TABLE ers_reimbursement(
reimb_id SERIAL PRIMARY KEY,
reimb_amount NUMERIC,
reimb_submitted DATE,
reimb_resolved DATE,
reimb_description VARCHAR(250),
reimb_author INTEGER,
reimb_resolver INTEGER,
reimb_status_id INTEGER,
reimb_type_id INTEGER
);

ALTER TABLE ers_reimbursement
	ADD FOREIGN KEY (reimb_author)
		REFERENCES ers_users (ers_users_id);
ALTER TABLE ers_reimbursement
	ADD FOREIGN KEY (reimb_resolver)
		REFERENCES ers_users (ers_users_id);
ALTER TABLE ers_reimbursement
	ADD FOREIGN KEY (reimb_status_id)
		REFERENCES ers_reimbursement_status (reimb_status_id);
ALTER TABLE ers_reimbursement
	ADD FOREIGN KEY (reimb_type_id)		
		REFERENCES ers_reimbursement_type (reimb_type_id);
		
	
	
	
	
	
	