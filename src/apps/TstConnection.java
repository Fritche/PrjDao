package apps;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;
//https://github.com/acenelio/jdbc6
public class TstConnection {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			int rows1 = st.executeUpdate("UPDATE seller SET baseSalary=2090 where DepartmentId=1");
			/*int x =1;
			if(x<2) {
				throw new SQLException("Fake Error");
			}*/
			int rows2 = st.executeUpdate("UPDATE seller SET baseSalary=3090 where DepartmentId=2");
			
			// st = conn.prepareStatement("insert into Department (Name) values ('D1'), ('D2')", Statement.RETURN_GENERATED_KEYS);
			
			conn.commit();
			
			//int rowsAffected = st.executeUpdate();
			System.out.println("Rows : " + rows1);
			System.out.println("Rows 2 : " + rows1);
			
			
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transação rolled back: " + e.getMessage());
			} catch (SQLException e1) {				 
				throw new DbException("Erro try rollback: " + e.getMessage());
			}
			
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

}
