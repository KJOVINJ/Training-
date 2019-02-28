package com.lti.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.Properties;

import com.lti.model.Customer;

//data access object  DAO 
public class CustomerDao {

	public void addCustomerDetails(Customer customer) throws SQLException, ClassNotFoundException, IOException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			Properties dbProps = new Properties();
			dbProps.load(this.getClass().getClassLoader().getResourceAsStream("prod-db.properties"));
			Class.forName(dbProps.getProperty("driverClassName"));
			conn = DriverManager.getConnection(dbProps.getProperty("url"), dbProps.getProperty("username"),
					dbProps.getProperty("password"));

			String sql = "insert into customer values(?,?,?) ";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, customer.getCust_id());
			stmt.setString(2, customer.getCust_name());
			stmt.setString(3, customer.getCust_email());
			stmt.executeUpdate();

		} finally {

			try {
				stmt.close();
			} catch (Exception e) {
			}

			try {
				conn.close();
			} catch (Exception e) {
			}

		}
	}

}
