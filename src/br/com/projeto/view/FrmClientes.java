package br.com.projeto.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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

import br.com.projeto.dao.ClientesDAO;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Utilitarios;

public class FrmClientes extends JFrame {

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
	private JFormattedTextField txtRg;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtCelular;
	private JTable tblClientes;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmClientes frame = new FrmClientes();
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
	public FrmClientes() {
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

		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setBounds(10, 21, 244, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));

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
		txtBairro.setBounds(83, 126, 94, 20);
		pnlDados.add(txtBairro);

		JLabel lblNewLabel_1_1_1_4 = new JLabel("Cidade:");
		lblNewLabel_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_4.setBounds(205, 128, 63, 17);
		pnlDados.add(lblNewLabel_1_1_1_4);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCidade.setColumns(10);
		txtCidade.setBounds(278, 127, 165, 20);
		pnlDados.add(txtCidade);

		JLabel lblNewLabel_1_1_1_5 = new JLabel("Complemento:");
		lblNewLabel_1_1_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_5.setBounds(458, 129, 91, 17);
		pnlDados.add(lblNewLabel_1_1_1_5);

		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(559, 126, 299, 20);
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

		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("RG:");
		lblNewLabel_1_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_3.setBounds(10, 158, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_3);

		try {
			txtRg = new JFormattedTextField(new MaskFormatter("##.######-#"));
			txtRg.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtRg.setBounds(84, 156, 94, 20);
			pnlDados.add(txtRg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lblNewLabel_1_1_1_1_4 = new JLabel("CPF:");
		lblNewLabel_1_1_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1_4.setBounds(205, 158, 48, 17);
		pnlDados.add(lblNewLabel_1_1_1_1_4);

		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCpf.setBounds(278, 156, 130, 20);
			pnlDados.add(txtCpf);
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
				//programcao keyevent
				if(e.getKeyCode()== KeyEvent.VK_TAB || e.getKeyCode()==KeyEvent.VK_ENTER) {
					Clientes clientes = new Clientes();
					ClientesDAO dao = new ClientesDAO();
					clientes=dao.buscaCep(txtCep.getText());
					
					txtEndereco.setText(clientes.getEndereco());
					txtBairro.setText(clientes.getBairro());
					txtCidade.setText(clientes.getCidade());
					cmbUF.setSelectedItem(clientes.getUf());
				}
				
				}
			});
			txtCep.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtCep.setBounds(84, 96, 94, 20);
			pnlDados.add(txtCep);

			JButton btnBuscarCliente = new JButton("Pesquisar");
			btnBuscarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nome = txtNome.getText();
					Clientes clientes = new Clientes();
					ClientesDAO dao = new ClientesDAO();

					clientes = dao.consultaNome(nome);

					// Exibir os dados do cliente nos campos de texto

					if (clientes.getNome() != null) {
						txtCodigo.setText(String.valueOf(clientes.getId()));
						txtNome.setText(clientes.getNome());
						txtRg.setText(clientes.getRg());
						txtCpf.setText(clientes.getCpf());
						txtEmail.setText(clientes.getEmail());
						txtTelefone.setText(clientes.getTelefone());
						txtCelular.setText(clientes.getCelular());
						txtCep.setText(clientes.getCep());
						txtEndereco.setText(clientes.getEndereco());
						txtNumero.setText(String.valueOf(clientes.getNumero()));
						txtComplemento.setText(clientes.getComplemento());
						txtBairro.setText(clientes.getBairro());
						txtCidade.setText(clientes.getCidade());
						cmbUF.setSelectedItem(clientes.getUf());
					} else {
						JOptionPane.showMessageDialog(null, "cliente nao encontrado");
					}
				}
			});
			btnBuscarCliente.setBounds(495, 39, 105, 23);
			pnlDados.add(btnBuscarCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel pnlConsulta = new JPanel();
		pnlConsulta.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Consulta de clientes", null, pnlConsulta, null);
		pnlConsulta.setLayout(null);

		JButton btnPesquisarNome = new JButton("Pesquisar");
		btnPesquisarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botao Pesquisar Nome

				String nome = "%" + txtNomeConsulta.getText() + "%";

				ClientesDAO dao = new ClientesDAO();
				List<Clientes> list = dao.pesquisarClientesPorNome(nome);
				DefaultTableModel dados = (DefaultTableModel) tblClientes.getModel();
				dados.setNumRows(0);

				for (Clientes c : list) {

					dados.addRow(new Object[] { c.getId(), c.getNome(), c.getRg(), c.getCpf(), c.getEmail(),
							c.getTelefone(), c.getCelular(), c.getCep(), c.getEndereco(), c.getNumero(),
							c.getComplemento(), c.getBairro(), c.getCidade(), c.getUf() });
				}

			}
		});
		btnPesquisarNome.setBounds(512, 10, 105, 23);
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

				ClientesDAO dao = new ClientesDAO();
				List<Clientes> list = dao.pesquisarClientesPorNome(nome);
				DefaultTableModel dados = (DefaultTableModel) tblClientes.getModel();
				dados.setNumRows(0);

				for (Clientes c : list) {

					dados.addRow(new Object[] { c.getId(), c.getNome(), c.getRg(), c.getCpf(), c.getEmail(),
							c.getTelefone(), c.getCelular(), c.getCep(), c.getEndereco(), c.getNumero(),
							c.getComplemento(), c.getBairro(), c.getCidade(), c.getUf() });
				}

			}
		});
		txtNomeConsulta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeConsulta.setColumns(10);
		txtNomeConsulta.setBounds(83, 13, 402, 20);
		pnlConsulta.add(txtNomeConsulta);

		tblClientes = new JTable();
		tblClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlDados.setVisible(true);
				txtCodigo.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString());
				txtNome.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 1).toString());
				txtRg.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 2).toString());
				txtCpf.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 3).toString());
				txtEmail.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 4).toString());
				txtTelefone.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 5).toString());
				txtCelular.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 6).toString());
				txtCep.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 7).toString());
				txtEndereco.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 8).toString());
				txtNumero.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 9).toString());
				txtComplemento.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 10).toString());
				txtBairro.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 11).toString());
				txtCidade.setText(tblClientes.getValueAt(tblClientes.getSelectedRow(), 12).toString());
				cmbUF.setSelectedItem(tblClientes.getValueAt(tblClientes.getSelectedRow(), 13).toString());

			}
		});
		tblClientes.setForeground(new Color(0, 0, 0));
		tblClientes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00F3digo", "Nome", "RG", "CPF", "Email", "Telefone", "Celular", "CEP",
						"Endere\u00E7o", "N\u00BA", "Complemento", "Bairro", "Cidade", "UF" }));
		tblClientes.setBounds(0, 56, 892, 102);
		tblClientes.setVisible(true);
		pnlConsulta.add(tblClientes);

		// Adicione a tabela a um JScrollPane
		JScrollPane scrollPane = new JScrollPane(tblClientes);
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
				Clientes clientes = new Clientes();

				clientes.setNome(txtNome.getText());
				clientes.setRg(txtRg.getText());
				clientes.setCpf(txtCpf.getText());
				clientes.setEmail(txtEmail.getText());
				clientes.setTelefone(txtTelefone.getText());
				clientes.setCelular(txtCelular.getText());
				clientes.setCep(txtCep.getText());
				clientes.setEndereco(txtEndereco.getText());
				clientes.setNumero(Integer.parseInt(txtNumero.getText()));
				clientes.setComplemento(txtComplemento.getText());
				clientes.setBairro(txtBairro.getText());
				clientes.setCidade(txtCidade.getText());
				clientes.setUf(cmbUF.getSelectedItem().toString());

				ClientesDAO dao = new ClientesDAO();
				dao.cadastrarCliente(clientes);
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

				Clientes clientes = new Clientes();

				clientes.setNome(txtNome.getText());
				clientes.setRg(txtRg.getText());
				clientes.setCpf(txtCpf.getText());
				clientes.setEmail(txtEmail.getText());
				clientes.setTelefone(txtTelefone.getText());
				clientes.setCelular(txtCelular.getText());
				clientes.setCep(txtCep.getText());
				clientes.setEndereco(txtEndereco.getText());
				clientes.setNumero(Integer.parseInt(txtNumero.getText()));
				clientes.setComplemento(txtComplemento.getText());
				clientes.setBairro(txtBairro.getText());
				clientes.setCidade(txtCidade.getText());
				clientes.setUf(cmbUF.getSelectedItem().toString());
				clientes.setId(Integer.parseInt(txtCodigo.getText()));

				ClientesDAO dao = new ClientesDAO();
				dao.alterarCliente(clientes);

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

				Clientes clientes = new Clientes();

				clientes.setId(Integer.parseInt(txtCodigo.getText()));

				ClientesDAO dao = new ClientesDAO();
				dao.excluirCliente(clientes);
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
		ClientesDAO dao = new ClientesDAO();
		List<Clientes> lista = dao.listarClientes();
		DefaultTableModel dadosTabela = (DefaultTableModel) tblClientes.getModel();
		dadosTabela.setNumRows(0);

		for (Clientes c : lista) {

			dadosTabela.addRow(new Object[] { c.getId(), c.getNome(), c.getRg(), c.getCpf(), c.getEmail(),
					c.getTelefone(), c.getCelular(), c.getCep(), c.getEndereco(), c.getNumero(), c.getComplemento(),
					c.getBairro(), c.getCidade(), c.getUf() });
		}

	}

}
