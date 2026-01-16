
package servlet;

import java.io.IOException;
import java.util.List;

import dao.memosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.memo;

public class MemoSearchUpServlet extends HttpServlet {

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
        
        String memo  = request.getParameter("memo");

        memosDAO dao = new memosDAO();
        List<memo> memoList = dao.searchmemo(userId,memo);

        session.setAttribute("memoList", memoList);
       

        // JSPへ
        request.getRequestDispatcher("WEB-INF/jsp/memoList.jsp")
        .forward(request, response);
    }
}
