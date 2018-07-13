<%@page import="model.ContentsdataBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<ContentsdataBean> contentsdata = (ArrayList<ContentsdataBean>)session.getAttribute("arraycontentsdata");
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
<body id="manager">
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
				<h1>コンテンツ詳細一覧</h1>
				<div class="row textcenter">
					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
						<a href="manager_contentsDataAdd.jsp">
							<div class="alert alert-info" role="alert">
								コンテンツ詳細追加
							</div>
						</a>
					</div>
				</div>
				<div class="table-responsive">
					<table class="table">
	                   	<tr>
							<th></th>
	                      	<th>コンテンツ詳細ID</th>
	                       	<th>コンテンツ詳細名</th>
	                       	<th>性別</th>
	                       	<th>生年月日</th>
	                       	<th>概要</th>
	                       	<th>画像</th>
	                       	<th></th>
	                       	<th></th>
	                   	</tr>
	                   	<% for(int i = 0; i < contentsdata.size(); i++){ %>
	                   	<tr>
	                   		<td><%= (i + 1) %></td>
	                   		<td><%= contentsdata.get(i).getContentsdataID() %></td>
	                   		<td><%= contentsdata.get(i).getContentsdataName() %></td>
	                   		<td><%= contentsdata.get(i).getSex() %></td>
	                   		<td><%= contentsdata.get(i).getBirthday() %></td>
	                   		<td>
		                       	<div class="dropdown">
									<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">概要</button>
									<div class="dropdown-menu p-4 text-muted"
										style="max-width: 200px;">
										<p><%= contentsdata.get(i).getIntroduction() %></p>
									</div>
								</div>
							</td>
	                   		<td><img class="img-responsive" src="${pageContext.request.contextPath}/GetContentsdataPicture?id=<%= contentsdata.get(i).getContentsID() %>&id2=<%= contentsdata.get(i).getContentsdataID() %>" height="65" width="100" alt="<%= contentsdata.get(i).getContentsdataName() %>"></td>
	                   		<td><button type="button" class="btn btn-warning" onclick="location.href='GetContentsdata?c_id=<%= contentsdata.get(i).getContentsID() %>&d_id=<%= contentsdata.get(i).getContentsdataID() %>&flg='change''">変更</button></td>
	                       	<td><button type="button" class="btn btn-danger" onclick="location.href='GetContentsdata?c_id=<%= contentsdata.get(i).getContentsID() %>&d_id=<%= contentsdata.get(i).getContentsdataID() %>&flg='delete''">削除</button></td>
	                   	</tr>
	                   	<% } %>
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