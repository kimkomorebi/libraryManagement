package book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookRegister.do")
public class BookRegisterDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookRegisterDoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String booknum = request.getParameter("BOOKNUM");
		String bookname = request.getParameter("BOOKNAME");
		String writer = request.getParameter("WRITER");
		String publisher = request.getParameter("PUBLISHER");
		String price = request.getParameter("PRICE");
		String date = request.getParameter("DATE");
		Book book = new Book();
		book.setId(booknum);
		book.setB_name(bookname);
		book.setA_name(writer);
		book.setPublisher(publisher);
		book.setPrice(Integer.parseInt(price));
		book.setP_date(date);
		DBExpert dbe = new DBExpert();
		boolean result = dbe.putBookInfo(book);
		String searchWriter = dbe.searchWriter(writer);
		boolean result2 = dbe.putBwInfo(booknum, searchWriter);
		System.out.println("선택한 저자의 번호"+searchWriter);
		System.out.println("도서 등록");
		if(result && result2) {
			response.sendRedirect("registerResult.jsp?R=Y");
		}else {
			response.sendRedirect("registerResult.jsp?R=N");
		}
	}

}
