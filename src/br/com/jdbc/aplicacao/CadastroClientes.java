package br.com.jdbc.aplicacao;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.showConfirmDialog;

import br.com.jdbc.dao.ClientesDao;
import br.com.jdbc.entity.Clientes;

import static java.lang.Integer.parseInt;

public class CadastroClientes {

	public static void main(String[] args) {

		while (true) {
			try {
				// Receber dados do usuário
				int id = parseInt(showInputDialog("Informe o ID"));
				String nome = showInputDialog("Informe o nome");
				String email = showInputDialog("Informe o email");

				// Instanciando a classe Clientes
				Clientes cliente = new Clientes();
				cliente.setId(id);
				cliente.setNome(nome);
				cliente.setEmail(email);

				// Incluindo o cliente
				new ClientesDao().incluirCliente(cliente);

				showMessageDialog(null, "Cliente inserido com sucesso");

			} catch (Exception e) {
				showMessageDialog(null, "Erro: " + e.getMessage());

			}
			int opcao = showConfirmDialog(null, "Deseja continuar?", "Confirma", JOptionPane.YES_NO_OPTION);
			if (opcao != JOptionPane.YES_OPTION) {
				break;

			}
		}

	}

}
