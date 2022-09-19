package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBExpert {
	final String driver = "oracle.jdbc.OracleDriver";
	final String url ="jdbc:oracle:thin:@localhost:1521/xe";
	
	public ArrayList<Book> getAllBook() {
		String select = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			
		}catch(Exception e) {
			
		}finally {
			try {
				
			}catch(Exception e) {}
		}
		return list;
	}
}
