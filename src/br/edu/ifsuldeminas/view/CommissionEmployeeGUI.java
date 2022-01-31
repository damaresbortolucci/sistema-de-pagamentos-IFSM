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
import br.edu.ifsuldeminas.model.SalariedEmployee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CommissionEmployeeGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldCpf;
	private JTextField textFieldVendaTotal;
	private JTextField textFieldTaxaComissao;

	
	/**
	 * Create the frame.
	 */
	public CommissionEmployeeGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CommissionEmployeeGUI.class.getResource("/img/Group2_Buyers_Dark.png")));
		setResizable(false);
		setTitle("Cadastrar Funcionário Comissionado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 546, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("FirstName");
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("LastName");
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* recuperar os dados do JTextField */
				String firstName = textFieldFirstName.getText();
				String lastName = textFieldLastName.getText();
				String cpf = textFieldCpf.getText();
				String vendaTotal = textFieldVendaTotal.getText();
				String taxaComissao = textFieldTaxaComissao.getText();
				
				double grossSales = 0;
				try {
					grossSales = Double.parseDouble(vendaTotal);
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Venda inválida");
					return;
				}
				
				double commissionRate = 0;
				try {
					commissionRate = Double.parseDouble(taxaComissao);
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Taxa de Comissão inválida");
					return;
				}
				
				/* Criar um objeto do tipo CommissionEmployee */
				CommissionEmployee salaried = new CommissionEmployee(firstName,lastName,cpf,grossSales,commissionRate);
				
				/* Adicionar na minha Lista */
				boolean resposta = ControllerPayable.getInstance().Add(salaried);
					
				
				if(resposta) {
					JOptionPane.showMessageDialog(null,  salaried.toString() + "\n incluído com sucesso !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null,  salaried.toString() + "\n Ocorreu um erro!", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			
			
				/* Limpar o JTexfield */
				textFieldFirstName.setText("");
				textFieldLastName.setText("");
				textFieldCpf.setText("");
				textFieldVendaTotal.setText("");
				textFieldTaxaComissao.setText("");
			}
		});
		btnIncluir.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnIncluir.setIcon(new ImageIcon(CommissionEmployeeGUI.class.getResource("/img/add.png")));
		btnIncluir.setPreferredSize(new Dimension(75, 23));
		btnIncluir.setMinimumSize(new Dimension(75, 23));
		btnIncluir.setMaximumSize(new Dimension(75, 23));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnCancelar.setIcon(new ImageIcon(CommissionEmployeeGUI.class.getResource("/img/DeleteRed.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldFirstName, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
						.addComponent(textFieldLastName, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
						.addComponent(textFieldCpf, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(202, Short.MAX_VALUE)
					.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldFirstName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldLastName, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldCpf, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Venda total");
		lblNewLabel_3.setBounds(27, 11, 105, 14);
		panel.add(lblNewLabel_3);
		
		textFieldVendaTotal = new JTextField();
		textFieldVendaTotal.setBounds(24, 38, 218, 25);
		panel.add(textFieldVendaTotal);
		textFieldVendaTotal.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Taxa de Comissão");
		lblNewLabel_4.setBounds(266, 11, 105, 14);
		panel.add(lblNewLabel_4);
		
		textFieldTaxaComissao = new JTextField();
		textFieldTaxaComissao.setBounds(266, 38, 218, 25);
		panel.add(textFieldTaxaComissao);
		textFieldTaxaComissao.setColumns(10);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnIncluir, btnCancelar});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnIncluir, btnCancelar});
		contentPane.setLayout(gl_contentPane);
	} //fim do mÃ©todo
}
