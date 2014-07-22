package com.ibm.cloudoe.scaletest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CpuStressTest")
public class CpuStressTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CpuStressTest() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		response.setStatus(200);
		PrintWriter writer = response.getWriter();
		
		nthPrime(1000);
		writer.println("---------------------------------------------------------------------");
		writer.println("CPU Stress Test");
		writer.println("---------------------------------------------------------------------");		
				
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	
	public int nthPrime(int n) {
	    int candidate, count;
	    for(candidate = 2, count = 0; count < n; ++candidate) {
	        if (isPrime(candidate)) {
	            ++count;
	        }
	    }
	    // The candidate has been incremented once after the count reached n
	    return candidate-1;
	}
	
	private boolean isPrime(int n) {
	    for(int i = 2; i < n; ++i) {
	        if (n % i == 0) {
	            // We are naive, but not stupid, if
	            // the number has a divisor other
	            // than 1 or itself, we return immediately.
	            return false;
	        }
	    }
	    return true;
	}
	
	

}
