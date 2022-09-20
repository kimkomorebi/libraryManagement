package book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookUpdateDoServlet
 */
@WebServlet("/bookUpdate.do")
public class BookUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdateDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("ID");
		String btn = request.getParameter("BTN");
		DBExpert dbe = new DBExpert();
		if(btn.equals("변경")) {
			Book book = dbe.getUpdateBookList(id);
			ArrayList<String> list = dbe.getWritersName();
			request.setAttribute("B", book);
			request.setAttribute("NAME", list);
			RequestDispatcher rd = request.getRequestDispatcher("bookUpdateList.jsp");
			rd.forward(request, response);
			
		}else if(btn.equals("삭제")) {
			boolean result = dbe.deleteBookList(id);
			if(result) {
				response.sendRedirect("bookDeleteResult.jsp?R=Y");
			}else {
				response.sendRedirect("bookDeleteResult.jsp?R=N");
			}
		}
	}

}
