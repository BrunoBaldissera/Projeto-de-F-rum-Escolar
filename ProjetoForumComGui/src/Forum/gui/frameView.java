package Forum.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import forumSistema.*;

import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class frameView extends JFrame {

	private JPanel contentPane;
	private Sistema s;
	private Mensagem m;
	private Usuario u;
	private mainFrame f;


	public frameView(Sistema s, Mensagem m, Usuario u, mainFrame f) {
		this.s = s;
		this.m = m;
		
		
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 776, 543);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 106, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -40, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, -106, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane);
		
		JLabel tituPostView = new JLabel(m.getTitulo());
		sl_contentPane.putConstraint(SpringLayout.NORTH, tituPostView, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, tituPostView, 283, SpringLayout.WEST, contentPane);
		contentPane.add(tituPostView);
		
		JLabel autor = new JLabel(m.getAutor());
		sl_contentPane.putConstraint(SpringLayout.WEST, autor, 101, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, autor, -466, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 11, SpringLayout.SOUTH, autor);
		contentPane.add(autor);
		
		JLabel cargo = new JLabel("<dynamic cargo>");
		sl_contentPane.putConstraint(SpringLayout.NORTH, cargo, 11, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, cargo, 0, SpringLayout.WEST, scrollPane);
		
		JTextArea textArea = new JTextArea(m.getCorpo_texto());
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		if(m.getCargo() == null)
			cargo.setVisible(false);
		else
			cargo.setText(m.getCargo());
		contentPane.add(cargo);
		
		JButton sair = new JButton("SAIR");
		sl_contentPane.putConstraint(SpringLayout.NORTH, sair, -5, SpringLayout.NORTH, cargo);
		sl_contentPane.putConstraint(SpringLayout.EAST, sair, 0, SpringLayout.EAST, scrollPane);
		contentPane.add(sair);
		
		JButton comentar = new JButton("Comentar");
		sl_contentPane.putConstraint(SpringLayout.NORTH, comentar, 6, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comentar, 89, SpringLayout.EAST, cargo);
		contentPane.add(comentar);
		
		comentar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameComent frame = new frameComent(s, u, f, m);
				frame.setVisible(true);
			}
		});
		
		
		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
	}

}
