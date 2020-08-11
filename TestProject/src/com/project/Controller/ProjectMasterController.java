package com.project.Controller;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.models.ProductMaster;

import java.io.IOException;

@WebServlet(name = "ProjectController")
public class ProjectMasterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int itemId = Integer.parseInt(request.getParameter("id"));
        final ProductMaster productMaster = ProjectMasterController.find(Id);
        request.setAttribute("productMaster",productMaster);
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/item.jsp");
        rd.forward(request,response);
    }
}
