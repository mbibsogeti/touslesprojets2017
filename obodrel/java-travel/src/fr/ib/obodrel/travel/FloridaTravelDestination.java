package fr.ib.obodrel.travel;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;

public class FloridaTravelDestination extends UnitedStatesTravelDestination {

	public FloridaTravelDestination() {
		super();
		_DestinationName = "Florida";
		_travelDuration = 8;
		_DestinationId = "f";
		_LocationName = "Coeast City";
		_meanOfTransport.setMeanOfTransport("p");
	}

	private void displayQueryRS(ResultSet rs) throws SQLException {
		ResultSetMetaData tableContentMD = rs.getMetaData();
		int columnsNumber = tableContentMD.getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= columnsNumber; i++) {
				System.out.print(rs.getString(i) + "\t");

			}
			System.out.println();
		}
		System.out.println();
	}

	protected void execute(Scanner cin) {
		boolean isRegistered = false;
		System.out.println("Please choose the correct username to validate your travel!");
		chooseUsername(cin);
		chooseUserEmail(cin);
		try {
			Class.forName("org.sqlite.JDBC");
			Connection connToDB = DriverManager.getConnection("jdbc:sqlite:./ressources/florida.sqlite");
			PreparedStatement createTable = connToDB.prepareStatement(
					"CREATE TABLE IF NOT EXISTS demande(request_id INTEGER PRIMARY KEY, request_name TEXT, request_email TEXT);");
			createTable.executeUpdate();
			PreparedStatement showTable = connToDB
					.prepareStatement("SELECT request_id AS \"Id\", request_email AS \"E-Mail\","
							+ " request_name AS \"Name\" FROM demande");
			ResultSet tableContent = showTable.executeQuery();
			System.out.println("Id\tE-Mail\tName");
			displayQueryRS(tableContent);
			PreparedStatement addIntoTable = connToDB
					.prepareStatement("INSERT INTO demande(request_name, request_email) VALUES (?,?)");
			addIntoTable.setString(1, _userName);
			addIntoTable.setString(2, _userEmail);
			addIntoTable.executeUpdate();
			tableContent = showTable.executeQuery();
			System.out.println("Id\tE-Mail\tName");
			displayQueryRS(tableContent);
			PreparedStatement showTableEmail = connToDB
					.prepareStatement("SELECT request_name AS \"Name\" FROM demande WHERE request_email = ?");
			showTableEmail.setString(1, _userEmail);
			tableContent = showTableEmail.executeQuery();
			System.out.println("Name");
			displayQueryRS(tableContent);
			PreparedStatement checkIfRegistered = connToDB
					.prepareStatement("SELECT COUNT(*) AS \"DoesExist\" FROM demande WHERE request_email = ? AND request_name = ?");
			checkIfRegistered.setString(1, _userEmail);
			checkIfRegistered.setString(2, _userName);
			tableContent = checkIfRegistered.executeQuery();
			tableContent.next();
			System.out.println("Number of people with such email and name are : "+tableContent.getInt("DoesExist"));
			if(tableContent.getInt("DoesExist")>0) {
				isRegistered = true;
			}
			connToDB.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getClass().getName() + "\n" + e);
		}
		if(isRegistered) {
			System.out.println("You are successfully registered as " + _userName + " using " + _userEmail + " as email");
		} else {
			System.out.println("Registration failed");
		}
	}
}
