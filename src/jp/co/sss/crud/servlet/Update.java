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

/**
 * Servlet implementation class Update
 */
@WebServlet(urlPatterns={"/update/update"})
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String emp_id = request.getParameter("emp_id");
		if(session.getAttribute("update_emp_id")!=null){
			emp_id = (String)session.getAttribute("update_emp_id");
		}
		Employee emp = new Employee();
		emp = EmployeeDAO.selectWhereSQLForUpdate("employee", emp_id);
		session.setAttribute("update_emp_id", emp_id);
		session.setAttribute("emp_name", emp.getEmp_name());
		session.setAttribute("emp_pass", emp.getEmp_pass());
		session.setAttribute("gender", emp.getGender());
		session.setAttribute("emp_birth", emp.getBirthday());
		session.setAttribute("emp_addr", emp.getAddress());
		session.setAttribute("authority", emp.getAuthority());
		session.setAttribute("dept_id", emp.getDept_id());
		request.getRequestDispatcher("/update/update_input.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
