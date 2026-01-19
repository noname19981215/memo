package servlet;

import java.io.IOException;

import dao.MemosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Memo;

public class MemoEdiServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("LoginServlet");
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));

        MemosDAO dao = new MemosDAO();
        Memo m = dao.findById(id, userId);

        if (m == null) {
            response.sendRedirect("MemoMainServlet");
            return;
        }

        request.setAttribute("memo", m);
        request.getRequestDispatcher(
            "WEB-INF/jsp/MemoEdit.jsp"
        ).forward(request, response);
    }
}