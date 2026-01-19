package servlet;

import java.io.IOException;

import dao.MemosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MemoDelServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("LoginServlet");
            return;
        }

        int memoId = Integer.parseInt(request.getParameter("id"));

        MemosDAO dao = new MemosDAO();
        dao.delete(memoId, userId);

        response.sendRedirect("MemoMainServlet");
    }
}