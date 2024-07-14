package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Cart;
import entity.CartItem;

/**
 * Servlet implementation class CartControl
 */
@WebServlet(name = "cart", urlPatterns = { "/cart"})
public class CartControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        
        String productIdParam = request.getParameter("productId");
        String action = request.getParameter("action");
        // Test
        System.out.println("ProductId: " + productIdParam);
        System.out.println("Action: " + action);

        if (productIdParam != null && action != null) {
            int productId = Integer.parseInt(productIdParam);
            if ("remove".equals(action)) {
                cart.removeItem(productId);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print("{\"cartTotal\": \"" + cart.getTotalPrice() + "\"}");
                out.flush();
            } else {
                for (CartItem item : cart.getItems()) {
                    if (item.getProduct().getId() == productId) {
                        if ("increase".equals(action)) {
                            item.setQuantity(item.getQuantity() + 1);
                        } else if ("decrease".equals(action) && item.getQuantity() > 1) {
                            item.setQuantity(item.getQuantity() - 1);
                        }
                        break;
                    }
                }
            }
            
            session.setAttribute("cart", cart);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            double totalPrice = cart.getTotalPrice();
            CartItem item = cart.getItems().stream().filter(ci -> ci.getProduct().getId() == productId).findFirst().orElse(null);
            if (item != null) {
                double itemTotalPrice = item.getTotalPrice();
                response.getWriter().write("{\"quantity\": " + item.getQuantity() + ", \"totalPrice\": " + itemTotalPrice + ", \"cartTotal\": " + totalPrice + "}");
            }
            return;
        }

        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/WEB-INF/views/Cart.jsp").forward(request, response);

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
