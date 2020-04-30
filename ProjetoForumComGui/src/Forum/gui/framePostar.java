package Forum.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import forumSistema.*;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

public class framePostar extends JFrame {

	private JPanel contentPane;
	
	public Sistema s;
	private JTextField textField;
	private Usuario u;
	
	private JTextArea textArea;
	private JLabel returnLabel;
	private JLabel mensagemLabel;
	private JButton exit;
	private mainFrame f;

	/**
	 * Create the frame.
	 */
	public framePostar(Sistema s, Usuario u, mainFrame f) {
		setBackground(Color.DARK_GRAY);
		this.f = f;
		this.s = s;
		this.u = u;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 526);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 89, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -75, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -15, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 51, SpringLayout.NORTH, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel labeltituPost = new JLabel("TITULO (max 20 caracteres)");
		sl_contentPane.putConstraint(SpringLayout.WEST, labeltituPost, 207, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, labeltituPost, -11, SpringLayout.NORTH, textField);
		contentPane.add(labeltituPost);
		
		JLabel labelTexto = new JLabel("Texto:");
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 128, SpringLayout.EAST, labelTexto);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, 368, SpringLayout.EAST, labelTexto);
		sl_contentPane.putConstraint(SpringLayout.WEST, labelTexto, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, labelTexto, -16, SpringLayout.NORTH, scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		contentPane.add(labelTexto);
		
		JButton fazerPost = new JButton("POSTAR");
		sl_contentPane.putConstraint(SpringLayout.NORTH, fazerPost, 6, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, fazerPost, 248, SpringLayout.WEST, contentPane);
		contentPane.add(fazerPost);
		
		returnLabel = new JLabel("New label");
		returnLabel.setVisible(false);
		sl_contentPane.putConstraint(SpringLayout.WEST, returnLabel, 104, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, returnLabel, 0, SpringLayout.SOUTH, contentPane);
		contentPane.add(returnLabel);
		
		mensagemLabel = new JLabel("New label");
		mensagemLabel.setVisible(false);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, mensagemLabel, -6, SpringLayout.NORTH, returnLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, mensagemLabel, 0, SpringLayout.EAST, returnLabel);
		contentPane.add(mensagemLabel);
		
		exit = new JButton("SAIR");
		sl_contentPane.putConstraint(SpringLayout.NORTH, exit, 6, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, exit, 0, SpringLayout.EAST, scrollPane);
		contentPane.add(exit);
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.atualizaPosts();
				dispose();
			}
		});
		
		fazerPost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PostagemPublica p = new PostagemPublica(s);
				String CorpoTexto = textArea.getText();
				String titulo = textField.getText();
				String mensagem;
				if(u instanceof UsuarioModerador) {
					p.criaPostagemPublica(s, u.getNome(), CorpoTexto, titulo, ((UsuarioModerador) u).getCargo());
					returnLabel.setText("Postagem Submetida! Clique SAIR se nao for postar mais nada.");
					returnLabel.setVisible(true);
					
					FileWriter fStream = null;
					try {
						fStream = new FileWriter("src/postagens.csv", true);
					} catch (IOException e) {
						e.printStackTrace();
					}
					PrintWriter out = new PrintWriter(fStream);
					out.println(u.getNome() + ";" + textField.getText() + ";" + textArea.getText());
					out.flush();
					out.close();
					try {
						fStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
						
				}
				else {
					mensagem = p.criaPostagemPublica(s, u.getNome(), CorpoTexto, titulo);
					returnLabel.setText("Postagem Submetida para avaliacao! Clique SAIR se nao for postar mais nada.");
					returnLabel.setVisible(true);
					mensagemLabel.setText(mensagem);
					mensagemLabel.setVisible(true);
				}
				
				textField.setText("");
				textArea.setText("");
			}
		});
	}
}
