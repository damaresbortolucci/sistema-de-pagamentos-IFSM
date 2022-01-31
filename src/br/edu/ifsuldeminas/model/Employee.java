package br.edu.ifsuldeminas.model;


public abstract class Employee implements Payable {

	private  String firstName;
	private  String lastName;
	private  String cpf; //para o nosso exemplo será o cpf
	
	public Employee(String firstName, String lastName, String cpf) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String toString() {
		String s = String.format("%s %s CPF número: %s", getFirstName(), getLastName(), getCpf());
		return s;
	}
	

}
