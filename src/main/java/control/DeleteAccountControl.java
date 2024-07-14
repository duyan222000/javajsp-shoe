package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Account;

/**
 * Servlet implementation class DeleteAccountControl
 */
@WebServlet(name = "deleteAccount", urlPatterns = { "/deleteAccount" })
public class DeleteAccountControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String aid = request.getParameter("aid");
		System.out.println(aid);
        DAO dao = new DAO();
        dao.deleteAccount(aid);
        
     	response.sendRedirect("managerAccount"); // Parameter here is the URL Pattern: /manager 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
