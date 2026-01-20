package servlet;

import java.io.IOException;

import dao.AccountsDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String pass = request.getParameter("pass");
        String mail = request.getParameter("mail");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        
        Account account = new Account(userId, pass, mail, name, age);

        AccountsDAO dao = new AccountsDAO();
        boolean result = dao.insert(account);
        
        if (result) {
            // 登録成功 → ログインページへ遷移
        	RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
    		dispatcher.forward(request, response);
        } else {
            // エラー → 再表示
            request.setAttribute("error", "登録に失敗しました");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/user_register.jsp");
            rd.forward(request, response);
        }
    }
}

