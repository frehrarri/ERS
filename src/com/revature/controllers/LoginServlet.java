package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Users;
import com.revature.services.UserServices;

public class LoginServlet extends HttpServlet {

	ObjectMapper om = new ObjectMapper();
	UserServices us = new UserServices();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

		Users user = om.readValue(body, Users.class);
		Users userCredentials = us.login(user);
		if (userCredentials != null) {
			resp.setStatus(200);
			String json = om.writeValueAsString(userCredentials);
			resp.getWriter().print(json);
		} else {
			resp.setStatus(403);
		}
	}
}
