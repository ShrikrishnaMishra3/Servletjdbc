package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.models.ProductMaster;
import com.project.models.kitModels;

public class ProductMasterDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public ProductMasterDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

	public boolean insertPrduct(ProductMaster productMaster) throws SQLException {
		String sql = "INSERT INTO ProductMaster(ProductName,Cost,ProductDescription) VALUES (?,?,?)";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, productMaster.getProductName());
		statement.setString(2, productMaster.getCost());
		statement.setString(3, productMaster.getProductDescription());
	
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}

	public List<ProductMaster> listAllProductinfo() throws SQLException {
		List<ProductMaster> listProductMaster= new ArrayList<>();

		String sql = "SELECT * FROM ProductMaster";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String ProductName = resultSet.getString("ProductName");
			String Cost = resultSet.getString("Cost");
			String ProductDescription = resultSet.getString("ProductDescription");
			
			ProductMaster Models = new ProductMaster(ProductName,Cost,ProductDescription); 
			listProductMaster.add(Models);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listProductMaster;
	}

	public boolean deleteProduct(ProductMaster models) throws SQLException {
		String sql = "DELETE FROM ProductMaster where id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, models.getId());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;
	}

	public boolean updateProduct(ProductMaster models) throws SQLException {
		String sql = "UPDATE ProductMaster SET ProductName = ? ,Cost = ?,ProductDescription = ?";
		sql += " WHERE id = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, models.getProductName());
		statement.setString(2, models.getCost());
		statement.setString(3, models.getProductDescription());
		statement.setInt(6, models.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;
	}

	public ProductMaster getProduct(int id) throws SQLException {
		ProductMaster details = null;
		String sql = "SELECT * FROM ProductMaster WHERE id = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String ProductName = resultSet.getString("ProductName");
			String Cost = resultSet.getString("Cost");
			String ProductDescription = resultSet.getString("ProductDescription");

			details = new ProductMaster(ProductName,Cost,ProductDescription);
		}

		resultSet.close();
		statement.close();

		return details;
	}
}