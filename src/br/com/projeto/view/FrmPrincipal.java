package br.com.projeto.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;

import javax.swing.*;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import br.com.projeto.dao.FuncionariosDAO;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.Utilitarios;

import java.awt.Font;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	public String usuarioLogado;
	public JLabel lblUsuario = new JLabel();
	private JLabel lblDataHora = new JLabel();

	ImageIcon icon = new ImageIcon(getClass().getResource("/imagem/fundo.jpg"));

	Image image = icon.getImage();
	private final JDesktopPane painelDesktop = new JDesktopPane() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	};
	private final JPanel pnlBarraStatus = new JPanel();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setTitle("Sistema de Controle de Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 425);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Clientes");
		mnNewMenu.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagem/clientes.png")));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Controle de Clientes");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		mntmNewMenuItem.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setAlignmentX(Component.LEFT_ALIGNMENT);
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnNewMenu_1 = new JMenu("Funcionários");
		mnNewMenu_1.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagem/funcionarios.png")));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Controle de Funcionários");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("Fornecedores");
		mnNewMenu_2.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagem/fornecedores.png")));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Controle de Fornecedores");
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_3 = new JMenu("Produtos");
		mnNewMenu_3.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagem/produtos.png")));
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Controle de Estoque");
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_3.add(mntmNewMenuItem_3);

		JSeparator separator = new JSeparator();
		mnNewMenu_3.add(separator);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Consulta de Produtos");
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_3.add(mntmNewMenuItem_4);

		JMenu mnNewMenu_5 = new JMenu("Vendas");
		mnNewMenu_5.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagem/vendas.png")));
		menuBar.add(mnNewMenu_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Abrir PDV");
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_5.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Posição do Dia");
		mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_5.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Histórico de Vendas");
		mntmNewMenuItem_8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_5.add(mntmNewMenuItem_8);

		JMenu mnNewMenu_4 = new JMenu("Configurações");
		mnNewMenu_4.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagem/configuracoes.png")));
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Troca de Usuário");
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_4.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_6 = new JMenu("Sair");
		mnNewMenu_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu_6.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/imagem/sair.png")));
		menuBar.add(mnNewMenu_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(painelDesktop, BorderLayout.CENTER);
		pnlBarraStatus.setBackground(new Color(128, 128, 192));
		contentPane.add(pnlBarraStatus, BorderLayout.SOUTH);
		pnlBarraStatus.setLayout(new MigLayout("", "[222.00px][533.00px][107.00][746.00px]", "[14px]"));
		
		JLabel lblNewLabel = new JLabel("Bem-vindo");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		pnlBarraStatus.add(lblNewLabel, "cell 0 0,alignx left,aligny center");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setForeground(new Color(255, 255, 255));
		pnlBarraStatus.add(lblUsuario, "cell 2 0,alignx right,aligny center");
		
		
		
		//Criar um Timer para atualizar a JLabel a cada segundo
		javax.swing.Timer timer = new javax.swing.Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atualizarTempo();
			}
		});
		timer.start();
		
		
		
		//String para ser alimentada do método AtualizadDataHora que está na classe utilitarios
		String dataHora = Utilitarios.AtualizaDataHora();
		lblDataHora.setFont(new Font("Tahoma", Font.BOLD, 11));
		//Abaixo, o codigo pede que  lblDataHora exiba a data e a hora no sistema
		lblDataHora.setText(dataHora);
		pnlBarraStatus.add(lblDataHora, "cell 3 0,alignx right,aligny center");
	}
	public void atualizarTempo() {
		String DataHora = Utilitarios.AtualizaDataHora();
		lblDataHora.setText(DataHora);
	}
}
