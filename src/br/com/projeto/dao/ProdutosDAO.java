package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxSql.StmtExecute;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Produtos;

public class ProdutosDAO {

	public Connection con;

	public ProdutosDAO() {
		super();
		this.con = new ConnectionFactory().getConnection();
	}

	// metodo cadastrar produtos

	public void cadastrarProdutos(Produtos produtos) {
		try {
			String sql = "insert into tb_produtos (descricao, preco, qtd_estoque, for_id) values(?,?,?,?)";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, produtos.getDescricao());
			stmt.setDouble(2, produtos.getPreco());
			stmt.setInt(3, produtos.getQtdEstoque());
			stmt.setObject(4, produtos.getFornecedores().getId());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Produto cadastrado!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel cadastrar: " + e.getMessage());
			;
		}
	}

	// metodo alterar produto
	public void alterarProdutos(Produtos produtos) {
		try {
			String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=? where id=?";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, produtos.getDescricao());
			stmt.setDouble(2, produtos.getPreco());
			stmt.setInt(3, produtos.getQtdEstoque());
			stmt.setInt(4, produtos.getFornecedores().getId());
			stmt.setInt(5, produtos.getId());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Produto alterado!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel alterar: " + e.getMessage());
			;
		}
	}

	// metodo excluir produtos

	public void excluirProdutos(Produtos produtos) {
		try {
			String sql = "delete from tb_produtos where id=?";

			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, produtos.getId());

			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Produto excluido!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel excluir: " + e.getMessage());
			;
		}
	}
	// Metodo Consulta Nome

	public Produtos consultaNome(String nome) {
		try {
			// Criar comando sql
			String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
					+ "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao=?";

			// conectar ao BD e executar o sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet resultset = stmt.executeQuery();

			Produtos produtos = new Produtos();
			if (resultset.next()) {
				produtos.setId(resultset.getInt("p.id"));
				produtos.setDescricao(resultset.getString("p.descricao"));
				produtos.setPreco(resultset.getDouble("p.preco"));
				produtos.setQtdEstoque(resultset.getInt("p.qtd_estoque"));
				
				Fornecedores fornecedores = new Fornecedores();
				fornecedores.setNome(resultset.getString("f.nome"));

				produtos.setFornecedores(fornecedores);
			}
			return produtos;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cliente nao encontrado! " + e.getMessage());
			return null;
		}
	}

	// Metodo Pesquisar produtos por nome

	public List<Produtos> pesquisarProdutosPorNome(String nome) {
		try {
			// criar a lista
			List<Produtos> lista = new ArrayList<>();

			// comando sql
			String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p inner join tb_fornecedores as f "
					+ "on (p.for_id = f.id) where p.descricao like ?";

			// conectar ao BD e executar sql
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setNString(1, nome);
			ResultSet resultset = stmt.executeQuery();

			while (resultset.next()) {
				Produtos produtos = new Produtos();
				produtos.setId(resultset.getInt("p.id"));
				produtos.setDescricao(resultset.getString("p.descricao"));
				produtos.setPreco(resultset.getDouble("p.preco"));
				produtos.setQtdEstoque(resultset.getInt("p.qtd_estoque"));

				Fornecedores fornecedores = new Fornecedores();
				fornecedores.setNome(resultset.getString("f.nome"));

				produtos.setFornecedores(fornecedores);

				// produtos.setFornecedores(resultset.);

				lista.add(produtos);

			}
			return lista;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

	// Metodo listar produtos
	public List<Produtos> listarProdutos() {
		List<Produtos> lista = new ArrayList<>();

		try {
			String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
					+ "from tb_produtos as p inner join tb_fornecedores as f on (p.for_id = f.id)";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet resultset = stmt.executeQuery();

			while (resultset.next()) {
				Produtos produtos = new Produtos();
				Fornecedores fornecedores = new Fornecedores();

				produtos.setId(resultset.getInt("p.id"));
				produtos.setDescricao(resultset.getString("p.descricao"));
				produtos.setPreco(resultset.getDouble("p.preco"));
				produtos.setQtdEstoque(resultset.getInt("p.qtd_estoque"));

				fornecedores.setNome(resultset.getString("f.nome"));
				produtos.setFornecedores(fornecedores);
				lista.add(produtos);
			}
			return lista;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}
}
