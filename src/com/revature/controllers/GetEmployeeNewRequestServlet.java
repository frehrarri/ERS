package com.revature.controllers;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employees;
import com.revature.services.EmployeeServices;

public class GetEmployeeNewRequestServlet extends HttpServlet {

	EmployeeServices es = new EmployeeServices();
	ObjectMapper om = new ObjectMapper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		List<Employees> list = es.getPendingRequests();
		String json = om.writeValueAsString(list);
		System.out.println(json);
		resp.getWriter().print(json);
		resp.setStatus(200);
		resp.setContentType("application/json");
		
	}
	
}

