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
 * Servlet implementation class EditAccountControl
 */
@WebServlet(name = "editAccount", urlPatterns = { "/editAccount" })
public class EditAccountControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String aid = request.getParameter("id");
		String auser = request.getParameter("username");
		String apass = request.getParameter("password");
		String isSellParam = request.getParameter("isSell");
		String isAdminParam = request.getParameter("isAdmin");
		
		int aisSell = 0;
		int aisAdmin = 0;
//		int aisSell = Integer.parseInt(request.getParameter("isSell"));
//		int aisAdmin = Integer.parseInt(request.getParameter("isAdmin"));
		
		try {
			if (isSellParam != null && !isSellParam.isEmpty()) {
				aisSell = Integer.parseInt(isSellParam);
			}
			
			if (isAdminParam != null && !isAdminParam.isEmpty()) {
				aisAdmin = Integer.parseInt(isAdminParam);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			// Handle the error, e.g., set default values or return an error response
		}
		
		// Get data from DAO
		DAO dao = new DAO();
		dao.updateAccount(auser, apass,aisSell, aisAdmin,  aid);

		response.sendRedirect("managerAccount");
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
