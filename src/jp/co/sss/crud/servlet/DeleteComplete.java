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
 * Servlet implementation class DeleteComplete
 */
@WebServlet(urlPatterns={"/delete/delete_complete"})
public class DeleteComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String empID = (String)session.getAttribute("delete_emp_id");
		int chkDelete = 0;
		chkDelete = EmployeeDAO.deleteEmpCol("employee", empID);
		if(chkDelete == 0){
			request.getRequestDispatcher("/delete/delete_complete.jsp").forward(request, response);
		}else{
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
