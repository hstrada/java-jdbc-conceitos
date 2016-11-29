package br.com.jdbc.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.jdbc.entity.Pedidos;

public class PedidosDao extends Dao {

	// método para um incluir um pedido
	public void incluirPedido(Pedidos pedido) throws Exception {
		try {
			abrirConexao();
			stmt = cn.prepareStatement("INSERT INTO PEDIDOS(ID, IDCLIENTE, DATA, DESCRICAO, VALOR) VALUES (?,?,?,?,?)");
			stmt.setInt(1, pedido.getId());
			stmt.setInt(2, pedido.getIdCliente());
			// retorna a data e hora em formato numérico
			stmt.setDate(3, new java.sql.Date(pedido.getData().getTime()));
			stmt.setString(4, pedido.getDescricao());
			stmt.setDouble(5, pedido.getValor());
			stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}

	// método para listar pedidos de um determinado cliente
	public List<Pedidos> listarPedidos(int idCliente) throws Exception {

		List<Pedidos> lista = new ArrayList<>();

		try {
			abrirConexao();

			stmt = cn.prepareStatement("SELECT * FROM PEDIDOS WHERE IDCLIENTE = ?");
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Pedidos pedido = new Pedidos();
				pedido.setId(rs.getInt("ID"));
				pedido.setIdCliente(idCliente);
				pedido.setData(rs.getDate("DATA"));
				pedido.setDescricao(rs.getString("DESCRICAO"));
				pedido.setValor(rs.getDouble("VALOR"));
				lista.add(pedido);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}

		return lista;

	}

}
