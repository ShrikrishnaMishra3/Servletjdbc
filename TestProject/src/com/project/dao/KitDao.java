package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.models.KitModels;

public class KitDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public KitDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public boolean insertkiT(KitModels kITModels) throws SQLException {
		String sql = "INSERT INTO Kit(PersonName,Email,ContactNumber,Status,OrderDate) VALUES (?,?,?,?,?)";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, kITModels.getPersonName());
		statement.setString(2, kITModels.getEmail());
		statement.setString(3, kITModels.getContactNumber());
		statement.setString(4, kITModels.getStatus());
		statement.setString(5, kITModels.getOrderDate());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}

	public List<KitModels> listAllkitModelsinfo() throws SQLException {
		List<KitModels> listkitModels = new ArrayList<>();

		String sql = "SELECT * FROM Kit";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String PersonName = resultSet.getString("PersonName");
			String Email = resultSet.getString("Email");
			String ContactNumber = resultSet.getString("ContactNumber");
			String Status = resultSet.getString("Status");
			String OrderDate = resultSet.getString("OrderDate");

			KitModels Models = new KitModels(id,PersonName,Email,ContactNumber,Status,OrderDate);
			System.out.println(Models);
			listkitModels.add(Models);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listkitModels;
	}

	public boolean deleteKit(int id) throws SQLException {
		String sql = "DELETE FROM Kit where id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;
	}

	public boolean updateKit(KitModels models) throws SQLException {
		String sql = "UPDATE Kit SET PersonName = ? ,Email = ?,ContactNumber = ?,Status=?,OrderDate=?";
		sql += " WHERE id = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, models.getPersonName());
		statement.setString(2, models.getEmail());
		statement.setString(3, models.getContactNumber());
		statement.setString(4, models.getStatus());
		statement.setString(5, models.getOrderDate());
		statement.setInt(6, models.getId());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;
	}

	public KitModels getKit(int id) throws SQLException {
		KitModels details = null;
		String sql = "SELECT * FROM Kit WHERE book_id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String PersonName = resultSet.getString("PersonName");
			String Email = resultSet.getString("Email");
			String ContactNumber = resultSet.getString("ContactNumber");
			String Status = resultSet.getString("Status");
			String OrderDate = resultSet.getString("OrderDate");

			details = new KitModels(id,PersonName,Email,ContactNumber,Status,OrderDate);
		}

		resultSet.close();
		statement.close();

		return details;
	}
}