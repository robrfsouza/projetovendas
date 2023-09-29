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
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.projeto.dao.FornecedoresDAO;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Utilitarios;
import javax.swing.ImageIcon;

public class FrmFornecedores extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JTextField txtNumero;
	private JTextField txtNomeConsulta;
	private JFormattedTextField txtCnpj;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCelular;
	private JTable tblFornecedores;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFornecedores frame = new FrmFornecedores();
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
	public FrmFornecedores() {
		setTitle("Seja bem vindo ao Sistema - Cadastro de Fornecedores");
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

		JLabel lblNewLabel = new JLabel("Cadastro de Fornecedores");
		lblNewLabel.setBounds(10, 21, 310, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(FrmFornecedores.class.getResource("/imagem/fornecedores.png")));
		lblNewLabel_2.setBounds(330, 11, 48, 48);
		panel.add(lblNewLabel_2);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 85, 891, 229);
		contentPane.add(tabbedPane);

		JPanel pnlDados = new JPanel();
		pnlDados.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Dados pessoais", null, pnlDados, null);
		pnlDados.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 48, 17);
		pnlDados.add(lblNewLabel_1);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigo.setBounds(84, 11, 94, 20);
		pnlDados.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 40, 48, 17);
		pnlDados.add(lblNewLabel_1_1);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(83, 40, 402, 20);
		pnlDados.add(txtNome);

		JLabel lblNewLabel_1_1_1 = new JLabel("Endereço:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(205, 98, 63, 17);
		pnlDados.add(lblNewLabel_1_1_1);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(278, 96, 307, 20);
		pnlDados.add(txtEndereco);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Celular:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(501, 67, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_1);

		try {
			txtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCelular.setBounds(555, 65, 114, 20);
			pnlDados.add(txtCelular);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Telefone:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(679, 67, 56, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("CEP:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_2.setBounds(10, 96, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_2);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("E-mail:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(10, 66, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_2);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(83, 68, 402, 20);
		pnlDados.add(txtEmail);

		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("UF:");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_2_1.setBounds(771, 98, 21, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_2_1);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("Bairro:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_3.setBounds(10, 128, 63, 17);
		pnlDados.add(lblNewLabel_1_1_1_3);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBairro.setColumns(10);
		txtBairro.setBounds(83, 126, 185, 20);
		pnlDados.add(txtBairro);

		JLabel lblNewLabel_1_1_1_4 = new JLabel("Cidade:");
		lblNewLabel_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_4.setBounds(278, 128, 46, 17);
		pnlDados.add(lblNewLabel_1_1_1_4);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCidade.setColumns(10);
		txtCidade.setBounds(337, 126, 165, 20);
		pnlDados.add(txtCidade);

		JLabel lblNewLabel_1_1_1_5 = new JLabel("Complemento:");
		lblNewLabel_1_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_5.setBounds(512, 128, 91, 17);
		pnlDados.add(lblNewLabel_1_1_1_5);

		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(613, 126, 245, 20);
		pnlDados.add(txtComplemento);

		JLabel lblNewLabel_1_1_1_1_2_1_1 = new JLabel("Nº");
		lblNewLabel_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_2_1_1.setBounds(613, 101, 21, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_2_1_1);

		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumero.setColumns(10);
		txtNumero.setBounds(644, 98, 94, 20);
		pnlDados.add(txtNumero);

		JComboBox<String> cmbUF = new JComboBox<String>();
		cmbUF.setModel(new DefaultComboBoxModel<String>(
				new String[] { "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE",
						"PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF" }));
		cmbUF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbUF.setBounds(802, 95, 56, 23);
		pnlDados.add(cmbUF);

		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("CNPJ");
		lblNewLabel_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_3.setBounds(10, 158, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_3);

		try {
			txtCnpj = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
			txtCnpj.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCnpj.setBounds(84, 156, 155, 20);
			pnlDados.add(txtCnpj);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtTelefone.setBounds(745, 65, 113, 20);
			pnlDados.add(txtTelefone);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
			txtCep.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					// programcao keyevent
					if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_ENTER) {
						Fornecedores Fornecedores = new Fornecedores();
						FornecedoresDAO dao = new FornecedoresDAO();
						Fornecedores = dao.buscaCep(txtCep.getText());

						txtEndereco.setText(Fornecedores.getEndereco());
						txtBairro.setText(Fornecedores.getBairro());
						txtCidade.setText(Fornecedores.getCidade());
						cmbUF.setSelectedItem(Fornecedores.getUf());
					}

				}
			});
			txtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCep.setBounds(84, 96, 94, 20);
			pnlDados.add(txtCep);

			JButton btnBuscarCliente = new JButton("Pesquisar");
			btnBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnBuscarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nome = txtNome.getText();
					Fornecedores fornecedores = new Fornecedores();
					FornecedoresDAO dao = new FornecedoresDAO();

					fornecedores = dao.consultaNome(nome);

					// Exibir os dados do cliente nos campos de texto

					if (fornecedores.getNome() != null) {
						txtCodigo.setText(String.valueOf(fornecedores.getId()));
						txtNome.setText(fornecedores.getNome());
						txtCnpj.setText(fornecedores.getRg());
						txtCnpj.setText(fornecedores.getCnpj());
						txtEmail.setText(fornecedores.getEmail());
						txtTelefone.setText(fornecedores.getTelefone());
						txtCelular.setText(fornecedores.getCelular());
						txtCep.setText(fornecedores.getCep());
						txtEndereco.setText(fornecedores.getEndereco());
						txtNumero.setText(String.valueOf(fornecedores.getNumero()));
						txtComplemento.setText(fornecedores.getComplemento());
						txtBairro.setText(fornecedores.getBairro());
						txtCidade.setText(fornecedores.getCidade());
						cmbUF.setSelectedItem(fornecedores.getUf());
					} else {
						JOptionPane.showMessageDialog(null, "cliente nao encontrado");
					}
				}
			});
			btnBuscarCliente.setBounds(495, 36, 114, 25);
			pnlDados.add(btnBuscarCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel pnlConsulta = new JPanel();
		pnlConsulta.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Consulta de Fornecedores", null, pnlConsulta, null);
		pnlConsulta.setLayout(null);

		JButton btnPesquisarNome = new JButton("Pesquisar");
		btnPesquisarNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botao Pesquisar Nome

				String nome = "%" + txtNomeConsulta.getText() + "%";

				FornecedoresDAO dao = new FornecedoresDAO();
				List<Fornecedores> list = dao.pesquisarFornecedoresPorNome(nome);
				DefaultTableModel dados = (DefaultTableModel) tblFornecedores.getModel();
				dados.setNumRows(0);

				for (Fornecedores c : list) {

					dados.addRow(new Object[] { c.getId(), c.getNome(), c.getCnpj(), c.getEmail(), c.getTelefone(),
							c.getCelular(), c.getCep(), c.getEndereco(), c.getNumero(), c.getComplemento(),
							c.getBairro(), c.getCidade(), c.getUf() });
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

				FornecedoresDAO dao = new FornecedoresDAO();
				List<Fornecedores> list = dao.pesquisarFornecedoresPorNome(nome);
				DefaultTableModel dados = (DefaultTableModel) tblFornecedores.getModel();
				dados.setNumRows(0);

				for (Fornecedores c : list) {

					dados.addRow(new Object[] { c.getId(), c.getNome(), c.getCnpj(), c.getEmail(), c.getTelefone(),
							c.getCelular(), c.getCep(), c.getEndereco(), c.getNumero(), c.getComplemento(),
							c.getBairro(), c.getCidade(), c.getUf() });
				}

			}
		});
		txtNomeConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeConsulta.setColumns(10);
		txtNomeConsulta.setBounds(83, 13, 402, 20);
		pnlConsulta.add(txtNomeConsulta);

		tblFornecedores = new JTable();
		tblFornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlDados.setVisible(true);
				txtCodigo.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 0).toString());
				txtNome.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 1).toString());
				txtCnpj.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 2).toString());
				txtEmail.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 3).toString());
				txtTelefone.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 4).toString());
				txtCelular.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 5).toString());
				txtCep.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 6).toString());
				txtEndereco.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 7).toString());
				txtNumero.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 8).toString());
				txtComplemento.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 9).toString());
				txtBairro.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 10).toString());
				txtCidade.setText(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 11).toString());
				cmbUF.setSelectedItem(tblFornecedores.getValueAt(tblFornecedores.getSelectedRow(), 12).toString());

			}
		});
		tblFornecedores.setForeground(new Color(0, 0, 0));
		tblFornecedores.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00F3digo", "Nome", "CNPJ", "Email", "Telefone", "Celular", "CEP", "Endere\u00E7o",
						"N\u00BA", "Complemento", "Bairro", "Cidade", "UF" }));
		tblFornecedores.setBounds(0, 56, 892, 102);
		tblFornecedores.setVisible(true);
		pnlConsulta.add(tblFornecedores);

		// Adicione a tabela a um JScrollPane
		JScrollPane scrollPane = new JScrollPane(tblFornecedores);
		scrollPane.setBounds(0, 56, 887, 145); // Defina as dimensões apropriadas
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Configura a barra de
																								// rolagem vertical
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS); // configura a barra
																									// de rolagem na
																									// horizontal

		// Adicione o JScrollPane ao painel de consulta
		pnlConsulta.add(scrollPane);

		JButton btnNovo = new JButton("NOVO");
		btnNovo.setBounds(208, 325, 113, 47);
		contentPane.add(btnNovo);
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Utilitarios().LimparTela(pnlDados);
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// execucao do Botao Salvar
				Fornecedores fornecedores = new Fornecedores();

				fornecedores.setNome(txtNome.getText());
				fornecedores.setRg(txtCnpj.getText());
				fornecedores.setCnpj(txtCnpj.getText());
				fornecedores.setEmail(txtEmail.getText());
				fornecedores.setTelefone(txtTelefone.getText());
				fornecedores.setCelular(txtCelular.getText());
				fornecedores.setCep(txtCep.getText());
				fornecedores.setEndereco(txtEndereco.getText());
				fornecedores.setNumero(Integer.parseInt(txtNumero.getText()));
				fornecedores.setComplemento(txtComplemento.getText());
				fornecedores.setBairro(txtBairro.getText());
				fornecedores.setCidade(txtCidade.getText());
				fornecedores.setUf(cmbUF.getSelectedItem().toString());

				FornecedoresDAO dao = new FornecedoresDAO();
				dao.cadastrarFornecedores(fornecedores);
				pnlConsulta.setVisible(true);
				listarTabela();
				pnlConsulta.setVisible(false);

				new Utilitarios().LimparTela(pnlDados);

			}
		});

		btnSalvar.setBounds(331, 325, 113, 47);
		contentPane.add(btnSalvar);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnEditar = new JButton("EDITAR");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// execucao do botao editar

				Fornecedores fornecedores = new Fornecedores();

				fornecedores.setNome(txtNome.getText());
				fornecedores.setRg(txtCnpj.getText());
				fornecedores.setCnpj(txtCnpj.getText());
				fornecedores.setEmail(txtEmail.getText());
				fornecedores.setTelefone(txtTelefone.getText());
				fornecedores.setCelular(txtCelular.getText());
				fornecedores.setCep(txtCep.getText());
				fornecedores.setEndereco(txtEndereco.getText());
				fornecedores.setNumero(Integer.parseInt(txtNumero.getText()));
				fornecedores.setComplemento(txtComplemento.getText());
				fornecedores.setBairro(txtBairro.getText());
				fornecedores.setCidade(txtCidade.getText());
				fornecedores.setUf(cmbUF.getSelectedItem().toString());
				fornecedores.setId(Integer.parseInt(txtCodigo.getText()));

				FornecedoresDAO dao = new FornecedoresDAO();
				dao.alterarFornecedores(fornecedores);

				new Utilitarios().LimparTela(pnlDados);
				pnlConsulta.setVisible(true);
				listarTabela();
				pnlConsulta.setVisible(false);

			}
		});
		btnEditar.setBounds(454, 325, 113, 47);
		contentPane.add(btnEditar);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnExcluir = new JButton("EXCLUIR");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// execucao do botao excluir

				Fornecedores fornecedores = new Fornecedores();

				fornecedores.setId(Integer.parseInt(txtCodigo.getText()));

				FornecedoresDAO dao = new FornecedoresDAO();
				dao.excluirFornecedores(fornecedores);
				pnlConsulta.setVisible(true);
				listarTabela();
				pnlConsulta.setVisible(false);

				new Utilitarios().LimparTela(pnlDados);

			}
		});
		btnExcluir.setBounds(577, 325, 113, 47);
		contentPane.add(btnExcluir);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));

		listarTabela();
	}

	public void listarTabela() {
		FornecedoresDAO dao = new FornecedoresDAO();
		List<Fornecedores> lista = dao.listarFornecedores();
		DefaultTableModel dadosTabela = (DefaultTableModel) tblFornecedores.getModel();
		dadosTabela.setNumRows(0);

		for (Fornecedores c : lista) {

			dadosTabela.addRow(new Object[] { c.getId(), c.getNome(), c.getCnpj(), c.getEmail(), c.getTelefone(),
					c.getCelular(), c.getCep(), c.getEndereco(), c.getNumero(), c.getComplemento(), c.getBairro(),
					c.getCidade(), c.getUf() });
		}

	}
}
