<!doctype html>
<%@page import="org.apache.tomcat.jni.Stdlib"%>
<%@page import="jp.co.sss.crud.db.EmployeeDAO"%>
<%@page import="jp.co.sss.crud.bean.Employee"%>
<%@page
	language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jp.co.sss.crud.util.HTMLStructure"%>
<%
	HTMLStructure stdHTML = new HTMLStructure();
	Employee emp = new Employee();
	emp = EmployeeDAO.selectWhereSQLForUpdate("employee", (String)session.getAttribute("update_emp_id"));
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
				<div class="col-lg-5">
					<h1>社員管理システム</h1>
				</div>
				<div class="col-lg-2 offset-lg-3 align-self-end">
					<a href="/html_crud_kimnamil/html/update/update_input.html">ようこそ、田中次郎さん</a>
				</div>
				<div class="col-lg-2 align-self-end">
					<a href="/html_crud_kimnamil/html/index.html">ログアウト</a>
				</div>
			</div>
			<div class="row row-eq-height row-main">
				<div class="col-lg-3 sidebar">
				<!-- search emp_name -->
					<div class="row sidebar-sub">
						<div class="col-lg-12">
							<form action="/html_crud_kimnamil/html/list/list_empty.html">
								<div class="form-group">
									<div class="row search-label">
										<label for="emp_name">社員名検索</label>
									</div>
									<div class="row">
										<div class="col-lg-8">
											<input type="text" class="form-control" id="emp_name">
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
							<form action="/html_crud_kimnamil/html/list/list_empty.html">
								<div class="form-group">
									<div class="row search-label">
										<label class="form-label" for="dept_name">部署名検索</label>
									</div>
									<div class="row">
										<div class="col-lg-8">
											<select class="form-control" id="dept_name">
												<option value="営業部">営業部</option>
												<option value="経理部" selected="selected">経理部</option>
												<option value="総務部">総務部</option>
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
				<div class="col-lg-9">
					<div class="section">
						<div class="row section-first">
							<p class="list-table-name">社員更新入力画面</p>
						</div>
						<form action="/html_crud_kimnamil/html/update/update_check.html">
							<div class="form-group">
								<div class="row form-group">
									<div class="col-lg-2 offset-lg-3">
										<label for="emp_pw" style="display:block;text-align:right;">パスワード：</label>
									</div>
									<div class="col-lg-4">
										<input type="password" class="form-control" id="emp_pw" value="<%=emp.getEmp_pass() %>"/>
									</div>
								</div>
								<div class="row form-group">
									<div class="col-lg-2 offset-lg-3">
										<label for="emp_name" style="display:block;text-align:right;">社員名：</label>
									</div>
									<div class="col-lg-4">
										<input type="text" class="form-control" id="emp_name" value="<%=emp.getEmp_name() %>">
									</div>
								</div>
								<div class="row form-group">
									<div class="col-lg-2 offset-lg-3">
										<label for="emp_name" style="display:block;text-align:right;">性別：</label>
									</div>
									<div class="col-lg-4">
										<div class="form-check-inline">
											<label class="form-check-label" for="sex1">
												<%if(Integer.parseInt(emp.getGender())==1){ %>
												<input type="radio" class="form-check-input" id="sex1" name="sex" value="1" checked="checked">男性
												<%}else { %>
												<input type="radio" class="form-check-input" id="sex1" name="sex" value="1">男性
												<%} %>
											</label>
										</div>
										<div class="form-check-inline">
											<label class="form-check-label" for="sex2">
												<%if(Integer.parseInt(emp.getGender())==1){ %>
												<input type="radio" class="form-check-input" id="sex2" name="sex" value="2">女性
												<%}else{ %>
												<input type="radio" class="form-check-input" id="sex2" name="sex" value="2" checked="checked">女性
												<%} %>
											</label>
										</div>
									</div>
								</div>
								<div class="row form-group">
									<div class="col-lg-2 offset-lg-3">
										<label for="emp_addr" style="display:block;text-align:right;">住所：</label>
									</div>
									<div class="col-lg-4">
										<input type="text" class="form-control" id="emp_addr" value="<%=emp.getAddress() %>"/>
									</div>
								</div>
								<div class="row form-group">
									<div class="col-lg-2 offset-lg-3">
										<label for="emp_birth" style="display:block;text-align:right;">誕生日：</label>
									</div>
									<div class="col-lg-4">
										<input type="text" class="form-control" id="emp_birth" value="<%=emp.getBirthday() %>"/>
									</div>
									<div class="col-lg-3">
										<p>(YYYY/MM/DD)</p>
									</div>
								</div>
								<div class="row form-group">
									<div class="col-lg-2 offset-lg-3">
										<label for="emp_admin" style="display:block;text-align:right;">権限：</label>
									</div>
									<div class="col-lg-4">
										<div class="form-check-inline">
											<label class="form-check-label" for="notAdmin">
												<%if(Integer.parseInt(emp.getAuthority())  == 1) {%>
												<input type="radio" class="form-check-input" id="notAdmin" name="isAdmin" value="1" checked="checked">一般
												<%}else{ %>
												<input type="radio" class="form-check-input" id="notAdmin" name="isAdmin" value="1">一般
												<%} %>
											</label>
										</div>
										<div class="form-check-inline">
											<label class="form-check-label" for="admin">
												<%if(Integer.parseInt(emp.getAuthority())  == 1) {%>
												<input type="radio" class="form-check-input" id="admin" name="isAdmin" value="2" >管理者
												<%}else{ %>
												<input type="radio" class="form-check-input" id="admin" name="isAdmin" value="2" checked="checked">管理者
												<%} %>
											</label>
										</div>
									</div>
								</div>
								<div class="row form-group">
									<div class="col-lg-2 offset-lg-3">
										<label for="dept_name" style="display:block;text-align:right;">部署名：</label>
									</div>
									<div class="col-lg-4">
										<select class="form-control" id="dept_name">
											<%if( Integer.parseInt(emp.getDept_id()) == 1 ){%>
											<option value="営業部" selected="selected">営業部</option>
											<option value="経理部">経理部</option>
											<option value="総務部">総務部</option>
											<%}else if(Integer.parseInt(emp.getDept_id()) == 2 ){%>
											<option value="営業部">営業部</option>
											<option value="経理部" selected="selected">経理部</option>
											<option value="総務部">総務部</option>
											<%}else {%>
											<option value="営業部">営業部</option>
											<option value="経理部">経理部</option>
											<option value="総務部"selected="selected">総務部</option>
											<%} %>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-3 offset-lg-5">
										<button type="submit" class="btn btn-info">更新</button>
									</div>
								</div>
								<div class="row" style="margin-top:5px;">
									<div class="col-lg-3 offset-lg-5">
										<a class="btn btn-info" href="/servlet_crud/list/list.jsp">戻る</a>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="row footer">
				<div class="col-lg-12">
					<p>Copyright(c) Nurinubi.inc All rights reserved</p>
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