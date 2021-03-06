<%@ page import="model.ContentsdataBean"%>
<%@page import="model.ContentsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	ContentsdataBean contentsdataBean = (ContentsdataBean)session.getAttribute("contentsdataBean");
	int check = (int)session.getAttribute("voteCheck");
	
	//コンテスト取得
	ArrayList<ContentsBean> activeContents = new ArrayList<ContentsBean>();
	activeContents = (ArrayList<ContentsBean>)session.getAttribute("activeContents");
	
	ArrayList<ContentsBean> noactiveContents = new ArrayList<ContentsBean>();
	noactiveContents = (ArrayList<ContentsBean>)session.getAttribute("noactiveContents");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <title>投票システム - コンテンツ詳細</title>
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
                    <a class="nav-link" href="LoginServlet">ログアウト</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <img class="img-fluid image" src="img/contents_test.jpeg" width="100%" alt="コンテンツ一覧">
        <div class="row">
            <!-- 固定サイドメニュー -->
            <div class="col-12 col-md-3 col-xl-3 bd-sidebar">
                <div class="list-group">
					<a href="#" class="list-group-item list-group-item-action list-group-item-warning">開催前・開催中</a>
					<% if(activeContents != null){ %>
						<% for(int i = 0; i < activeContents.size(); i++){ %>
							<a href="#" class="list-group-item list-group-item-action"><%= activeContents.get(i).getContentsName() %></a>
						<% }
					   } else { %>
						<a href="#" class="list-group-item list-group-item-action">開催中のコンテストはありません</a>
					<% } %>
					<a href="#" class="list-group-item list-group-item-action list-group-item-secondary">終了</a>
					<% if(noactiveContents != null){
						for(int i = 0; i < noactiveContents.size(); i++){ %>
							<a href="#" class="list-group-item list-group-item-action"><%= noactiveContents.get(i).getContentsName() %></a>
						<% }
					   } else { %>
						<a href="#" class="list-group-item list-group-item-action">終了したコンテストはありません</a>
					<% } %>
				</div>
            </div>

            <!-- コンテンツ一覧 -->
            <main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content">
                <h1>出場者のプロフィール</h1>
                <img class="img-fluid" src="${pageContext.request.contextPath}/GetContentsdataPicture?id=<%= contentsdataBean.getContentsID() %>&id2=<%= contentsdataBean.getContentsdataID() %>" height="500px" width="800px" alt="<%= contentsdataBean.getContentsdataName() %>">
                <!-- <img src="img/nezumi.jpeg" class="img-fluid" alt="プロフィール画像" width="800px" height="500px"> -->

                <table class="table">
                    <tr>
                        <th>名前</th>
                        <td><%= contentsdataBean.getContentsdataName() %></td>
                    </tr>
                    <tr>
                        <th>性別</th>
                        <td><%= contentsdataBean.getSex() %></td>
                    </tr>
                    <tr>
                        <th>生年月日</th>
                        <td><%= contentsdataBean.getBirthday() %></td>
                    </tr>
                    <tr>
                        <th>概要</th>
                        <td><%= contentsdataBean.getIntroduction() %></td>
                    </tr>
                </table>
                <button onclick="history.back()" class="btn btn-secondary">戻る</button>
                <% if(check == 0){ %>
                <form action="AddVote" method="post">
                	<button type="submit" class="btn btn-info" onclick="return confirm('<%= contentsdataBean.getContentsdataName() %>に投票してもいいですか？')">投票する</button>
            	</form>
            	<% }else{ %>
            		<button type="button" class="btn btn-lg btn-info" disabled>投票済み</button>
            	<% } %>
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
