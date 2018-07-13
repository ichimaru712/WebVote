<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="model.UserBean" import ="model.PasswordBean"%>
<!-- 新規登録確認画面 -->
<%
UserBean user = (UserBean)session.getAttribute("newuser");
PasswordBean password = (PasswordBean)session.getAttribute("userpass");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>投票システム - 新規登録</title>
    </head>
    <body id="newusercheck">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="login.jsp">投票システム</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp">ログイン</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="newuser.jsp">新規登録<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container">
            <h1 class="textcenter">新規登録情報確認</h1>
            <form class="form-horizontal" action="NewUser" name="newusercheckform" method="get">
                <div class="form-group row">
    				<label for="userid" class="col-sm-3 col-form-label">ユーザID</label>
   					<div class="col-sm-9">
     					<input type="text" readonly class="form-control-plaintext" id="userid" value="<%= user.getUserID()%>">
  					</div>
				</div>
                <div class="form-group row">
    				<label for="password" class="col-sm-3 col-form-label">パスワード</label>
   					<div class="col-sm-9">
     					<input type="text" readonly class="form-control-plaintext" id="password" value="*************">
  					</div>
				</div>
                <div class="form-group row">
    				<label for="birthday" class="col-sm-3 col-form-label">生年月日</label>
   					<div class="col-sm-9">
     					<input type="text" readonly class="form-control-plaintext" id="birthday" value=<%=user.getBirthday() %>>>
  					</div>
				</div>
                <div class="form-group row">
    				<label for="sex" class="col-sm-3 col-form-label">性別</label>
   					<div class="col-sm-9">
     					<input type="text" readonly class="form-control-plaintext" id="sex" value="男">
  					</div>
				</div>
                <button class="btn btn-secondary" onclick="history.back()">戻る</button>
                <button type="submit" class="btn btn-secondary">登録</button>
            </form>
        </div>

        <footer class="footer">
            <small>Copyright &copy; Sato Team, all rights reserved.</small>
        </footer>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </body>
</html>

