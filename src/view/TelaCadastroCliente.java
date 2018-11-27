package view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.controller.ClienteController;
import model.vo.ClienteVO;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblnome = new JLabel("Nome :");
		lblnome.setBounds(42, 27, 46, 14);
		contentPane.add(lblnome);

		lblcpf = new JLabel("CPF :");
		lblcpf.setBounds(42, 52, 46, 14);
		contentPane.add(lblcpf);

		JLabel lblemail = new JLabel("E-mail:");
		lblemail.setBounds(42, 77, 46, 14);
		contentPane.add(lblemail);

		JButton btnCadastrar = new JButton("Salvar Cliente");
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
		btnCadastrar.setBounds(42, 102, 134, 23);
		contentPane.add(btnCadastrar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(314, 227, 89, 23);
		contentPane.add(btnExcluir);

		txtNome = new JTextField();
		txtNome.setBounds(98, 24, 164, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtCPF = new JTextField();
		txtCPF.setBounds(98, 49, 117, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		txtemail = new JTextField();
		txtemail.setBounds(98, 74, 164, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		tblClientes = new JTable();
		tblClientes.setBounds(42, 136, 342, 82);
		contentPane.add(tblClientes);
		
		btnAtualizrLista = new JButton("Atualizr lista");
		btnAtualizrLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ClienteVO> clientes = clienteControler.ListarTodosClientes();
				atualizarTabelaClientes(clientes);
				
			}
		});
		btnAtualizrLista.setBounds(197, 227, 107, 23);
		contentPane.add(btnAtualizrLista);
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
