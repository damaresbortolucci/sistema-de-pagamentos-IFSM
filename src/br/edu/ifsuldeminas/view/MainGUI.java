package br.edu.ifsuldeminas.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Frame;

public class MainGUI {

	private JFrame frmSistemaDePagamentos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frmSistemaDePagamentos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaDePagamentos = new JFrame();
		frmSistemaDePagamentos.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmSistemaDePagamentos.setTitle("Sistema de Pagamentos");
		frmSistemaDePagamentos.setBounds(100, 100, 958, 504);
		frmSistemaDePagamentos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDePagamentos.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelCentral = new JPanel();
		frmSistemaDePagamentos.getContentPane().add(panelCentral, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainGUI.class.getResource("/img/logo_if_resize.png")));
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addContainerGap(550, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelCentral.createSequentialGroup()
					.addContainerGap(222, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panelCentral.setLayout(gl_panelCentral);
		
		JMenuBar menuBar = new JMenuBar();
		frmSistemaDePagamentos.setJMenuBar(menuBar);
		
		JMenu mnMenuArquivo = new JMenu("Arquivo");
		menuBar.add(mnMenuArquivo);
		
		JMenuItem mntmMenuItemSair = new JMenuItem("Sair");
		mntmMenuItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmMenuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmMenuItemSair.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Exit_Plain_Blue.png")));
		mnMenuArquivo.add(mntmMenuItemSair);
		
		JMenu mnMenuCadastro = new JMenu("Cadastro");
		menuBar.add(mnMenuCadastro);
		
		JMenu mnMenuFuncionarios = new JMenu("Funcinários");
		mnMenuCadastro.add(mnMenuFuncionarios);
		
		JMenuItem mntmMenuItemAssalariado = new JMenuItem("Assalariado");
		mntmMenuItemAssalariado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SalariedEmployeeGUI minhaGui = new SalariedEmployeeGUI();
				minhaGui.setLocationRelativeTo(null);
				minhaGui.setVisible(true);
			}
		});
		
		mntmMenuItemAssalariado.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Group2_Buyers_Dark.png")));
		mnMenuFuncionarios.add(mntmMenuItemAssalariado);
		
		JMenuItem mntmMenuItemComissionados = new JMenuItem("Comissionados");
		mntmMenuItemComissionados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CommissionEmployeeGUI minhaGui = new CommissionEmployeeGUI();
				minhaGui.setLocationRelativeTo(null);
				minhaGui.setVisible(true);
				
			}
		});
		mntmMenuItemComissionados.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Group2_Buyers_Dark.png")));
		mnMenuFuncionarios.add(mntmMenuItemComissionados);
		
		JMenuItem mntmMenuItemComissionadoSalarioFixo = new JMenuItem("Comissionado e Salário Fixo");
		mntmMenuItemComissionadoSalarioFixo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BasePlusCommissionEmployeeGUI minhaGui = new BasePlusCommissionEmployeeGUI();
				minhaGui.setLocationRelativeTo(null);
				minhaGui.setVisible(true);
				
			}
		});
		mntmMenuItemComissionadoSalarioFixo.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Group2_Buyers_Dark.png")));
		mnMenuFuncionarios.add(mntmMenuItemComissionadoSalarioFixo);
		
		JMenuItem mntmMenuItemHorista = new JMenuItem("Horista");
		mntmMenuItemHorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HourlyEmployeeGUI minhaGui = new HourlyEmployeeGUI();
				minhaGui.setLocationRelativeTo(null);
				minhaGui.setVisible(true);
				
			}
		});
		mntmMenuItemHorista.setIcon(new ImageIcon(MainGUI.class.getResource("/img/Group2_Buyers_Dark.png")));
		mnMenuFuncionarios.add(mntmMenuItemHorista);
		
		JMenuItem mntmMenuItemInvoice = new JMenuItem("Nota Fiscal");
		mntmMenuItemInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InvoiceGUI invoiceGui = new InvoiceGUI();
				invoiceGui.setLocationRelativeTo(null);
				invoiceGui.setVisible(true);
				
			}
		});
		mnMenuCadastro.add(mntmMenuItemInvoice);
		
		JMenu mnMenuRelatorio = new JMenu("Relatório");
		menuBar.add(mnMenuRelatorio);
		
		JMenuItem mntmMenuItemRelatorioPagamento = new JMenuItem("Relatórios");
		mntmMenuItemRelatorioPagamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReportEmployeeGUI reportGui = new ReportEmployeeGUI();
				reportGui.setLocationRelativeTo(null);
				reportGui.setVisible(true);
				
			}
		});
		mntmMenuItemRelatorioPagamento.setIcon(new ImageIcon(MainGUI.class.getResource("/img/attached16x16.png")));
		mnMenuRelatorio.add(mntmMenuItemRelatorioPagamento);
	}
}
