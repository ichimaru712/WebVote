<%@page import="java.awt.image.BufferedImage"%>
<%@page import="model.ContentsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ContentsBean contentsBean = (ContentsBean)session.getAttribute("insertcontents");
	BufferedImage bi = (BufferedImage)session.getAttribute("insertcontentspicture");
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
				<li class="nav-item"><a class="nav-link" href="LoginServlet">ログアウト</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="image"><img class="img-fluid" src="img/contents_test.jpeg" width="100%" alt="コンテンツ画像"></div>
		<div class="row">
            <!-- 固定サイドメニュー -->
            <div class="col-12 col-md-3 col-xl-3 bd-sidebar">
                <div class="list-group">
					<a href="#" class="list-group-item list-group-item-action list-group-item-warning">開催中</a>
					<a href="#" class="list-group-item list-group-item-action">プレビュー</a>
					<a href="#" class="list-group-item list-group-item-action">プレビュー</a>
					<a href="#" class="list-group-item list-group-item-action list-group-item-secondary">終了</a>
					<a href="#" class="list-group-item list-group-item-action">プレビュー</a>
					<a href="#" class="list-group-item list-group-item-action">プレビュー</a>
				</div>
            </div>

			<main class="col-12 col-md-9 col-xl-9 bd-content">
				<div class="row">
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
		                <div class="alert alert-warning textcenter" role="alert">開催中</div>
		                <div class="image">
		                	<img src="${pageContext.request.contextPath}/InsertContentsPicture" alt="プレビュー画像" width="100%">
		                </div>
		                <h2><%= contentsBean.getContentsName() %></h2>
		                <table class="table">
		                    <tr>
		                        <th>開催期間</th>
		                        <td><%= contentsBean.getStartDate() %>〜<%= contentsBean.getEndDate() %></td>
		                    </tr>
		                    <tr>
		                        <th>出場者数</th>
		                        <td>0人</td>
		                    </tr>
		                </table>
						<div class="alert alert-info textcenter" role="alert">
							投票状況
						</div>
					</div>
					<h3>出場者一覧</h3>
		            <div class="row">
		                <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12">
		                    <section>
		                        <div class="card" style="width: 14.5rem;">
		                            <img class="card-img-top" src="img/no_image.png" alt="麻生太郎" width="200" height="200">
		                            <div class="card-body">
		                                <h5 class="card-title">麻生太郎</h5>
		                                <a href="#" class="btn btn-secondary">もっと見る</a>
		                            </div>
		                        </div>
		                    </section>
		                </div>
		                <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12">
		                    <section>
		                        <div class="card" style="width: 14.5rem;">
		                            <img class="card-img-top" src="img/marusan.jpg" alt="麻生二郎" width="200" height="200">
		                            <div class="card-body">
		                                <h5 class="card-title">麻生二郎</h5>
		                                <a href="#" class="btn btn-secondary">もっと見る</a>
		                            </div>
		                        </div>
		                    </section>
		                </div>
		                <div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12">
		                    <section>
		                        <div class="card" style="width: 14.5rem;">
		                            <img class="card-img-top" src="img/marusan.jpg" alt="麻生三郎" width="200" height="200">
		                            <div class="card-body">
		                                <h5 class="card-title">麻生三郎</h5>
		                                <a href="#" class="btn btn-secondary">もっと見る</a>
		                            </div>
		                        </div>
		                    </section>
		                </div>
		            </div>
				</div>
				<button type="button" class="btn btn-secondary">戻る</button>
				<form action="InsertContents" method="get">
                	<button type="button" class="btn btn-primary">登録</button>
                </form>
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