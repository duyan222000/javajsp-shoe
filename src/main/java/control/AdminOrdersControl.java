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
import entity.Orders;

/**
 * Servlet implementation class AdminOrdersControl
 */
@WebServlet(name = "adminOrders", urlPatterns = { "/adminOrders" })
public class AdminOrdersControl extends HttpServlet {
    private DAO dao = new DAO(); // Tạo đối tượng DAO

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc"); 
        DAO dao = new DAO();
        
        if (user != null) {
            if (user.getIsAdmin() == 1 ) {
            	List<Orders> ordersList = dao.getAllOrders();
                request.setAttribute("ordersList", ordersList);
                request.getRequestDispatcher("/WEB-INF/views/AdminOrders.jsp").forward(request, response);
            } else {
            	request.getRequestDispatcher("/WEB-INF/views/AccessDenied.jsp").forward(request, response); // Chuyển hướng đến trang từ chối truy cập
            }
        } else {
            response.sendRedirect("login"); // Chuyển hướng đến trang đăng nhập
        }
//		List<Orders> ordersList = dao.getAllOrders();
//        request.setAttribute("ordersList", ordersList);
//        request.getRequestDispatcher("/WEB-INF/views/AdminOrders.jsp").forward(request, response);
    }
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        List<Orders> ordersList = dao.getAllOrders();
//        request.setAttribute("ordersList", ordersList);
//        request.getRequestDispatcher("/WEB-INF/views/AdminOrders.jsp").forward(request, response);
//    }
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
