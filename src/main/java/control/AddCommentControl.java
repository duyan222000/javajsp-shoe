package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Account;


@WebServlet(name = "addComment", urlPatterns = { "/addComment" })
public class AddCommentControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        int productId = Integer.parseInt(request.getParameter("productId"));
//        int userId = (int) request.getSession().getAttribute("userId"); // Assume userId stored session after login
//        int rating = Integer.parseInt(request.getParameter("rating"));
//        String comment = request.getParameter("comment");
//
//        DAO dao = new DAO();
//        dao.addRating(productId, userId, rating);
//        dao.addComment(productId, userId, comment);
//
//        response.sendRedirect("detail?pid=" + productId);
    	response.setContentType("text/html;charset=UTF-8");

        // Lấy giá trị từ request
    	int productId = Integer.parseInt(request.getParameter("productId"));
        String comment = request.getParameter("comment");
        int rating = Integer.parseInt(request.getParameter("rating"));

        // Lấy Account từ session
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("acc");

        if (account == null) {
            response.sendRedirect("login"); // Chuyển hướng người dùng đến trang đăng nhập nếu account là null
            return;
        }

        int userId = account.getId();

        // Gọi DAO để thêm comment
        DAO dao = new DAO();
        dao.addComment(productId, userId, comment);
        dao.addRating(productId, userId, rating);

        // Chuyển hướng lại trang chi tiết sản phẩm
        response.sendRedirect("detail?pid=" + productId);
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
