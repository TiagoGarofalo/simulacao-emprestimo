package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JLabel lblcpf;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setTitle("Tela de Cadastro de usu\u00E1rio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroCliente.class.getResource("/icones/icons8-usu\u00E1rio.png")));
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
			}
		});
		btnCadastrar.setBounds(42, 102, 134, 23);
		contentPane.add(btnCadastrar);
		
		JList list = new JList();
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("Nome");
		list.setBounds(42, 132, 361, 84);
		contentPane.add(list);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(314, 227, 89, 23);
		contentPane.add(btnExcluir);
		
		textField = new JTextField();
		textField.setBounds(98, 24, 164, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 49, 117, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 74, 164, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
