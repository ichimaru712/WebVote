<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ログイン画面 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">

    <title>投票システム</title>
</head>
<body id="login">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="login.jsp">投票システム</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="login.jsp">ログイン<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="newuser.jsp">新規登録</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <div class="textcenter">
            <img class="img-responsive" src="img/marusan.jpg" height="350" width="350" alt="まるさん">
        </div>

        <form action="${pageContext.request.contextPath}/LoginServlet" name="loginform" method="post" onsubmit="return check()">
            <div class="form-group">
                <label for="exampleInputUserID">ユーザID</label>
                <input type="text" name="userid" class="form-control" id="exampleInputEmail1" placeholder="UserID">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword">パスワード</label>
                <input type="password" name="password" class="form-control" id="exampleInputPassword" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-secondary">ログイン</button>
        </form>

        <p>新規登録の方は<a href="newuser.jsp">コチラ</a></p>

    </div>

    <footer class="footer">
        <small>Copyright &copy; Sato Team, all rights reserved.</small>
    </footer>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <script>
        function check(){
            var flg = 0;
            if (document.loginform.userid.value == "" || document.loginform.password.value == "") {
                flg = 1;
            }

            if (flg == 1) {
                alert('必須項目が入力されていません');
                return false;
            } else {
                return true;
            }
        }
    </script>
</body>
</html>
