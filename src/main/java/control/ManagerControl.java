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
 * Servlet implementation class ManagerControl
 */
@WebServlet(name = "manager", urlPatterns = { "/manager" })
public class ManagerControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");

		// Get data from DAO
		HttpSession session = request.getSession();
		Account a = (Account) session.getAttribute("acc"); // var acc in session. session.getAttribute return string => TypeCasting to Account.
		int id = a.getId();
		DAO dao = new DAO();
		List<Product> list = dao.getProductBySellID(id);
		List<Category> listC = dao.getAllCategory();
		
		// Push to JSP
		request.setAttribute("listP", list);
		request.setAttribute("listCC", listC);
		request.getRequestDispatcher("/WEB-INF/views/ManagerProduct.jsp").forward(request, response);
		
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
