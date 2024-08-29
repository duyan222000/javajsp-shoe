package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc"); 
        DAO dao = new DAO();
        
        if (user != null) {
            if (user.getIsAdmin() == 1 ) {
            	String aid = request.getParameter("id");
        		String auser = request.getParameter("username");
        		String apass = request.getParameter("password");
        		String isSellParam = request.getParameter("isSell");
        		String isAdminParam = request.getParameter("isAdmin");
        		
        		int aisSell = 0;
        		int aisAdmin = 0;
        		
        		try {
        			if (isSellParam != null && !isSellParam.isEmpty()) {
        				aisSell = Integer.parseInt(isSellParam);
        			}
        			
        			if (isAdminParam != null && !isAdminParam.isEmpty()) {
        				aisAdmin = Integer.parseInt(isAdminParam);
        			}
        		} catch (NumberFormatException e) {
        			e.printStackTrace();
        		}
        		
        		dao.updateAccount(auser, apass,aisSell, aisAdmin,  aid);

        		response.sendRedirect("managerAccount");
            } else {
            	request.getRequestDispatcher("/WEB-INF/views/AccessDenied.jsp").forward(request, response); // Chuyển hướng đến trang từ chối truy cập
            }
        } else {
            response.sendRedirect("login"); // Chuyển hướng đến trang đăng nhập
        }
		
		
//		String aid = request.getParameter("id");
//		String auser = request.getParameter("username");
//		String apass = request.getParameter("password");
//		String isSellParam = request.getParameter("isSell");
//		String isAdminParam = request.getParameter("isAdmin");
//		
//		int aisSell = 0;
//		int aisAdmin = 0;
//		
//		try {
//			if (isSellParam != null && !isSellParam.isEmpty()) {
//				aisSell = Integer.parseInt(isSellParam);
//			}
//			
//			if (isAdminParam != null && !isAdminParam.isEmpty()) {
//				aisAdmin = Integer.parseInt(isAdminParam);
//			}
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//
//		DAO dao = new DAO();
//		dao.updateAccount(auser, apass,aisSell, aisAdmin,  aid);
//
//		response.sendRedirect("managerAccount");
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
