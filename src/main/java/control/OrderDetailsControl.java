package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.OrderDetails;
import entity.Orders;

/**
 * Servlet implementation class OrderDetailsControl
 */
@WebServlet(name = "orderDetails", urlPatterns = { "/orderDetails" })
public class OrderDetailsControl extends HttpServlet {
    private DAO dao = new DAO(); // Tạo đối tượng DAO

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		int orderID = Integer.parseInt(request.getParameter("orderID"));
        Orders order = dao.getOrderById(orderID);
        List<OrderDetails> orderDetails = dao.getOrderDetailsByOrderId(orderID);

        request.setAttribute("order", order);
        request.setAttribute("orderDetails", orderDetails);
        request.getRequestDispatcher("/WEB-INF/views/OrderDetails.jsp").forward(request, response);
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

