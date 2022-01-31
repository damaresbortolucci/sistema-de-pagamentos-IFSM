package br.edu.ifsuldeminas.controller;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.dao.EPayable;
import br.edu.ifsuldeminas.dao.PayableDao;
import br.edu.ifsuldeminas.dao.factory.PayableFactory;
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
	
	
	//salvar
	public boolean Add(Payable p) {
		PayableFactory factory = new PayableFactory(); //chama payable factory
		PayableDao dao = factory.getDaoPayble(p); //factory instancia o dao correspondente ao objeto recebido 
		boolean resposta = dao.savePayable(p); // salva o objeto 
		return resposta;
	}
	
	
	//listar todos
	public List<Payable> ListAll() {
		
		listPayable.clear();
		List<Payable> listTemp = null;
		PayableFactory factory = new PayableFactory();
		
		for(EPayable objeto : EPayable.values()) { //busca o tipo de payable
			PayableDao dao = factory.getDaoPayable(objeto); 
			listTemp = dao.getAllPayable();
			if(listTemp != null) {
				listPayable.addAll(listTemp);
				listTemp.clear();
			}
		}
			
		return listPayable;  //continuar
	}
}
