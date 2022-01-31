package br.edu.ifsuldeminas.model;

public class SalariedEmployee extends Employee {

	private double weeklySalary;
	
	public SalariedEmployee(String firstName, String lastName, String cpf, double weeklySalary) {
		// TODO Auto-generated constructor stub
		super(firstName,lastName,cpf);
		
		this.weeklySalary = weeklySalary;
	}
	
	

	public double getWeeklySalary() {
		return weeklySalary;
	}



	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}


	
	@Override
	public String toString() {
		String s = String.format("Funcionario assalariado: %s, salário semanal: %s", super.toString(), getWeeklySalary());
		return s;
		
	}



	@Override
	public double getPaymentAmount() {
		return getWeeklySalary();
	}
	
	
}
