package servlet;

import java.io.IOException;

import dao.MemosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Memo;

public class MemoUpdateServlet extends HttpServlet {

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

        Memo m = new Memo(id, userId, title, text, day);

        MemosDAO dao = new MemosDAO();
        dao.update(m);

        response.sendRedirect("MemoMainServlet");
    }
}