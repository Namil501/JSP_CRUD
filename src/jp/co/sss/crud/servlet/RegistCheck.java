package jp.co.sss.crud.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.sss.crud.bean.Employee;
import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.util.Check;

/**
 * Servlet implementation class RegistCheck
 */
@WebServlet(urlPatterns={"/regist/regist_check"})
public class RegistCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = new Employee();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if ( Check.checkDatePossibility((String)session.getAttribute("emp_birth")) ){
			request.getRequestDispatcher("/regist/regist_check.jsp").forward(request, response);
		}else{
			System.out.println("regist fail");
			out.println("<meta charset='UTF-8'>");
			out.println("<script>");
			out.println("alert('登録失敗！誕生日の形式が正しくありません。');");
            out.println("location.href='/servlet_crud/regist/regist.jsp';");
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
