package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.controller.VendedorController;
import model.vo.VendedorVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroVendedor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txNome;
	private JTextField txEmail;
	private VendedorController control = new VendedorController();
	private JTextField txSenha;
	private JTextField txCPF;
	
	/**
	 * Create the panel.
	 */
	public TelaCadastroVendedor() {
		setLayout(null);

		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(10, 50, 46, 14);
		add(lblNome);

		txNome = new JTextField();
		txNome.setBounds(66, 47, 220, 20);
		add(txNome);
		txNome.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(10, 78, 46, 14);
		add(lblEmail);

		txEmail = new JTextField();
		txEmail.setBounds(66, 75, 220, 20);
		add(txEmail);
		txEmail.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (control.ValidaCPF(txCPF.getText()) == true) {	
				try {
					VendedorVO novoVendedor = new VendedorVO();
					
				novoVendedor.setNome(txNome.getText());
				novoVendedor.setEmail(txEmail.getText());
				novoVendedor.setCpf(txCPF.getText());
				novoVendedor.setSenha(txSenha.getText());
				control.salvar(novoVendedor);
				JOptionPane.showMessageDialog(null, "Salvo com sucesso");	
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"Preencha os campos!!");
				}

			} else {
				JOptionPane.showMessageDialog(null,"CPF invalido");
			}
				
				
			}
		});
		btnCadastrar.setBounds(10, 209, 220, 23);
		add(btnCadastrar);

		JLabel lblCadastrarVendedor = new JLabel("Cadastrar Vendedor");
		lblCadastrarVendedor.setBounds(10, 11, 150, 14);
		add(lblCadastrarVendedor);
		
		txSenha = new JTextField();
		txSenha.setBounds(66, 102, 150, 20);
		add(txSenha);
		txSenha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Senha : ");
		lblNewLabel.setBounds(10, 103, 46, 14);
		add(lblNewLabel);
		
		txCPF = new JTextField();
		txCPF.setBounds(66, 133, 86, 20);
		add(txCPF);
		txCPF.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 136, 46, 14);
		add(lblCpf);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (control.ValidaCPF(txCPF.getText()) == true) {	
					try {
						
					control.deletar(txCPF.getText());
					JOptionPane.showMessageDialog(null, "Excluido com sucesso");	
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,"Preencha os campos!!");
					}

				} else {
					JOptionPane.showMessageDialog(null,"CPF invalido");
				}
				
			}
		});
		btnExcluir.setBounds(10, 243, 220, 23);
		add(btnExcluir);

	}
}
