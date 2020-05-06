package com;

import java.sql.*;

public class Hospital {
	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Hospital", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

 	public String insertHospital(String hcode, String hname, String htp, String haddress, String hdoc, String hdesc) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}
// create a prepared statement
			String query = " insert into Hospital (`hpCode`,`hpName`,`hpTp`,`hpAddress`,`hpDoc`,`hpDesc`)"
					+ " values (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values

			preparedStmt.setString(1, hcode);
			preparedStmt.setString(2, hname);
			preparedStmt.setString(3, htp);
			preparedStmt.setString(4, haddress);
			preparedStmt.setString(5, hdoc);
			preparedStmt.setString(6, hdesc);

// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newHospital = readHospital();
			output = "{\"status\":\"success\" ,\"data\": \"" +
						newHospital +"\"}";
			
		
		} catch (Exception e) {
			output = "{\"status\":\"error\" ,\"data\":\"Error while inserting.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String readHospital() {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Hospital Code</th>"
					+ "<th>Hospital Name</th>"
					+ "<th>Telephone</th><th>Address</th>"
					+ "<th>Doctors</th><th>Description</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from Hospital";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
// iterate through the rows in the result set
			while (rs.next()) {
				String hpID = Integer.toString(rs.getInt("hpID"));
				String hpCode = rs.getString("hpCode");
				String hpName = rs.getString("hpName");
				String hpTp = rs.getString("hpTp");
				String hpAddress = rs.getString("hpAddress");
				String hpDoc = rs.getString("hpDoc");
				String hpDesc = rs.getString("hpDesc");
// Add into the html table

				output += "<tr><td><input id='hidehpIDUpdate' name='hidehpIDUpdate'  type='hidden' value='"+ hpID + "'>"
				+ hpCode + "</td>";
				output += "<td>" + hpName + "</td>";
				output += "<td>" + hpTp + "</td>";
				output += "<td>" + hpAddress + "</td>";
				output += "<td>" + hpDoc + "</td>";
				output += "<td>" + hpDesc + "</td>";

// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update'class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-hpId='"
						+ hpID + "'>" + "</td></tr>";
			}
			
			
			
			
			
			
			con.close();
// Complete the html table
			output += "</table>";
			
		} catch (Exception e) {
			output = "Error while reading.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateHospital(String ID, String hcode, String hname, String htp, String haddress, String hdoc,
			String hdesc) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
// create a prepared statement
			String query = "UPDATE Hospital SET hpCode=?,hpName=?,hpTp=?,hpAddress=?,hpDoc=?, hpDesc=? WHERE hpID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
			preparedStmt.setString(1, hcode);
			preparedStmt.setString(2, hname);
			preparedStmt.setString(3, htp);
			preparedStmt.setString(4, haddress);
			preparedStmt.setString(5, hdoc);
			preparedStmt.setString(6, hdesc);
			preparedStmt.setInt(7, Integer.parseInt(ID));
// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newHospital = readHospital();
			output = "{\"status\":\"success\" ,\"data\": \"" +
			newHospital +"\"}";
			
		} catch (Exception e) {
			
			output ="{\"status\":\"error\" ,\"data\":\"Error while updating.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteHospital(String hpID) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
// create a prepared statement
			String query = "delete from Hospital where hpID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
// binding values
			preparedStmt.setInt(1, Integer.parseInt(hpID));
			
// execute the statement
			preparedStmt.execute();
			con.close();
			
			String newHospital = readHospital();
			output = "{\"status\":\"success\" ,\"data\": \"" +
					newHospital +"\"}";
			
			
		} catch (Exception e) {
			output = "{\"status\":\"error\" ,\"data\":\"Error while deleting.\"}";
			System.err.println(e.getMessage());
		}
		return output;
	}
}