package br.com.projeto.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import br.com.projeto.dao.FornecedoresDAO;
import br.com.projeto.dao.ProdutosDAO;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Produtos;
import br.com.projeto.model.Utilitarios;

public class FrmProdutos extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtDescricao;
	private JTextField txtQtdEstoque;
	private JTextField txtPreco;
	private JTextField txtNomeConsulta;
	private JTable tblProdutos;
	private JComboBox cmbFornecedor;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProdutos frame = new FrmProdutos();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmProdutos() {
		setTitle("Seja bem vindo ao Sistema - Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 425);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 192));
		panel.setBounds(0, 0, 900, 74);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Produtos");
		lblNewLabel.setBounds(10, 21, 257, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(FrmProdutos.class.getResource("/imagem/produtos.png")));
		lblNewLabel_2.setBounds(277, 11, 48, 48);
		panel.add(lblNewLabel_2);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 85, 891, 229);
		contentPane.add(tabbedPane);

		JPanel pnlDados = new JPanel();
		pnlDados.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Dados do produto", null, pnlDados, null);
		pnlDados.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 48, 17);
		pnlDados.add(lblNewLabel_1);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigo.setBounds(102, 9, 94, 20);
		pnlDados.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Descrição:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 40, 64, 17);
		pnlDados.add(lblNewLabel_1_1);

		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(102, 38, 402, 20);
		pnlDados.add(txtDescricao);

		JLabel lblNewLabel_1_1_1 = new JLabel("Qtd Estoque:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(275, 69, 82, 17);
		pnlDados.add(lblNewLabel_1_1_1);

		txtQtdEstoque = new JTextField();
		txtQtdEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQtdEstoque.setColumns(10);
		txtQtdEstoque.setBounds(367, 69, 69, 20);
		pnlDados.add(txtQtdEstoque);

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Preço:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(10, 71, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_2);

		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPreco.setColumns(10);
		txtPreco.setBounds(102, 69, 94, 20);
		pnlDados.add(txtPreco);

		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("Fornecedor:");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_2_1.setBounds(10, 105, 75, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_2_1);

		cmbFornecedor = new JComboBox<String>();
		cmbFornecedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FornecedoresDAO dao = new FornecedoresDAO();
				List<Fornecedores>listaFornecedores = dao.listarFornecedores();
				
				cmbFornecedor.removeAllItems();
				for(Fornecedores f: listaFornecedores) {
					cmbFornecedor.addItem(f);
				}
			}
		});
		cmbFornecedor.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		cmbFornecedor.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				FornecedoresDAO dao = new FornecedoresDAO();
				List<Fornecedores> listaFornecedores = dao.listarFornecedores();

				cmbFornecedor.removeAll();

				for (Fornecedores f : listaFornecedores) {
					cmbFornecedor.addItem(f);
				}

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cmbFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbFornecedor.setBounds(104, 99, 181, 23);
		pnlDados.add(cmbFornecedor);

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			JButton btnBuscarCliente = new JButton("Pesquisar");
			btnBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnBuscarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String descricao = txtDescricao.getText();
					Produtos produtos = new Produtos();
					ProdutosDAO dao = new ProdutosDAO();

					produtos = dao.consultaNome(descricao);
					cmbFornecedor.removeAllItems();

					// Exibir os dados do cliente nos campos de texto

					if (produtos.getDescricao() != null) {
						txtCodigo.setText(String.valueOf(produtos.getId()));
						txtDescricao.setText(produtos.getDescricao());
						txtPreco.setText(String.valueOf(produtos.getPreco()));
						txtQtdEstoque.setText(String.valueOf(produtos.getQtdEstoque()));
						
						Fornecedores fornecedores = new Fornecedores();
						FornecedoresDAO fdao = new FornecedoresDAO();
						fornecedores=fdao.consultaNome(produtos.getFornecedores().getNome());
						cmbFornecedor.getModel().setSelectedItem(fornecedores);
					} else {
						JOptionPane.showMessageDialog(null, "produto nao encontrado");
					}
				}
			});
			btnBuscarCliente.setBounds(522, 36, 114, 25);
			pnlDados.add(btnBuscarCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel pnlConsulta = new JPanel();
		pnlConsulta.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Consulta de produtos", null, pnlConsulta, null);
		pnlConsulta.setLayout(null);

		JButton btnPesquisarNome = new JButton("Pesquisar");
		btnPesquisarNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botao Pesquisar Nome

				String nome = "%" + txtNomeConsulta.getText() + "%";

				ProdutosDAO dao = new ProdutosDAO();
				List<Produtos> list = dao.pesquisarProdutosPorNome(nome);
				DefaultTableModel dados = (DefaultTableModel) tblProdutos.getModel();
				dados.setNumRows(0);

				for (Produtos c : list) {

					dados.addRow(new Object[] { c.getId(), c.getDescricao(), c.getPreco(), c.getQtdEstoque(),
							c.getFornecedores().getNome() });
				}

			}
		});
		btnPesquisarNome.setBounds(512, 10, 114, 25);
		pnlConsulta.add(btnPesquisarNome);

		JLabel lblNewLabel_1_1_2 = new JLabel("Nome:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(10, 13, 48, 17);
		pnlConsulta.add(lblNewLabel_1_1_2);

		txtNomeConsulta = new JTextField();
		txtNomeConsulta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				String nome = "%" + txtNomeConsulta.getText() + "%";

				ProdutosDAO dao = new ProdutosDAO();
				List<Produtos> list = dao.pesquisarProdutosPorNome(nome);
				DefaultTableModel dados = (DefaultTableModel) tblProdutos.getModel();
				dados.setNumRows(0);

				for (Produtos c : list) {

					dados.addRow(new Object[] { c.getId(), c.getDescricao(), c.getPreco(), c.getQtdEstoque(),
							c.getFornecedores().getNome() });
				}

			}
		});
		txtNomeConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeConsulta.setColumns(10);
		txtNomeConsulta.setBounds(83, 13, 402, 20);
		pnlConsulta.add(txtNomeConsulta);

		tblProdutos = new JTable();
		tblProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlDados.setVisible(true);
				txtCodigo.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString());
				txtDescricao.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 1).toString());
				txtPreco.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 2).toString());
				txtQtdEstoque.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 3).toString());
				
				Fornecedores fornecedores = new Fornecedores();
				FornecedoresDAO dao = new FornecedoresDAO();
				fornecedores=dao.consultaNome(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 4).toString());
				
				cmbFornecedor.removeAllItems();
				cmbFornecedor.getModel().setSelectedItem(fornecedores);
			}
		});
		tblProdutos.setForeground(new Color(0, 0, 0));
		tblProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Descricao", "Pre\u00E7o", "Qtd Estoque", "Fornecedor"
			}
		));
		tblProdutos.setBounds(0, 56, 892, 102);
		tblProdutos.setVisible(true);
		pnlConsulta.add(tblProdutos);

		// Adicione a tabela a um JScrollPane
		JScrollPane scrollPane = new JScrollPane(tblProdutos);
		scrollPane.setBounds(0, 56, 887, 145); // Defina as dimensões apropriadas
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Configura a barra de
																								// rolagem vertical
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS); // configura a barra
																									// de rolagem na
																									// horizontal

		// Adicione o JScrollPane ao painel de consulta
		pnlConsulta.add(scrollPane);

		JButton btnNovo = new JButton("NOVO");
		btnNovo.setIcon(new ImageIcon(FrmProdutos.class.getResource("/imagem/novo.png")));
		btnNovo.setBounds(158, 319, 140, 60);
		contentPane.add(btnNovo);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Utilitarios().LimparTela(pnlDados);
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.setIcon(new ImageIcon(FrmProdutos.class.getResource("/imagem/salvar.png")));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// execucao do Botao Salvar
				Produtos produtos = new Produtos();

				produtos.setDescricao(txtDescricao.getText());
				produtos.setPreco(Double.parseDouble(txtPreco.getText()));
				produtos.setQtdEstoque(Integer.parseInt(txtQtdEstoque.getText()));
				
				//criar um objeto de fornecedor
				Fornecedores fornecedor = new Fornecedores();
				fornecedor=(Fornecedores)cmbFornecedor.getSelectedItem();
				produtos.setFornecedores(fornecedor);
				

				ProdutosDAO dao = new ProdutosDAO();
				dao.cadastrarProdutos(produtos);
				pnlConsulta.setVisible(true);
				listarTabela();
				pnlConsulta.setVisible(false);

				new Utilitarios().LimparTela(pnlDados);

			}
		});

		btnSalvar.setBounds(308, 319, 140, 60);
		contentPane.add(btnSalvar);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setIcon(new ImageIcon(FrmProdutos.class.getResource("/imagem/editar.png")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// execucao do botao editar

				Produtos produtos = new Produtos();

				produtos.setId(Integer.parseInt(txtCodigo.getText()));
				produtos.setDescricao(txtDescricao.getText());
				produtos.setPreco(Double.parseDouble(txtPreco.getText()));
				produtos.setQtdEstoque(Integer.parseInt(txtQtdEstoque.getText()));
				
				//Criar um objeto Fornecedores
				Fornecedores fornecedores = new Fornecedores();
				fornecedores = (Fornecedores)cmbFornecedor.getSelectedItem();
				produtos.setFornecedores(fornecedores);
				
				ProdutosDAO dao = new ProdutosDAO();
				dao.alterarProdutos(produtos);

				new Utilitarios().LimparTela(pnlDados);
				pnlConsulta.setVisible(true);
				listarTabela();
				pnlConsulta.setVisible(false);

			}
		});
		btnEditar.setBounds(458, 319, 140, 60);
		contentPane.add(btnEditar);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.setIcon(new ImageIcon(FrmProdutos.class.getResource("/imagem/excluir.png")));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// execucao do botao excluir

				Produtos produtos = new Produtos();

				produtos.setId(Integer.parseInt(txtCodigo.getText()));

				ProdutosDAO dao = new ProdutosDAO();
				dao.excluirProdutos(produtos);
				pnlConsulta.setVisible(true);
				listarTabela();
				pnlConsulta.setVisible(false);

				new Utilitarios().LimparTela(pnlDados);

			}
		});
		btnExcluir.setBounds(608, 319, 140, 60);
		contentPane.add(btnExcluir);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));

		listarTabela();
	}

	public void listarTabela() {
		ProdutosDAO dao = new ProdutosDAO();
		List<Produtos> lista = dao.listarProdutos();
		DefaultTableModel dadosTabela = (DefaultTableModel) tblProdutos.getModel();
		dadosTabela.setNumRows(0);

		for (Produtos c : lista) {

			dadosTabela.addRow(new Object[] { c.getId(), c.getDescricao(), c.getPreco(), c.getQtdEstoque(),
					c.getFornecedores().getNome(), });
		}

	}
}
