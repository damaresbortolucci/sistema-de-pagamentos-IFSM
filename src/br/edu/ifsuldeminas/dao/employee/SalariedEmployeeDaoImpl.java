package br.edu.ifsuldeminas.dao.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsuldeminas.connection.ConnectFactory;
import br.edu.ifsuldeminas.dao.PayableDao;
import br.edu.ifsuldeminas.model.Payable;
import br.edu.ifsuldeminas.model.SalariedEmployee;

public class SalariedEmployeeDaoImpl implements PayableDao {

	@Override
	public boolean savePayable(Payable payable) {
	
		Connection connection = null;
		SalariedEmployee employee = (SalariedEmployee) payable;
		boolean sucesso = true;
		
		try {
			connection = ConnectFactory.createConnection();
			
			/* preparar a instrução SQL */
			String query = "insert into salaried_employee (first_name,last_name,cpf,weekly_salary,object_type) values(?, ?, ?, ?, ?)";

			/* preencher os dados na query */
			PreparedStatement prepare = connection.prepareStatement(query);
			
			prepare.setString(1, employee.getFirstName());
			prepare.setString(2, employee.getLastName());
			prepare.setString(3, employee.getCpf().replace(".", "").replace("-", ""));
			prepare.setDouble(4, employee.getWeeklySalary());
			prepare.setString(5, employee.getClass().getSimpleName());
			
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
	
		List<Payable> listPayable = new ArrayList<Payable>();
		Connection connection = null;
		Statement st = null;
	
		
		try {
			connection = ConnectFactory.createConnection();
			
			String query = "SELECT id, first_name, last_name, cpf, weekly_salary FROM salaried_employee";
			st = connection.createStatement();
			ResultSet rs = st.executeQuery(query); //recebe o resultado da query
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String cpf = String.format("xxx.xxx.xxx-xx", rs.getString("cpf"));
				double weeklySalaried = rs.getDouble("weekly_salary");
				listPayable.add(new SalariedEmployee(id, firstName,lastName,cpf,weeklySalaried));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return listPayable;
	}

}
