package br.edu.ifsuldeminas.model;

public class BasePlusCommissionEmployee extends CommissionEmployee{
	
	private double baseSalary;
	
	public BasePlusCommissionEmployee(String firstName, String lastName, String cpf, double grossSales, double commissionRate, double baseSalary) {
		
		super(firstName, lastName, cpf, grossSales, commissionRate );
		
		this.baseSalary = baseSalary;
	}
	
	
	public double getBaseSalary() {
		return baseSalary;
	}


	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	
	@Override
	public String toString() {
		return String.format("Funcionário comissionado e salário fixo: %s. Salário Base: %s e Comissão: %s", super.toString(),
				getBaseSalary(), super.getCommissionRate());
	}

	
	@Override
	public double getPaymentAmount() {
		return getBaseSalary() + super.getPaymentAmount();
	}

}
