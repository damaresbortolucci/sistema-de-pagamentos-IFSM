package br.edu.ifsuldeminas.dao.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import br.edu.ifsuldeminas.connection.ConnectFactory;
import br.edu.ifsuldeminas.dao.PayableDao;
import br.edu.ifsuldeminas.model.HourlyEmployee;
import br.edu.ifsuldeminas.model.Payable;


public class HourlyEmployeeDaoImpl implements PayableDao {

	@Override
	public boolean savePayable(Payable payable) {
		
		Connection connection = null;
		HourlyEmployee employee = (HourlyEmployee) payable;
		boolean sucesso = true;
		
		try {
			connection = ConnectFactory.createConnection();
			
			/* preparar a instrução SQL */
			String query = "insert into hourly_employee (first_name,last_name,cpf,wage,hours,object_type) values(?, ?, ?, ?, ?,?)";

			/* preencher os dados na query */
			PreparedStatement prepare = connection.prepareStatement(query);
			
			prepare.setString(1, employee.getFirstName());
			prepare.setString(2, employee.getLastName());
			prepare.setString(3, employee.getCpf().replace(".", "").replace("-", ""));
			prepare.setDouble(4, employee.getWage());
			prepare.setDouble(5, employee.getHours());
			prepare.setString(6, employee.getClass().getSimpleName());
			
			prepare.execute();
			
		} catch (SQLException e) {

			e.printStackTrace();
			sucesso = false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		
		return sucesso;
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
