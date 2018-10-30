package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.InlineView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 11, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 53, 46, 14);
		contentPane.add(lblSenha);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(10, 28, 167, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtsenha = new JPasswordField();
		txtsenha.setBounds(10, 70, 167, 20);
		contentPane.add(txtsenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (txtLogin.getText().equals("admin")&&txtsenha.getText().equals("admin")) {
					 TelaPrincipal inicio = new TelaPrincipal();
						
						inicio.setVisible(true);
						dispose();
				} else {
					JOptionPane.showMessageDialog(rootPane, "senha ou usuario invalidos");
				}
				
			
				 
								
			}
		});
		btnLogin.setBounds(88, 101, 89, 23);
		contentPane.add(btnLogin);
	}
}
