package br.com.projeto.dao;

import javax.swing.JOptionPane;

import br.com.projeto.model.Clientes;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.WebServiceCep;

public class FornecedoresDAO {

	//Metodo Cadastrar
	
	public void CadastrarFornecedores() {
		
	}
	//Metodo Alterar
	
	
	//Metodo Excluir
	
	
	//Metodo busca cep
	public Fornecedores buscaCep(String cep) {

		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

		Fornecedores fornecedores = new Fornecedores();

		if (webServiceCep.wasSuccessful()) {
			fornecedores.setEndereco(webServiceCep.getLogradouroFull());
			fornecedores.setCidade(webServiceCep.getCidade());
			fornecedores.setBairro(webServiceCep.getBairro());
			fornecedores.setUf(webServiceCep.getUf());
			return fornecedores;
		} else {
			JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
			JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
			return null;
		}
	}
}
