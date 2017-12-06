package dto;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
public class Dto {
	private final String JNDI = "java:comp/env/jdbc/mysql";
	protected Connection connection;

	/**
	 * データベースコネクション取得
	 */
	public Dto() {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup(JNDI);
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
