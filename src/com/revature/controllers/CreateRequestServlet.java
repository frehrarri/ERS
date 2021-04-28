package com.revature.controllers;

import java.io.BufferedReader;

import java.io.IOException;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

public class CreateRequestServlet extends HttpServlet {

	ReimbursementService rs = new ReimbursementService();
	ObjectMapper om = new ObjectMapper();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		BufferedReader reader = req.getReader();
		// A BufferedReader will read line by line the contents of the request body. we
		// will use a StringBuilder to collect all the
		// lines together
		StringBuilder sb = new StringBuilder();

		// reads the first line
		String line = reader.readLine();

		// continues to append till we run out of lines.
		while (line != null) {
			sb.append(line);
			// advances to the next line.
			line = reader.readLine();
		}

		String body = new String(sb);

		// Jackson reads the JSON from the body of the request and puts it in a Java
		// object.
		Reimbursement reimb = om.readValue(body, Reimbursement.class);

		if (rs.addNewRequest(reimb)) {
			resp.setStatus(201);
			resp.getWriter().print("Your refund request has been created!");
		} else {
			resp.setStatus(400);
		}
	}
}

