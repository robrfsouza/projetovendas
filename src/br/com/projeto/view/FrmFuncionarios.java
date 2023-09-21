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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.projeto.dao.ClientesDAO;
import br.com.projeto.dao.FuncionariosDAO;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.Utilitarios;
import java.util.Locale;

public class FrmFuncionarios extends JFrame {

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
	private JTextField txtCargo;
	private JTextField txtNomeConsulta;
	private JFormattedTextField txtRg;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCelular;
	private JTable tblFuncionarios;
	private JPasswordField txtSenha;
	private JComboBox<String> cmbNivel;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFuncionarios frame = new FrmFuncionarios();
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
	public FrmFuncionarios() {
		setLocale(new Locale("pt", "BR"));
		setTitle("Seja bem vindo ao Sistema - Cadastro de Funcionários");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 425);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 192));
		panel.setBounds(0, 0, 907, 74);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastro de Funcionários");
		lblNewLabel.setBounds(10, 21, 301, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 85, 891, 229);
		contentPane.add(tabbedPane);

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
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel pnlDados = new JPanel();
		pnlDados.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Dados pessoais", null, pnlDados, null);
		pnlDados.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 13, 48, 17);
		pnlDados.add(lblNewLabel_1);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigo.setBounds(84, 11, 94, 20);
		pnlDados.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(188, 13, 48, 17);
		pnlDados.add(lblNewLabel_1_1);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setColumns(10);
		txtNome.setBounds(246, 11, 402, 20);
		pnlDados.add(txtNome);

		JLabel lblNewLabel_1_1_1 = new JLabel("Endereço:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(205, 113, 63, 17);
		pnlDados.add(lblNewLabel_1_1_1);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(278, 111, 307, 20);
		pnlDados.add(txtEndereco);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Celular:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(501, 79, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_1);
		try {
			txtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCelular.setBounds(555, 77, 114, 20);
			pnlDados.add(txtCelular);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Telefone:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_1.setBounds(679, 79, 56, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("CEP:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_2.setBounds(10, 111, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_2);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("E-mail:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(10, 78, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_2);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(83, 80, 402, 20);
		pnlDados.add(txtEmail);

		JLabel lblNewLabel_1_1_1_1_2_1 = new JLabel("UF:");
		lblNewLabel_1_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_2_1.setBounds(771, 113, 21, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_2_1);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("Bairro:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_3.setBounds(10, 144, 63, 17);
		pnlDados.add(lblNewLabel_1_1_1_3);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBairro.setColumns(10);
		txtBairro.setBounds(83, 142, 185, 20);
		pnlDados.add(txtBairro);

		JLabel lblNewLabel_1_1_1_4 = new JLabel("Cidade:");
		lblNewLabel_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_4.setBounds(278, 144, 46, 17);
		pnlDados.add(lblNewLabel_1_1_1_4);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCidade.setColumns(10);
		txtCidade.setBounds(337, 142, 165, 20);
		pnlDados.add(txtCidade);

		JLabel lblNewLabel_1_1_1_5 = new JLabel("Complemento:");
		lblNewLabel_1_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_5.setBounds(512, 144, 91, 17);
		pnlDados.add(lblNewLabel_1_1_1_5);

		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(613, 142, 245, 20);
		pnlDados.add(txtComplemento);

		JLabel lblNewLabel_1_1_1_1_2_1_1 = new JLabel("Nº");
		lblNewLabel_1_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_2_1_1.setBounds(613, 113, 21, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_2_1_1);

		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumero.setColumns(10);
		txtNumero.setBounds(644, 113, 94, 20);
		pnlDados.add(txtNumero);

		JComboBox<String> cmbUF = new JComboBox<String>();
		cmbUF.setModel(new DefaultComboBoxModel<String>(
				new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR",
						"PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF" }));
		cmbUF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbUF.setBounds(802, 110, 56, 23);
		pnlDados.add(cmbUF);

		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("RG:");
		lblNewLabel_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_3.setBounds(10, 173, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_3);
		try {
			txtRg = new JFormattedTextField(new MaskFormatter("##.######-#"));
			txtRg.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtRg.setBounds(84, 171, 94, 20);
			pnlDados.add(txtRg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel_1_1_1_1_4 = new JLabel("CPF:");
		lblNewLabel_1_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_4.setBounds(205, 173, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_4);

		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCpf.setBounds(246, 171, 130, 20);
			pnlDados.add(txtCpf);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			txtTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtTelefone.setBounds(745, 77, 113, 20);
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
						Funcionarios funcionarios = new Funcionarios();
						FuncionariosDAO dao = new FuncionariosDAO();
						funcionarios = dao.buscaCep(txtCep.getText());

						txtEndereco.setText(funcionarios.getEndereco());
						txtBairro.setText(funcionarios.getBairro());
						txtCidade.setText(funcionarios.getCidade());
						cmbUF.setSelectedItem(funcionarios.getUf());
					}

				}
			});
			txtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCep.setBounds(84, 111, 94, 20);
			pnlDados.add(txtCep);

		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton btnBuscarFuncionarios = new JButton("Pesquisar");
		btnBuscarFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionarios funcionarios = new Funcionarios();
				String nome = txtNome.getText();
				FuncionariosDAO dao = new FuncionariosDAO();

				funcionarios = dao.consultaNome(nome);

				// Exibir os dados do cliente nos campos de texto

				if (funcionarios.getNome() != null) {
					txtCodigo.setText(String.valueOf(funcionarios.getId()));
					txtNome.setText(funcionarios.getNome());
					txtRg.setText(funcionarios.getRg());
					txtCpf.setText(funcionarios.getCpf());
					txtEmail.setText(funcionarios.getEmail());
					
					txtSenha.setText(funcionarios.getSenha());
					txtCargo.setText(funcionarios.getCargo());
					cmbNivel.setSelectedItem(funcionarios.getNivelAcesso());
					
					txtTelefone.setText(funcionarios.getTelefone());
					txtCelular.setText(funcionarios.getCelular());
					txtCep.setText(funcionarios.getCep());
					txtEndereco.setText(funcionarios.getEndereco());
					txtNumero.setText(String.valueOf(funcionarios.getNumero()));
					txtComplemento.setText(funcionarios.getComplemento());
					txtBairro.setText(funcionarios.getBairro());
					txtCidade.setText(funcionarios.getCidade());
					cmbUF.setSelectedItem(funcionarios.getUf());
				} else {
					JOptionPane.showMessageDialog(null, "Funcionário nao encontrado");
				}
			}
		});
		btnBuscarFuncionarios.setBounds(658, 9, 114, 25);
		pnlDados.add(btnBuscarFuncionarios);

		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 50, 43, 17);
		pnlDados.add(lblNewLabel_2);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setBounds(84, 49, 94, 20);
		pnlDados.add(txtSenha);

		JLabel lblNewLabel_3 = new JLabel("Cargo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(188, 50, 42, 17);
		pnlDados.add(lblNewLabel_3);

		JTextField txtCargo = new JTextField();
		txtCargo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCargo.setBounds(246, 47, 195, 22);
		pnlDados.add(txtCargo);

		JLabel lblNewLabel_4 = new JLabel("Nivel de Acesso:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(451, 50, 98, 17);
		pnlDados.add(lblNewLabel_4);

		JComboBox<String> cmbNivel = new JComboBox<>();
		cmbNivel.setModel(new DefaultComboBoxModel<String>(new String[] { "Usuário", "Administrador" }));
		cmbNivel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbNivel.setBounds(555, 43, 113, 23);
		pnlDados.add(cmbNivel);

		JPanel pnlConsulta = new JPanel();
		pnlConsulta.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Consulta de funcionários", null, pnlConsulta, null);
		pnlConsulta.setLayout(null);

		JButton btnPesquisarNome = new JButton("Pesquisar");
		btnPesquisarNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botao Pesquisar Nome

				String nome = "%" + txtNomeConsulta.getText() + "%";

				FuncionariosDAO dao = new FuncionariosDAO();
				List<Funcionarios> list = dao.listaFuncionariosPorNome(nome);
				DefaultTableModel dados = (DefaultTableModel) tblFuncionarios.getModel();
				dados.setNumRows(0);

				for (Funcionarios c : list) {

					dados.addRow(new Object[] { c.getId(), c.getNome(), c.getRg(), c.getCpf(), c.getEmail(),
							c.getSenha(), c.getCargo(), c.getNivelAcesso(), c.getTelefone(), c.getCelular(), c.getCep(), c.getEndereco(), c.getNumero(),
							c.getComplemento(), c.getBairro(), c.getCidade(), c.getUf() });
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

				FuncionariosDAO dao = new FuncionariosDAO();
				List<Funcionarios> list = dao.listaFuncionariosPorNome(nome);
				DefaultTableModel dados = (DefaultTableModel) tblFuncionarios.getModel();
				dados.setNumRows(0);

				for (Funcionarios c : list) {

					dados.addRow(new Object[] { c.getId(), c.getNome(), c.getRg(), c.getCpf(), c.getEmail(),
							c.getSenha(), c.getCargo(), c.getNivelAcesso(), c.getTelefone(), c.getCelular(), c.getCep(), c.getEndereco(), c.getNumero(),
							c.getComplemento(), c.getBairro(), c.getCidade(), c.getUf() });
				}

			}
		});
		txtNomeConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeConsulta.setColumns(10);
		txtNomeConsulta.setBounds(83, 13, 402, 20);
		pnlConsulta.add(txtNomeConsulta);

		tblFuncionarios = new JTable();
		tblFuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlDados.setVisible(true);
				txtCodigo.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 0).toString());
				txtNome.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 1).toString());
				txtRg.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 2).toString());
				txtCpf.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 3).toString());
				txtEmail.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 4).toString());
				txtSenha.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 5).toString());
				txtCargo.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 6).toString());
				cmbNivel.setSelectedItem(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 7).toString());
				txtTelefone.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 8).toString());
				txtCelular.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 9).toString());
				txtCep.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 10).toString());
				txtEndereco.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 11).toString());
				txtNumero.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 12).toString());
				txtComplemento.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 13).toString());
				txtBairro.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 14).toString());
				txtCidade.setText(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 15).toString());
				cmbUF.setSelectedItem(tblFuncionarios.getValueAt(tblFuncionarios.getSelectedRow(), 16).toString());

			}
		});
		tblFuncionarios.setForeground(new Color(0, 0, 0));
		tblFuncionarios.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00F3digo", "Nome", "RG", "CPF", "Email", "Senha", "Cargo", "Nivel de Acesso",
						"Telefone", "Celular", "CEP", "Endere\u00E7o", "N\u00BA", "Complemento", "Bairro", "Cidade",
						"UF" }));
		tblFuncionarios.setBounds(0, 56, 892, 102);
		tblFuncionarios.setVisible(true);
		pnlConsulta.add(tblFuncionarios);

		// Adicione a tabela a um JScrollPane
		JScrollPane scrollPane = new JScrollPane(tblFuncionarios);
		scrollPane.setBounds(0, 56, 887, 102); // Defina as dimensões apropriadas
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
				Funcionarios funcionarios = new Funcionarios();

				funcionarios.setNome(txtNome.getText());
				funcionarios.setRg(txtRg.getText());
				funcionarios.setCpf(txtCpf.getText());
				funcionarios.setEmail(txtEmail.getText());
				funcionarios.setSenha(txtSenha.getText());
				funcionarios.setCargo(txtCargo.getText());
				funcionarios.setNivelAcesso(cmbNivel.getSelectedItem().toString());
				funcionarios.setTelefone(txtTelefone.getText());
				funcionarios.setCelular(txtCelular.getText());
				funcionarios.setCep(txtCep.getText());
				funcionarios.setEndereco(txtEndereco.getText());
				funcionarios.setNumero(Integer.parseInt(txtNumero.getText()));
				funcionarios.setComplemento(txtComplemento.getText());
				funcionarios.setBairro(txtBairro.getText());
				funcionarios.setCidade(txtCidade.getText());
				funcionarios.setUf(cmbUF.getSelectedItem().toString());

				FuncionariosDAO dao = new FuncionariosDAO();
				dao.cadastrarFuncionario(funcionarios);
				;

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

				Funcionarios funcionarios = new Funcionarios();

				funcionarios.setNome(txtNome.getText());
				funcionarios.setRg(txtRg.getText());
				funcionarios.setCpf(txtCpf.getText());
				funcionarios.setEmail(txtEmail.getText());
				funcionarios.setSenha(txtSenha.getText());
				funcionarios.setCargo(txtCargo.getText());
				funcionarios.setNivelAcesso(cmbNivel.getSelectedItem().toString());
				funcionarios.setTelefone(txtTelefone.getText());
				funcionarios.setCelular(txtCelular.getText());
				funcionarios.setCep(txtCep.getText());
				funcionarios.setEndereco(txtEndereco.getText());
				funcionarios.setNumero(Integer.parseInt(txtNumero.getText()));
				funcionarios.setComplemento(txtComplemento.getText());
				funcionarios.setBairro(txtBairro.getText());
				funcionarios.setCidade(txtCidade.getText());
				funcionarios.setUf(cmbUF.getSelectedItem().toString());
				funcionarios.setId(Integer.parseInt(txtCodigo.getText()));

				FuncionariosDAO dao = new FuncionariosDAO();
				dao.alterarFuncionario(funcionarios);

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

				Funcionarios funcionarios = new Funcionarios();

				funcionarios.setId(Integer.parseInt(txtCodigo.getText()));

				FuncionariosDAO dao = new FuncionariosDAO();
				dao.excluirFuncionarios(funcionarios);
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
		FuncionariosDAO dao = new FuncionariosDAO();
		List<Funcionarios> lista = dao.listarFuncionarios();
		DefaultTableModel dadosTabela = (DefaultTableModel) tblFuncionarios.getModel();
		dadosTabela.setNumRows(0);

		for (Funcionarios f : lista) {

			dadosTabela.addRow(new Object[] { f.getId(), f.getNome(), f.getRg(), f.getCpf(), f.getEmail(), f.getSenha(),
					f.getCargo(), f.getNivelAcesso(), f.getTelefone(), f.getCelular(), f.getCep(), f.getEndereco(),
					f.getNumero(), f.getComplemento(), f.getBairro(), f.getCidade(), f.getUf() });
		}

	}
}
