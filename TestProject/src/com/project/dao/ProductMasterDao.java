package com.project.dao;

import com.project.models.ProductMaster;
import com.project.utils.Database;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ProductMasterDao {
	public boolean createProductMaster(final int id, final String ProductName, final String Cost,
			String ProductDescription) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO ProductMaster(ProductName,Cost,ProductDescription) VALUES (?,?,?)");
			ps.setString(1, ProductName);
			ps.setString(2, Cost);
			ps.setString(3, ProductDescription);
			ps.executeUpdate();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ProductMaster getProductMasterbyId(int id) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ProductMaster WHERE id=?");
			ps.setString(1, String.valueOf(id));
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ProductMaster productMaster = ProductMasterBuilder(rs);
				con.close();
				return productMaster;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private ProductMaster ProductMasterBuilder(ResultSet rs) throws NullPointerException, SQLException {

		if (rs == null) {
			throw new NullPointerException("Result Set");
		}
		final int id = rs.getInt("id");
		final String ProductName = rs.getString("ProductName");
		final String Cost = rs.getString("Cost");
		final String ProductDescription = rs.getString("ProductDescription");

		return new ProductMaster(id, ProductName, Cost, ProductDescription, getProductMasterDetails(id));
	}

	public Collection<ProductMaster> getLastFiveItems() {
		try {
			Connection con = Database.getConnection();
			final List<ProductMaster> items = new ArrayList<ProductMaster>();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ProductMaster ORDER BY id DESC LIMIT 5");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				final ProductMaster productMaster = ProductMasterBuilder(rs);
				items.add(productMaster);
			}
			con.close();
			return items;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean saveProductMaster(ProductMaster productMaster) {
		try {
			Connection con = Database.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE ProductMaster SET ProductName = ? ,Cost = ?,ProductDescription = ? WHERE id = ?");
			ps.setString(1, productMaster.getProductName());
			ps.setString(2, productMaster.getCost());
			ps.setString(3, productMaster.getProductDescription());
			ps.setInt(4, productMaster.getId());
			ps.executeUpdate();
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private JSONArray getProductMasterDetails(final int productMasterId) {
		JSONArray itemDetailsArray = new JSONArray();
		if (productMasterId == 0)
			throw new NullPointerException("ProductMaster Id can't be null");
		try {
			Connection con = Database.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ProductMasterDetails WHERE ProductMasterId = ?");
			ps.setInt(1, productMasterId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				JSONObject itemDetails = new JSONObject();
				itemDetails.put("id", rs.getInt("id"));
				itemDetails.put("key", rs.getString("key"));
				itemDetails.put("value", rs.getString("value"));
				itemDetailsArray.put(itemDetails);
			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemDetailsArray;
	}

	public Collection<ProductMaster> getAllItem() {
		try {
			Connection con = Database.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ProductMaster");
			ResultSet rs = ps.executeQuery();
			Collection<ProductMaster> productMaster = new ArrayList<ProductMaster>();
			while (rs.next()) {
				productMaster.add(ProductMasterBuilder(rs));
			}
			con.close();
			return productMaster;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
