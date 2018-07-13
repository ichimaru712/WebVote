<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<title>投票システム - 管理者</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="manager.jsp">投票システム</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="manager.jsp">管理者<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="logout.jsp">ログアウト</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="row textcenter">
					<div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12">
						<a href="manager.jsp">
							<div class="alert alert-success" role="alert">
								コンテンツ確認
							</div>
						</a>
					</div>
					<div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12">
						<a href="manager_contentsAdd.jsp">
							<div class="alert alert-primary" role="alert">
								コンテンツ登録
							</div>
						</a>
					</div>
					<div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12">
						<a href="manager_UserManager.jsp">
							<div class="alert alert-warning" role="alert">
								ユーザ管理
							</div>
						</a>
					</div>
				</div>
				<h1>ユーザ管理</h1>
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">ユーザID</th>
								<th scope="col">ユーザ名</th>
								<th scope="col">性別</th>
								<th scope="col">生年月日</th>
								<th scope="col">登録日</th>
								<th scope="col"></th>
								<th scope="col"></th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>ichimaru</td>
								<td>いちまる</td>
								<td>男</td>
								<td>YYYY:MM:DD</td>
								<td>YYYY:MM:DD hh:mm:ss</td>
								<td><button type="button" class="btn btn-warning" onclick="location.href='manager_UserChange.jsp'">情報変更</button></td>
								<td><button type="button" class="btn btn-warning" onclick="location.href='manager_UserPassChange.jsp'">パス変更</button></td>
								<td><button type="button" class="btn btn-danger" onclick="return confirm('削除してもいいですか？')">削除</button></td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>ichimaru</td>
								<td>いちまる</td>
								<td>男</td>
								<td>YYYY:MM:DD</td>
								<td>YYYY:MM:DD hh:mm:ss</td>
								<td><button type="button" class="btn btn-warning" onclick="location.href='manager_UserChange.jsp'">情報変更</button></td>
								<td><button type="button" class="btn btn-warning" onclick="location.href='manager_UserPassChange.jsp'">パス変更</button></td>
								<td><button type="button" class="btn btn-danger" onclick="return confirm('削除してもいいですか？')">削除</button></td>
							</tr>
							<tr>
								<th scope="row">3</th>
								<td>ichimaru</td>
								<td>いちまる</td>
								<td>男</td>
								<td>YYYY:MM:DD</td>
								<td>YYYY:MM:DD hh:mm:ss</td>
								<td><button type="button" class="btn btn-warning" onclick="location.href='manager_UserChange.jsp'">情報変更</button></td>
								<td><button type="button" class="btn btn-warning" onclick="location.href='manager_UserPassChange.jsp'">パス変更</button></td>
								<td><button type="button" class="btn btn-danger" onclick="return confirm('削除してもいいですか？')">削除</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<footer class="footer">
		<small>Copyright &copy; Sato Team, all rights reserved.</small>
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</body>
</html>