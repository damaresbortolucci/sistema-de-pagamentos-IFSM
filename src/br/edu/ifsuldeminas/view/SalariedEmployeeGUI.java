package br.edu.ifsuldeminas.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.ifsuldeminas.controller.ControllerPayable;
import br.edu.ifsuldeminas.model.SalariedEmployee;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalariedEmployeeGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldCpf;
	private JTextField textFieldSalarioMensal;

	
	/**
	 * Create the frame.
	 */
	public SalariedEmployeeGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SalariedEmployeeGUI.class.getResource("/img/Group2_Buyers_Dark.png")));
		setResizable(false);
		setTitle("Cadastrar Funcionário Assalariado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 546, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		
		JLabel lblNewLabel_3 = new JLabel("Salário Semanal");
		
		textFieldSalarioMensal = new JTextField();
		textFieldSalarioMensal.setColumns(10);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* recuperar os dados do JTextField */
				String firstName = textFieldFirstName.getText();
				String lastName = textFieldLastName.getText();
				String cpf = textFieldCpf.getText();
				String salario = textFieldSalarioMensal.getText();
				
				double weeklySalary = 0;
				try {
					weeklySalary = Double.parseDouble(salario);
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Salário inválido");
					return;
				}
				
				/* Criar um objeto do tipo SalariedEmployee */
				SalariedEmployee salaried = new SalariedEmployee(firstName, lastName, cpf, weeklySalary);
				
				/* Adicionar na minha Lista */
				ControllerPayable.getInstance().Add(salaried);
				//System.out.print(ControllerEmployee.getInstance().ListAll());
				
				JOptionPane.showMessageDialog(null,  salaried.toString() + "\nincluído com sucesso !", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				
				/* Limpar o JTexfield */
				textFieldFirstName.setText("");
				textFieldLastName.setText("");
				textFieldCpf.setText("");
				textFieldSalarioMensal.setText("");
			
			}
		});
		btnIncluir.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnIncluir.setIcon(new ImageIcon(SalariedEmployeeGUI.class.getResource("/img/add.png")));
		btnIncluir.setPreferredSize(new Dimension(75, 23));
		btnIncluir.setMinimumSize(new Dimension(75, 23));
		btnIncluir.setMaximumSize(new Dimension(75, 23));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(SalariedEmployeeGUI.class.getResource("/img/DeleteRed.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldFirstName, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
						.addComponent(textFieldLastName, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
						.addComponent(textFieldCpf, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
						.addComponent(textFieldSalarioMensal, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
					.addGap(10))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(202, Short.MAX_VALUE)
					.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
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
					.addGap(30)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldSalarioMensal, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIncluir, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {btnIncluir, btnCancelar});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnIncluir, btnCancelar});
		contentPane.setLayout(gl_contentPane);
	} //fim do método
}
