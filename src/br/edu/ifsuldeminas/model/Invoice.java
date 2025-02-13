package br.edu.ifsuldeminas.model;

public class Invoice implements Payable {
	
	 private String partNumber;
	 private String partDescription;
	 private int quantity;
	 private double pricePerItem;
	 
	public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
		super();
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
	}
	

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}


	@Override
	public double getPaymentAmount() {
			return getQuantity() * getPricePerItem();
	}
	
	
	@Override
	public String toString() {
		String s = String.format("Invoice n�mero: %s com a descri��o: %s e quantidade %s com pre�o unit�rio %s", getPartNumber(),  getPartDescription(), getQuantity(), getPricePerItem());
		return s;
	}
	 
	 

}
