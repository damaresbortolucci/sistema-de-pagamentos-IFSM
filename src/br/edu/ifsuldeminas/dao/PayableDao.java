package br.edu.ifsuldeminas.dao;

import java.util.List;

import br.edu.ifsuldeminas.model.Payable;

public interface PayableDao {
	
	public boolean savePayable(Payable payable) ;
	public boolean deletePayable(int id);
	public boolean updatePayable(Payable payble, int id);
	public Payable getPayable(int id);
	public List<Payable> getAllPayable();

}
