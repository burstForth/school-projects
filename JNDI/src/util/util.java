package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class util {
		private Connection conn;
		
		public Connection getConnection() {
			conn=null;
	         try {
				Context ctx = new InitialContext();
				DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/jndi");//ÎªÁËJNDI½âÎö
		        conn = ds.getConnection();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         return conn;
		}
		public void closeAll(Connection conn,PreparedStatement pa,ResultSet rs) {
			
				try {
					if(conn!=null) {
					conn.close();
					}
					if(pa!=null) {
						pa.close();
					}
					if(rs!=null) {
						rs.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
			}
		}
}
	