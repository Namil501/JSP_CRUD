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
	public static List<Employee> selectAllSQL(String table) {
		List<Employee> empList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;
		String sql;
		String tmp;

		try {
			conn = DBM.getConnection();
			sql = "select * from "+ table +" order by emp_id asc";
			pst = conn.prepareStatement(sql);
			reslt = pst.executeQuery();

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
	public static String[] selectWhereSQLForUpdate(String table, String condition, String con_val) {
		Employee emp = new Employee();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;
		String sql="select * from "+ table +" where ";


		String[] arr= {null, null, null, null, null};

		try {
			conn = DBM.getConnection();

			sql = sql + condition;

			pst = conn.prepareStatement(sql);
			pst.setString(1, con_val);

			reslt = pst.executeQuery();



			System.out.println(String.format("|%-4s \t|%-10s \t|%-4s \t|%-10s \t|%-8s|", "�Ј�ID", "�Ј���", "����", "���N����", "������"));
			if(reslt.next()) {
				do{

					arr[0] = reslt.getString("EMP_ID");
					arr[1] = reslt.getString("EMP_NAME");
					arr[2] = reslt.getString("GENDER");
					arr[3] = reslt.getDate("BIRTHDAY").toString();
					arr[4] = reslt.getString("DEPT_ID");


					emp = Check.printEmployeeTable(reslt.getInt("EMP_ID"), reslt.getString("EMP_NAME"), reslt.getInt("gender"), reslt.getDate("BIRTHDAY").toString(), reslt.getString("DEPT_ID"));
				}while(reslt.next());
			}else{
				System.out.println("�Y������Ј��͑��݂��܂���B");
				return arr;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBM.close(reslt);
			DBM.close(pst);
			DBM.close(conn);
		}
		return arr;
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
		System.out.println(pw + " " + name + " " + gender + " " + addr + " " +birthday+ " " +authority+ " " +dept);
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
			e.printStackTrace();
		}finally {
			DBM.close(reslt);
			DBM.close(pst);
			DBM.close(conn);
		}
	}
	public static void updateSQL() {


		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;

		String emp_id;
		int emp_id_integer;
		String name;
		String sex;
		String birthday;
		String dept;
		String tmp=null;

		String[] arr= {null, null, null, null, null};

		String sqlString="update employee set emp_name= ?, gender = ?, birthday = ?, dept_id = ? where emp_id = ?";

		try {
			emp_id_integer = Check.isIntFalseLoop("�X�V����Ј��̎Ј�ID����͂��Ă��������F", 1, 9999);
			emp_id = Integer.toString(emp_id_integer);


			arr=selectWhereSQLForUpdate("employee","emp_id = ?", emp_id);

			if(arr[0]!=null) {

				tmp = Check.isStringFalseLoop(0, 30);
				name = tmp.isEmpty()?arr[1]:tmp;

				tmp = Check.isIntFalseLoop("���ʁi�P�F�j���A�Q�F�����j:", 0, 2, true);
				sex = tmp.isEmpty()?arr[2]:tmp;

				tmp = Check.isDateFalseLoop("���N�����i����N/��/���j�F",true);
				birthday = tmp.isEmpty()?arr[3]:tmp;

				tmp = Check.isIntFalseLoop("����ID�i�P�F�c�ƕ��A�Q�F�o�����A�R�F�������j�F", 0, 3, true);
				dept = tmp.isEmpty()?arr[4]:tmp;

				conn = DBM.getConnection();
				pst = conn.prepareStatement(sqlString);
				pst.setString(1, name);
				pst.setString(2, sex);
				pst.setString(3, birthday);
				pst.setString(4, dept);
				pst.setString(5, emp_id);
				System.out.println("�Ј������X�V���܂����B");

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
	public static void deleteTable(String table, String column) {

		Connection conn = null;
		PreparedStatement pst = null;
		String emp_id;
		int emp_id_integer;
		String condition = column + " = ?";
		String sql = "delete from " + table + " where " + condition;
		try {
			emp_id_integer = Check.isIntFalseLoop("�폜����Ј��̎Ј�ID����͂��Ă��������F", 1, 9999);
			emp_id = Integer.toString(emp_id_integer);

			conn=DBM.getConnection();

			pst = conn.prepareStatement(sql);
			pst.setString(1, emp_id);
			if(pst.executeUpdate() > 0 ) {
				System.out.println("�Ј������폜���܂����B");
			}else {
				System.out.println("�Y������Ј��͓o�^����Ă��܂���B");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBM.close(pst);
			DBM.close(conn);
		}
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
