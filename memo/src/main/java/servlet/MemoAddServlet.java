package servlet;

import java.io.IOException;

import dao.memosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.memo;

public class MemoAddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        // ① セッションから userId を取得
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            // 未ログイン対策
            response.sendRedirect("LoginServlet");
            return;
        }

        // ② フォームの値を取得
        String title = request.getParameter("title");
        String text  = request.getParameter("memo");
        String day   = request.getParameter("date");

        // ③ memo オブジェクト生成
        memo m = new memo(userId, title, text, day);

        // ④ DAO で登録
        memosDAO dao = new memosDAO();
        boolean result = dao.create(m);

        // ⑤ 成功したら一覧へ
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
