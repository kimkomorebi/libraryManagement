package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBExpert {
	final String driver = "oracle.jdbc.OracleDriver";
	final String url ="jdbc:oracle:thin:@localhost:1521/xe";
	
	public ArrayList<Book> getAllBook() {
		String select = "select b.id, b.name, w.name, b.publisher, b.price, b.p_date"
				+ " from books_tbl b, writers_tbl w, bw_tbl b"
				+ " where b.w_no = w.no"
				+ " and b.b_id = b.id";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<Book>();
		Book book = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new Book();
				book.setId(rs.getString(1));
				
			}
		}catch(Exception e) {
			
		}finally {
			try {
				
			}catch(Exception e) {}
		}
		return list;
	}
}
