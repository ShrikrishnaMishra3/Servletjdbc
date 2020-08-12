package com.project.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 


import com.project.dao.ProductMasterDao;
import com.project.models.ProductMaster;


public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductMasterDao productMasterDao;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		productMasterDao = new ProductMasterDao(jdbcURL, jdbcUsername, jdbcPassword);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action =  request.getParameter("action");

		try {
			switch (action) {
			case "newProduct":
				showNewForm(request, response);
				break;
			case "insertProduct":
				insertProduct(request, response);
				break;
			case "deleteProduct":
				deleteProject(request, response);
				break;
			case "editProduct":
				showEditForm(request, response);
				break;
			case "updateProduct":
				updateProject(request, response);
				break;
			default:
				listProject(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listProject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<ProductMaster> listProductMaster = productMasterDao.listAllProductinfo();
		request.setAttribute("listProductMaster", listProductMaster);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductMasterList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductMasterForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductMaster existingProduct = productMasterDao.getProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ProductMasterForm.jsp");
        request.setAttribute("ProductMaster", existingProduct);
        dispatcher.forward(request, response);
 
    }

	private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String ProductName = request.getParameter("ProductName");
		String Cost = request.getParameter("Cost");
		String ProductDescription = request.getParameter("ProductDescription");

		

		ProductMaster productMaster = new ProductMaster(0,ProductName, Cost, ProductDescription);
		productMasterDao.insertPrduct(productMaster);
		response.sendRedirect("list");
	}

	private void updateProject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String ProductName = request.getParameter("ProductName");
		String Cost = request.getParameter("Cost");
		String ProductDescription = request.getParameter("ProductDescription");
	

		ProductMaster productMaster = new ProductMaster(0,ProductName, Cost, ProductDescription);
		productMasterDao.updateProduct(productMaster);
		response.sendRedirect("list");
	}

	private void deleteProject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		productMasterDao.deleteProduct(id);
		response.sendRedirect("list");

	}
}