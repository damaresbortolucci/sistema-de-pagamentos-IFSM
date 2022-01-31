package br.edu.ifsuldeminas.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.TableView.TableRow;

import br.edu.ifsuldeminas.controller.ControllerPayable;
import br.edu.ifsuldeminas.model.Employee;
import br.edu.ifsuldeminas.model.Invoice;
import br.edu.ifsuldeminas.model.Payable;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.awt.event.ActionEvent;

public class ReportEmployeeGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;



	/**
	 * Create the frame.
	 */
	public ReportEmployeeGUI() {
		setResizable(false);
		setTitle("Relatórios de Pagamentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 906, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelSul = new JPanel();
		panelSul.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelSul, BorderLayout.SOUTH);
		
		JButton btnExecutarRelatorio = new JButton("Executar Relatório");
		btnExecutarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				/* recupero a lista de Payable */
				List<Payable> listPayable = ControllerPayable.getInstance().ListAll();
				
				/* Código para popular a JTable */
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				table.setModel(modelo);
				
				int numeroLinhas = modelo.getRowCount();
				
				for(int i=0; i<numeroLinhas;i++)
					modelo.removeRow(0);
				
				Object[] elementos = new Object[6];
				
				
				for(Payable tipo_interface_payable : listPayable) {
					
					if(tipo_interface_payable instanceof Employee) {
  					    Employee funcionario = (Employee) tipo_interface_payable;
						String numeroFormatado = String.format("%.02f",funcionario.getPaymentAmount());
						elementos[0] = "FU";
						elementos[1] = funcionario.getFirstName();
						elementos[2] = funcionario.getLastName();
						elementos[3] = "";
						elementos[4] = "";
						elementos[5] = numeroFormatado;
					} else if(tipo_interface_payable instanceof Invoice) {
						//Entra nesse if se o objeto da lista for do tipo Invoice.
						Invoice invoice = (Invoice) tipo_interface_payable;
						String numeroFormatado = String.format("%.02f",invoice.getPaymentAmount());
						elementos[0] = "NF";
						elementos[1] = "";
						elementos[2] = "";
						elementos[3] = invoice.getPartNumber();
						elementos[4] = invoice.getPartDescription();
						elementos[5] = numeroFormatado;
						
					}
					
					modelo.addRow(elementos);
					
				}
				
			}
		});
		btnExecutarRelatorio.setIcon(new ImageIcon(ReportEmployeeGUI.class.getResource("/img/add.png")));
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnFechar.setIcon(new ImageIcon(ReportEmployeeGUI.class.getResource("/img/DeleteRed.png")));
		GroupLayout gl_panelSul = new GroupLayout(panelSul);
		gl_panelSul.setHorizontalGroup(
			gl_panelSul.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSul.createSequentialGroup()
					.addGap(170)
					.addComponent(btnExecutarRelatorio, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
					.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(89))
		);
		gl_panelSul.setVerticalGroup(
			gl_panelSul.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSul.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSul.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExecutarRelatorio, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFechar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelSul.linkSize(SwingConstants.VERTICAL, new Component[] {btnExecutarRelatorio, btnFechar});
		gl_panelSul.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnExecutarRelatorio, btnFechar});
		panelSul.setLayout(gl_panelSul);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setPreferredSize(new Dimension(60, 60));
		contentPane.add(panelNorte, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Relatório de Pagamentos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GroupLayout gl_panelNorte = new GroupLayout(panelNorte);
		gl_panelNorte.setHorizontalGroup(
			gl_panelNorte.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelNorte.createSequentialGroup()
					.addContainerGap(312, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
					.addGap(259))
		);
		gl_panelNorte.setVerticalGroup(
			gl_panelNorte.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNorte.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panelNorte.setLayout(gl_panelNorte);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCentro.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipo", "FirstName", "LastName", "Número da Nota", "Descrição", "Pagamento"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, Object.class, Object.class, String.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(186);
		table.getColumnModel().getColumn(2).setPreferredWidth(152);
		table.getColumnModel().getColumn(3).setPreferredWidth(147);
		table.getColumnModel().getColumn(4).setPreferredWidth(189);
		table.getColumnModel().getColumn(5).setPreferredWidth(137);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)
	            table.getTableHeader().getDefaultRenderer();
		
		renderer.setHorizontalAlignment(JLabel.LEFT);
		
		scrollPane.setViewportView(table);
	}
}
