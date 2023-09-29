package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.WebServiceCep;

public class FornecedoresDAO {

	private Connection con;

	public FornecedoresDAO() {
		this.con = new ConnectionFactory().getConnection();
	}
	// Metodo Cadastrar

	public void cadastrarFornecedores(Fornecedores forn) {

		try {
			// comando sql
			String sql = "insert into tb_fornecedores (nome, cnpj, email, telefone,"
					+ "celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";

			// executar sql e conectar ao bd
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, forn.getNome());
			stmt.setString(2, forn.getCnpj());
			stmt.setString(3, forn.getEmail());
			stmt.setString(4, forn.getTelefone());
			stmt.setString(5, forn.getCelular());
			stmt.setString(6, forn.getCep());
			stmt.setString(7, forn.getEndereco());
			stmt.setInt(8, forn.getNumero());
			stmt.setString(9, forn.getComplemento());
			stmt.setString(10, forn.getBairro());
			stmt.setString(11, forn.getCidade());
			stmt.setString(12, forn.getUf());

			// executa o comando sql
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	// Metodo Alterar
	public void alterarFornecedores(Fornecedores forn) {
		try {
			// comando sql
			String sql = "update tb_fornecedores set nome=?, cnpj=?, email=?,"
					+ "telefone=?, celular=?, cep=?, endereco=?, numero=?, "
					+ "complemento=?, bairro=?, cidade=?, estado=?" + "where id=?";

			// conectar ao bd e preparar o sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, forn.getNome());
			stmt.setString(2, forn.getCnpj());
			stmt.setString(3, forn.getEmail());
			stmt.setString(4, forn.getTelefone());
			stmt.setString(5, forn.getCelular());
			stmt.setString(6, forn.getCep());
			stmt.setString(7, forn.getEndereco());
			stmt.setInt(8, forn.getNumero());
			stmt.setString(9, forn.getComplemento());
			stmt.setString(10, forn.getBairro());
			stmt.setString(11, forn.getCidade());
			stmt.setString(12, forn.getUf());
			stmt.setInt(13, forn.getId());

			// executar e fechar o sql

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());

		}
	}

	// Metodo Excluir
	public void excluirFornecedores(Fornecedores forn) {
		try {
			// preparar o comando sql
			String sql = "delete from tb_fornecedores where id=?";

			// conectar ao bd e preparar o sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, forn.getId());

			// executar e fechar o sql
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	// Metodo busca cep
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

	// metodo listar fornecedores
	public List<Fornecedores> listarFornecedores() {
		// criar a lista
		List<Fornecedores> lista = new ArrayList<Fornecedores>();
		try {
			// preparar o comando sql
			String sql = "select * from tb_fornecedores";
			// conecetar com o bd
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet resultset = stmt.executeQuery();

			while (resultset.next()) {
				Fornecedores forn = new Fornecedores();

				forn.setId(resultset.getInt("id"));
				forn.setNome(resultset.getString("nome"));
				forn.setCnpj(resultset.getString("cnpj"));
				forn.setEmail(resultset.getString("email"));
				forn.setTelefone(resultset.getString("telefone"));
				forn.setCelular(resultset.getString("celular"));
				forn.setCep(resultset.getString("cep"));
				forn.setEndereco(resultset.getString("endereco"));
				forn.setNumero(resultset.getInt("numero"));
				forn.setComplemento(resultset.getString("complemento"));
				forn.setBairro(resultset.getString("bairro"));
				forn.setCidade(resultset.getString("cidade"));
				forn.setUf(resultset.getString("estado"));

				lista.add(forn);
			}
			return lista;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;

		}
	}

	public Fornecedores consultaNome(String nome) {
		try {
			String sql = "select * from tb_fornecedores where nome = ?";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setNString(1, nome);
			ResultSet resultset = stmt.executeQuery();

			Fornecedores forn = new Fornecedores();

			if (resultset.next()) {
				forn.setId(resultset.getInt("id"));
				forn.setNome(resultset.getString("nome"));
				forn.setCnpj(resultset.getString("cnpj"));
				forn.setEmail(resultset.getString("email"));
				forn.setTelefone(resultset.getString("telefone"));
				forn.setCelular(resultset.getString("celular"));
				forn.setCep(resultset.getString("cep"));
				forn.setEndereco(resultset.getString("endereco"));
				forn.setNumero(resultset.getInt("numero"));
				forn.setComplemento(resultset.getString("complemento"));
				forn.setBairro(resultset.getString("bairro"));
				forn.setCidade(resultset.getString("cidade"));
				forn.setUf(resultset.getString("estado"));
			}
			return forn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cliente nao encontrado! " + e.getMessage());
			return null;
		}
	}

	public List<Fornecedores> pesquisarFornecedoresPorNome(String nome) {

		// criar a lista
		List<Fornecedores> lista = new ArrayList<>();
		try {

			// criar o comando sql
			String sql = "select * from tb_fornecedores where nome like ?";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setNString(1, nome);
			ResultSet resultset = stmt.executeQuery();

			while (resultset.next()) {
				Fornecedores forn = new Fornecedores();

				// criar um fonset para forn
				forn.setId(resultset.getInt("id"));
				forn.setNome(resultset.getString("nome"));
				forn.setCnpj(resultset.getString("cnpj"));
				forn.setEmail(resultset.getString("email"));
				forn.setTelefone(resultset.getString("telefone"));
				forn.setCelular(resultset.getString("celular"));
				forn.setCep(resultset.getString("cep"));
				forn.setEndereco(resultset.getString("endereco"));
				forn.setNumero(resultset.getInt("numero"));
				forn.setComplemento(resultset.getString("complemento"));
				forn.setBairro(resultset.getString("bairro"));
				forn.setCidade(resultset.getString("cidade"));
				forn.setUf(resultset.getString("estado"));

				// adiciona fornecedores a lista
				lista.add(forn);

			}
			return lista;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
}
