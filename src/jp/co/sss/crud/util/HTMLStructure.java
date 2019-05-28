package jp.co.sss.crud.util;

import java.io.PrintWriter;

public class HTMLStructure {
	static String title = "社員管理システム";
	public static void head(PrintWriter out){
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>"+ title +"</title>");
		out.println("</head>");
		out.println("<body>");
	}
	public static void footer(PrintWriter out){
		out.println("</body>");
		out.println("</html>");
	}
}
