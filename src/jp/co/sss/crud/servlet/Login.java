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
		PrintWriter out = response.getWriter();
		//System.out.println(request.getParameter("emp_id"));
		//System.out.println(request.getParameter("emp_pw"));

		int id = Integer.parseInt(request.getParameter("emp_id"));
		String pw = request.getParameter("emp_pw");
		int loginStatus = dao.login(id, pw);
		String user_name = EmployeeDAO.searchDept(Integer.toString(id), false);
		if(loginStatus == 1){
			//success;
			session.setAttribute("login_status", loginStatus);
			session.setAttribute("user_name", user_name);
			session.setAttribute("login_emp_id", id);
			session.setAttribute("list_condition", 0);
			request.getRequestDispatcher("list/list_emp.jsp").forward(request, response);
		}else if(loginStatus == 2){
			session.setAttribute("login_status", loginStatus);
			session.setAttribute("user_name", user_name);
			session.setAttribute("login_emp_id", id);
			session.setAttribute("list_condition", 0);
			request.getRequestDispatcher("/list/list.jsp").forward(request, response);
		}else{
			System.out.println("login fail");
			out.println("<meta charset='UTF-8'>");
			out.println("<script>");
			out.println("alert('社員ID、またはパスワードが間違っています。');");
            out.println("location.href='index.jsp';");
			out.println("</script>");
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
