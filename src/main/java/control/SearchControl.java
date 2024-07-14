package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class SearchControl
 */
@WebServlet(name = "search", urlPatterns = { "/search" })
public class SearchControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String txtSearch = request.getParameter("txt"); // Dùng biến txt trong Menu.jsp => get được chữ user nhập.
		
		// Step 1: Get data from DAO
		DAO dao = new DAO();
		List<Product> list = dao.searchByName(txtSearch);
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLast();
		// Step 2: Push data to JSP page
	
		request.setAttribute("listP", list);    // Push to Home.jsp
		request.setAttribute("listCC", listC);
		request.setAttribute("p", last);
		request.setAttribute("txtS", txtSearch);
		
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);

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
