package br.com.jdbc.aplicacao;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.jdbc.dao.ClientesDao;
import br.com.jdbc.entity.Clientes;

public class ConsultaClientes {

	public static void main(String[] args) {

		try {
			while (true) {

				String opcao = (String) JOptionPane.showInputDialog(null, "Escolha uma opção: ", "Opções",
						JOptionPane.DEFAULT_OPTION, null, new String[] { "Listar", "Buscar", "Sair" }, "Listar");

				switch (opcao) {
				case "Listar": {
					List<Clientes> clientes = new ClientesDao().listarClientes();
					for (Clientes cliente : clientes) {
						System.out.println("ID: " + cliente.getId());
						System.out.println("Nome: " + cliente.getNome());
						System.out.println("Email: " + cliente.getEmail());
						System.out.println("---------------##---------------");
					}
				}
					;
					break;
				case "Buscar": {
					int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do cliente:"));
					Clientes cliente = new ClientesDao().buscarCliente(id);
					if (cliente == null) {
						JOptionPane.showMessageDialog(null, "Nenhum cliente com este id");
					} else {
						System.out.println("ID: " + cliente.getId());
						System.out.println("Nome: " + cliente.getNome());
						System.out.println("Email: " + cliente.getEmail());
						System.out.println("---------------##---------------");
					}
				}
					;
					break;
				case "Sair": {
					System.exit(0);
				}
					;
					break;
				default:
					System.exit(0);
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}

	}

}
