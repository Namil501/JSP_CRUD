<!doctype html>
<%@page import="jp.co.sss.crud.bean.Employee"%>
<%@page import="jp.co.sss.crud.db.EmployeeDAO"%>
<%@page
	language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jp.co.sss.crud.util.HTMLStructure"%>
<%
	HTMLStructure stdHTML = new HTMLStructure();
	Employee emp = new Employee();
	emp = EmployeeDAO.selectWhereSQLForUpdate("employee", (String)session.getAttribute("delete_emp_id"));

	String emp_name = emp.getEmp_name();
	String emp_addr = emp.getAddress();
	String authority = Integer.parseInt(emp.getAuthority()) == 1 ? "一般":"管理者";
	String emp_birth = emp.getBirthday();
	String dept_id = emp.getDept_id();
	dept_id = EmployeeDAO.searchDept(dept_id, true);
	String gender = Integer.parseInt(emp.getGender()) ==1?"男性":"女性";
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
		<title>社員管理システム</title>
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
							<p class="list-table-name">社員削除確認画面</p>
						</div>
						<div class="row">
							<div class="col-lg-2 offset-lg-3">
								<p style="display:block;text-align:right;">パスワード：</p>
							</div>
								<p>※非表示</p>
							<div class="col-lg-4">
							</div>
						</div>
						<div class="row">
							<div class="col-lg-2 offset-lg-3">
								<p style="display:block;text-align:right;">社員名：</p>
							</div>
							<div class="col-lg-4">
								<p><%=emp_name %></p>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-2 offset-lg-3">
								<label for="emp_name" style="display:block;text-align:right;">性別：</label>
							</div>
							<div class="col-lg-4">
								<p><%=gender%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-2 offset-lg-3">
								<label for="emp_addr" style="display:block;text-align:right;">住所：</label>
							</div>
							<div class="col-lg-4">
								<p><%=emp_addr%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-2 offset-lg-3">
								<p style="display:block;text-align:right;">生年月日：</p>
							</div>
							<div class="col-lg-4">
								<p><%=emp_birth%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-2 offset-lg-3">
								<label for="emp_admin" style="display:block;text-align:right;">権限：</label>
							</div>
							<div class="col-lg-4">
								<p><%=authority%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-2 offset-lg-3">
								<label for="dept_name" style="display:block;text-align:right;">部署名：</label>
							</div>
							<div class="col-lg-4">
								<p><%=dept_id%></p>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-3 offset-lg-5">
								<a class="btn btn-info" href="<%=stdHTML.rootPath%>delete/delete_complete">削除</a>
							</div>
						</div>
						<div class="row" style="margin-top:5px;">
							<div class="col-lg-3 offset-lg-5">
								<a class="btn btn-info" href="<%=stdHTML.rootPath%>list/list.jsp">戻る</a>
							</div>
						</div>
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