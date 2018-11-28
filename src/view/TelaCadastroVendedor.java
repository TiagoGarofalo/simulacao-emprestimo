package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.controller.VendedorController;
import model.dao.VendedorDAO;
import model.vo.ClienteVO;
import model.vo.VendedorVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.JScrollPane;

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
	private JTable tblvendedores;
	private List<VendedorVO> ListarTodosVendedores;

	/**
	 * Create the panel.
	 */
	public TelaCadastroVendedor() {
		setLayout(null);

		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(39, 50, 46, 14);
		add(lblNome);

		txNome = new JTextField();
		txNome.setBounds(95, 47, 220, 20);
		add(txNome);
		txNome.setColumns(10);

		JLabel lblEmail = new JLabel("E-mail :");
		lblEmail.setBounds(39, 78, 46, 14);
		add(lblEmail);

		txEmail = new JTextField();
		txEmail.setBounds(95, 75, 220, 20);
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
						;
						if (control.verificarexist(novoVendedor)) {
							JOptionPane.showMessageDialog(null,"vendedor ja cadastrado");
						}else {
						JOptionPane.showMessageDialog(null, "Salvo com sucesso");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Preencha os campos!!");
					}

				} else {
					JOptionPane.showMessageDialog(null, "CPF invalido");
				}

			}
		});
		btnCadastrar.setBounds(208, 166, 107, 23);
		add(btnCadastrar);

		JLabel lblCadastrarVendedor = new JLabel("Cadastrar Vendedor");
		lblCadastrarVendedor.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblCadastrarVendedor.setBounds(29, 8, 276, 28);
		add(lblCadastrarVendedor);

		txSenha = new JTextField();
		txSenha.setBounds(95, 103, 150, 20);
		add(txSenha);
		txSenha.setColumns(10);

		JLabel lblNewLabel = new JLabel("Senha : ");
		lblNewLabel.setBounds(39, 104, 46, 14);
		add(lblNewLabel);

		txCPF = new JTextField();
		txCPF.setBounds(95, 134, 86, 20);
		add(txCPF);
		txCPF.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(39, 137, 46, 14);
		add(lblCpf);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (control.ValidaCPF(txCPF.getText()) == true) {
					try {

						control.deletar(txCPF.getText());
						JOptionPane.showMessageDialog(null, "Excluido com sucesso");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Preencha os campos!!");
					}

				} else {
					JOptionPane.showMessageDialog(null, "CPF invalido");
				}

			}
		});
		btnExcluir.setBounds(540, 360, 92, 23);
		add(btnExcluir);

		JLabel lblListaDeVendedores = new JLabel("Lista de Vendedores :");
		lblListaDeVendedores.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblListaDeVendedores.setBounds(39, 207, 257, 37);
		add(lblListaDeVendedores);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<VendedorVO> vendedores = VendedorController.ListarTodosClientes();
				atualizarTabelaVendedores(vendedores);
			}
		});
		btnAtualizar.setBounds(441, 360, 89, 23);
		add(btnAtualizar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 255, 593, 104);
		add(scrollPane);
		scrollPane.setViewportView(tblvendedores);

		tblvendedores = new JTable();
		scrollPane.setViewportView(tblvendedores);
		tblvendedores.setToolTipText("Nome Cpf Email ");
		tblvendedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblvendedores.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "Email" }));
	}

	protected void atualizarTabelaVendedores(List<VendedorVO> vendedores) {
		// atualiza o atributo produtosConsultados
		ListarTodosVendedores = vendedores;

		// Limpa a tabela
		tblvendedores.setModel(new DefaultTableModel(new String[][] { { "Nome", "CPF", "E-mail" }, },
				new String[] { "Nome", "CPF", "E-mail" }));

		DefaultTableModel modelo = (DefaultTableModel) tblvendedores.getModel();

		for (VendedorVO vendedor : vendedores) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			String[] novaLinha = new String[] { vendedor.getNome(), vendedor.getCpf(), vendedor.getEmail()

			};
			modelo.addRow(novaLinha);
		}

	}
}
