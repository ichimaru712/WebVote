<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.ContentsdataBean"%>
<%
	ContentsdataBean contentsdataBean = (ContentsdataBean)session.getAttribute("contentsdataBean");	
%>
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
<title>投票システム - 投票完了</title>
</head>
<body id="mypage">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="contents.jsp">投票システム</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="contents.jsp">コンテスト一覧</a></li>
				<li class="nav-item active"><a class="nav-link" href="mypage.jsp">マイページ<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="LoginServlet">ログアウト</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="image"><img class="img-fluid" src="img/contents_test.jpeg" width="100%" alt="コンテンツ一覧"></div>
		<div class="row">
			<!-- 固定サイドメニュー -->
			<div class="col-12 col-md-3 col-xl-3 bd-sidebar">
				<div class="list-group">
					<a href="#" class="list-group-item list-group-item-action list-group-item-warning">開催中</a>
					<a href="#" class="list-group-item list-group-item-action">いちまるコンテスト</a>
					<a href="#" class="list-group-item list-group-item-action">いちまるコンテスト</a>
					<a href="#" class="list-group-item list-group-item-action list-group-item-secondary">終了</a>
					<a href="#" class="list-group-item list-group-item-action">いちまるコンテスト</a>
					<a href="#" class="list-group-item list-group-item-action">いちまるコンテスト</a>
				</div>
			</div>

			<!-- コンテンツ -->
			<main class="col-12 col-md-9 col-xl-9 bd-content">
				<div class="row">
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
						<h1>投票完了</h1>
						<div class="textcenter">
							<img class="image" src="${pageContext.request.contextPath}/GetContentsdataPicture?id=<%= contentsdataBean.getContentsID() %>&id2=<%= contentsdataBean.getContentsdataID() %>" alt="<%= contentsdataBean.getContentsdataName() %>">
							<!-- <img class="image" src="img/nezumi.jpeg" alt="コンテンツ画像" height="500px" width="800px"> -->
							<p class="h2">投票しました</p>
							<a href="contents.jsp" class="btn btn-secondary">一覧へ戻る</a>
						</div>
					</div>
				</div>
			</main>
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