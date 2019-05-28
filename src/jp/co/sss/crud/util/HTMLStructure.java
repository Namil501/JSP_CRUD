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
}