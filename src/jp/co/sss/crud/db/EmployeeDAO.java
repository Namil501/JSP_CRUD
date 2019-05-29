package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.sss.crud.util.Check;

public class EmployeeDAO {

	public static void selectAllSQL(String sql) {
		//�p�����^sql�̃N�G�������s���郁�b�\�[�h
		//���������employee�e�[�u���S�ẴJ�������o�͂��郁�b�\�[�h

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;

		try {
			conn = DBM.getConnection();
			pst = conn.prepareStatement(sql);
			reslt = pst.executeQuery();

			//employee�e�[�u���̃J������format�ɍ��킹�ďo�͂���B
			System.out.println(String.format("|%-4s \t|%-10s \t|%-4s \t|%-10s \t|%-8s|", "�Ј�ID", "�Ј���", "����", "���N����", "������"));
			if(reslt.next()){
				 do{
					//Util.java��printEmployeeTalbe��fomat�ɍ��킹�ďo�͂��郁�b�\�[�h�B
					//�o�͏����igender�͒j���E����,�������͐����ł͂Ȃ��{���̕������Łj
					Check.printEmployeeTable(reslt.getString("EMP_ID"), reslt.getString("EMP_NAME"), reslt.getInt("gender"), reslt.getDate("BIRTHDAY").toString(), reslt.getString("DEPT_ID"));
				}while(reslt.next());
			}else {
				System.out.println("�Ј����o�^����Ă��܂���B");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBM.close(reslt);
			DBM.close(pst);
			DBM.close(conn);
		}
	}
	public static void selectWhereSQL(String table, String condition, String con_val) {
		/*
		 * select����where�������Ă�sql��
		 * condition�͏����̃J����
		 * con_val��condition�����̃f�[�^
		 * */
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


			//employee�e�[�u���̃J������format�ɍ��킹�ďo�͂���B�ҏW����Ɠ��ꐫ�̂��߂ɑ���select���b�\�[�h���ҏW���Ȃ��Ⴞ�߁B
			System.out.println(String.format("|%-4s \t|%-10s \t|%-4s \t|%-10s \t|%-8s|", "�Ј�ID", "�Ј���", "����", "���N����", "������"));
			if(reslt.next()) {
				do{
					//Util.java��printEmployeeTalbe��fomat�ɍ��킹�ďo�͂��郁�b�\�[�h�B
					//�o�͏����igender�͒j���E����,�������͐����ł͂Ȃ��{���̕������Łj
					Check.printEmployeeTable(reslt.getString("EMP_ID"), reslt.getString("EMP_NAME"), reslt.getInt("gender"), reslt.getDate("BIRTHDAY").toString(), reslt.getString("DEPT_ID"));
				}while(reslt.next());
			}else{
				System.out.println("�Y������Ј��͑��݂��܂���B");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBM.close(reslt);
			DBM.close(pst);
			DBM.close(conn);
		}
	}
	public static void selectWhereSQL(String table, String condition) {

		/*
		 * selectWhereSQL(String table, String condition, String con_val)�ƂɂĂ邯��
		 * like���g��SQL���ł���B
		 * like���g��select���̏ꍇ�͂������g���ׂ��B
		 * */

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;
		String sql="select * from "+ table +" where ";
		try {
			conn = DBM.getConnection();

			sql = sql + condition + " order by emp_id asc";

			pst = conn.prepareStatement(sql);

			reslt = pst.executeQuery();


			//employee�e�[�u���̃J������format�ɍ��킹�ďo�͂���B�ҏW����Ɠ��ꐫ�̂��߂ɑ���select���b�\�[�h���ҏW���Ȃ��Ⴞ�߁B
			System.out.println(String.format("|%-4s \t|%-10s \t|%-4s \t|%-10s \t|%-8s|", "�Ј�ID", "�Ј���", "����", "���N����", "������"));
			if(reslt.next()) {
				do{
					//Util.java��printEmployeeTalbe��fomat�ɍ��킹�ďo�͂��郁�b�\�[�h�B
					//�o�͏����igender�͒j���E����,�������͐����ł͂Ȃ��{���̕������Łj
					Check.printEmployeeTable(reslt.getString("EMP_ID"), reslt.getString("EMP_NAME"), reslt.getInt("gender"), reslt.getDate("BIRTHDAY").toString(), reslt.getString("DEPT_ID"));
				}while(reslt.next());
			}else{
				System.out.println("�Y������Ј��͑��݂��܂���B");
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
		/*
		 * selectWhereSQL()�Ɠ����@�\�����A
		 * �X�V�p�̃��b�\�[�h���B
		 * �Ⴄ�Ƃ���͎Ј�ID����͂��A���̎Ј��̃��R�[�h��
		 * String�^�̔z��arr�ɕۑ������̃f�[�^���o�͂��邱�Ƃ��B
		 *
		 * */

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;
		String sql="select * from "+ table +" where ";

		//return�ŕԂ����Ɏg���ϐ�
		String[] arr= {null, null, null, null, null};

		try {
			conn = DBM.getConnection();

			sql = sql + condition;

			pst = conn.prepareStatement(sql);
			pst.setString(1, con_val);

			reslt = pst.executeQuery();


			//employee�e�[�u���̃J������format�ɍ��킹�ďo�͂���B�ҏW����Ɠ��ꐫ�̂��߂ɑ���select���b�\�[�h���ҏW���Ȃ��Ⴞ�߁B
			System.out.println(String.format("|%-4s \t|%-10s \t|%-4s \t|%-10s \t|%-8s|", "�Ј�ID", "�Ј���", "����", "���N����", "������"));
			if(reslt.next()) {
				do{
					//arr��String�^�����炷�ׂẴf�[�^��String�^�ŕς��Ċe�C���f�b�N�X�ɕۑ��B
					//�X�V���郁�b�\�[�h���X�V���Ȃ��f�[�^�̏ꍇ���͂Ȃ��ɂ��邯��
					//���̎����f���邽�߂⌳�̃f�[�^����͂��邽�߂�arr�z��ɕۑ������̃f�[�^��Ԃ��B
					arr[0] = reslt.getString("EMP_ID");
					arr[1] = reslt.getString("EMP_NAME");
					arr[2] = reslt.getString("GENDER");
					arr[3] = reslt.getDate("BIRTHDAY").toString();
					arr[4] = reslt.getString("DEPT_ID");

					//Util.java��printEmployeeTalbe��fomat�ɍ��킹�ďo�͂��郁�b�\�[�h�B
					//�o�͏����igender�͒j���E����,�������͐����ł͂Ȃ��{���̕������Łj
					Check.printEmployeeTable(reslt.getString("EMP_ID"), reslt.getString("EMP_NAME"), reslt.getInt("gender"), reslt.getDate("BIRTHDAY").toString(), reslt.getString("DEPT_ID"));
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
	public static void insertSQL() {

		/*
		 * employee table�ɓo�^�iinsert�j����@�\�̃��b�\�[�h���B
		 * */
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet reslt = null;

		String name;
		String sex;
		int sex_integer;
		String birthday;
		String dept;
		int dept_integer;

		String sqlString="insert into employee(emp_id, emp_name, gender, birthday, dept_id) values(seq_emp.nextval, ?, ?, ?, ?)";

		try {
			name = Check.isStringFalseLoop("�Ј����F", 1, 30);
			sex_integer = Check.isIntFalseLoop("���ʁi�P�F�j���A�Q�F�����j:", 1, 2);
			sex = Integer.toString(sex_integer);
			birthday = Check.isDateFalseLoop("���N�����i����N/��/���j�F");
			dept_integer = Check.isIntFalseLoop("����ID�i�P�F�c�ƕ��A�Q�F�o�����A�R�F�������j�F", 1, 3);
			dept = Integer.toString(dept_integer);

			conn = DBM.getConnection();
			pst = conn.prepareStatement(sqlString);
			pst.setString(1, name);
			pst.setString(2, sex);
			pst.setString(3, birthday);
			pst.setString(4, dept);

			pst.executeUpdate();

			System.out.println("�Ј�����o�^���܂����B");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBM.close(reslt);
			DBM.close(pst);
			DBM.close(conn);
		}
	}
	public static void updateSQL() {

		/*
		 *employee�e�[�u�����X�V���郁�b�\�[�h���B
		 * */
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
		//�󗓂œ��͎󂯂������̃f�[�^�ōX�V���邽�߂ɁA���̌��̃f�[�^��ۑ�����String �z��
		String[] arr= {null, null, null, null, null};

		String sqlString="update employee set emp_name= ?, gender = ?, birthday = ?, dept_id = ? where emp_id = ?";

		try {
			emp_id_integer = Check.isIntFalseLoop("�X�V����Ј��̎Ј�ID����͂��Ă��������F", 1, 9999);
			emp_id = Integer.toString(emp_id_integer);

			//�󂯂�emp_id��employee�e�[�u�����烌�R�[�h��T���A�o�͌�A���̃��R�[�h�̃J�����̃f�[�^��arr�z��ɕۑ�
			arr=selectWhereSQLForUpdate("employee","emp_id = ?", emp_id);

			if(arr[0]!=null) {
				//tmp�ɍX�V����f�[�^���󂯂ď����ɍ��킹�Ă邩���f���A�󗓂���͂����ꍇ�͌��̃f�[�^��ۑ�����B
				//���̃f�[�^��arr�z��ɂ���B
				tmp = Check.isStringFalseLoop("�Ј����F", 0, 30);
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
		/*
		 * �Ј��̖��O��employee�e�[�u�����猟�����郁�b�\�[�h���B
		 * ������selectWhereSQL�iString table, String condition�j���g���Ă���B
		 * */
		String name;
		String condition = "emp_name like ";
		try {
			name = Check.isStringFalseLoop("�Ј�������͂��Ă��������F", 1, 30);
			name = "'%" + name + "%'";
			selectWhereSQL("employee", condition + name);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void selectDeptName() {
		/*
		 * �������Ō������郁�b�\�[�h���B
		 * ������selectWhereSQL(String table, String condition, String con_val)���g���Ă���B
		 * */
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
		/*
		 * employee�e�[�u���̃��R�[�h���폜���郁�b�\�[�h���B
		 * �폜��������͎Ј�ID�B
		 *
		 * */
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
		/*
		 * department�e�[�u����dept_id���������A���������󂯂ĕԂ����b�\�[�h���B
		 * */
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
	//前の授業で学んだコードを最初コピーして修正
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
