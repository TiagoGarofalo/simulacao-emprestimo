package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.controller.SimulacaoController;
import model.vo.Simulacao;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class TelaListaSimulacao extends JPanel {

	private JPanel contentPane;
	private JTable table;
	private JTable tblSimulacao;
	private JTextField tfNome;
	private JTextField tfCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaSimulacao frame = new TelaListaSimulacao();
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
	public TelaListaSimulacao() {

		setBounds(100, 100, 494, 329);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);
		// contentPane.setLayout(null);
		setLayout(null);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SimulacaoController controlador = new SimulacaoController();

				boolean temFiltro = false;

				// TODO pegar da tela os valores dos filtros
				Long numContrato = Long.valueOf(tfNome.getText());
				String cpfCliente = tfCpf.getText();
				List<Simulacao> simulacoes = controlador.listarContratos(numContrato, cpfCliente);

				if (simulacoes != null) {
					atualizarTabelaSimulacoes(simulacoes);
				}
			}
		});

		btnConsultar.setBounds(110, 71, 127, 23);
		add(btnConsultar);

		JLabel lbNumContrato = new JLabel("N\u00BA Contrato:");
		lbNumContrato.setBounds(10, 40, 73, 14);
		add(lbNumContrato);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 56, 404, -1);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 62, 474, 14);
		add(separator_1);

		JLabel lblFiltrosDeConsulta = new JLabel("Filtros de consulta");
		lblFiltrosDeConsulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltrosDeConsulta.setBounds(10, 11, 448, 14);
		add(lblFiltrosDeConsulta);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 194, 345, -100);
		add(scrollPane);

		table = new JTable();
		table.setBounds(30, 225, 246, -119);
		add(table);

		tblSimulacao = new JTable();
		tblSimulacao
				.setModel(new DefaultTableModel(new Object[][] { { "Contrato", "Nome", "CPF", "Valor", "Validade" }, },
						new String[] { "Contrato", "Nome", "CPF", "Valor", "Validade" }));
		tblSimulacao.getColumnModel().getColumn(0).setPreferredWidth(104);
		tblSimulacao.getColumnModel().getColumn(1).setPreferredWidth(163);
		tblSimulacao.getColumnModel().getColumn(2).setPreferredWidth(123);
		tblSimulacao.getColumnModel().getColumn(4).setPreferredWidth(78);
		tblSimulacao.setBounds(10, 105, 474, 213);
		add(tblSimulacao);

		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setBounds(273, 40, 30, 14);
		add(lbCPF);

		tfNome = new JTextField();
		tfNome.setBounds(85, 37, 178, 20);
		add(tfNome);
		tfNome.setColumns(10);

		tfCpf = new JTextField();
		tfCpf.setBounds(303, 37, 181, 20);
		add(tfCpf);
		tfCpf.setColumns(10);

		JButton btnContratar = new JButton("Contratar");
		btnContratar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// TODO acao botao contratar

			}
		});
		btnContratar.setBounds(250, 71, 127, 23);
		add(btnContratar);

	}

	protected void atualizarTabelaSimulacoes(List<Simulacao> simulacoes) {
		// Limpa a tabela
		tblSimulacao.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Contrato", "Nome", "CPF", "Valor", "Validade" }));

		DefaultTableModel modelo = (DefaultTableModel) tblSimulacao.getModel();

		for (Simulacao simula : simulacoes) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do produto
			// na ORDEM do cabeçalho da tabela
			Object[] novaLinha = new Object[] { simula.getNumCont(), simula.getNome(), simula.getCpf(),
					simula.getValorCont(), simula.getDtValidade() };
			modelo.addRow(novaLinha);
		}

	}
}
