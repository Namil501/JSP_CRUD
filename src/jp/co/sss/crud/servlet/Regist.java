package jp.co.sss.crud.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.crud.bean.Employee;
import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.util.HTMLStructure;

/**
 * Servlet implementation class Regist
 */
@WebServlet(urlPatterns={"/regist/regist"})
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDAO dao = new EmployeeDAO();
		HTMLStructure root = new HTMLStructure();
		Employee emp = new Employee();
		HttpSession session = request.getSession();
		emp.setEmp_name(request.getParameter("emp_name"));
		session.setAttribute("emp_name", emp.getEmp_name());
		emp.setEmp_pass(request.getParameter("emp_pw"));
		session.setAttribute("emp_pass", emp.getEmp_pass());
		emp.setGender(request.getParameter("gender"));
		session.setAttribute("gender", emp.getGender());
		emp.setBirthday(request.getParameter("emp_birth"));
		session.setAttribute("emp_birth", emp.getBirthday());
		emp.setAddress(request.getParameter("emp_addr"));
		session.setAttribute("emp_addr", emp.getAddress());
		emp.setAuthority(request.getParameter("authority"));
		session.setAttribute("authority", emp.getAuthority());
		emp.setDept_id(request.getParameter("dept_id"));
		session.setAttribute("dept_id", emp.getDept_id());
		//dao.insertSQLForEmployee(emp);
		request.getRequestDispatcher("/regist/regist_check").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
