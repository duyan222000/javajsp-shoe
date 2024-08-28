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
 * Servlet implementation class EditControl
 */
@WebServlet(name = "edit", urlPatterns = { "/edit" })
public class EditControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc"); 
        DAO dao = new DAO();
        
		if (user != null) {
            if (user.getIsAdmin() == 1 || user.getIsSell() == 1) {
            	String pid = request.getParameter("id");
        		String pname = request.getParameter("name");
        		String pimage = request.getParameter("image");
        		String pprice = request.getParameter("price");
        		String ptitle = request.getParameter("title");
        		String pdescription = request.getParameter("description");
        		String pCategory = request.getParameter("category");
        		
        		// Get data from DAO
        		dao.editProduct(pname, pimage, pprice, ptitle, pdescription, pCategory, pid);

        		response.sendRedirect("manager");
            } else {
            	request.getRequestDispatcher("/WEB-INF/views/AccessDenied.jsp").forward(request, response); // Chuyển hướng đến trang từ chối truy cập
            }
        } else {
            response.sendRedirect("login"); // Chuyển hướng đến trang đăng nhập
        }
		
//		String pid = request.getParameter("id");
//		String pname = request.getParameter("name");
//		String pimage = request.getParameter("image");
//		String pprice = request.getParameter("price");
//		String ptitle = request.getParameter("title");
//		String pdescription = request.getParameter("description");
//		String pCategory = request.getParameter("category");
//		
//		// Get data from DAO
//		DAO dao = new DAO();
//		dao.editProduct(pname, pimage, pprice, ptitle, pdescription, pCategory, pid);
//
//		response.sendRedirect("manager");
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
