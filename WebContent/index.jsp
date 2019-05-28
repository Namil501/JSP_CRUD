<!doctype html>
<%@page import="jp.co.sss.crud.util.HTMLStructure"%>
<html>
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrinkto-fit=no">
		<%
			HTMLStructure stdHTML = new HTMLStructure();
		%>
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<link rel="stylesheet" href="<%=stdHTML.rootPath %>css/layout.css?v=1.2">
		<link rel="stylesheet" href="<%=stdHTML.rootPath %>css/style.css?v=1.4">
		<title><%= stdHTML.title %></title>
	</head>
	<body>

		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12 header">
					<h1>社員管理システム</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-3">
					<div class="sidebar-sub">
						<p style="font-size:25px;">ログイン画面</p>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="login">
						<p>社員IDとパスワードを入力してください。</p>
						<form action="/html_crud_kimnamil/html/list/list.html">
							<div class="row">
								<div class="col-lg-12">
									<div class="form-group form-inline">
										<div class="col-lg-2">
											<label for="emp_id" style="display:block;text-align:right;">社員ID</label>
										</div>
										<div class="col-lg-10">
											<input type="text" class="form-control" id="emp_id"/>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12">
									<div class="form-group form-inline">
										<div class="col-lg-2">
											<label for="emp_pw" style="display:block;text-align:right;">パスワード</label>
										</div>
										<div class="col-lg-10">
											<input type="password" class="form-control" id="emp_pw"/>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-12">
									<div class="form-group form-inline">
										<div class="col-lg-6 offset-lg-2">
											<button type="submit" class="btn btn-primary">ログイン</button>
										</div>
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
	</body>
		<!-- Optional JavaScript -->
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

	</body>
</html>