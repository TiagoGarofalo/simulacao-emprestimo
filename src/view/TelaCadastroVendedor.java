package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaCadastroVendedor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNome;
	private JTextField tfSenha;

	/**
	 * Create the panel.
	 */
	public TelaCadastroVendedor() {
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 50, 46, 14);
		add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(10, 66, 220, 20);
		add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 97, 46, 14);
		add(lblSenha);
		
		tfSenha = new JTextField();
		tfSenha.setBounds(10, 113, 220, 20);
		add(tfSenha);
		tfSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 147, 220, 23);
		add(btnCadastrar);
		
		JLabel lblCadastrarVendedor = new JLabel("Cadastrar Vendedor");
		lblCadastrarVendedor.setBounds(10, 11, 150, 14);
		add(lblCadastrarVendedor);

	}

}
