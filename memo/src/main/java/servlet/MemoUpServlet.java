package servlet;

import java.io.IOException;

import dao.memosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.memo;

public class MemoUpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            response.sendRedirect("LoginServlet");
            return;
        }

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String text  = request.getParameter("memo");
        String day   = request.getParameter("date");

        memo m = new memo(id, userId, title, text, day);

        memosDAO dao = new memosDAO();
        dao.update(m);

        response.sendRedirect("MemoMainServlet");
    }
}