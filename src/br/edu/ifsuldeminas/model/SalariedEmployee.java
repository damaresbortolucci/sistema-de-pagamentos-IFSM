package br.edu.ifsuldeminas.model;

public class SalariedEmployee extends Employee {

	private double weeklySalary;
	
	public SalariedEmployee(String firstName, String lastName, String cpf, double weeklySalary) {
		super(firstName,lastName,cpf);
		
		this.weeklySalary = weeklySalary;
	}
	
	public SalariedEmployee(int id, String firstName, String lastName, String cpf, double weeklySalary) {
		super(id, firstName,lastName,cpf);
		
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
		String s = String.format("Funcionário assalariado: %s, salário semanal: %s", super.toString(), getWeeklySalary());
		return s;
		
	}



	@Override
	public double getPaymentAmount() {
		return getWeeklySalary();
	}
	
	
}
