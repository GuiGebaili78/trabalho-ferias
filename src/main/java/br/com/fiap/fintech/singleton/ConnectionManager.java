package br.com.fiap.fintech.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {

	private static ConnectionManager connectionManager;

	public ConnectionManager() {

	}

	public static ConnectionManager getinstance() {
		if (connectionManager == null) {
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96646", "140378");
		} catch (Exception e) {
			e.printStackTrace();
				
			}
			return connection;
		}
		
		public Connection conectar() {
			return null;
		}
		
	}


