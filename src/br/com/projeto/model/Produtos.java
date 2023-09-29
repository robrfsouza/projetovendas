package br.com.projeto.model;

public class Produtos {

	// Atributos
	private String descricao;
	private int id;
	private int qtdEstoque;
	private double preco;
	private Fornecedores fornecedores;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(int qdtEstoque) {
		this.qtdEstoque = qdtEstoque;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Fornecedores getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	// Metodos getters e setters
	
}
