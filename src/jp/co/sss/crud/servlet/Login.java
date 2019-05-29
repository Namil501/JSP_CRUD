package jp.co.sss.crud.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.util.HTMLStructure;

/**
 * Servlet implementation class Login
 */
@WebServlet("/index")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		EmployeeDAO dao = new EmployeeDAO();
		//System.out.println(request.getParameter("emp_id"));
		//System.out.println(request.getParameter("emp_pw"));

		int id = Integer.parseInt(request.getParameter("emp_id"));
		String pw = request.getParameter("emp_pw");
		int loginStatus = dao.login(id, pw);
		if(loginStatus == 1){
			//success
			session.setAttribute("emp_id", id);
			request.getRequestDispatcher("list/list.html").forward(request, response);
		}else{

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
