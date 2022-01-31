package br.edu.ifsuldeminas.dao.factory;

import br.edu.ifsuldeminas.dao.EPayable;
import br.edu.ifsuldeminas.dao.PayableDao;
import br.edu.ifsuldeminas.dao.employee.BasePlusCommissionEmployeeDaoImpl;
import br.edu.ifsuldeminas.dao.employee.CommissionEmployeeDaoImpl;
import br.edu.ifsuldeminas.dao.employee.HourlyEmployeeDaoImpl;
import br.edu.ifsuldeminas.dao.employee.SalariedEmployeeDaoImpl;
import br.edu.ifsuldeminas.dao.invoice.InvoiceDaoImpl;
import br.edu.ifsuldeminas.model.BasePlusCommissionEmployee;
import br.edu.ifsuldeminas.model.CommissionEmployee;
import br.edu.ifsuldeminas.model.HourlyEmployee;
import br.edu.ifsuldeminas.model.Invoice;
import br.edu.ifsuldeminas.model.Payable;
import br.edu.ifsuldeminas.model.SalariedEmployee;

public class PayableFactory {
	
	
	public PayableDao getDaoPayble(Payable payable) {
		
		if(payable instanceof SalariedEmployee) {
			return new SalariedEmployeeDaoImpl();
		} else if (payable instanceof HourlyEmployee) {
			return new HourlyEmployeeDaoImpl();
		}else if (payable instanceof BasePlusCommissionEmployee) {
			return new BasePlusCommissionEmployeeDaoImpl();
		}else if (payable instanceof CommissionEmployee) {
			return new CommissionEmployeeDaoImpl();	
		} else if (payable instanceof Invoice) {
			return new InvoiceDaoImpl();
		}
		
		return null;
	}
	
	
	public PayableDao getDaoPayable(EPayable tipo) {
		
		switch(tipo) {
		 
		case SalariedEmployee:
			return new SalariedEmployeeDaoImpl();
		
		case HourlyEmployee:
			return new HourlyEmployeeDaoImpl();

		case BasePlusCommissionEmployee:
			return new BasePlusCommissionEmployeeDaoImpl();
			
		case CommissionEmployee:
			return new CommissionEmployeeDaoImpl();
		
		case Invoice:
			return new InvoiceDaoImpl();
		
		default: 
			return null;
		}
	}

}
