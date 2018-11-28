package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.controller.ClienteController;
import model.controller.VendedorController;
import model.vo.ClienteVO;
import model.vo.VendedorVO;

import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Font;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JLabel lblcpf;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtemail;
	private List<ClienteVO> ListarTodosClientes;

	ClienteVO cliente = new ClienteVO();
	
	private JTable tblClientes;
	private JButton btnAtualizrLista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		ClienteController clienteControler = new ClienteController();
		
		setTitle("Tela de Cadastro de usu\u00E1rio");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(TelaCadastroCliente.class.getResource("/icones/icons8-usu\u00E1rio.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblnome = new JLabel("Nome :");
		lblnome.setBounds(42, 69, 46, 14);
		contentPane.add(lblnome);

		lblcpf = new JLabel("CPF :");
		lblcpf.setBounds(42, 94, 46, 14);
		contentPane.add(lblcpf);

		JLabel lblemail = new JLabel("E-mail:");
		lblemail.setBounds(42, 119, 46, 14);
		contentPane.add(lblemail);

		JButton btnCadastrar = new JButton("Salvar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (clienteControler.ValidaCPF(txtCPF.getText()) == true) {
					try {
						
						cliente.setNome(txtNome.getText());
						cliente.setEmail(txtemail.getText());
						cliente.setCpf(txtCPF.getText());
						clienteControler.salvar(cliente);
						List<ClienteVO> clientes = clienteControler.ListarTodosClientes();
						atualizarTabelaClientes(clientes);
						
						
						JOptionPane.showMessageDialog(null,"Salvo com sucesso");
						
					} catch (Exception e2) {
						
						JOptionPane.showMessageDialog(null,"Erro ao salvar"+ e2);
					}
				} else {
					JOptionPane.showMessageDialog(null,"Erro ao salvar, CPF invalido");
				}
				

			}
		});
		btnCadastrar.setBounds(168, 144, 94, 23);
		contentPane.add(btnCadastrar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (clienteControler.ValidaCPF(txtCPF.getText()) == true) {
					try {

						clienteControler.deletar(txtCPF.getText());
						JOptionPane.showMessageDialog(null, "Excluido com sucesso");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Preencha os campos!!");
					}

				} else {
					JOptionPane.showMessageDialog(null, "CPF invalido");
				}
				
					}
		});
		btnExcluir.setBounds(488, 348, 89, 23);
		contentPane.add(btnExcluir);

		txtNome = new JTextField();
		txtNome.setBounds(98, 66, 164, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtCPF = new JTextField();
		txtCPF.setBounds(98, 91, 164, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		txtemail = new JTextField();
		txtemail.setBounds(98, 116, 164, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		btnAtualizrLista = new JButton("Atualizar");
		btnAtualizrLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ClienteVO> clientes= clienteControler.ListarTodosClientes();
				atualizarTabelaClientes(clientes);
				
			}
		});
		btnAtualizrLista.setBounds(371, 348, 107, 23);
		contentPane.add(btnAtualizrLista);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 226, 520, 111);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(tblClientes);
		
		tblClientes = new JTable();
		scrollPane.setViewportView(tblClientes);
		
		JLabel lblListaDeClientes = new JLabel("Lista de Clientes:");
		lblListaDeClientes.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblListaDeClientes.setBounds(42, 168, 201, 47);
		contentPane.add(lblListaDeClientes);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Cliente :");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(42, 11, 220, 47);
		contentPane.add(lblNewLabel);
	}
	protected void atualizarTabelaClientes(List<ClienteVO> clientes) {
		// atualiza o atributo produtosConsultados
		ListarTodosClientes = clientes;

		// Limpa a tabela
		tblClientes.setModel(new DefaultTableModel(new String[][] { { "Nome", "CPF", "E-mail" }, },
				new String[] { "Nome", "CPF", "E-mail" }));

		DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();

		for (ClienteVO cliente : clientes) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			String[] novaLinha = new String[] { cliente.getNome(), cliente.getCpf(), cliente.getEmail()

			};
			modelo.addRow(novaLinha);
		}

	}
}
