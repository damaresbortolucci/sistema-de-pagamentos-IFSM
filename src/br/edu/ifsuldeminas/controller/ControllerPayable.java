package br.edu.ifsuldeminas.controller;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifsuldeminas.model.Employee;
import br.edu.ifsuldeminas.model.Payable;

public class ControllerPayable {
	
	/* padrão de projeto - singleton */
	private static ControllerPayable instance = null;
	
	/* Arraylist */
	
	private List<Payable> listPayable = new ArrayList<Payable>();
	
	private ControllerPayable() {}
	
	public static ControllerPayable getInstance() {
		if(instance == null) {
			instance = new ControllerPayable();
		}
		
		return instance;
	}
	
	
	public void Add(Payable p) {
		listPayable.add(p);
	}
	
	public List<Payable> ListAll() {
		return listPayable;
	}

}
