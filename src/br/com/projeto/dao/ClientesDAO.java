package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.WebServiceCep;

public class ClientesDAO {

	public Connection con;

	public ClientesDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	// Metodo cadastrarCliente

	public void cadastrarCliente(Clientes clientes) {

		try {
			// criar o comando sql
			String sql = "insert into tb_clientes(nome, rg, cpf, email, telefone, celular, "
					+ "cep, endereco, numero, complemento, bairro, cidade, estado) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, clientes.getNome());
			stmt.setString(2, clientes.getRg());
			stmt.setString(3, clientes.getCpf());
			stmt.setString(4, clientes.getEmail());
			stmt.setString(5, clientes.getTelefone());
			stmt.setString(6, clientes.getCelular());
			stmt.setString(7, clientes.getCep());
			stmt.setString(8, clientes.getEndereco());
			stmt.setInt(9, clientes.getNumero());
			stmt.setString(10, clientes.getComplemento());
			stmt.setString(11, clientes.getBairro());
			stmt.setString(12, clientes.getCidade());
			stmt.setString(13, clientes.getUf());

			// executar o comando sql
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	// Metodo alterarCliente

	public void alterarCliente(Clientes clientes) {
		try {
			// criar o comando sql
			String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, "
					+ "cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?" + "where id=?";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, clientes.getNome());
			stmt.setString(2, clientes.getRg());
			stmt.setString(3, clientes.getCpf());
			stmt.setString(4, clientes.getEmail());
			stmt.setString(5, clientes.getTelefone());
			stmt.setString(6, clientes.getCelular());
			stmt.setString(7, clientes.getCep());
			stmt.setString(8, clientes.getEndereco());
			stmt.setInt(9, clientes.getNumero());
			stmt.setString(10, clientes.getComplemento());
			stmt.setString(11, clientes.getBairro());
			stmt.setString(12, clientes.getCidade());
			stmt.setString(13, clientes.getUf());
			stmt.setInt(14, clientes.getId());

			// executar o comando sql
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	// Metodo excluirCliente
	public void excluirCliente(Clientes clientes) {
		try {
			// criar o comando sql
			String sql = "delete from tb_clientes where id=?";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, clientes.getId());
			;

			// executar o comando sql
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	// Metodo listar clientes

	public List<Clientes> listarClientes() {

		// criar a lista
		List<Clientes> lista = new ArrayList<>();

		try {
			// criar o comando sql
			String sql = "select * from Tb_clientes";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				// criar um cliente set cliente
				Clientes clientes = new Clientes();

				clientes.setId(resultSet.getInt("id"));
				clientes.setNome(resultSet.getString("nome"));
				clientes.setRg(resultSet.getString("rg"));
				clientes.setCpf(resultSet.getString("cpf"));
				clientes.setEmail(resultSet.getString("email"));
				clientes.setTelefone(resultSet.getString("telefone"));
				clientes.setCelular(resultSet.getString("celular"));
				clientes.setCep(resultSet.getString("cep"));
				clientes.setEndereco(resultSet.getString("endereco"));
				clientes.setNumero(resultSet.getInt("numero"));
				clientes.setComplemento(resultSet.getString("complemento"));
				clientes.setBairro(resultSet.getString("bairro"));
				clientes.setCidade(resultSet.getString("cidade"));
				clientes.setUf(resultSet.getString("estado"));

				// adicionar o cliente à lista
				lista.add(clientes);
			}
			return lista;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

	}

	// Metodo pesquisar clientes por nome

	public List<Clientes> pesquisarClientesPorNome(String nome) {

		// criar a lista
		List<Clientes> lista = new ArrayList<>();

		try {
			// criar o comando sql
			String sql = "select * from Tb_clientes where nome like ?";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setNString(1, nome);
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				// criar um clienteseto cliente
				Clientes clientes = new Clientes();

				clientes.setId(resultSet.getInt("id"));
				clientes.setNome(resultSet.getString("nome"));
				clientes.setRg(resultSet.getString("rg"));
				clientes.setCpf(resultSet.getString("cpf"));
				clientes.setEmail(resultSet.getString("email"));
				clientes.setTelefone(resultSet.getString("telefone"));
				clientes.setCelular(resultSet.getString("celular"));
				clientes.setCep(resultSet.getString("cep"));
				clientes.setEndereco(resultSet.getString("endereco"));
				clientes.setNumero(resultSet.getInt("numero"));
				clientes.setComplemento(resultSet.getString("complemento"));
				clientes.setBairro(resultSet.getString("bairro"));
				clientes.setCidade(resultSet.getString("cidade"));
				clientes.setUf(resultSet.getString("estado"));

				// adicionar o cliente à lista
				lista.add(clientes);
			}
			return lista;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

	}

	public Clientes consultaNome(String nome) {

		try {
			// criar o comando sql
			String sql = "select * from Tb_clientes where nome = ?";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setNString(1, nome);
			ResultSet resultSet = stmt.executeQuery();

			// criar um clienteseto cliente
			Clientes clientes = new Clientes();
			if (resultSet.next()) {
				clientes.setId(resultSet.getInt("id"));
				clientes.setNome(resultSet.getString("nome"));
				clientes.setRg(resultSet.getString("rg"));
				clientes.setCpf(resultSet.getString("cpf"));
				clientes.setEmail(resultSet.getString("email"));
				clientes.setTelefone(resultSet.getString("telefone"));
				clientes.setCelular(resultSet.getString("celular"));
				clientes.setCep(resultSet.getString("cep"));
				clientes.setEndereco(resultSet.getString("endereco"));
				clientes.setNumero(resultSet.getInt("numero"));
				clientes.setComplemento(resultSet.getString("complemento"));
				clientes.setBairro(resultSet.getString("bairro"));
				clientes.setCidade(resultSet.getString("cidade"));
				clientes.setUf(resultSet.getString("estado"));

			}
			return clientes;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cliente nao encontrado! " + e.getMessage());
			return null;
		}

	}

	// busca cep
	public Clientes buscaCep(String cep) {

		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

		Clientes clientes = new Clientes();

		if (webServiceCep.wasSuccessful()) {
			clientes.setEndereco(webServiceCep.getLogradouroFull());
			clientes.setCidade(webServiceCep.getCidade());
			clientes.setBairro(webServiceCep.getBairro());
			clientes.setUf(webServiceCep.getUf());
			return clientes;
		} else {
			JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
			JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
			return null;
		}

	}

}
