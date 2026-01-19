package servlet;

import java.io.IOException;
import java.util.List;

import dao.MemosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Memo;



public class MemoMainServlet extends HttpServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        HttpSession session = request.getSession(false);

	        String userId = (String) session.getAttribute("userId");

	        MemosDAO dao = new MemosDAO();
	        List<Memo> memoList = dao.selectmemo(userId);

	        session.setAttribute("memoList", memoList);

	        // JSPへ
	        request.getRequestDispatcher("WEB-INF/jsp/memoList.jsp")
	               .forward(request, response);
	    }
	}
