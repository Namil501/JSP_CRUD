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
				<div class="col-lg-3 sidebar">
				<!-- search emp_name -->
					<div class="row sidebar-sub">
						<div class="col-lg-12">
							<form action="<%=stdHTML.rootPath%>search_name">
								<div class="form-group">
									<div class="row search-label">
										<label for="search_emp_name">社員名検索</label>
									</div>
									<div class="row">
										<div class="col-lg-8">
											<input type="text" class="form-control" id="search_emp_name" name="search_emp_name">
										</div>
										<div class="col-lg-4">
											<button type="submit" class="btn btn-info">検索</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div class="row sidebar-sub">
						<div class="col-lg-12">
							<form action="<%=stdHTML.rootPath%>search_dept">
								<div class="form-group">
									<div class="row search-label">
										<label for="dept_name">部署名検索</label>
									</div>
									<div class="row">
										<div class="col-lg-8">
											<select class="form-control" id="dept_id" name="dept_id">
												<option value="1">営業部</option>
												<option value="2">経理部</option>
												<option value="3">総務部</option>
											</select>
										</div>
										<div class="col-lg-4">
											<button type="submit" class="btn btn-info">検索</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

	</body>
</html>