/*
 * package com.project.dao;
 * 
 * import com.project.models.Kit; import com.project.models.ProductMaster;
 * import com.project.utils.Database;
 * 
 * import org.json.JSONArray; import org.json.JSONObject;
 * 
 * import java.sql.*; import java.util.ArrayList; import java.util.Collection;
 * import java.util.Date; import java.util.List;
 * 
 * public class KitDao { public boolean createKit(final int id, final String
 * PersonName, final String Email, String ContactNumber, final String Status,
 * String OrderDate) { try { Connection con = Database.getConnection();
 * PreparedStatement ps = con.prepareStatement(
 * "INSERT INTO Kit(PersonName,Email,ContactNumber,Status,OrderDate) VALUES (?,?,?,?,?)"
 * ); ps.setString(1, PersonName); ps.setString(2, Email); ps.setString(3,
 * ContactNumber); ps.setString(4, Status); ps.setString(5, OrderDate);
 * ps.executeUpdate(); con.close(); return true; } catch (Exception e) {
 * e.printStackTrace(); } return false; }
 * 
 * public Kit getKitbyId(int id) { try { Connection con =
 * Database.getConnection(); PreparedStatement ps =
 * con.prepareStatement("SELECT * FROM Kit WHERE id=?"); ps.setString(1,
 * String.valueOf(id)); ResultSet rs = ps.executeQuery(); if (rs.next()) { Kit
 * kit = KitBuilder(rs); con.close(); return kit; } } catch (Exception e) {
 * e.printStackTrace(); } return null; }
 * 
 * private Kit KitBuilder(ResultSet rs) throws NullPointerException,
 * SQLException {
 * 
 * if (rs == null) { throw new NullPointerException("Result Set"); } final int
 * id = rs.getInt("id"); final String PersonName = rs.getString("PersonName");
 * final String Email = rs.getString("Email"); final String ContactNumber =
 * rs.getString("ContactNumber"); final String Status = rs.getString("Status");
 * final String OrderDate = rs.getString("OrderDate");
 * 
 * return new Kit(id, PersonName, Email, ContactNumber, Status, OrderDate,
 * getKitDetails(id)); }
 * 
 * public Collection<Kit> getLastFiveItems() { try { Connection con =
 * Database.getConnection(); final List<Kit> items = new ArrayList<Kit>();
 * PreparedStatement ps =
 * con.prepareStatement("SELECT * FROM Kit ORDER BY id DESC LIMIT 5"); ResultSet
 * rs = ps.executeQuery(); while (rs.next()) { final Kit details =
 * KitBuilder(rs); items.add(details); } con.close(); return items; } catch
 * (Exception e) { e.printStackTrace(); return null; } }
 * 
 * public boolean saveKit(Kit kit) { try { Connection con =
 * Database.getConnection(); PreparedStatement ps = con.prepareStatement(
 * "UPDATE Kit SET PersonName = ? ,Email = ?,ContactNumber = ?,Status=?,OrderDate=?, WHERE id = ?"
 * ); ps.setString(1, kit.getPersonName()); ps.setString(2, kit.getEmail());
 * ps.setString(3, kit.getContactNumber()); ps.setString(2, kit.getStatus());
 * ps.setString(3, kit.getOrderDate()); ps.setInt(4, kit.getId());
 * ps.executeUpdate(); con.close(); return true; } catch (Exception e) {
 * e.printStackTrace(); return false; } }
 * 
 * private JSONArray getKitDetails(final int kitId) { JSONArray itemDetailsArray
 * = new JSONArray(); if (kitId == 0) throw new
 * NullPointerException("Kit Id can't be null"); try { Connection con =
 * Database.getConnection(); PreparedStatement ps =
 * con.prepareStatement("SELECT * FROM Kit WHERE Id = ?"); ps.setInt(1, kitId);
 * ResultSet rs = ps.executeQuery(); while (rs.next()) { JSONObject itemDetails
 * = new JSONObject(); itemDetails.put("id", rs.getInt("id"));
 * itemDetails.put("key", rs.getString("key")); itemDetails.put("value",
 * rs.getString("value")); itemDetailsArray.put(itemDetails); } con.close(); }
 * catch (ClassNotFoundException e) { e.printStackTrace(); } catch (SQLException
 * e) { e.printStackTrace(); } return itemDetailsArray; }
 * 
 * public Collection<Kit> getAllItem() { try { Connection con =
 * Database.getConnection(); PreparedStatement ps =
 * con.prepareStatement("SELECT * FROM Kit"); ResultSet rs = ps.executeQuery();
 * Collection<Kit> details = new ArrayList<Kit>(); while (rs.next()) {
 * details.add(KitBuilder(rs)); } con.close(); return details; } catch
 * (ClassNotFoundException e) { e.printStackTrace(); } catch (SQLException e) {
 * e.printStackTrace(); } return null; }
 * 
 * }
 */