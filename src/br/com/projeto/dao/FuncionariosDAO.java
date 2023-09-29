package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.WebServiceCep;
import br.com.projeto.view.FrmLogin;
import br.com.projeto.view.FrmPrincipal;

public class FuncionariosDAO {

	// declarar atributo
	public Connection con;

	// metodo construtor
	public FuncionariosDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	// metodo cadastrar funcionario
	public void cadastrarFuncionario(Funcionarios funcionarios) {
		try {
			// criar comando sql
			String sql = "insert into tb_funcionarios(nome, rg, cpf, email, senha, cargo, "
					+ "nivel_acesso, telefone, celular, cep, endereco, numero, "
					+ "complemento, bairro, cidade, estado) " + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, funcionarios.getNome());
			stmt.setString(2, funcionarios.getRg());
			stmt.setString(3, funcionarios.getCpf());
			stmt.setString(4, funcionarios.getEmail());
			stmt.setString(5, funcionarios.getSenha());
			stmt.setString(6, funcionarios.getCargo());
			stmt.setString(7, funcionarios.getNivelAcesso());
			stmt.setString(8, funcionarios.getTelefone());
			stmt.setString(9, funcionarios.getCelular());
			stmt.setString(10, funcionarios.getCep());
			stmt.setString(11, funcionarios.getEndereco());
			stmt.setInt(12, funcionarios.getNumero());
			stmt.setString(13, funcionarios.getComplemento());
			stmt.setString(14, funcionarios.getBairro());
			stmt.setString(15, funcionarios.getCidade());
			stmt.setString(16, funcionarios.getUf());

			// executar o comando sql
			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Cadastro efetuado!");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível cadastrar: " + e.getMessage());
			// TODO: handle exception
		}
	}

	// metodo alterar funcionario
	public void alterarFuncionario(Funcionarios funcionarios) {
		try {
			// criar comando sql
			String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, "
					+ "nivel_acesso=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, "
					+ "complemento=?, bairro=?, cidade=?, estado=? where id=? ";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, funcionarios.getNome());
			stmt.setString(2, funcionarios.getRg());
			stmt.setString(3, funcionarios.getCpf());
			stmt.setString(4, funcionarios.getEmail());
			stmt.setString(5, funcionarios.getSenha());
			stmt.setString(6, funcionarios.getCargo());
			stmt.setString(7, funcionarios.getNivelAcesso());
			stmt.setString(8, funcionarios.getTelefone());
			stmt.setString(9, funcionarios.getCelular());
			stmt.setString(10, funcionarios.getCep());
			stmt.setString(11, funcionarios.getEndereco());
			stmt.setInt(12, funcionarios.getNumero());
			stmt.setString(13, funcionarios.getComplemento());
			stmt.setString(14, funcionarios.getBairro());
			stmt.setString(15, funcionarios.getCidade());
			stmt.setString(16, funcionarios.getUf());
			stmt.setInt(17, funcionarios.getId());

			// executar o comando sql
			stmt.execute();
			stmt.close();

			JOptionPane.showMessageDialog(null, "Alteração concluída!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possível alterar: " + e.getMessage());
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}

	public void excluirFuncionarios(Funcionarios funcionarios) {
		try {
			// Criar o comando sql
			String sql = "delete from tb_funcionarios where id=?";

			// concectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, funcionarios.getId());

			// executar o comando sql
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível excluir: " + e.getMessage());
		}
	}

	// Metodo listar funcionarios
	public List<Funcionarios> listarFuncionarios() {

		// criar a lista de funcionarios
		List<Funcionarios> lista = new ArrayList<>();

		try {
			// criar o comando sql
			String sql = "select * from Tb_funcionarios";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet resultset = stmt.executeQuery();

			while (resultset.next()) {
				// criar um funcionario set

				Funcionarios funcionarios = new Funcionarios();

				funcionarios.setId(resultset.getInt("id"));
				funcionarios.setNome(resultset.getString("nome"));
				funcionarios.setRg(resultset.getString("rg"));
				funcionarios.setCpf(resultset.getString("cpf"));
				funcionarios.setEmail(resultset.getString("email"));
				funcionarios.setSenha(resultset.getString("senha"));
				funcionarios.setCargo(resultset.getString("cargo"));
				funcionarios.setNivelAcesso(resultset.getString("nivel_acesso"));
				funcionarios.setTelefone(resultset.getString("telefone"));
				funcionarios.setCelular(resultset.getString("celular"));
				funcionarios.setCep(resultset.getString("cep"));
				funcionarios.setEndereco(resultset.getString("endereco"));
				funcionarios.setNumero(resultset.getInt("numero"));
				funcionarios.setComplemento(resultset.getString("complemento"));
				funcionarios.setBairro(resultset.getString("bairro"));
				funcionarios.setCidade(resultset.getString("cidade"));
				funcionarios.setUf(resultset.getString("estado"));

				// adicionar o funcionario a lista
				lista.add(funcionarios);

			}
			return lista;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

	}

	public Funcionarios buscaCep(String cep) {

		WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

		Funcionarios funcionarios = new Funcionarios();

		if (webServiceCep.wasSuccessful()) {
			funcionarios.setEndereco(webServiceCep.getLogradouroFull());
			funcionarios.setCidade(webServiceCep.getCidade());
			funcionarios.setBairro(webServiceCep.getBairro());
			funcionarios.setUf(webServiceCep.getUf());
			return funcionarios;
		} else {
			JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
			JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
			return null;
		}

	}

	// metodo consulta funcionario por nome
	public Funcionarios consultaNome(String nome) {
		try {
			// criar o comando sql
			String sql = "select * from tb_funcionarios where nome = ?";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setNString(1, nome);

			ResultSet resultset = stmt.executeQuery();
			Funcionarios funcionarios = new Funcionarios();

			if (resultset.next()) {
				funcionarios.setId(resultset.getInt("id"));
				funcionarios.setNome(resultset.getString("nome"));
				funcionarios.setRg(resultset.getString("rg"));
				funcionarios.setCpf(resultset.getString("cpf"));
				funcionarios.setEmail(resultset.getString("email"));
				funcionarios.setSenha(resultset.getString("senha"));
				funcionarios.setCargo(resultset.getString("cargo"));
				funcionarios.setNivelAcesso(resultset.getString("nivel_acesso"));
				funcionarios.setTelefone(resultset.getString("telefone"));
				funcionarios.setCelular(resultset.getString("celular"));
				funcionarios.setCep(resultset.getString("cep"));
				funcionarios.setEndereco(resultset.getString("endereco"));
				funcionarios.setNumero(resultset.getInt("numero"));
				funcionarios.setComplemento(resultset.getString("complemento"));
				funcionarios.setBairro(resultset.getString("bairro"));
				funcionarios.setCidade(resultset.getString("cidade"));
				funcionarios.setUf(resultset.getString("estado"));
			}
			return funcionarios;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Funcionário nao encontrado! " + e.getMessage());
			return null;
		}

	}

	// Retorna uma lista de funcionario por nome
	public List<Funcionarios> listaFuncionariosPorNome(String nome) {

		// criar a lista
		List<Funcionarios> lista = new ArrayList<>();

		try {
			// criar o comando sql
			String sql = "select * from Tb_funcionarios where nome like ?";

			// conectar o banco de dados e organizar o comando sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setNString(1, nome);
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				// criar um clienteseto cliente
				Funcionarios funcionarios = new Funcionarios();

				funcionarios.setId(resultSet.getInt("id"));
				funcionarios.setNome(resultSet.getString("nome"));
				funcionarios.setRg(resultSet.getString("rg"));
				funcionarios.setCpf(resultSet.getString("cpf"));
				funcionarios.setEmail(resultSet.getString("email"));
				funcionarios.setSenha(resultSet.getString("senha"));
				funcionarios.setCargo(resultSet.getString("cargo"));
				funcionarios.setNivelAcesso(resultSet.getString("nivel_acesso"));
				funcionarios.setTelefone(resultSet.getString("telefone"));
				funcionarios.setCelular(resultSet.getString("celular"));
				funcionarios.setCep(resultSet.getString("cep"));
				funcionarios.setEndereco(resultSet.getString("endereco"));
				funcionarios.setNumero(resultSet.getInt("numero"));
				funcionarios.setComplemento(resultSet.getString("complemento"));
				funcionarios.setBairro(resultSet.getString("bairro"));
				funcionarios.setCidade(resultSet.getString("cidade"));
				funcionarios.setUf(resultSet.getString("estado"));

				// adicionar o cliente à lista
				lista.add(funcionarios);
			}
			return lista;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}

	}

	// Método logar
	public void Logar(String email, String senha) {
		try {
			// SQL
			String sql = "select * from tb_funcionarios where email=? and senha=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setNString(1, email);
			stmt.setNString(2, senha);

			ResultSet resultset = stmt.executeQuery();

			if (resultset.next()) {
				// logou
				JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema!");
				FrmPrincipal principal = new FrmPrincipal();
				principal.usuarioLogado = resultset.getString("nome");
				principal.lblUsuario.setText(principal.usuarioLogado);
				principal.setVisible(true);

			} else {
				// nao logou
				JOptionPane.showMessageDialog(null, "Dados incorretos!");
				FrmLogin frmLogin = new FrmLogin();
				frmLogin.setLocationRelativeTo(null);
				frmLogin.setVisible(true);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao logar: /n" + e.getMessage());

		}
	}
}
