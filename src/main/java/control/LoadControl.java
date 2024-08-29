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
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class LoadControl
 */
@WebServlet(name = "load", urlPatterns = { "/loadProduct" })
public class LoadControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc"); 
        DAO dao = new DAO();
        
		if (user != null) {
            if (user.getIsAdmin() == 1 || user.getIsSell() == 1) {
            	String id = request.getParameter("pid");
        		Product p = dao.getProductByID(id);
        		List<Category> listC = dao.getAllCategory();
        		
        		
        		request.setAttribute("detail", p);
        		request.setAttribute("listCC", listC);
        		request.getRequestDispatcher("/WEB-INF/views/Edit.jsp").forward(request, response);
            } else {
            	request.getRequestDispatcher("/WEB-INF/views/AccessDenied.jsp").forward(request, response); // Chuyển hướng đến trang từ chối truy cập
            }
        } else {
            response.sendRedirect("login"); // Chuyển hướng đến trang đăng nhập
        }
		
//		String id = request.getParameter("pid");
//		DAO dao = new DAO();
//		Product p = dao.getProductByID(id);
//		List<Category> listC = dao.getAllCategory();
//		
//		
//		request.setAttribute("detail", p);
//		request.setAttribute("listCC", listC);
//		request.getRequestDispatcher("/WEB-INF/views/Edit.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		processRequest(request, response);
	}
	
}
