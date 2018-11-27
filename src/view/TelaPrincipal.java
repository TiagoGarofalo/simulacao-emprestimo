package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public TelaPrincipal() {

		setTitle("Simulação de Empréstimos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 440);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnEmprestimo = new JMenu("Empr\u00E9stimo");
		mnEmprestimo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-documento-regular.png")));
		menuBar.add(mnEmprestimo);

		JMenuItem mntmSimular = new JMenuItem("Simular");
		mntmSimular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Instanciar a tela de simulação
				TelaSimulacao tela = new TelaSimulacao();
				// PainelTeste tela = new PainelTeste();

				// Adicionar o painel na tela principal
				setContentPane(tela);
			}
		});
		mntmSimular.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmSimular.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-confian\u00E7a.png")));
		mnEmprestimo.add(mntmSimular);

		JMenuItem mntmPesquisar = new JMenuItem("Pesquisar");
		mntmPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				TelaListaSimulacao lista = new TelaListaSimulacao();
				setContentPane(lista);
				lista.updateUI();

			}
		});
		mntmPesquisar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/lupa.png")));
		mntmPesquisar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mnEmprestimo.add(mntmPesquisar);
		
				JMenu mnCadastrarVendedor = new JMenu("Cadastrar Vendedor");
				mnCadastrarVendedor.setIcon(
						new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-usu\u00E1rio.png")));
				menuBar.add(mnCadastrarVendedor);
				
						JMenuItem mntmCadastrarVendedor = new JMenuItem("Cadastrar Vendedor");
						mntmCadastrarVendedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
						mntmCadastrarVendedor.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								TelaCadastroVendedor vendedor = new TelaCadastroVendedor();
								setContentPane(vendedor);
								vendedor.updateUI();
							}
						});
						
								mntmCadastrarVendedor.setIcon(
										new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-adicionar-usu\u00E1rio-masculino.png")));
								mnCadastrarVendedor.add(mntmCadastrarVendedor);
								
										JMenu mnSobre = new JMenu("sobre");
										mnSobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-card\u00E1pio.png")));
										menuBar.add(mnSobre);
										
												JMenuItem mntmTaxasDeJuros = new JMenuItem("Taxas de juros");
												mntmTaxasDeJuros.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														TelaJuros juros = new TelaJuros();
														setContentPane(juros);
													}
												});
												mntmTaxasDeJuros
														.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-gr\u00E1fico-combinado.png")));
												mnSobre.add(mntmTaxasDeJuros);
												
														JMenuItem mntmSoftware = new JMenuItem("Software");
														mntmSoftware.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																PainelSobre sobre = new PainelSobre();
																setContentPane(sobre);
															}
														});
														mntmSoftware.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/icons8-molho-de-chaves.png")));
														mnSobre.add(mntmSoftware);
	}
}