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



public class MemoMainServlet extends HttpServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        HttpSession session = request.getSession(false);

	        String userId = (String) session.getAttribute("userId");

	        memosDAO dao = new memosDAO();
	        List<memo> memoList = dao.selectmemo(userId);

	        session.setAttribute("memoList", memoList);

	        // JSPへ
	        request.getRequestDispatcher("WEB-INF/jsp/memoList.jsp")
	               .forward(request, response);
	    }
	}
