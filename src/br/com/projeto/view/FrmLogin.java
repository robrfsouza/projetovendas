package br.com.projeto.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.projeto.dao.FuncionariosDAO;
import br.com.projeto.model.Funcionarios;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSenha;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setTitle("Seja bem vindo ao Sistema - Autenticação");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(128, 128, 192));
		panel.setBounds(0, 0, 907, 74);
		contentPane.add(panel);
		
		JLabel lblAutenticaoDeUsurios = new JLabel("Autenticação de Usuários");
		lblAutenticaoDeUsurios.setForeground(Color.WHITE);
		lblAutenticaoDeUsurios.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAutenticaoDeUsurios.setBounds(10, 21, 302, 29);
		panel.add(lblAutenticaoDeUsurios);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 123, 43, 17);
		contentPane.add(lblNewLabel_2);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSenha.setBounds(84, 119, 94, 25);
		contentPane.add(txtSenha);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("E-mail:");
		lblNewLabel_1_1_1_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(10, 85, 48, 27);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(83, 84, 400, 25);
		contentPane.add(txtEmail);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionarios func = new Funcionarios();
				FuncionariosDAO dao = new FuncionariosDAO();
				
				func.setEmail(txtEmail.getText());
				func.setSenha(txtSenha.getText());
				
				dao.Logar(func.getEmail(), func.getSenha());
				setVisible(false);
			}
		});
		btnEntrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEntrar.setBounds(172, 168, 105, 46);
		contentPane.add(btnEntrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		btnSair.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBounds(301, 168, 105, 46);
		contentPane.add(btnSair);
	}
}
