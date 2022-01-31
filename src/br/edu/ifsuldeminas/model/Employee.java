package br.edu.ifsuldeminas.model;


public abstract class Employee implements Payable {

	private int id;
	private  String firstName;
	private  String lastName;
	private  String cpf; //para o nosso exemplo serÃ¡ o cpf
	
	public Employee(String firstName, String lastName, String cpf) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
	}
	
	public Employee(int id,String firstName, String lastName, String cpf) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.setId(id);
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
