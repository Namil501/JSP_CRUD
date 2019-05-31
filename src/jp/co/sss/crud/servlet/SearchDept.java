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
 * Servlet implementation class SearchDept
 */
@WebServlet(urlPatterns={"/search_dept"})
public class SearchDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String dept_id=request.getParameter("dept_id");
		int con = 2;
		session.setAttribute("list_condition", con);
		session.setAttribute("search_dept", dept_id);
		if(EmployeeDAO.selectAllSQL("employee", "dept_id", dept_id, false)!=null){
			request.getRequestDispatcher("/list/list").forward(request, response);
		}else{
			request.getRequestDispatcher("/list/list_empty.jsp").forward(request, response);
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
