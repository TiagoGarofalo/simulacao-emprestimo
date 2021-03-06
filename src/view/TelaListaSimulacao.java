package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bo.GeradorPlanilha;
import model.controller.ClienteController;
import model.controller.SimulacaoController;
import model.vo.SimulacaoVO;


import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class TelaListaSimulacao extends JPanel {

	private JPanel contentPane;
	private JTable table;
	private JTable tblSimulacao;
	private JTextField tfNumCont;
	private JTextField tfCpf;

	//Esta lista de produtos � atualizada a cada nova consulta realizada com os filtros.
		//Ser� a lista usada para gerar os relat�rios
		private List<SimulacaoVO> simulacoesConsultadas;
	
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
	List<SimulacaoVO> simulacoes = new ArrayList<>();
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

				// TODO pegar da tela os valores dos filtros
				String numContrato = String.valueOf(tfNumCont.getText());
				String cpfCliente = tfCpf.getText();
				simulacoes = controlador.listarContratos(numContrato, cpfCliente);

				if (simulacoes != null) {
					atualizarTabelaSimulacoes(simulacoes);
				}
			}
		});

		btnConsultar.setBounds(10, 71, 127, 23);
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
				.setModel(new DefaultTableModel(
			new Object[][] {
				{"Contrato", "Nome", "CPF", "Valor", "num Parcelas", "Contratado"},
			},
			new String[] {
				"Contrato", "Nome", "CPF", "Valor", "num Parcelas", "Contratado"
			}
		));
		tblSimulacao.getColumnModel().getColumn(0).setPreferredWidth(110);
		tblSimulacao.getColumnModel().getColumn(1).setPreferredWidth(174);
		tblSimulacao.getColumnModel().getColumn(2).setPreferredWidth(109);
		tblSimulacao.getColumnModel().getColumn(3).setPreferredWidth(89);
		tblSimulacao.getColumnModel().getColumn(4).setPreferredWidth(78);
		tblSimulacao.setBounds(10, 105, 474, 213);
		add(tblSimulacao);

		JLabel lbCPF = new JLabel("CPF:");
		lbCPF.setBounds(273, 40, 30, 14);
		add(lbCPF);

		tfNumCont = new JTextField();
		tfNumCont.setBounds(85, 37, 178, 20);
		add(tfNumCont);
		tfNumCont.setColumns(10);

		tfCpf = new JTextField();
		tfCpf.setBounds(303, 37, 181, 20);
		add(tfCpf);
		tfCpf.setColumns(10);

		JButton btnContratar = new JButton("Contratar");
		btnContratar.addActionListener(new ActionListener() {
			private SimulacaoController controller;
			public void actionPerformed(ActionEvent e) {
				int indexNumber = tblSimulacao.getSelectedRow();
				
				if (indexNumber > -1) {
					if (controller == null) {
						controller = new SimulacaoController();
					}
					simulacoes.get(indexNumber-1).setContratado("Sim");
					controller.contrataEmprestimo(simulacoes.get(indexNumber-1).getNumero_Contrato());
					atualizarTabelaSimulacoes(simulacoes);
				}
			}
		});
		btnContratar.setBounds(147, 71, 127, 23);
		add(btnContratar);
		
		JButton btnRelatorio = new JButton("Gerar Relat\u00F3rio");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				JFileChooser jfc = new JFileChooser();
//				jfc.setDialogTitle("Salvar relat�rio como...");
//				
//				int resultado = jfc.showSaveDialog(null);
//				if(resultado == JFileChooser.APPROVE_OPTION){
//					String caminhoEscolhido = jfc.getSelectedFile().getAbsolutePath();
					GeradorPlanilha gerador = new GeradorPlanilha();
					try {
						gerador.gerarPlanilhaProdutos(simulacoes, "contratos");
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					
//				}
				
			}
		});
		btnRelatorio.setBounds(283, 71, 201, 23);
		add(btnRelatorio);

	}

	protected void atualizarTabelaSimulacoes(List<SimulacaoVO> simulacoes) {
		// Limpa a tabela
		Object[][] header = new Object[][] {new String[] { "Contrato", "Nome", "CPF", "Valor", "num Parcelas", "Contratado" }};
		String[] registros = new String[] { "Contrato", "Nome", "CPF", "Valor", "num Parcelas", "Contratado" };
		
		tblSimulacao.setModel(new DefaultTableModel(header,
				registros));

		DefaultTableModel modelo = (DefaultTableModel) tblSimulacao.getModel();

		for (SimulacaoVO simula : simulacoes) {
			// Crio uma nova linha na tabela
			// Preencher a linha com os atributos do contrato
			// na ORDEM do cabeçalho da tabela
			
			Object[] novaLinha = new Object[] { simula.getNumero_Contrato(), simula.getNome_Cliente(),
					simula.getCpf_cliente(), simula.getValor_contrato(), simula.getNum_parcelas(), simula.getContratado() };
			modelo.addRow(novaLinha);
		}

	}
}
