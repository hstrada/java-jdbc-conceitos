package br.com.jdbc.aplicacao;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.parseInt;

import javax.swing.JOptionPane;

import br.com.jdbc.dao.ClientesDao;
import br.com.jdbc.dao.PedidosDao;
import br.com.jdbc.entity.Clientes;
import br.com.jdbc.entity.Pedidos;

import static javax.swing.JOptionPane.showConfirmDialog;

public class CadastroPedidos {

	public static void main(String[] args) {

		List<Clientes> listaClientes = null;
		try {
			listaClientes = new ClientesDao().listarClientes();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		while (true) {

			try {

				int id = parseInt(showInputDialog("Informe o ID: "));
				String dataString = showInputDialog("Informe a Data: ");
				Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
				String descricao = showInputDialog("Descrição: ");
				double valor = Double.parseDouble(showInputDialog("Valor do pedido: "));
				// solicitando o código do cliente
				Clientes cliente = (Clientes) showInputDialog(null, "Selecione o cliente: ", "Clientes",
						JOptionPane.DEFAULT_OPTION, null, listaClientes.toArray(), null);

				// Instanciando a classe pedidos
				Pedidos pedido = new Pedidos();
				pedido.setId(id);
				pedido.setIdCliente(cliente.getId());
				pedido.setData(data);
				pedido.setDescricao(descricao);
				pedido.setValor(valor);

				// Incluindo o novo pedido
				new PedidosDao().incluirPedido(pedido);
				showMessageDialog(null, "Pedido incluído com sucesso.");

			} catch (Exception e) {
				showMessageDialog(null, "ERRO: " + e.getMessage());
			}

			int opcao = showConfirmDialog(null, "Deseja continuar?", "Confirma", JOptionPane.YES_NO_OPTION);
			if (opcao != JOptionPane.YES_OPTION) {
				break;
			}

		}

	}

}
