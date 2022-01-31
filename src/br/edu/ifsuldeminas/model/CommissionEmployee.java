package br.edu.ifsuldeminas.model;

public class CommissionEmployee extends Employee {
	
	private double grossSales; //vendas brutas
	private double commissionRate; // porcentagem da comiss√£o
	
	public CommissionEmployee(String firstName, String lastName, String cpf, double grossSales, double commissionRate) {
		super(firstName, lastName, cpf);
		
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	
	

	public double getGrossSales() {
		return grossSales;
	}



	public void setGrossSales(double grossSales) {
		this.grossSales = grossSales;
	}



	public double getCommissionRate() {
		return commissionRate;
	}



	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}



	@Override
	public String toString() {
		String s = String.format("Funcion·rio comissionado: %s, vendas brutas semanais: %s e taxa de comiss„o: %s", super.toString(),  getGrossSales(), getCommissionRate());
		return s;
	}



	@Override
	public double getPaymentAmount() {
		return getCommissionRate() * getGrossSales();
	}

}
