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
 * Servlet implementation class CategoryControl
 */
@WebServlet(name = "category", urlPatterns = { "/category" })
public class CategoryControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");

		// Get Category ID
		String cateID = request.getParameter("cid");
		
		
		// Step 1: Get data from DAO
		DAO dao = new DAO();
		List<Product> list = dao.getProductByCID(cateID); // List Product By Category
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLast();

		// Step 2: Push data to JSP page
		
		request.setAttribute("listP", list); // Alter listP by "list"--Product By Category
		request.setAttribute("listCC", listC);
		request.setAttribute("p", last);
		request.setAttribute("tag", cateID);
		
		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);

		// 404 -> url
		// 500 -> jsp properties
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
