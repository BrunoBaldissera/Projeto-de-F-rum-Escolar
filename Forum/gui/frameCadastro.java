package Forum.gui;

import forumSistema.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class frameCadastro extends JFrame implements ActionListener{

	private Sistema s;
	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField senhaField;
	private JTextField cargoField;
	private JLabel nomeLabel;
	private JLabel senhaLabel;
	private JLabel cargoLabel;
	private JLabel greetText;
	private JCheckBox modCheck;
	private JButton aceitaButton;


	public frameCadastro(Sistema s) {
		this.s = s;
		
		setForeground(Color.WHITE);
		setBackground(Color.DARK_GRAY);
		setTitle("CADASTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel modText = new JLabel("Voce eh um moderador?");
		sl_contentPane.putConstraint(SpringLayout.EAST, modText, 254, SpringLayout.WEST, contentPane);
		modText.setVerticalAlignment(SwingConstants.BOTTOM);
		modText.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(modText);
		
		modCheck = new JCheckBox("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, modCheck, 15, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, modCheck, 6, SpringLayout.EAST, modText);
		sl_contentPane.putConstraint(SpringLayout.EAST, modCheck, -155, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, modText, 0, SpringLayout.NORTH, modCheck);
		modCheck.setBackground(new Color(51, 204, 255));
		modCheck.setVerticalAlignment(SwingConstants.BOTTOM);
		modCheck.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(modCheck);
		
		modCheck.addActionListener(this);
		modCheck.setActionCommand("mod");
		
		
		nomeField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, nomeField, 112, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, nomeField, -123, SpringLayout.EAST, contentPane);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		senhaField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, senhaField, -115, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, nomeField, -29, SpringLayout.NORTH, senhaField);
		sl_contentPane.putConstraint(SpringLayout.WEST, senhaField, 0, SpringLayout.WEST, nomeField);
		sl_contentPane.putConstraint(SpringLayout.EAST, senhaField, 0, SpringLayout.EAST, nomeField);
		contentPane.add(senhaField);
		senhaField.setColumns(10);
		
		cargoField = new JTextField();
		cargoField.setFocusable(false);
		cargoField.setVisible(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, cargoField, 26, SpringLayout.SOUTH, senhaField);
		sl_contentPane.putConstraint(SpringLayout.WEST, cargoField, 0, SpringLayout.WEST, nomeField);
		sl_contentPane.putConstraint(SpringLayout.EAST, cargoField, 0, SpringLayout.EAST, nomeField);
		contentPane.add(cargoField);
		cargoField.setColumns(10);
		
		nomeLabel = new JLabel("Login:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, nomeLabel, 0, SpringLayout.NORTH, nomeField);
		sl_contentPane.putConstraint(SpringLayout.WEST, nomeLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(nomeLabel);
		
		senhaLabel = new JLabel("Senha:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, senhaLabel, 0, SpringLayout.NORTH, senhaField);
		sl_contentPane.putConstraint(SpringLayout.WEST, senhaLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(senhaLabel);
		
		cargoLabel = new JLabel("Cargo:");
		cargoLabel.setVisible(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, cargoLabel, 0, SpringLayout.NORTH, cargoField);
		sl_contentPane.putConstraint(SpringLayout.WEST, cargoLabel, 10, SpringLayout.WEST, contentPane);
		contentPane.add(cargoLabel);
		
		greetText = new JLabel("Digite as credenciais a serem cadastradas");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, modCheck, -10, SpringLayout.NORTH, greetText);
		sl_contentPane.putConstraint(SpringLayout.WEST, modText, 0, SpringLayout.WEST, greetText);
		sl_contentPane.putConstraint(SpringLayout.NORTH, greetText, 41, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, greetText, -69, SpringLayout.EAST, contentPane);
		contentPane.add(greetText);
		
		aceitaButton = new JButton("Cadastrar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, aceitaButton, 17, SpringLayout.SOUTH, cargoField);
		sl_contentPane.putConstraint(SpringLayout.WEST, aceitaButton, 158, SpringLayout.WEST, contentPane);
		contentPane.add(aceitaButton);
		
		aceitaButton.addActionListener(this);
		aceitaButton.setActionCommand("criar");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if("mod".equals(arg0.getActionCommand())) {
			if(modCheck.isSelected()) {
				cargoLabel.setVisible(true);
				cargoField.setFocusable(true);
				cargoField.setVisible(true);
			}
			else {
				cargoLabel.setVisible(false);
				cargoField.setFocusable(false);
				cargoField.setVisible(false);
			}
		}
		if("criar".equals(arg0.getActionCommand())) {
			if(modCheck.isSelected()) {
				new UsuarioModerador(s, nomeField.getText(), senhaField.getText(), cargoField.getText());
			}
			else {
				new Usuario(s, nomeField.getText(), senhaField.getText());				
			}
			dispose();
		}
	}

}
