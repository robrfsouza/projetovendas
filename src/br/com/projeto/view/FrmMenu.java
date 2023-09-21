package br.com.projeto.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
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

public class FrmMenu extends JFrame {

	private JPanel contentPane;

	ImageIcon icon = new ImageIcon(getClass().getResource("/imagem/fundo.jpg"));

	Image image = icon.getImage();
	private final JDesktopPane painelDesktop = new JDesktopPane() {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenu frame = new FrmMenu();
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
	public FrmMenu() {
		setTitle("Sistema de Controle de Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 425);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Clientes");
		mnNewMenu.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagem/clientes.png")));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Controle de Clientes");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		mntmNewMenuItem.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem.setAlignmentX(Component.LEFT_ALIGNMENT);
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnNewMenu_1 = new JMenu("Funcionários");
		mnNewMenu_1.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagem/funcionarios.png")));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Controle de Funcionários");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("Fornecedores");
		mnNewMenu_2.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagem/fornecedores.png")));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Controle de Fornecedores");
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_3 = new JMenu("Produtos");
		mnNewMenu_3.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagem/produtos.png")));
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
		mnNewMenu_5.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagem/vendas.png")));
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
		mnNewMenu_4.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagem/configuracoes.png")));
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Troca de Usuário");
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_DOWN_MASK));
		mnNewMenu_4.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_6 = new JMenu("Sair");
		mnNewMenu_6.setIcon(new ImageIcon(FrmMenu.class.getResource("/imagem/sair.png")));
		menuBar.add(mnNewMenu_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		//contentPane.setLayout(null);
		//painelDesktop.setBounds(0, 0, 891, 332);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(painelDesktop);
	}
}
