package view;

import javax.swing.JPanel;
import javax.swing.JTextPane;

public class TelaJuros extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaJuros() {
		setLayout(null);

		JTextPane txtpnTaxaDeJuros = new JTextPane();
		txtpnTaxaDeJuros.setText(
				"         A taxa de juros sendo o valor do contrato menor ou igual a R$1.000,00 fica em 1,8% como percentual de taxa de juros, se for maior ficar\u00E1 em 3%. Sendo a quantidade de parcelas maior que 12 parcelas, adicionar 0,5% a taxa de juros.");
		txtpnTaxaDeJuros.setBounds(10, 11, 430, 278);
		add(txtpnTaxaDeJuros);

	}

}
