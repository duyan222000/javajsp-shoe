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
 * Servlet implementation class AddControl
 */
@WebServlet(name = "add", urlPatterns = { "/add" })
public class AddControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc"); 
        DAO dao = new DAO();
        
        if (user != null) {
            if (user.getIsAdmin() == 1 || user.getIsSell() == 1 ) {

        		String pname = request.getParameter("name");
        		String pimage = request.getParameter("image");
        		String pprice = request.getParameter("price");
        		String ptitle = request.getParameter("title");
        		String pdescription = request.getParameter("description");
        		String pCategory = request.getParameter("category");
        		// Get sell_ID: ID of seller
        		int sid = user.getId();
        		
        		// Get data from DAO
        		dao.insertProduct(pname, pimage, pprice, ptitle, pdescription, pCategory, sid);

        		response.sendRedirect("manager");
            } else {
            	request.getRequestDispatcher("/WEB-INF/views/AccessDenied.jsp").forward(request, response); // Chuyển hướng đến trang từ chối truy cập
            }
        } else {
            response.sendRedirect("login"); // Chuyển hướng đến trang đăng nhập
        }
		
//		
//		String pname = request.getParameter("name");
//		String pimage = request.getParameter("image");
//		String pprice = request.getParameter("price");
//		String ptitle = request.getParameter("title");
//		String pdescription = request.getParameter("description");
//		String pCategory = request.getParameter("category");
//		// Get sell_ID: ID of seller
//		HttpSession session = request.getSession();
//		Account a = (Account) session.getAttribute("acc");
//		int sid = a.getId();
//		
//		// Get data from DAO
//		DAO dao = new DAO();
//		dao.insertProduct(pname, pimage, pprice, ptitle, pdescription, pCategory, sid);
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
