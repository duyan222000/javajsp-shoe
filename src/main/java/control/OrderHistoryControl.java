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
import entity.Orders;
import entity.Product;

/**
 * Servlet implementation class OrderHistoryControl
 */
@WebServlet(name = "orderHistory", urlPatterns = { "/orderHistory" })
public class OrderHistoryControl extends HttpServlet {
	private DAO dao = new DAO();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc");

        if (user != null) {
            List<Orders> ordersList = dao.getOrdersByUserId(user.getId());
            request.setAttribute("ordersList", ordersList);
            request.getRequestDispatcher("/WEB-INF/views/OrderHistory.jsp").forward(request, response);
        } else {
            response.sendRedirect("login");
        }
		
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
