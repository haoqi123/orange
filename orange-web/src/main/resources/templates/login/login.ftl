<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
    <title>登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.css" />
    <link href="css/dlstyle.css" rel="stylesheet" type="text/css">
    <script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
    <script src="AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
</head>
<body>

<div class="login-boxtitle">
    <a href="home.html"><img alt="logo" src="images/logobig.png" /></a>
</div>

<div class="login-banner">
    <div class="login-main">
        <div class="login-banner-bg"><span></span><img src="images/big.jpg" /></div>
        <div class="login-box">

            <h3 class="title">登录商城</h3>

            <div class="clear"></div>

            <div class="login-form">
                <form>
                    <div class="user-name">
                        <label for="user"><i class="am-icon-user"></i></label>
                        <input type="text"  onblur="testName()" name="userName" id="user" placeholder="邮箱/手机/用户名">
                    </div>
                    <div class="user-pass">
                        <label for="password"><i class="am-icon-lock"></i></label>
                        <input type="password" name="userPhone" id="password" placeholder="请输入密码">
                    </div>
                </form>
            </div>

            <div class="login-links">
                <label for="remember-me"><input id="remember-me" type="checkbox">记住密码</label>
                <a href="#" class="am-fr">忘记密码</a>
                <a href="register" class="zcnext am-fr am-btn-default">注册</a>
                <br />
            </div>
            <div class="am-cf">
                <input type="button" name="" onclick="login()" value="登 录" class="am-btn am-btn-primary am-btn-sm">
            </div>
            <div class="partner">
                <h3>合作账号</h3>
                <div class="am-btn-group">
                    <li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
                    <li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span> </a></li>
                    <li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span> </a></li>
                </div>
            </div>

        </div>
    </div>
</div>


<div class="footer ">
    <div class="footer-hd ">
        <p>
            <a href="# ">恒望科技</a>
            <b>|</b>
            <a href="# ">商城首页</a>
            <b>|</b>
            <a href="# ">支付宝</a>
            <b>|</b>
            <a href="# ">物流</a>
        </p>
    </div>
    <div class="footer-bd ">
        <p>
            <a href="# ">关于恒望</a>
            <a href="# ">合作伙伴</a>
            <a href="# ">联系我们</a>
            <a href="# ">网站地图</a>
            <em>© 2015-2025 Hengwang.com 版权所有</em>
        </p>
    </div>
</div>


<<script>

    function testName(){
        var name = $("#user").val();
        //判断不是空数据
        if(name == null){
            return;
        }
        //判断正则
        var phoneTest = /^1\d{10}$/;
        if(!phoneTest.test(name)){
            fals = false;
            $.messager.alert('您的账号格式错误！');
            return;
        }else{
            fals=true;
        }
    }
    function login() {
        testName();
        if(!fals){
            return;
        }
        var name = $('#user').val();
        var pass = $('#password').val();
        //判断密码不为空
        if(pass == null && pass ==''){
            return;
        }
        if(name == null && name ==''){
            return;
        }
        $.ajax({
            type:'get',
            url:'/tologin',
            data:{'userName':name,'userPhone':pass},
            dataType:'json',
            async:false,
            success:function(data){
                alert(data);
                if(data.code==500 || data.code == 501){
                    $.messager.alert('您的账号或者密码错误！');
                }else{
                    location.href="../index";
                }
            },
            error:function(){
                $.messager.alert('系统错误！');
            }
        });
    }

</script>
</body>
</html>