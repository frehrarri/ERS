package com.revature.utils;

import java.io.IOException;

public class CORSFilter implements Filter {
	
	   @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	        
	        System.out.println("CORS Filter leveraged");
	        
	        if(!(response instanceof HttpServletResponse)) {
	            chain.doFilter(request, response);
	            return;
	        }
	        
	        // Cast the response as an HttpServletResponse
	        // Which is important, because we are going to set
	        // headers, which is specific to HTTP
	        HttpServletResponse res = (HttpServletResponse) response;
	        
	        res.setHeader("Access-Control-Allow-Origin", "null"); // Allow all origins
	        
	        res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	        // Allow specific HTTP Verbs
	        
	        res.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type,"
	                + "Access-Control-Request-Method, Access-Control-Request-Headers");
	        // Allow specific HTTP Headers (there's a fair few)
	        
	        res.setHeader("Access-Control-Allow-Credentials", "true");
	        // Credentials are allowed
	        
	        chain.doFilter(request, response);
	        // Continue the filter chain
	    }
}
