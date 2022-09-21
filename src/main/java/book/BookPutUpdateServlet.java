package book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookPutUpdateServlet
 */
@WebServlet("/putUpdate.do")
public class BookPutUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookPutUpdateServlet() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		DBExpert dbe = new DBExpert();
		Book book = new Book();
		String id = request.getParameter("ID");
		String b_name = request.getParameter("B_NAME");
		String writer = request.getParameter("WRITER");
		String publisher = request.getParameter("PUBLISHER");
		String price = request.getParameter("PRICE");
		String day = request.getParameter("DAY");
		book.setId(id);
		book.setB_name(b_name);
		book.setA_name(writer);
		book.setPublisher(publisher);
		book.setPrice(Integer.parseInt(price));
		book.setP_date(day);
		boolean result = dbe.putupdateBookInfo(book);
		String searchWriter =  dbe.searchWriter(writer);
		boolean result2 = dbe.putUpdateBw(searchWriter, id);
		System.out.println("업데이트");
		if(result && result2) {
			response.sendRedirect("bookUpdateResult.jsp?R=Y");
		}else {
			response.sendRedirect("bookUpdateResult.jsp?R=N");
		}
	}

}
