package com.project.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.Kit_Dao;
import com.project.models.kitModels;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Kit_Dao kitDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		kitDAO = new Kit_Dao(jdbcURL, jdbcUsername, jdbcPassword);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertKit(request, response);
				break;
			case "/delete":
				deleteKit(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateKit(request, response);
				break;
			default:
				listKit(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listKit(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<kitModels> listKit = kitDAO.listAllkitModelsinfo();
		request.setAttribute("listKit", listKit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("KitList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("KitForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        kitModels existingKit = kitDAO.getBook(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("KitForm.jsp");
        request.setAttribute("kit", existingKit);
        dispatcher.forward(request, response);
 
    }

	private void insertKit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		String PersonName = request.getParameter("PersonName");
		String Email = request.getParameter("Email");
		String ContactNumber = request.getParameter("ContactNumber");
		String Status = request.getParameter("Status");
		String OrderDate = request.getParameter("OrderDate");
		

		kitModels newkit = new kitModels(PersonName, Email, ContactNumber,Status,OrderDate);
		kitDAO.insertkiT(newkit);
		response.sendRedirect("list");
	}

	private void updateKit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String PersonName = request.getParameter("PersonName");
		String Email = request.getParameter("Email");
		String ContactNumber = request.getParameter("ContactNumber");
		String Status = request.getParameter("Status");
		String OrderDate = request.getParameter("OrderDate");
	

		kitModels kites = new kitModels(PersonName, Email, ContactNumber,Status,OrderDate);
		kitDAO.updateKit(kites);
		response.sendRedirect("list");
	}

	private void deleteKit(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		kitModels kites = new kitModels(id);
		kitDAO.deleteKit(kites);
		response.sendRedirect("list");

	}
}