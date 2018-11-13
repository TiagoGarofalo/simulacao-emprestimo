package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.bo.SimulacaoBO;
import model.controller.SimulacaoController;
import model.dao.SimulacaoDAO;
import model.vo.Simulacao;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaSimulacao extends JPanel {

	private JPanel contentPane;
	private JTextField txNome;
	private JTextField txEmail;
	private JTextField txCPF;
	private JTextField txValorCont;
	private JTextField txParcelas;
	private JLabel lbInserirNumCont;
	private JLabel lbInserirValorParcela;
	private JLabel lbInserirDtSimulacao;
	private JLabel lbInserirDtValidade;
	Simulacao simula = new Simulacao();
	SimulacaoController control = new SimulacaoController();

	/**
	 * Create the frame.
	 */
	public TelaSimulacao() {
		setLayout(null);
		setBounds(0, 57, 587, 335);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(null);

		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(8, 69, 46, 14);
		// contentPane.add(lbNome);
		add(lbNome);

		txNome = new JTextField();
		txNome.setBounds(53, 66, 196, 20);
		// contentPane.add(txNome);
		add(txNome);
		txNome.setColumns(10);

		JLabel lbEmail = new JLabel("E-mail:");
		lbEmail.setBounds(8, 126, 46, 14);
		// contentPane.add(lbEmail);
		add(lbEmail);

		txEmail = new JTextField();
		txEmail.setBounds(52, 123, 197, 20);
		// contentPane.add(txEmail);
		add(txEmail);
		txEmail.setColumns(10);

		JLabel lbCpf = new JLabel("CPF:");
		lbCpf.setBounds(8, 98, 46, 14);
		// contentPane.add(lbCpf);
		add(lbCpf);

		/*
		 * try { txCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##")); }
		 * catch (ParseException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		txCPF = new JTextField();
		txCPF.setBounds(53, 96, 196, 20);
		// contentPane.add(txCPF);
		add(txCPF);
		txCPF.setColumns(10);

		JLabel lbValorCont = new JLabel("Valor Contrato:");
		lbValorCont.setBounds(8, 194, 105, 14);
		// contentPane.add(lbValorCont);
		add(lbValorCont);

		txValorCont = new JTextField();
		txValorCont.setBounds(119, 191, 130, 20);
		// contentPane.add(txValorCont);
		add(txValorCont);
		txValorCont.setColumns(10);

		JLabel lbQtdDeParcelas = new JLabel("Qtd. de Parcelas:");
		lbQtdDeParcelas.setBounds(8, 225, 100, 14);
		// contentPane.add(lbQtdDeParcelas);
		add(lbQtdDeParcelas);

		txParcelas = new JTextField();
		txParcelas.setBounds(119, 222, 130, 20);
		// contentPane.add(txParcelas);
		add(txParcelas);
		txParcelas.setColumns(10);

		lbInserirNumCont = new JLabel("N\u00B0 Contrato: ");
		lbInserirNumCont.setBounds(8, 11, 179, 14);
		// contentPane.add(lbInserirNumCont);
		add(lbInserirNumCont);

		Date numCont = new Date();
		SimpleDateFormat formatNum = new SimpleDateFormat("yyyyMMdd");
		int acumulador = 0;
		String.format("%05d", acumulador);
		lbInserirNumCont.setText(
				"N° Contrato: " + formatNum.format(numCont) + String.format("%06d", criaNumContrato(acumulador)));

		lbInserirValorParcela = new JLabel("");
		lbInserirValorParcela.setBounds(105, 265, 164, 14);
		// contentPane.add(lbInserirValorParcela);
		add(lbInserirValorParcela);

		lbInserirDtSimulacao = new JLabel("Data Simula\u00E7\u00E3o: ");
		lbInserirDtSimulacao.setBounds(208, 11, 172, 14);
		// contentPane.add(lbInserirDtSimulacao);
		add(lbInserirDtSimulacao);

		Date dataSimulacao = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
		lbInserirDtSimulacao.setText("Data Simulação: " + formatDate.format(dataSimulacao));

		lbInserirDtValidade = new JLabel("Validade Simula\u00E7\u00E3o: ");
		lbInserirDtValidade.setBounds(395, 11, 178, 14);
		// contentPane.add(lbInserirDtValidade);
		add(lbInserirDtValidade);

		SimpleDateFormat formatValidade = new SimpleDateFormat("dd/MM/yy");
		GregorianCalendar dataValidade = new GregorianCalendar();
		dataValidade.add(Calendar.DAY_OF_MONTH, 30);
		Date dataV = dataValidade.getTime();
		lbInserirDtValidade.setText("Validade simulação: " + formatValidade.format(dataV));

		JSeparator separator = new JSeparator();
		separator.setBounds(8, 33, 566, 2);
		// contentPane.add(separator);
		add(separator);

		JLabel lbInserirJuros = new JLabel("");
		lbInserirJuros.setBounds(105, 250, 136, 14);
		// contentPane.add(lbInserirJuros);
		add(lbInserirJuros);

		JButton btSimular = new JButton("Simular");
		btSimular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btSimular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				//criaNumContrato(acumulador);

				String mensagemValidacao = validarCampos();

				if (!mensagemValidacao.equals("")) {
					JOptionPane.showMessageDialog(null, mensagemValidacao, "Atenção", JOptionPane.ERROR_MESSAGE);
				} else {

					Simulacao novaSimula = construirSimulacao();

					double juros = control.calculaJuros(novaSimula);
					lbInserirJuros.setText(juros + "");
					double valorP = control.calculaValorParc(novaSimula);
					DecimalFormat numf = new DecimalFormat("#,###.00");
					lbInserirValorParcela.setText(numf.format(valorP));
				}
			}

		});
		btSimular.setBounds(82, 286, 89, 23);
		// contentPane.add(btSimular);
		add(btSimular);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(8, 159, 565, 2);
		// contentPane.add(separator_1);
		add(separator_1);

		JLabel lblNewLabel = new JLabel("Dados usu\u00E1rio:");
		lblNewLabel.setBounds(8, 40, 105, 14);
		// contentPane.add(lblNewLabel);
		add(lblNewLabel);

		JLabel lblDadosEmprstimo = new JLabel("Dados Empr\u00E9stimo:");
		lblDadosEmprstimo.setBounds(8, 166, 150, 16);
		// contentPane.add(lblDadosEmprstimo);
		add(lblDadosEmprstimo);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Simulacao SalvarSimulacao = construirSimulacao();

				control.inserirSimulacao(SalvarSimulacao);
			}
		});
		btnGravar.setBounds(179, 286, 90, 23);
		add(btnGravar);
		
		//botão que salva o cliente
		JButton btnSalvarCliente = new JButton("Salvar Cliente");
		btnSalvarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnSalvarCliente.setBounds(278, 122, 113, 23);
		add(btnSalvarCliente);

		JLabel lblVlrParcela = new JLabel("Vlr. Parcela: R$");
		lblVlrParcela.setBounds(8, 265, 87, 14);
		add(lblVlrParcela);

		JLabel lblTxJuros = new JLabel("Tx. de juros:");
		lblTxJuros.setBounds(8, 248, 70, 14);
		add(lblTxJuros);

	}

	private Object criaNumContrato(int acumulador) {
		
		// TODO Criar parte final do numero do contrato
		
		return null;
	}

	protected String validarCampos() {
		String mensagemValidacao = "";

		if (txNome.getText().equals("")) {
			mensagemValidacao += "- Informe o nome. \n";
		}

		if (txEmail.getText().equals("")) {
			mensagemValidacao += "- Informe o E-mail. \n";
		}

		if (txCPF.getText().equals("")) {

			mensagemValidacao += "- Informe o CPF. \n";
		} else {
			try {
				Integer.parseInt(txCPF.getText());
			} catch (NumberFormatException ex) {

				mensagemValidacao += "- CPF deve ser apenas números \n";
			}
		}

		if (!control.validarCPF(txCPF.getText())) {

			mensagemValidacao += "- CPF inválido. \n";
		}

		if (txValorCont.getText().equals("")) {

			mensagemValidacao += "- Informe o valor do contrato \n";
		} else {
			try {
				Double.parseDouble(txValorCont.getText());
			} catch (NumberFormatException ex) {

				mensagemValidacao += "- O valor do contrato deve conter apenas números. \n";
			}
		}

		int qtdParc = 0;
		if (txParcelas.getText().equals("")) {

			mensagemValidacao += "- Informe a quantidade de parcelas. \n";
		} else {
			try {
				qtdParc = Integer.parseInt(txParcelas.getText());

			} catch (NumberFormatException ex) {

				mensagemValidacao += "- A quantidade de parcelas deve conter apenas números. \n";
			}
		}

		if (qtdParc > 24 || qtdParc < 1) {

			mensagemValidacao += "- Quantidade de parcelas deve ter no máximo 24 parcelas e ser maior do que zero.";
		}

		return mensagemValidacao;
	}

	public Simulacao construirSimulacao() {

		Simulacao novaSimula = new Simulacao();
		novaSimula.setNome(txNome.getText());
		novaSimula.setEmail(txEmail.getText());
		novaSimula.setCpf(txCPF.getText());
		novaSimula.setValorCont(Double.parseDouble(txValorCont.getText()));
		novaSimula.setNumParcela(Integer.parseInt(txParcelas.getText()));

		return novaSimula;
	}
}
