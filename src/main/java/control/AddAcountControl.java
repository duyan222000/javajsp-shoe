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
 * Servlet implementation class AddAcountControl
 */
@WebServlet(name = "addAccount", urlPatterns = { "/addAccount" })
public class AddAcountControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc"); 
        DAO dao = new DAO();
        
        if (user != null) {
            if (user.getIsAdmin() == 1 ) {
            	String username = request.getParameter("username");
                String password = request.getParameter("password");
                int isSell = Integer.parseInt(request.getParameter("isSell"));
                int isAdmin = Integer.parseInt(request.getParameter("isAdmin"));

                dao.addAccount(username, password, isSell, isAdmin);

                response.sendRedirect("managerAccount");
            } else {
            	request.getRequestDispatcher("/WEB-INF/views/AccessDenied.jsp").forward(request, response); // Chuyển hướng đến trang từ chối truy cập
            }
        } else {
            response.sendRedirect("login"); // Chuyển hướng đến trang đăng nhập
        }
		
//		String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        int isSell = Integer.parseInt(request.getParameter("isSell"));
//        int isAdmin = Integer.parseInt(request.getParameter("isAdmin"));
//        
//        DAO dao = new DAO();
//        dao.addAccount(username, password, isSell, isAdmin);
//
//        response.sendRedirect("managerAccount");
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
