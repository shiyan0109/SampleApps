package com.ibm.cloudoe.scaletest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/")
public class CpuStressTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CpuStressTest() {
        super();
        
    }

	/**
	 * When receives httprequest, it calculates the number of primes within 1000 and this consumes cpu utilization
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		response.setStatus(200);
		PrintWriter writer = response.getWriter();
		
		nthPrime(1000);
		writer.println("---------------------------------------------------------------------");
		writer.println("CPU Stress Test. Calculate the number of primes within 1000 for each single request");
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
	    return candidate-1;
	}
	
	private boolean isPrime(int n) {
	    for(int i = 2; i < n; ++i) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	

}
