<%@page import="model.MypageVotehistoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MypageVotehistoryBean> votearray = (ArrayList<MypageVotehistoryBean>)session.getAttribute("votearray");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <title>投票システ</title>
</head>
<body id="contents">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="contents.html">投票システム</a>
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
        <img class="img-fluid" src="img/contents_test.jpeg" width="100%" alt="コンテンツ一覧">
        <div class="row">
            <!-- 固定サイドメニュー -->
            <div class="col-12 col-md-3 col-xl-4 bd-sidebar">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link disabled">開催中</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">　いちまるコンテスト</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">　いちまる</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">　いちまる</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled">終了</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">　いちまる</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">　いちまる</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">　いちまる</a>
                    </li>
                </ul>
            </div>

            <!-- コンテンツ一覧 -->
            <main class="col-12 col-md-9 col-xl-8 py-md-3 pl-md-5 bd-content">
				<h1>投票履歴</h1>
	            <table class="table table-bordered">
	              <tr>
	              	<th></th>
	                <th class="bg-light">コンテスト名</th>
	                <th class="bg-light">投票内容</th>
	                <th class="bg-light">日付</th>
	              </tr>
	              <% if(votearray != null){ %>
		              <% for(int i = 0; i < votearray.size(); i++){ %>
		              <tr>
		              	<td><%= i + 1 %></td>
		                <td><%= votearray.get(i).getContentsname() %></td>
		                <td><%= votearray.get(i).getContentsdatename() %></td>
		                <td><%= votearray.get(i).getVotedate() %></td>
		              </tr>
					  <% } %>
				  <% } %>
	            </table>
	            <button class="back" onclick="history.back()">戻る</button>
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
