<%@page import="model.ContentsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ContentsBean updatecontents = (ContentsBean)session.getAttribute("updatecontents");
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
				<li class="nav-item"><a class="nav-link" href="LoginServlet">ログアウト</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="row textcenter">
					<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
						<a href="manager.jsp">
							<div class="alert alert-success" role="alert">
								コンテンツ確認
							</div>
						</a>
					</div>
					<div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12">
						<a href="manager_contentsAdd.jsp">
							<div class="alert alert-primary" role="alert">
								コンテンツ登録
							</div>
						</a>
					</div>
					<!-- <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12">
						<a href="manager_UserManager.jsp">
							<div class="alert alert-warning" role="alert">
								ユーザ管理
							</div>
						</a>
					</div> -->
				</div>
				<h1>コンテンツ確認</h1>
				<form name="form" action="UpdateContents" method="post" onsubmit="return check()" enctype="multipart/form-data">
					<div class="form-group">
						<label for="contentsId">コンテンツID</label>
						<input type="text" class="form-control" id="contentsId" name="contentsId" value="<%= updatecontents.getContentsID() %>" placeholder="コンテンツID" readonly>
					</div>
					<div class="form-group">
						<label for="contentsName">コンテンツ名（コンテスト名）</label>
						<input type="text" class="form-control" value="<%= updatecontents.getContentsName() %>" id="contentsName" name="contentsName" placeholder="コンテンツ名">
					</div>
					<div class="form-group">
						<label for="start">投票開始日</label><br>
						<input type="datetime-local" class="form-control" value="<%= updatecontents.getStartDate() %>" name="start" id="start">
					</div>
					<div class="form-group">
						<label for="end">投票終了日</label><br>
						<input type="datetime-local" class="form-control" value="<%= updatecontents.getEndDate() %>" name="end" id="end">
					</div>
					<div class="form-group">
 					    <label for="contents">コンテンツ画像</label>
					    <input type="file" name="picture" class="form-control-file" id="contentsimage">
  					</div>
  					<button type="submit" class="btn btn-secondary">登録</button>
				</form>
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
		<script>
        var now = new Date();
        var y = now.getFullYear();
        var m = now.getMonth() + 1;
        var startDate =now;
        var date;
        var sDate;
        if(m<10){
            m = '0'+m;
        }
        var d = now.getDate();
        if(d<10){
            d = '0'+d;
        }
        var today = y+'-'+m+'-'+d;
        $('#start').on('focus', function(e) {
            date = new Date($(this).val());
        }); 
        $('#start').on('change', function(e) {
            startDate = new Date($(this).val());
            if(startDate<=now){
                alert("今日以降の日付を入力してください");
                $(this).val(today);
            }
        $('#end').val($(this).val());
        }); 
        
        
         $('#end').on('focus', function(e) {
            sDate =$(this).val();
            date = new Date($(this).val());
        }); 
        $('#end').on('change', function(e) {
            endDate = new Date($(this).val());
            if(endDate<date){
                alert("開始日以降の日付を入力してください");
                $(this).val(today);
            }
        $('#end').val(sDate);
        }); 
	</script>
</body>
</html>