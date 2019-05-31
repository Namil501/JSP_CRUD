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
	String emp_name = (String)session.getAttribute("emp_name");
	String emp_addr = (String)session.getAttribute("emp_addr");
	String authority = (String)session.getAttribute("authority");
	String emp_birth = (String)session.getAttribute("emp_birth");
	String dept_id = (String)session.getAttribute("dept_id");
	String gender = (String)session.getAttribute("gender");
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
							<p class="list-table-name">社員更新入力画面</p>
						</div>
						<form action="update_input" method="post">
							<div class="form-group">
								<div class="row form-group">
									<div class="col-lg-2 offset-lg-3">
										<label for="emp_pw" style="display:block;text-align:right;">パスワード：</label>
									</div>
									<div class="col-lg-4">
										<input type="password" class="form-control" id="emp_pw" name="emp_pw" value="<%=(String)session.getAttribute("emp_pass")%>"/>
									</div>
								</div>
								<div class="row form-group">
									<div class="col-lg-2 offset-lg-3">
										<label for="emp_name" style="display:block;text-align:right;">社員名：</label>
									</div>
									<div class="col-lg-4">
										<input type="text" class="form-control" id="emp_name" name="emp_name" value="<%=emp_name%>">
									</div>
								</div>
								<div class="row form-group">
									<div class="col-lg-2 offset-lg-3">
										<label for="emp_name" style="display:block;text-align:right;">性別：</label>
									</div>
									<div class="col-lg-4">
										<div class="form-check-inline">
											<label class="form-check-label" for="sex1">
												<%if(Integer.parseInt(gender)==1){ %>
												<input type="radio" class="form-check-input" id="sex1" name="gender" value="1" checked="checked">男性
												<%}else { %>
												<input type="radio" class="form-check-input" id="sex1" name="gender" value="1">男性
												<%} %>
											</label>
										</div>
										<div class="form-check-inline">
											<label class="form-check-label" for="sex2">
												<%if(Integer.parseInt(gender)==1){ %>
												<input type="radio" class="form-check-input" id="sex2" name="gender" value="2">女性
												<%}else{ %>
												<input type="radio" class="form-check-input" id="sex2" name="gender" value="2" checked="checked">女性
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
										<input type="text" class="form-control" id="emp_addr" name="emp_addr" value="<%=emp_addr%>"/>
									</div>
								</div>
								<div class="row form-group">
									<div class="col-lg-2 offset-lg-3">
										<label for="emp_birth" style="display:block;text-align:right;">誕生日：</label>
									</div>
									<div class="col-lg-4">
										<input type="text" class="form-control" id="emp_birth" name="emp_birth" value="<%=emp_birth%>"/>
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
												<%if(Integer.parseInt(authority)== 1) {%>
												<input type="radio" class="form-check-input" id="notAdmin" name="authority" value="1" checked="checked">一般
												<%}else{ %>
												<input type="radio" class="form-check-input" id="notAdmin" name="authority" value="1">一般
												<%} %>
											</label>
										</div>
										<div class="form-check-inline">
											<label class="form-check-label" for="admin">
												<%if(Integer.parseInt(authority)== 1) {%>
												<input type="radio" class="form-check-input" id="admin" name="authority" value="2" >管理者
												<%}else{ %>
												<input type="radio" class="form-check-input" id="admin" name="authority" value="2" checked="checked">管理者
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
										<select class="form-control" id="dept_id" name="dept_id">
											<%if( Integer.parseInt(dept_id) == 1 ){%>
											<option value="1" selected="selected">営業部</option>
											<option value="2">経理部</option>
											<option value="3">総務部</option>
											<%}else if(Integer.parseInt(dept_id) == 2 ){%>
											<option value="1">営業部</option>
											<option value="2" selected="selected">経理部</option>
											<option value="3">総務部</option>
											<%}else {%>
											<option value="1">営業部</option>
											<option value="2">経理部</option>
											<option value="3"selected="selected">総務部</option>
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
										<a class="btn btn-info" href="<%=stdHTML.rootPath%>list/list">戻る</a>
									</div>
								</div>
							</div>
						</form>
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