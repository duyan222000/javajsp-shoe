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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int orderID = Integer.parseInt(request.getParameter("orderID"));
        Orders order = dao.getOrderById(orderID);
        List<OrderDetails> orderDetails = dao.getOrderDetailsByOrderId(orderID);

        request.setAttribute("order", order);
        request.setAttribute("orderDetails", orderDetails);
        request.getRequestDispatcher("/WEB-INF/views/OrderDetails.jsp").forward(request, response);
    }
}

