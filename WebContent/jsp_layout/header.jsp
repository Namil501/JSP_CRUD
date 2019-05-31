<%@page
	language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jp.co.sss.crud.util.HTMLStructure"%>
<%
	HTMLStructure stdHTML = new HTMLStructure();
%>
			<div class="row header">
				<div class="col-lg-5">
					<h1>社員管理システム</h1>
				</div>
				<div class="col-lg-2 offset-lg-3 align-self-end">
					<a href="<%=stdHTML.rootPath%>update/update_input.jsp">ようこそ、田中次郎さん</a>
				</div>
				<div class="col-lg-2 align-self-end">
					<a href="<%=stdHTML.rootPath%>index.jsp">ログアウト</a>
				</div>
			</div>