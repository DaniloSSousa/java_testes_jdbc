package br.com.alura.jdbc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDao {
	private Connection cnn;

	public ContaDao() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			this.cnn = DriverManager.getConnection(
			  "jdbc:mysql://localhost/alura_jdbc?useTimezone=true&serverTimezone=UTC", "root", "414925"
			);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Conta conta) {
		try {
			String sql = "insert into conta(agencia, numero, titular) values (?, ?, ?)";
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setLong(1, conta.getAgencia());
			ps.setLong(2, conta.getNumero());
			ps.setString(3, conta.getTitular());
			
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
