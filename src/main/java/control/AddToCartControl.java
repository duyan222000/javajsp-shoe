package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Cart;
import entity.CartItem;
import entity.Product;

/**
 * Servlet implementation class AddToCartControl
 */
@WebServlet(name = "addtocart", urlPatterns = { "/addtocart" })
public class AddToCartControl extends HttpServlet {
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int productId = Integer.parseInt(request.getParameter("productId"));
        DAO dao = new DAO();
        Product product = dao.getProductByID(productId);
        
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        } 
        CartItem cartItem = new CartItem(product, 1);
        
        cart.addItem(cartItem);
        session.setAttribute("cart", cart);

        response.sendRedirect("cart");
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

//if (product != null) {
//  HttpSession session = request.getSession();
//  Cart cart = (Cart) session.getAttribute("cart");
//  if (cart == null) {
//      cart = new Cart();
//  }
//  cart.addItem(new CartItem(product, quantity));
//  session.setAttribute("cart", cart);
//}

