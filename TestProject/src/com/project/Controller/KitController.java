/*
 * package com.project.Controller; import javax.servlet.RequestDispatcher;
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import com.project.models.Kit;
 * 
 * 
 * import java.io.IOException;
 * 
 * @WebServlet(name = "KitController") public class KitController extends
 * HttpServlet { protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * 
 * }
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { final int Id =
 * Integer.parseInt(request.getParameter("id")); final Kit details =
 * ProjectMasterController.find(Id); request.setAttribute("details",details);
 * RequestDispatcher rd = request.getRequestDispatcher("/jsp/item.jsp");
 * rd.forward(request,response); } }
 */