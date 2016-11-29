package br.com.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.jdbc.entity.Clientes;

public class ClientesDao extends Dao {

	// método para incluir um novo cliente
	public void incluirCliente(Clientes cliente) throws Exception {
		try {
			abrirConexao();
			cn.setAutoCommit(false);
			String sql = "INSERT INTO clientes (ID, NOME, EMAIL) VALUES(?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, cliente.getId());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getEmail());
			stmt.executeUpdate();
			cn.commit();
			cn.setAutoCommit(true);
		} catch (Exception e) {
			cn.rollback();
			throw e;
		} finally {
			fecharConexao();
		}
	}

	public Clientes buscarCliente(int id) throws Exception {

		Clientes cliente = null;

		try {
			abrirConexao();
			stmt = cn.prepareStatement("SELECT * FROM CLIENTES WHERE ID = ?");
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				cliente = new Clientes();
				cliente.setId(id);
				cliente.setNome(rs.getString("NOME"));
				cliente.setEmail(rs.getString("EMAIL"));
			}

		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return cliente;
	}

	public List<Clientes> listarClientes() throws Exception {

		List<Clientes> lista = new ArrayList<>();

		try {
			abrirConexao();
			stmt = cn.prepareStatement("SELECT * FROM CLIENTES");

			rs = stmt.executeQuery();

			while (rs.next()) {
				Clientes cliente = new Clientes();
				cliente.setId(rs.getInt("ID"));
				cliente.setNome(rs.getString("NOME"));
				cliente.setEmail(rs.getString("EMAIL"));
				lista.add(cliente);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return lista;
	}

}
