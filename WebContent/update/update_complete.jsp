<!doctype html>
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
							<p class="list-table-name">社員更新完了画面</p>
						</div>
						<div class="row">
							<div class="col-lg-4 offset-lg-4" style="text-align:center;">
								<p>社員登録処理が完了しました。</p>
								<a href="<%=stdHTML.rootPath%>list/list">一覧表示に戻る</a>
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