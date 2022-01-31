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
		return String.format("Funcion�rio comissionado e sal�rio fixo: %s. Sal�rio Base: %s e Comiss�o: %s", super.toString(),
				getBaseSalary(), super.getCommissionRate());
	}

	
	@Override
	public double getPaymentAmount() {
		return getBaseSalary() + super.getPaymentAmount();
	}

}
