<!doctype html>
<%@page import="jp.co.sss.crud.db.EmployeeDAO"%>
<%@page import="java.util.List"%>
<%@page import="jp.co.sss.crud.bean.Employee"%>
<%@page
	language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jp.co.sss.crud.util.HTMLStructure"%>
<%
	HTMLStructure stdHTML = new HTMLStructure();
%>
<html lang="jp">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrinkto-fit=no">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="<%=stdHTML.rootPath %>css/layout.css?v=1.2">
		<link rel="stylesheet" href="<%=stdHTML.rootPath %>css/style.css?v=1.4">
		<title><%= stdHTML.title %></title>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row header">
				<jsp:include page="/jsp_layout/header.jsp" />
			</div>
			<div class="row row-eq-height row-main">
				<jsp:include page="/jsp_layout/sidebar.jsp" />
				<div class="col-lg-9">
					<div class="section">
						<div class="row section-first">
							<p class="list-table-name">社員一覧画面</p>
						</div>
						<div class="row">
							<div class="col-lg-3 offset-lg-9">
								<a href="<%= stdHTML.rootPath %>regist/regist_input.jsp">新規社員登録</a>
							</div>
						</div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>社員ID</th>
									<th>社員名</th>
									<th>性別</th>
									<th>住所</th>
									<th>生年月日</th>
									<th>権限</th>
									<th>部署名</th>
									<th>変更</th>
									<th>削除</th>
								</tr>
							</thead>
							<tbody>
								<%
									int list_con = (int)session.getAttribute("list_condition");
									List<Employee> empAll;
									switch(list_con){
									case 1:
										String search_name = (String)session.getAttribute("search_name");
										empAll = EmployeeDAO.selectAllSQL("employee", "emp_name", search_name, true);
										break;
									case 2:
										String dept_id = (String)session.getAttribute("search_dept");
										empAll = EmployeeDAO.selectAllSQL("employee", "dept_id", dept_id, false);
										break;
									default:
										empAll = EmployeeDAO.selectAllSQL("employee", null, null, false);
										break;
									}
									session.setAttribute("list_condition", 0);
									for(Employee emp : empAll){
								%>
								<tr>
									<td><%=emp.getEmp_id() %></td>
									<td><%=emp.getEmp_name() %></td>
									<td><%=emp.getGender() %></td>
									<td><%=emp.getAddress() %></td>
									<td><%=emp.getBirthday() %></td>
									<td><%=emp.getAuthority() %></td>
									<td><%=emp.getDept_id() %></td>
									<td>
										<form action = "<%=stdHTML.rootPath %>update/update" >
											<input type = "hidden" name = "emp_id" value="<%=emp.getEmp_id() %>">
											<input class="btn btn-info" type = "submit" value="変更">
										</form>
									</td>
									<td>
										<form action = "<%=stdHTML.rootPath %>delete/delete">
											<input type = "hidden" name = "emp_id" value = "<%=emp.getEmp_id() %>">
											<input class="btn btn-danger" type = "submit" value = "削除">
										</form>
									</td>
								</tr>
								<% }%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row footer">
				<jsp:include page="/jsp_layout/footer.jsp" />
			</div>
		</div>
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

	</body>
</html>