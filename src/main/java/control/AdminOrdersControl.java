package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Orders;

/**
 * Servlet implementation class AdminOrdersControl
 */
@WebServlet(name = "adminOrders", urlPatterns = { "/adminOrders" })
public class AdminOrdersControl extends HttpServlet {
    private DAO dao = new DAO(); // Tạo đối tượng DAO

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Orders> ordersList = dao.getAllOrders();
        request.setAttribute("ordersList", ordersList);
        request.getRequestDispatcher("/WEB-INF/views/AdminOrders.jsp").forward(request, response);
    }
}
