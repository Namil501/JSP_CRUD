package jp.co.sss.crud.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.crud.db.EmployeeDAO;

/**
 * Servlet implementation class SearchName
 */
@WebServlet(urlPatterns={"/search_name"})
public class SearchName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String emp_name=request.getParameter("search_emp_name");
		emp_name = "'%" + emp_name + "%'";
		System.out.println(emp_name);
		int con = 1;
		session.setAttribute("list_condition", con);
		session.setAttribute("search_name", emp_name);
		if(EmployeeDAO.selectAllSQL("employee", "emp_name", emp_name, true)!=null){
			request.getRequestDispatcher("list/list.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("list/list_empty.jsp").forward(request, response);
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
