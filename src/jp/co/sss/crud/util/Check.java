package jp.co.sss.crud.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;

import jp.co.sss.crud.db.*;
import jp.co.sss.crud.bean.Employee;

public class Check {


	public static boolean checkInteger(String str, int min, int max) {
	/*
	 *
	 * �Ԃ��O��int�^�ŋA�邩���f���A��Ȃ�������-1�ŕԂ��B
	 * */
		int tmp;
		try {
			tmp=Integer.parseInt(str);
			if(tmp < min || tmp > max) {
				System.out.println(min + "�ȏ�" + max + "�ȉ��̐�������͂��Ă��������B");
				return false;
			}
		}catch(NumberFormatException e) {
			System.out.println("��������������͂��Ă��������B");
			return false;
		}
		return true;
	}
	public static boolean checkStringLength(String str, int min, int max) {
	/*
	 * �p�����^str�̒������@min�ȏ� max�ȉ��Ȃ̂����f���郁�b�\�[�h
	 * */
		try {
			if(str.length()<min || str.length()>max) {
				System.out.println(min + "�����ȏ�" + max + "�����ȉ��̕��������͂��Ă��������B");
				return false;
			}

		}catch(Exception e) {
			return false;
		}
		return true;
	}
	public static boolean checkDatePossibility(String str) {
		boolean chk=false;
		try {
			DateFormat format = DateFormat.getDateInstance();
			format.setLenient(false);
			format.parse(str);
			chk = true;
		}catch(Exception e) {
			return false;
		}
		return chk;
	}
	public static int isIntFalseLoop(String str, int min, int max) {
		/*
		 * �p�����^str��min�ȏ�max�ȉ��̐��������f���A�������f�[�^�����͂����܂Ń��[�v���郁�b�\�[�h
		 * */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ret;
		String input;
		boolean chk=false;
		try {
			do {
				System.out.print(str);
				input = br.readLine();
				chk = checkInteger(input, min, max);
			}while(chk==false);
		}catch(Exception e) {
			return -1;
		}
		ret = Integer.parseInt(input);
		return ret;
	}
	public static String isIntFalseLoop(String str, int min, int max, boolean isUpdate) {
		/*
		 * �p�����^str��min�ȏ�max�ȉ��̐��������f���A�������f�[�^�����͂����܂Ń��[�v���郁�b�\�[�h
		 * �X�V�iupdate�j�̂��߂̃��b�\�[�h
		 * �󗓂��󂯂�Ƌ󗓂�Ԃ��B
		 * null��Ԃ���null point exception���������邩��
		 * �󗓂̏ꍇ""�ŕԂ��B
		 * */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ret;
		String input;
		boolean chk=false;
		try {
			do {
				System.out.print(str);
				input = br.readLine();
				if(input.isEmpty()) {
					return "";
				}
				chk = checkInteger(input, min, max);
			}while(chk==false);
		}catch(Exception e) {
			return null;
		}
		ret = Integer.parseInt(input);
		return Integer.toString(ret);
	}
	public static String isStringFalseLoop(int min, int max) {
		/*
		 * �p�����^str��min�ȏ�max�ȉ��̕�����œ��͎󂯂�܂Ń��[�v
		 * */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		String ret=null;
		boolean chk = false;
		try {
			do {
				input = br.readLine();
				chk = checkStringLength(input, min, max);
			}while(chk == false);
			ret = input;
		}catch(Exception e) {
			return null;
		}
		return ret;
	}
	public static String isDateFalseLoop(String str) {
		// date�̃f�[�^����͂��Ă��̃f�[�^���������f�[�^�œ��͂����܂łɃ��[�v����B
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		String ret=null;
		boolean chk = false;
		try {
			do {
				System.out.print(str);
				input = br.readLine();
				chk = checkDatePossibility(input);
			}while(chk == false);
			ret = input;
		}catch(Exception e) {
			return null;
		}
		return ret;
	}
	public static String isDateFalseLoop(String str, boolean isUpdate) {
		// date�̃f�[�^����͂��Ă��̃f�[�^���������f�[�^�œ��͂����܂łɃ��[�v����B
		//�@�X�V�����鎞�p���b�\�[�h
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		String ret=null;
		boolean chk = false;
		try {
			do {
				System.out.print(str);
				input = br.readLine();
				if(input.isEmpty()) {
					chk = true;
				}
				else {
					chk = checkDatePossibility(input);
				}
			}while(chk == false);
			ret = input;
		}catch(Exception e) {
			return null;
		}
		return ret;
	}
	public static Employee printEmployeeTable(int empID, String empName, int gender, String birthday, String dept_id) {
		Employee emp = new Employee();
		String dept;
		String date;
		String gender_string;
		if(gender == 1) {
			gender_string = "男性";
		}else
		{
			gender_string = "女性";
		}
		date = birthday;
		date = date.replaceAll("-", "/");
		dept = dept_id;
		dept = EmployeeDAO.searchDept(dept, true);
		emp.setEmp_id(empID);
		emp.setEmp_name(empName);
		emp.setGender(gender_string);
		emp.setBirthday(date);
		emp.setDept_id(dept);
		return emp;
	}
	public static int checkAuthority(String empID){
		int authority=0;

		return authority;
	}
}
