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
				<h1>コンテンツ詳細登録</h1>
				<form name="check" action="${pageContext.request.contextPath}/InsertContentsdata" method="post" onsubmit="return check()" enctype="multipart/form-data">
					<div class="form-group">
						<label for="contentsdataId">コンテンツ詳細ID</label>
						<input type="text" class="form-control" id="contentsdataId" value="入力不可" placeholder="コンテンツID" readonly>
					</div>
					<div class="form-group">
						<label for="contentsdataName">コンテンツ詳細名（出場者名）</label>
						<input type="text" class="form-control" id="contentsName" name="name" placeholder="コンテンツ詳細名">
					</div>
					<div class="form-group">
						<label for="exampleInputBirthday">性別</label><br>
						<div class="radio-inline">
							<label><input type="radio" name="sex" id="optionsRadios1" value="男" checked> 男</label>
						</div>
						<div class="radio-inline">
							<label><input type="radio" name="sex" id="optionsRadios2" value="女"> 女</label>
						</div>
					</div>
					<div class="form-group">
						<label for="birthday">生年月日</label><br>
						<input type="date" class="form-control" name="birthday" value="1990-01-01">
					</div>
					<div class="form-group">
    					<label for="textarea">紹介文(500文字以内)</label>
    					<textarea class="form-control" id="textarea" name="introduction" rows="3"></textarea>
  					</div>
					<div class="form-group">
 					    <label for="contents">コンテンツ詳細画像 (画像サイズ：800px × 500px .jpegもしくは.jpgのみ)</label>
					    <input type="file" class="form-control-file" name="picture" id="contentsimage" accept=".jpg,.jpeg">
  					</div>
  					<button type="submit" class="btn btn-secondary">登録</button>
				</form>
			</div>
		</div>
	</div>

	<footer class="footer">
		<small>Copyright &copy; Sato Team, all rights reserved.</small>
	</footer>

	<script>
		function check(){
			flg = 0;
			if(document.form.contentsName.value == "" || document.form.birthday.value == "" || document.form.textarea.value == ""){
				alert('必須項目が入力されていません。');
				flg = 1;
			}
			if(flg = 1){
				return false;
			}else{
				return true;
			}
		}
	</script>

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