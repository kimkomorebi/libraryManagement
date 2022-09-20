package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBExpert {
	final String driver = "oracle.jdbc.OracleDriver";
	final String url ="jdbc:oracle:thin:@localhost:1521/xe";
	
	
	
	public boolean putBwInfo(String booknum, String writer) {
		String insert = "insert into bw_tbl values(?,?)";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result2 = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, booknum);
			pstmt.setString(2, writer);
			pstmt.executeUpdate();
			result2 = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result2;
	}
	
	public String searchWriter(String writer) {
		String select = "select no from writers_tbl where name =?";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null; // 찾은 저자 반환할 변수
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, writer);
			rs = pstmt.executeQuery();
			if(rs.next()) result = rs.getString(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public boolean putBookInfo(Book b) {
		String insert = "insert into books_tbl values(?, ?, ?, ?, to_date(?, 'YYYYMMDD'))";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, b.getId());
			pstmt.setString(2, b.getB_name());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());
			pstmt.setString(5, b.getP_date());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public ArrayList<String> getWritersName () {
		String select = "select name from writers_tbl";
		ArrayList<String> list = new ArrayList<String>();
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				list.add(name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<Book> getAllBook() {
		String select = "select b.id, b.name, w.name, b.publisher, b.price, to_char(b.p_date, 'YYYY/MM/DD')"
				+ " from books_tbl b, writers_tbl w, bw_tbl bw"
				+ " where bw.w_no = w.no"
				+ " and bw.b_id = b.id";
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
				book.setB_name(rs.getString(2));
				book.setA_name(rs.getString(3));
				book.setPublisher(rs.getString(4));
				book.setPrice(rs.getInt(5));
				book.setP_date(rs.getString(6));
				list.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
}
