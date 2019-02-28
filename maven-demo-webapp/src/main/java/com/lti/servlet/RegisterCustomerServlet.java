package com.lti.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;
import com.lti.model.Customer;

public class RegisterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterCustomerServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		Customer customer = new Customer();
		customer.setCust_id(id);
		customer.setCust_name(name);
		customer.setCust_email(email);

		CustomerDao dao = new CustomerDao();
		try {
			dao.addCustomerDetails(customer);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("confirmation.html");
	}

}
