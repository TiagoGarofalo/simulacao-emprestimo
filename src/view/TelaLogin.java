package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.InlineView;

import model.dao.VendedorDAO;
import model.vo.VendedorVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.ImageIcon;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	VendedorVO vendedor = new VendedorVO();
	private JTextField txtsenha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		// criação do usuario admin
		
		
		vendedor.setCpf("07179591980");
		vendedor.setSenha("123456");
		vendedor.setNome("paulo");
		vendedor.setEmail("paulo@paulo.com");
		VendedorDAO vendedordao = new VendedorDAO();
		vendedordao.insert(vendedor);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(124, 73, 46, 14);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(124, 115, 46, 14);
		contentPane.add(lblSenha);

		txtLogin = new JTextField();
		txtLogin.setBounds(124, 90, 167, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setSelectedIcon(new ImageIcon(TelaLogin.class.getResource("/icones/icons8-\u00E0-esquerda-dentro-de-um-c\u00EDrculo.png")));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String login, senha;
				login = txtLogin.getText();
				senha = txtsenha.getText();		
				
				
				VendedorDAO dao = new VendedorDAO();
				
				if (dao.fazerLogin(login, senha)) {
					TelaPrincipal inicio = new TelaPrincipal();
					inicio.setExtendedState(JFrame.MAXIMIZED_BOTH);
					inicio.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(rootPane, "senha ou usuario invalidos");
				}

			}
		});
		btnLogin.setBounds(151, 163, 108, 52);
		contentPane.add(btnLogin);
		
		txtsenha = new JTextField();
		txtsenha.setBounds(124, 132, 167, 20);
		contentPane.add(txtsenha);
		txtsenha.setColumns(10);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblLogin, lblSenha, txtLogin, btnLogin}));
	}
}
