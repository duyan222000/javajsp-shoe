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
import entity.Comment;
import entity.Product;
import entity.Rating;

/**
 * Servlet implementation class DetailControl
 */
@WebServlet(name = "detail", urlPatterns = { "/detail" })
public class DetailControl extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");

		// Get Category ID
		String id = request.getParameter("pid"); // "pid tự đặt trong file Home.jsp chỉ các product: href="detail?pid=${o.id}"
		
		// Step 1: Get data from DAO
		DAO dao = new DAO();
		Product p = dao.getProductByID(id);
		List<Product> list = dao.getAllProduct();
		List<Category> listC = dao.getAllCategory();
		Product last = dao.getLast();
		
		// Get ratings and comments for product
        List<Rating> ratings = dao.getRatingsByProductId(Integer.parseInt(id));
        List<Comment> comments = dao.getCommentsByProductId(Integer.parseInt(id));
        
        // AVG rating 
        double avgRating = dao.getAverageRating(Integer.parseInt(id));
        
        //
		
		// Step 2: Push data to JSP page
		request.setAttribute("detail", p);
		request.setAttribute("listP", list);
		request.setAttribute("listCC", listC);
		request.setAttribute("p", last);
		request.setAttribute("ratings", ratings);
        request.setAttribute("comments", comments);
        request.setAttribute("avgRating", avgRating);
        
		request.getRequestDispatcher("/WEB-INF/views/Detail.jsp").forward(request, response);
		
		// Push ratings and comments to JSP page

		
		
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
