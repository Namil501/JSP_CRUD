package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.bean.Employee;
import jp.co.sss.crud.util.Check;

public class EmployeeDAO {

	//select * from [table name]
	public static List<Employee> selectAllSQL(String table, String condition, String conditionValue, boolean like) {
		List<Employee> empList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;
		String sql;
		String tmp;

		try {
			conn = DBM.getConnection();
			if(condition == null){
				sql = "select * from "+ table +" order by emp_id asc";
				pst = conn.prepareStatement(sql);
				reslt = pst.executeQuery();
			}else if(like){
				sql = "select * from "+ table +" where " + condition + " like "+conditionValue+" order by emp_id asc";
				pst = conn.prepareStatement(sql);
				reslt = pst.executeQuery();
			}else{
				sql = "select * from "+ table +" where " + condition + " = ? order by emp_id asc";
				pst = conn.prepareStatement(sql);
				pst.setString(1, conditionValue);
				reslt = pst.executeQuery();
			}

			if(reslt.next()){
				 do{
					Employee emp = new Employee();
					emp.setEmp_id(reslt.getInt("emp_id"));
					emp.setEmp_name(reslt.getString("emp_name"));
					tmp = reslt.getInt("gender")==1?"男性":"女性";
					emp.setGender(tmp);
					tmp = reslt.getDate("BIRTHDAY").toString();
					tmp = tmp.replaceAll("-", "/");
					emp.setBirthday(tmp);
					tmp = EmployeeDAO.searchDept(reslt.getString("dept_id"));
					emp.setDept_id(tmp);
					tmp = reslt.getInt("authority") == 1?"一般":"管理者";
					emp.setAuthority(tmp);
					emp.setAddress(reslt.getString("address"));
					empList.add(emp);
				}while(reslt.next());
			}else {
				empList = null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			empList = null;
		}finally {
			DBM.close(reslt);
			DBM.close(pst);
			DBM.close(conn);
		}
		return empList;
	}
	//
	public static void selectWhereSQL(String table, String condition, String con_val) {
		Employee emp = new Employee();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;
		String sql="select * from "+ table +" where ";
		try {
			conn = DBM.getConnection();

			sql = sql + condition +" order by emp_id asc";

			pst = conn.prepareStatement(sql);
			pst.setString(1, con_val);

			reslt = pst.executeQuery();

			if(reslt.next()) {
				do{
					emp = Check.printEmployeeTable(reslt.getInt("EMP_ID"), reslt.getString("EMP_NAME"), reslt.getInt("gender"), reslt.getDate("BIRTHDAY").toString(), reslt.getString("DEPT_ID"));
				}while(reslt.next());
			}else{
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBM.close(reslt);
			DBM.close(pst);
			DBM.close(conn);
		}
	}
	public static Employee selectWhereSQLForUpdate(String table, String con_val) {
		Employee emp = new Employee();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;
		String sql="select * from "+ table +" where emp_id = ?";


		try {
			conn = DBM.getConnection();

			pst = conn.prepareStatement(sql);
			pst.setString(1, con_val);

			reslt = pst.executeQuery();
			if(reslt.next()) {
				System.out.println("in if by selectWhereSQLForUpadate");
				emp.setEmp_id(Integer.parseInt(reslt.getString("emp_id")));
				emp.setEmp_name(reslt.getString("emp_name"));
				emp.setEmp_pass(reslt.getString("emp_pass"));
				emp.setGender(reslt.getString("GENDER"));
				emp.setBirthday(reslt.getDate("BIRTHDAY").toString().replaceAll("-", "/"));
				emp.setAddress(reslt.getString("address"));
				emp.setAuthority(reslt.getString("authority"));
				emp.setDept_id(reslt.getString("DEPT_ID"));

			}else{
				System.out.println("in else by selectWhereSQLForUpadate");
				emp=null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBM.close(reslt);
			DBM.close(pst);
			DBM.close(conn);
		}
		return emp;
	}
	public static void insertSQLForEmployee(Employee emp) {


		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;

		String pw = emp.getEmp_pass();
		String name = emp.getEmp_name();
		String gender = emp.getGender();
		String addr = emp.getAddress();
		String birthday = emp.getBirthday();
		String authority = emp.getAuthority();
		String dept = emp.getDept_id();
		String sqlString="insert into employee(emp_id, emp_pass, emp_name, gender, address, birthday, authority, dept_id) values(seq_emp.nextval, ?, ?, ?, ?, ?, ?, ?)";

		try {

			conn = DBM.getConnection();
			pst = conn.prepareStatement(sqlString);
			pst.setString(1, pw);
			pst.setString(2, name);
			pst.setString(3, gender);
			pst.setString(4, addr);
			pst.setString(5, birthday);
			pst.setString(6, authority);
			pst.setString(7, dept);

			pst.executeUpdate();
			System.out.println("insert!");
		}catch(Exception e) {
			System.out.println("insert Fail!");
			e.printStackTrace();
		}finally {
			DBM.close(reslt);
			DBM.close(pst);
			DBM.close(conn);
		}
	}
	public static void updateSQL(Employee emp) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;

		String pass = emp.getEmp_pass();
		String name = emp.getEmp_name();
		String gender = emp.getGender();
		String address = emp.getAddress();
		String birthday = emp.getBirthday();
		String authority = emp.getAuthority();
		String dept = emp.getDept_id();
		String id = Integer.toString(emp.getEmp_id());

		String sqlString="update employee set emp_pass = ?, emp_name = ?, gender = ?, address = ?, birthday = ?, authority = ?, dept_id = ? where emp_id = ?";

		try {

			if(emp!=null) {
				conn = DBM.getConnection();
				pst = conn.prepareStatement(sqlString);
				pst.setString(1, pass);
				pst.setString(2, name);
				pst.setString(3, gender);
				pst.setString(4, address);
				pst.setString(5, birthday);
				pst.setString(6, authority);
				pst.setString(7, dept);
				pst.setString(8, id);

				pst.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBM.close(reslt);
			DBM.close(pst);
			DBM.close(conn);
		}
	}
	public static void selectEmpName() {
		String name;
		String condition = "emp_name like ";
		try {
			name = Check.isStringFalseLoop(1, 30);
			name = "'%" + name + "%'";
			selectWhereSQL("employee", condition , name);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectDeptName() {

		String id;
		int id_integer;
		String condition = "dept_id = ?";
		try {
			id_integer = Check.isIntFalseLoop("����ID�i�P�F�c�ƕ��A�Q�F�o�����A�R�F�������j����͂��Ă��������F", 1, 3);
			id = Integer.toString(id_integer);
			selectWhereSQL("employee", condition, id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static int deleteEmpCol(String table, String empID) {

		Connection conn = null;
		PreparedStatement pst = null;
		int ret = 0;	//0: delete OK, 1: wrong empID, 2: exception
		String condition = "emp_id = ?";
		String sql = "delete from " + table + " where " + condition;
		try {
			conn=DBM.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, empID);
			if(pst.executeUpdate() > 0 ) {
				ret = 0;
				System.out.println("Delete Complete!");
			}else {
				ret = 1;
				System.out.println("Delete Fail!");
			}
		}catch(Exception e) {
			ret = 2;
			e.printStackTrace();
			System.out.println("Exception!!!");
		}finally {
			DBM.close(pst);
			DBM.close(conn);
		}
		return ret;
	}
	public static String searchDept(String dept_id) {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;
		String dept_name = null;
		String sql="select dept_name from department where dept_id = ?";
		try {
			conn = DBM.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, dept_id);
			reslt = pst.executeQuery();
			if(reslt.next()) {
				dept_name = reslt.getString("dept_name");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBM.close(reslt);
			DBM.close(pst);
			DBM.close(conn);
		}
		return dept_name;
	}

	public int login(int id, String pw) {
		int success = 0;
		try {
			Connection con = DBM.getConnection();
			String sql = "SELECT * FROM employee WHERE emp_id=? AND emp_pass=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, pw);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				success = 1;
				return success;
			} else {
				return success;
			}

		} catch (Exception e) {
			success = -1;
			e.printStackTrace();
		}
		return success;

	}
}
