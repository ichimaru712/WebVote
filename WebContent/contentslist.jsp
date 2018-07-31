<%@page import="model.ContentsdataBean"%>
<%@page import="model.ContentsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//コンテスト取得
	ContentsBean contents = (ContentsBean)session.getAttribute("contentsBean");

	//コンテンツ詳細取得
	ArrayList<ContentsdataBean> contentsdata = new ArrayList<ContentsdataBean>();
	contentsdata = (ArrayList<ContentsdataBean>)session.getAttribute("contentsdata");
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
                <div class="row">
                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                    <% if(true){ %>
                    	<div class="alert alert-warning textcenter" role="alert">開催中</div>
                    <% } else { %>
                    	<div class="alert alert-dark textcenter" role="alert">終了</div>
                    <% } %>
                        <img class="img-responsive" src="<c:url value="/GetContentsPicture">
						<c:param name ="id"><%= contents.getContentsID() %></c:param>
						</c:url>" width="100%" alt="コンテンツ画像">
                        <h2><%= contents.getContentsName() %></h2>
                        <table class="table">
                            <tr>
                                <th>開催期間</th>
                                <td><%= contents.getStartDate() %>〜<%= contents.getEndDate() %></td>
                            </tr>
                            <tr>
                                <th>出場者数</th>
                                <td><%= contentsdata.size() %></td>
                            </tr>
                        </table>
						<a href="${pageContext.request.contextPath}/VoteStatus?id=<%= contents.getContentsID() %>">
							<div class="alert alert-info textcenter" role="alert">
								投票状況
							</div>
						</a>
					</div>
                </div>
                <h3>出場者一覧</h3>
                <div class="row">
                	<% for(int i = 0; i < contentsdata.size(); i++){ %>
                	<div class="col-xl-4 col-lg-4 col-md-6 col-sm-12 col-12">
                        <section>
                        	<form action="GetContentsData" method="post">
                        		<input type="hidden" name="id" value=<%= contentsdata.get(i).getContentsdataID() %>>
	                            <div class="card" style="width: 14.5rem;">
	                                <img class="card-img-top" src="img/nezumi.jpeg" alt="test" width="200" height="200">
	                                <div class="card-body">
	                                    <h5 class="card-title"><%= contentsdata.get(i).getContentsdataName() %></h5>
	                                    <button type="submit" class="btn btn-secondary">もっと見る</button>
	                                </div>
	                            </div>
                            </form>
                        </section>
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
