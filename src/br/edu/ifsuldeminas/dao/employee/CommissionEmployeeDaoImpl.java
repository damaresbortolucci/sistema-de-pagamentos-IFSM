package br.edu.ifsuldeminas.dao.employee;

import java.util.List;

import br.edu.ifsuldeminas.dao.PayableDao;
import br.edu.ifsuldeminas.model.Payable;

public class CommissionEmployeeDaoImpl implements PayableDao {

	@Override
	public boolean savePayable(Payable payable) {
		
		
		return false;
	}

	@Override
	public boolean deletePayable(int id) {
		return false;
	}

	@Override
	public boolean updatePayable(Payable payble, int id) {
		return false;
	}

	@Override
	public Payable getPayable(int id) {
		return null;
	}

	@Override
	public List<Payable> getAllPayable() {
		return null;
	}

}
