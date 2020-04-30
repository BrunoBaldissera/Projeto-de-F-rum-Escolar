package Forum.gui;

import forumSistema.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class frameLogin extends JFrame {

	public Sistema s;
	private JPanel contentPane;
	public JPasswordField passwordField;
	public JTextField loginField;
	public JLabel loginLabel;
	public JLabel passLabel;
	public JLabel errorLabel;


	public frameLogin(Sistema s) {
		setResizable(false);
		this.s = s;
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(64, 64, 64));
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		passwordField = new JPasswordField();
		
		JLabel titleLabel = new JLabel("Bem-Vindx ao WILL, o forum de apoio a vitimas de bullying");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		loginLabel = new JLabel("Login:");
		
		passLabel = new JLabel("Senha:");
		
		JButton entrar = new JButton("Entrar");
		
		JButton criar = new JButton("Cadastrar");
		
		entrar.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = (String) loginField.getText();
				String senha = new String(passwordField.getPassword());
						
				Usuario u = s.estaNoSistema(nome, senha);
				if (u == null)
					errorLabel.setVisible(true);
				else {
					mainFrame frame = new mainFrame(s, u);
					frame.setVisible(true);
					dispose();
				}
			}
		});
		
		criar.addActionListener(new ActionListener( ) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String nome = (String) loginField.getText();
				String senha = new String(passwordField.getPassword());
						
				frameCadastro frame = new frameCadastro(s);
				frame.setVisible(true);
			}
		});
		
		loginField = new JTextField();
		loginField.setColumns(10);
		
		errorLabel = new JLabel("Credenciais invalidas. Reinsira seus dados ou cadastre-se.");
		errorLabel.setVisible(false);
		errorLabel.setForeground(new Color(255, 0, 0));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(titleLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(loginLabel)
								.addComponent(passLabel))
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(loginField)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(entrar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(criar))
								.addComponent(passwordField, 240, 240, Short.MAX_VALUE))))
					.addContainerGap(26, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(156, Short.MAX_VALUE)
					.addComponent(errorLabel)
					.addGap(119))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginLabel)
						.addComponent(loginField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passLabel)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(entrar)
						.addComponent(criar))
					.addGap(18)
					.addComponent(errorLabel)
					.addGap(30))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
