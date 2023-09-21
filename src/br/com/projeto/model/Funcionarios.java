package br.com.projeto.model;

public class Funcionarios extends Clientes {

	//Atributos
	private String senha;
	private String cargo;
	private String nivelAcesso;
	
	//Metodo getter e setter
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNivelAcesso() {
		return nivelAcesso;
	}
	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}
}
