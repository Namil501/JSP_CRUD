package jp.co.sss.crud.util;

import java.io.PrintWriter;

public class HTMLStructure {
	public String title = "社員管理システム";
	public String rootPath = "/servlet_crud/";
	public void head(PrintWriter out){
		out.println("<!DOCTYPE html>");
		out.println("<html lang='jp'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1, shrinkto-fit=no'>");
		out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>");
		out.println("<link rel='stylesheet' href='"+this.rootPath+"css/layout.css?v=1.2'>");
		out.println("<link rel='stylesheet' href='"+this.rootPath+"css/style.css?v=1.4'>");
		out.println("<title>"+ this.title +"</title>");
		out.println("</head>");
		out.println("<body>");
	}
	public void footer(PrintWriter out){
		out.println("<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js' integrity='sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo' crossorigin='anonymous'></script>");
		out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js' integrity='sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49' crossorigin='anonymous'></script>");
		out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js' integrity='sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy' crossorigin='anonymous'></script>");
		out.println("</body>");
		out.println("</html>");
	}
	public void sidebar(PrintWriter out){
		out.println("<div class='row sidebar-sub'>");
			out.println("<div class='col-lg-12'>");
		//修正必要
				out.println("<form action='"+rootPath+"list/list_empty.html'>");
					out.println("<div class='form-group'>");
						out.println("<div class='row search-label'>");
							out.println("<label for='emp_name'>社員名検索</label>");
						out.println("</div>");
						out.println("<div class='row'>");
							out.println("<div class='col-lg-8'>");
								out.println("<input type='text' class='form-control' id='emp_name'>");
							out.println("</div>");
							out.println("<div class='col-lg-4'>");
								out.println("<button type='submit' class='btn btn-info'>検索</button>");
							out.println("</div>");
						out.println("</div>");
					out.println("</div>");
				out.println("</form>");
			out.println("</div>");
		out.println("</div>");
		out.println("<div class='row sidebar-sub'>");
			out.println("<div class='col-lg-12'>");
				out.println("<form action='"+rootPath+"list/list_empty.html'>");
					out.println("<div class='form-group'>");
						out.println("<div class='row search-label'>");
							out.println("<label class='form-label' for='dept_name'>部署名検索</label>");
						out.println("</div>");
						out.println("<div class='row'>");
							out.println("<div class='col-lg-8'>");
								out.println("<select class='form-control' id='dept_name'>");
									out.println("<option value='営業部'>営業部</option>");
									out.println("<option value='経理部'>経理部</option>");
									out.println("<option value='総務部'>総務部</option>");
								out.println("</select>");
							out.println("</div>");
							out.println("<div class='col-lg-4'>");
								out.println("<button type='submit' class='btn btn-info'>検索</button>");
							out.println("</div>");
						out.println("</div>");
					out.println("</form>");
				out.println("</div>");
			out.println("</div>");
		out.println("</div>");
	}
}