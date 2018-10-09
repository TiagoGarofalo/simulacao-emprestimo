package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import model.bo.SimulacaoBO;
import model.controller.SimulacaoController;

import model.vo.Simulacao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

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
	private JLabel lbPesquisarSimulao;
	private JTextField txPesquisar;
	Simulacao simula = new Simulacao();
	SimulacaoBO bo = new SimulacaoBO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setTitle("Simulação de Empréstimos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbNome = new JLabel("Nome:");
		lbNome.setBounds(8, 79, 46, 14);
		contentPane.add(lbNome);

		txNome = new JTextField();
		txNome.setBounds(53, 76, 196, 20);
		contentPane.add(txNome);
		txNome.setColumns(10);

		JLabel lbEmail = new JLabel("E-mail:");
		lbEmail.setBounds(263, 79, 46, 14);
		contentPane.add(lbEmail);

		txEmail = new JTextField();
		txEmail.setBounds(307, 76, 157, 20);
		contentPane.add(txEmail);
		txEmail.setColumns(10);

		JLabel lbCpf = new JLabel("CPF:");
		lbCpf.setBounds(8, 108, 46, 14);
		contentPane.add(lbCpf);

		txCPF = new JTextField();
		txCPF.setBounds(53, 106, 196, 20);
		contentPane.add(txCPF);
		txCPF.setColumns(10);

		JLabel lbValorCont = new JLabel("Valor Contrato:");
		lbValorCont.setBounds(8, 138, 105, 14);
		contentPane.add(lbValorCont);

		txValorCont = new JTextField();
		txValorCont.setBounds(119, 135, 130, 20);
		contentPane.add(txValorCont);
		txValorCont.setColumns(10);

		JLabel lbQtdDeParcelas = new JLabel("Qtd. de Parcelas:");
		lbQtdDeParcelas.setBounds(8, 169, 100, 14);
		contentPane.add(lbQtdDeParcelas);

		txParcelas = new JTextField();
		txParcelas.setBounds(119, 166, 130, 20);
		contentPane.add(txParcelas);
		txParcelas.setColumns(10);

		lbInserirNumCont = new JLabel("N\u00B0 Contrato: ");
		lbInserirNumCont.setBounds(8, 11, 179, 14);
		contentPane.add(lbInserirNumCont);

		Date numCont = new Date();
		SimpleDateFormat formatNum = new SimpleDateFormat("yyyyMMdd");
        int acumulador = 0;
        String.format("%05d", acumulador);
		lbInserirNumCont.setText("N° Contrato: " + formatNum.format(numCont) + String.format("%06d", criaNumContrato(acumulador)));

		lbInserirValorParcela = new JLabel("Vlr. Parcela: R$ ");
		lbInserirValorParcela.setBounds(409, 169, 164, 14);
		contentPane.add(lbInserirValorParcela);

		lbInserirDtSimulacao = new JLabel("Data Simula\u00E7\u00E3o: ");
		lbInserirDtSimulacao.setBounds(208, 11, 172, 14);
		contentPane.add(lbInserirDtSimulacao);

		Date dataSimulacao = new Date();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yy");
		lbInserirDtSimulacao.setText("Data Simulação: " + formatDate.format(dataSimulacao));

		lbInserirDtValidade = new JLabel("Validade Simula\u00E7\u00E3o: ");
		lbInserirDtValidade.setBounds(395, 11, 178, 14);
		contentPane.add(lbInserirDtValidade);

		SimpleDateFormat formatValidade = new SimpleDateFormat("dd/MM/yy");
		GregorianCalendar dataValidade = new GregorianCalendar();
		dataValidade.add(Calendar.DAY_OF_MONTH, 30);
		Date dataV = dataValidade.getTime();
		lbInserirDtValidade.setText("Validade simulação: " + formatValidade.format(dataV));

		lbPesquisarSimulao = new JLabel("Pesquisar Simula\u00E7\u00E3o:");
		lbPesquisarSimulao.setBounds(8, 50, 130, 14);
		contentPane.add(lbPesquisarSimulao);

		txPesquisar = new JTextField();
		txPesquisar.setBounds(142, 46, 107, 20);
		contentPane.add(txPesquisar);
		txPesquisar.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(8, 33, 566, 2);
		contentPane.add(separator);

		JLabel lbInserirJuros = new JLabel("Tx. de juros:");
		lbInserirJuros.setBounds(263, 169, 136, 14);
		contentPane.add(lbInserirJuros);

		JButton btSimular = new JButton("Simular");
		btSimular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			 criaNumContrato(acumulador);
				
				String mensagemValidacao = validarCampos();

				if (!mensagemValidacao.equals("")) {
					JOptionPane.showMessageDialog(null, mensagemValidacao, "Atenção", JOptionPane.ERROR_MESSAGE);
				} else {

					SimulacaoController controlador = new SimulacaoController();

					Simulacao novaSimula = construirSimulacao();

					double juros = bo.calcularJuros(novaSimula);
					lbInserirJuros.setText("Tx. de juros: " + juros + "%.");
					double valorP = bo.calcularValorParcelas(novaSimula);
					DecimalFormat numf = new DecimalFormat("#,###.00");
					lbInserirValorParcela.setText("Vlr. Parcela: R$ " + numf.format(valorP));
				}
			}

		});
		btSimular.setBounds(160, 197, 89, 23);
		contentPane.add(btSimular);

		JButton btPesquisar = new JButton("Buscar");
		btPesquisar.setBounds(258, 45, 89, 23);
		contentPane.add(btPesquisar);

		JButton btContratar = new JButton("Contratar");
		btContratar.setBounds(160, 231, 89, 23);
		contentPane.add(btContratar);

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

		if (!validaCPF(txCPF.getText())) {

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

	protected Simulacao construirSimulacao() {

		Simulacao novaSimula = new Simulacao();
		novaSimula.setNome(txNome.getText());
		novaSimula.setEmail(txEmail.getText());
		novaSimula.setCpf(txCPF.getText());
		novaSimula.setValorContrato(Double.parseDouble(txValorCont.getText()));
		novaSimula.setNumParcela(Integer.parseInt(txParcelas.getText()));

		return novaSimula;
	}

	public boolean validaCPF(String cpf) {

		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || (cpf.length() != 11))
			return false;

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {

			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);

			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return true;
			else
				return false;
		} catch (InputMismatchException erro) {
			return false;
		}
	}
	public int criaNumContrato(int acumulador) {

		acumulador = acumulador + 1 ;
		
		return acumulador;	
		
	}

}
