package Forum.gui;

import forumSistema.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.ComponentOrientation;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	public Sistema s;
	public Usuario u;
	public JLabel currentCounter;
	JButton previous;
	JButton next;
	JButton listadePendentes;
	public int npag;
	public int pagAtual;
	public ArrayList<JButton> buttons;
	public ArrayList<JLabel> labels;

	public ArrayList<Mensagem> arrMensagens;
	
	public void atualizaPosts() {
		npag = (int) Math.ceil(s.postagens.size() / 7.0);
		currentCounter.setText("PAGINA ATUAL:  " + pagAtual + " DE " + npag);
		previous.setVisible(pagAtual > 1);
		previous.setEnabled(pagAtual > 1);
		next.setVisible(pagAtual < npag);
		next.setEnabled(pagAtual < npag);
		ArrayList<Mensagem> m = s.getPostagens();
		
		int k = 7;
		for(Mensagem atual : m ) {
			int i = m.indexOf(atual);
			
			if(i >= 7 * (pagAtual - 1) && i < 7 * pagAtual) {
				
				k = i%7;
				labels.get(k).setText(atual.getTitulo());
				labels.get(k).setVisible(true);
				buttons.get(k).setVisible(true);
				buttons.get(k).setEnabled(true);
		
				arrMensagens.set(k, atual);
			}
		}
		
		k++;
		
		while(k < 7) {
			labels.get(k).setVisible(false);
			buttons.get(k).setVisible(false);
			buttons.get(k).setEnabled(false);
			k++;
		}
		
	}
	
	public mainFrame(Sistema s, Usuario u) {
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		buttons = new ArrayList<JButton>();
		labels = new ArrayList<JLabel>();
		arrMensagens = new ArrayList<Mensagem>();
		mainFrame f = this;
		
		setResizable(false);
		setForeground(new Color(102, 102, 204));
		this.s = s;
		this.u = u;
		npag = (int) Math.ceil(s.postagens.size() / 7.0);
		pagAtual = 1;
		
		setMinimumSize(new Dimension(800, 800));
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel greetLabel = new JLabel("Bom dia " + u.getNome() + "!");
		greetLabel.setBounds(236, 15, 524, 19);
		greetLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		contentPane.add(greetLabel);
		
		for (int i = 0; i < 7; i++) {
			arrMensagens.add(null);
		}
		
		JLabel lblPost = new JLabel("post1");
		lblPost.setBounds(163, 195, 229, 19);
		lblPost.setVisible(false);
		lblPost.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblPost);
		labels.add(lblPost);
		
		
		JLabel lblPost_1 = new JLabel("post2");
		lblPost_1.setBounds(163, 263, 229, 18);
		lblPost_1.setVisible(false);
		lblPost_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblPost_1);
		labels.add(lblPost_1);
		
		JLabel lblPost_2 = new JLabel("post3");
		lblPost_2.setBounds(163, 338, 229, 18);
		lblPost_2.setVisible(false);
		lblPost_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblPost_2);
		labels.add(lblPost_2);
		
		JLabel lblPost_3 = new JLabel("post4");
		lblPost_3.setBounds(163, 411, 229, 18);
		lblPost_3.setVisible(false);
		lblPost_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblPost_3);
		labels.add(lblPost_3);
		
		JLabel lblPost_4 = new JLabel("post5");
		lblPost_4.setBounds(163, 485, 229, 18);
		lblPost_4.setVisible(false);
		lblPost_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblPost_4);
		labels.add(lblPost_4);
		
		JLabel lblPost_5 = new JLabel("post6");
		lblPost_5.setBounds(163, 559, 229, 18);
		lblPost_5.setVisible(false);
		lblPost_5.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblPost_5);
		labels.add(lblPost_5);
		
		JLabel lblPost_6 = new JLabel("post7");
		lblPost_6.setBounds(163, 631, 229, 18);
		lblPost_6.setVisible(false);
		lblPost_6.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lblPost_6);
		labels.add(lblPost_6);
		
		JButton button = new JButton("Acessar");
		button.setBounds(438, 192, 86, 26);
		button.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		button.setEnabled(false);
		button.setVisible(false);
		contentPane.add(button);
		buttons.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameView frame = new frameView(s, arrMensagens.get(0), u, f);
				frame.setVisible(true);
			}
		});
		
		
		JButton button_1 = new JButton("Acessar");
		button_1.setBounds(438, 263, 86, 26);
		button_1.setEnabled(false);
		button_1.setVisible(false);
		contentPane.add(button_1);
		buttons.add(button_1);
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameView frame = new frameView(s, arrMensagens.get(1), u, f);
				frame.setVisible(true);
			}
		});
		
		JButton button_2 = new JButton("Acessar");
		button_2.setBounds(438, 336, 86, 25);
		button_2.setEnabled(false);
		button_2.setVisible(false);
		contentPane.add(button_2);
		buttons.add(button_2);
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameView frame = new frameView(s, arrMensagens.get(2), u, f);
				frame.setVisible(true);
			}
		});
		
		JButton button_3 = new JButton("Acessar");
		button_3.setBounds(438, 409, 86, 25);
		button_3.setEnabled(false);
		button_3.setVisible(false);
		contentPane.add(button_3);
		buttons.add(button_3);
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameView frame = new frameView(s, arrMensagens.get(3), u, f);
				frame.setVisible(true);
			}
		});
		
		JButton button_4 = new JButton("Acessar");
		button_4.setBounds(438, 483, 86, 25);
		button_4.setEnabled(false);
		button_4.setVisible(false);
		contentPane.add(button_4);
		buttons.add(button_4);
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameView frame = new frameView(s, arrMensagens.get(4), u, f);
				frame.setVisible(true);
			}
		});
		
		JButton button_5 = new JButton("Acessar");
		button_5.setBounds(438, 557, 86, 25);
		button_5.setEnabled(false);
		button_5.setVisible(false);
		contentPane.add(button_5);
		buttons.add(button_5);
		button_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameView frame = new frameView(s, arrMensagens.get(5), u, f);
				frame.setVisible(true);
			}
		});
		
		JButton button_6 = new JButton("Acessar");
		button_6.setBounds(438, 629, 86, 25);
		button_6.setEnabled(false);
		button_6.setVisible(false);
		contentPane.add(button_6);
		buttons.add(button_6);
		button_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameView frame = new frameView(s, arrMensagens.get(6), u, f);
				frame.setVisible(true);
			}
		});
		
		
		
		
		
		
		previous = new JButton("<");
		previous.setBounds(70, 409, 51, 25);
		previous.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		previous.setHorizontalAlignment(SwingConstants.LEFT);
		previous.setHorizontalTextPosition(SwingConstants.CENTER);
		previous.setVisible(false);
		previous.setEnabled(false);
		contentPane.add(previous);
		
		next = new JButton(">");
		next.setBounds(681, 404, 44, 25);
		next.setEnabled(npag > 1);
		next.setVisible(npag > 1);
		contentPane.add(next);
		
		currentCounter = new JLabel(" ");
		currentCounter.setBounds(251, 104, 167, 15);
		atualizaPosts();
		contentPane.add(currentCounter);
		
		
		previous.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pagAtual--;
				atualizaPosts();
			}
		});
		
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pagAtual++;
				atualizaPosts();
			}
		});
		
		
		JLabel forcaguerreirx = new JLabel("Você está em um espaço seguro, sinta-se à vontade!");
		forcaguerreirx.setBounds(207, 689, 374, 15);
		contentPane.add(forcaguerreirx);
		
		listadePendentes = new JButton("Lista de Pendentes");
		listadePendentes.setBounds(560, 143, 165, 25);
		listadePendentes.setVisible(u instanceof UsuarioModerador && !s.getPendentes().isEmpty());
		listadePendentes.setEnabled(u instanceof UsuarioModerador && !s.getPendentes().isEmpty());
		contentPane.add(listadePendentes);
		
		
		listadePendentes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!s.getPendentes().isEmpty()) {
					framePendentes frame = new framePendentes(s, s.getPendentes().get(0), f);
					frame.setVisible(true);
				}
			}
		});
		
		
		JButton postar = new JButton("Criar Postagem");
		postar.setBounds(70, 143, 139, 25);
		contentPane.add(postar);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setBounds(695, 684, 65, 25);
		contentPane.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frameLogin frame = new frameLogin(s);
				frame.setVisible(true);
				dispose();
			}
		});
		
		
		
		
		postar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				framePostar frame = new framePostar(s, u, f);
				frame.setVisible(true);
			}
		});
		
	}

}
