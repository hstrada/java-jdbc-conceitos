package br.com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class Dao {

	// usada para manter a conexão com o banco de dados
	protected Connection cn;
	// realizar operações no bd
	protected PreparedStatement stmt;
	// referenciar consultas
	protected ResultSet rs;

	private String url = "jdbc:mysql://localhost:3306/dbpedidos";

	protected void abrirConexao() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(url, "root", "fiap");
	}

	protected void fecharConexao() throws Exception {
		// diferente de nulo e não estiver fechado
		if (cn != null && !cn.isClosed()) {
			cn.close();
		}
	}

}
