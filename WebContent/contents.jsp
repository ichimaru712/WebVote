<%@page import="model.ContentsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//コンテスト取得
	ArrayList<ContentsBean> contents = new ArrayList<ContentsBean>();
	contents = (ArrayList<ContentsBean>)session.getAttribute("contents");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <title>投票システム - コンテンツ一覧</title>
</head>
<body id="contents">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="contents.jsp">投票システム</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="contents.jsp">コンテスト一覧<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="mypage.jsp">マイページ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout.jsp">ログアウト</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
    	<p><%= contents.get(0).getContentsID() %></p>
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

            <!-- コンテンツ一覧 -->
            <main class="col-12 col-md-9 col-xl-9 bd-content">
            	<h1>開催中のコンテスト</h1>
                <div class="row">
                <% for(int i = 0; i < contents.size(); i++){ %>
                	<div class="col-12">
                		<article>
                			<form action="GetContents" method="post">
                				<input type="hidden" name="id" value=<%= contents.get(i).getContentsID() %>>
                				<img src="img/no_image.png" class="img-fluid" alt="test" width="100%" height="200">
                				<div class="sample-box-3">
                                    <p class="textcenter">開催期間: <%= contents.get(i).getStartDate() %> 〜 <%= contents.get(i).getEndDate() %></p>
                                    <p class="textcenter title"><%= contents.get(i).getContentsName() %></p>
                                    <button type="submit" class="btn btn-secondary">詳しく見る</button>
                                </div>
                			</form>
                		</article>
                	</div>
               	<% } %>
                </div>
            </main>
        </div>
    </div>

    <footer class="footer">
        <small>Copyright &copy; Sato Team, all rights reserved.</small>
    </footer>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>
