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
import entity.Cart;
import entity.CartItem;
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class ConfirmPurchaseControl
 */
@WebServlet(name = "confirmPurchase", urlPatterns = { "/confirmPurchase" })
public class ConfirmPurchaseControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String couponName = request.getParameter("couponName");
        double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
        
        DAO dao = new DAO();
        
        int couponID = dao.getCouponIdByName(couponName);
        // Lấy đối tượng Cart từ session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
//        if (cart == null || cart.getItems().isEmpty()) {
//            response.sendRedirect("checkout");
//            return;
//        }
		
        Account account = (Account) session.getAttribute("acc");
        int userID = account.getId();
        
        int orderID = dao.saveOrder(userID, name, phone, couponID, totalAmount);
        
        if (orderID > 0) {
            // Lưu chi tiết đơn hàng
            dao.saveOrderDetails(orderID, cart);
            // Xóa giỏ hàng
            session.removeAttribute("cart");
            // Chuyển hướng đến trang xác nhận thành công
            request.setAttribute("message", "Your order has been placed successfully!");
            request.getRequestDispatcher("/WEB-INF/views/ConfirmPurchase.jsp").forward(request, response);
        } else {
            // Xử lý lỗi khi lưu đơn hàng
            request.setAttribute("message", "Failed to place the order. Please try again.");
            request.getRequestDispatcher("/WEB-INF/views/Home.jsp").forward(request, response);
        }
		
		
		
		
//		String _name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
		
//        request.setAttribute("name", _name);
		
//		request.getRequestDispatcher("/WEB-INF/views/ConfirmPurchase.jsp").forward(request, response);
		
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
