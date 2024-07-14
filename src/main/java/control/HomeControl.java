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
 * Servlet implementation class HomeControl
 */
//@WebServlet("/home")
@WebServlet(name = "HomeControl", urlPatterns = { "/home" })
public class HomeControl extends HttpServlet {

//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//
//		// Step 1: Get data from DAO
//		DAO dao = new DAO();
//		List<Product> list = dao.getAllProduct();
//		List<Category> listC = dao.getAllCategory();
//		Product last = dao.getLast();
//
//
//		// Step 2: Push data to JSP page
//		request.setAttribute("listP", list);
//		request.setAttribute("listCC", listC);
//		request.setAttribute("p", last);
//		
//		
//		request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
//
//
//		// 404 -> url
//		// 500 -> jsp properties
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//		processRequest(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		doGet(request, response);
//		processRequest(request, response);
//	}
//
//}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int page = 1;
        int pageSize = 9;

        if (request.getParameter("page") != null) {
            try {
                page = Integer.parseInt(request.getParameter("page"));
            } catch (NumberFormatException e) {
                page = 1; // default to first page if parsing fails
            }
        }

        DAO dao = new DAO();
        List<Product> list = dao.getProductsByPage(page, pageSize);
        List<Category> listC = dao.getAllCategory();
        Product last = dao.getLast();
        int totalProducts = dao.getTotalProductCount();
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        request.setAttribute("listP", list);
        request.setAttribute("listCC", listC);
        request.setAttribute("p", last);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}