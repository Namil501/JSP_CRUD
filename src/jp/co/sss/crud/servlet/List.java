package jp.co.sss.crud.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class List
 */
@WebServlet(urlPatterns={"/list/list"})
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int con = 0;
		int loginStatus = (int)session.getAttribute("login_status");
		session.setAttribute("list_condition", con);
		if(loginStatus == 1){
			//success;
			session.setAttribute("list_condition", 0);
			request.getRequestDispatcher("/list/list_emp.jsp").forward(request, response);
		}else if(loginStatus == 2){
			session.setAttribute("list_condition", 0);
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
