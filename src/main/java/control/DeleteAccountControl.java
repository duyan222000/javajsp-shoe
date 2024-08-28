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
 * Servlet implementation class DeleteAccountControl
 */
@WebServlet(name = "deleteAccount", urlPatterns = { "/deleteAccount" })
public class DeleteAccountControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc"); 
        DAO dao = new DAO();
        
        if (user != null) {
            if (user.getIsAdmin() == 1 ) {
            	String aid = request.getParameter("aid");
        		System.out.println(aid);
                dao.deleteAccount(aid);
                
             	response.sendRedirect("managerAccount"); 
            } else {
            	request.getRequestDispatcher("/WEB-INF/views/AccessDenied.jsp").forward(request, response); // Chuyển hướng đến trang từ chối truy cập
            }
        } else {
            response.sendRedirect("login"); // Chuyển hướng đến trang đăng nhập
        }
//		String aid = request.getParameter("aid");
//		System.out.println(aid);
//        DAO dao = new DAO();
//        dao.deleteAccount(aid);
//        
//     	response.sendRedirect("managerAccount"); // Parameter here is the URL Pattern: /manager 
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
