<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"><!--Head--><head>
    <meta charset="utf-8">
    <title>LOGIN</title>
    <meta name="description" content="login page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!--Basic Styles-->
    <link href="/static/admin/style/bootstrap.css" rel="stylesheet">
    <link href="/static/admin/style/font-awesome.css" rel="stylesheet">
    <!--Beyond styles-->
    <link id="beyond-link" href="/static/admin/style/beyond.css" rel="stylesheet">
    <link href="/static/admin/style/demo.css" rel="stylesheet">
    <link href="/static/admin/style/animate.css" rel="stylesheet">
</head>
<!--Head Ends-->    
<!--Body-->

<body>
    <div class="login-container animated fadeInDown">
        <form action="${path}door" method="post">
            <div class="loginbox bg-white">       
                <div class="loginbox-title">SIGN IN</div>
                <div class="loginbox-textbox">
                    <input value="" class="form-control" autocomplete="off" placeholder="username" name="username" value="" type="text">
                </div>
                <div class="loginbox-textbox">
                    <input class="form-control" placeholder="password" name="password" value="" type="password">
                </div>
                <div class="loginbox-submit">
                    <input class="btn btn-primary btn-block" value="Login" type="submit">
                </div>
            </div>
               
        </form>
    </div>
    <!--Basic Scripts-->
    <script src="/static/admin/style/jquery.js"></script>
    <script src="/static/admin/style/bootstrap.js"></script>
    <script src="/static/admin/style/jquery_002.js"></script>
    <!--Beyond Scripts-->
    <script src="/static/admin/style/beyond.js"></script>




</body><!--Body Ends--></html>