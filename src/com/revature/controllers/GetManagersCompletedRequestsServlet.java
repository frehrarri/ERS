package com.revature.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employees;
import com.revature.models.Managers;
import com.revature.services.EmployeeServices;
import com.revature.services.ManagerServices;

public class GetManagersCompletedRequestsServlet extends HttpServlet {

	ManagerServices ms = new ManagerServices();
	ObjectMapper om = new ObjectMapper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		List<Managers> list = ms.getCompletedRequests();
		String json = om.writeValueAsString(list);
		System.out.println(json);
		resp.getWriter().print(json);
		resp.setStatus(200);
		resp.setContentType("application/json");
		
	}
	
}
