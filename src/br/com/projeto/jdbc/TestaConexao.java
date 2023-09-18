package br.com.projeto.jdbc;

import javax.swing.JOptionPane;

public class TestaConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new ConnectionFactory().getConnection();
			JOptionPane.showMessageDialog(null,"conexao com sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "conexao nao efetuada: "+e.getMessage());
		}
	}

}
