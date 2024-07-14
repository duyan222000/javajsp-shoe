package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Cart;

/**
 * Servlet implementation class CheckoutControl
 */
@WebServlet(name = "checkout", urlPatterns = { "/checkout" })
public class CheckoutControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        if (cart != null && !cart.getItems().isEmpty()) {
            request.setAttribute("message", "Your order has been placed successfully!");
            request.setAttribute("cart", cart);
        } else {
            request.setAttribute("message", "Your cart is empty!");
        }
        
        request.getRequestDispatcher("/WEB-INF/views/Checkout.jsp").forward(request, response);
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
