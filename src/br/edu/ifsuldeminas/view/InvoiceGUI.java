package br.edu.ifsuldeminas.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.edu.ifsuldeminas.controller.ControllerPayable;
import br.edu.ifsuldeminas.model.CommissionEmployee;
import br.edu.ifsuldeminas.model.HourlyEmployee;
import br.edu.ifsuldeminas.model.Invoice;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvoiceGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldPartNumber;
	private JTextField textFieldPartDescription;
	private JTextField textFieldQuantity;
	private JTextField textFieldPricePerItem;

	
	/**
	 * Create the frame.
	 */
	public InvoiceGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InvoiceGUI.class.getResource("/img/attached16x16.png")));
		setResizable(false);
		setTitle("Cadastrar Invoice");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 546, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("PartNumber");
		
		textFieldPartNumber = new JTextField();
		textFieldPartNumber.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PartDescription");
		
		textFieldPartDescription = new JTextField();
		textFieldPartDescription.setColumns(10);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* recuperar os dados do JTextField */
				String partNumber = textFieldPartNumber.getText();
				String partDescription = textFieldPartDescription.getText();
			    String quantityString = textFieldQuantity.getText();
				String pricePerItemString = textFieldPricePerItem.getText();
				
				int quantity = 0;
				try {
					quantity = Integer.parseInt(quantityString);
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Quantidade inválida");
					return;
				}
				
				double pricePerItem = 0;
				try {
					pricePerItem = Double.parseDouble(pricePerItemString);
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Preço por item inválido");
					return;
				}
				
				/* Criar um objeto do tipo HourlyEmployee */
				Invoice invoice = new Invoice(partNumber,partDescription,quantity,pricePerItem);
				
				/* Adicionar na minha Lista */
				boolean resposta = ControllerPayable.getInstance().Add(invoice);
			
				if(resposta) {
					JOptionPane.showMessageDialog(null,  invoice.toString() + "\n incluído com sucesso !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null,  invoice.toString() + "\n Ocorreu um erro!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
				/* Limpar o JTexfield */
				textFieldPartNumber.setText("");
				textFieldPartDescription.setText("");
				textFieldQuantity.setText("");
				textFieldPricePerItem.setText("");
				
			}
		});
		btnIncluir.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnIncluir.setIcon(new ImageIcon(InvoiceGUI.class.getResource("/img/add.png")));
		btnIncluir.setPreferredSize(new Dimension(75, 23));
		btnIncluir.setMinimumSize(new Dimension(75, 23));
		btnIncluir.setMaximumSize(new Dimension(75, 23));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
			
		});
		btnCancelar.setIcon(new ImageIcon(InvoiceGUI.class.getResource("/img/DeleteRed.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldPartNumber, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
						.addComponent(textFieldPartDescription, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(208, Short.MAX_VALUE)
					.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldPartNumber, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldPartDescription, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnIncluir, btnCancelar});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnIncluir, btnCancelar});
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Quantity");
		lblNewLabel_3.setBounds(27, 11, 105, 14);
		panel.add(lblNewLabel_3);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(24, 36, 218, 31);
		panel.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Price Per Item");
		lblNewLabel_4.setBounds(276, 11, 177, 14);
		panel.add(lblNewLabel_4);
		
		textFieldPricePerItem = new JTextField();
		textFieldPricePerItem.setBounds(276, 36, 218, 31);
		panel.add(textFieldPricePerItem);
		textFieldPricePerItem.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	} 
}
