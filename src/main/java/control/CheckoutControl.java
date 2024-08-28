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

/**
 * Servlet implementation class CheckoutControl
 */
@WebServlet(name = "checkout", urlPatterns = { "/checkout" })
public class CheckoutControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("acc"); 
        DAO dao = new DAO();
        
        if (user != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            
            if (cart != null && !cart.getItems().isEmpty()) {
                request.setAttribute("message", "Your order has been placed successfully!");
                request.setAttribute("cart", cart);
            } else {
                request.setAttribute("message", "Your cart is empty!");
            }
            
            request.getRequestDispatcher("/WEB-INF/views/Checkout.jsp").forward(request, response);
        } else {
            response.sendRedirect("login"); // Chuyển hướng đến trang đăng nhập
        }
		
		
//        HttpSession session = request.getSession();
//        Cart cart = (Cart) session.getAttribute("cart");
//        
//        if (cart != null && !cart.getItems().isEmpty()) {
//            request.setAttribute("message", "Your order has been placed successfully!");
//            request.setAttribute("cart", cart);
//        } else {
//            request.setAttribute("message", "Your cart is empty!");
//        }
//        
//        request.getRequestDispatcher("/WEB-INF/views/Checkout.jsp").forward(request, response);
    }

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
