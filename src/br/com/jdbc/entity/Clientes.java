package br.com.jdbc.entity;

import java.io.Serializable;
import java.util.List;

public class Clientes implements Serializable {

	private int id;
	private String nome;
	private String email;
	private List<Pedidos> pedidos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		// return "Clientes [id=" + id + ", nome=" + nome + "]";
		return this.getId() + " - " + this.getNome();
	}

}
