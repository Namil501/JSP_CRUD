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
 * Servlet implementation class UpdateComplete
 */
@WebServlet(urlPatterns={"/update/update_complete"})
public class UpdateComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		HttpSession session = request.getSession();
		try{
			emp.setEmp_name((String)session.getAttribute("emp_name"));
			session.removeAttribute("emp_name");
			emp.setEmp_pass((String)session.getAttribute("emp_pass"));
			session.removeAttribute("emp_pass");
			emp.setAddress((String)session.getAttribute("emp_addr"));
			session.removeAttribute("emp_addr");
			emp.setAuthority((String)session.getAttribute("authority"));
			session.removeAttribute("authority");
			emp.setBirthday((String)session.getAttribute("emp_birth"));
			session.removeAttribute("emp_birth");
			emp.setDept_id((String)session.getAttribute("dept_id"));
			session.removeAttribute("dept_id");
			emp.setGender((String)session.getAttribute("gender"));
			session.removeAttribute("gender");
			emp.setEmp_id(Integer.parseInt(session.getAttribute("update_emp_id").toString()));
			EmployeeDAO.updateSQL(emp);
			session.removeAttribute("update_emp_id");
			session.setAttribute("user_name", emp.getEmp_name());
			request.getRequestDispatcher("/update/update_complete.jsp").forward(request, response);
		}catch(Exception e){
			System.out.println("update fail by RegistComplete");
			request.getRequestDispatcher("/list/list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
