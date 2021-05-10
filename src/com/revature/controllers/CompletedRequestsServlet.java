package com.revature.controllers;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.services.ReimbursementService;

public class CompletedRequestsServlet extends HttpServlet {

	ReimbursementService rs = new ReimbursementService();
	ObjectMapper om = new ObjectMapper();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		if (Users.getRole() == 1) {
			List<Reimbursement> list = rs.getAllCompletedRequests();
			String json = om.writeValueAsString(list);
			System.out.println(json);
			resp.getWriter().print(json);
			resp.setStatus(200);
			resp.setContentType("application/json");
		
		} 
		List<Reimbursement> list = rs.getUserCompletedRequests();
		String json = om.writeValueAsString(list);
		System.out.println(json);
		resp.getWriter().print(json);
		resp.setStatus(200);
		resp.setContentType("application/json");
	}


}
