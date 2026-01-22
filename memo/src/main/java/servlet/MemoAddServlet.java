package servlet;

import java.io.IOException;

import dao.MemosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Memo;

public class MemoAddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // セッションから userId を取得
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            // 未ログイン対策
            response.sendRedirect("LoginServlet");
            return;
        }

        // フォームの値を取得
        String title = request.getParameter("title");
        String text  = request.getParameter("memo");
        String day   = request.getParameter("date");

        // memo オブジェクト生成
        Memo m = new Memo(userId, title, text, day);

        // DAO で登録
        MemosDAO dao = new MemosDAO();
        boolean result = dao.create(m);

        // 成功したら一覧へ
        if (result) {
            response.sendRedirect("MemoMainServlet");
        } else {
            request.setAttribute("errorMsg", "メモの登録に失敗しました");
            request.getRequestDispatcher(
                "WEB-INF/jsp/MemoRegistration.jsp"
            ).forward(request, response);
        }
    }
}
