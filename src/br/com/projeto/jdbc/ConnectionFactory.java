package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.management.RuntimeErrorException;


public class ConnectionFactory {

	public Connection getConnection() {
		
		try {
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas", "usuario", "123");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
