package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;

public class PainelSobre extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelSobre() {
		setLayout(null);
		
		JTextPane txtpnSoftwareDesenvolvidoPara = new JTextPane();
		txtpnSoftwareDesenvolvidoPara.setText("          Software desenvolvido para simular empr\u00E9stimos e tornar possivel a contrata\u00E7\u00E3o posterior.");
		txtpnSoftwareDesenvolvidoPara.setBounds(10, 11, 430, 278);
		add(txtpnSoftwareDesenvolvidoPara);

	}
}
