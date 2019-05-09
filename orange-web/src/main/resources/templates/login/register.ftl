<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="UTF-8">
    <title>注册</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.min.css" />
    <link href="css/dlstyle.css" rel="stylesheet" type="text/css">
    <script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
    <script src="AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

</head>

<body>

<div class="login-boxtitle">
    <a href="home/demo.html"><img alt="" src="/images/logobig.png" /></a>
</div>

<div class="res-banner">
    <div class="res-main">
        <div class="login-banner-bg"><span></span><img src="/images/big.jpg" /></div>
        <div class="login-box">

            <div class="am-tabs" id="doc-my-tabs">
                <ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
                    <li class="am-active"><a href="">手机号注册</a></li>
                </ul>

                <div class="am-tabs-bd">

                    <div class="am-tab-panel am-active">
                        <form method="post">
                            <div class="user-phone">
                                <label for="phone"><i class="am-icon-mobile-phone am-icon-md"></i></label>
                                <input type="tel" name="userName" id="phone" placeholder="请输入手机号">
                            </div>
                            <div class="verification">
                                <label for="code"><i class="am-icon-code-fork"></i></label>
                                <input type="tel" name="msg" id="code" placeholder="请输入验证码">
                                <a class="btn" href="javascript:sendMobileCode()" id="sendMobileCode">
                                    <span id="dyMobileButton">获取</span></a>
                            </div>
                            <div class="user-pass">
                                <label for="password"><i class="am-icon-lock"></i></label>
                                <input type="password" name="userPhone" id="password" placeholder="设置密码">
                            </div>
                            <div class="user-pass">
                                <label for="passwordRepeat"><i class="am-icon-lock"></i></label>
                                <input type="password" name="userPhone1" id="passwordRepeat" placeholder="确认密码">
                            </div>
                        </form>
                        <div class="login-links">
                            <label for="reader-me">
                                <input id="reader-me" type="checkbox"> 点击表示您同意商城《服务协议》
                            </label>
                        </div>
                        <div class="am-cf">
                            <input type="button" onclick="onRegister()" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
                        </div>

                        <hr>
                    </div>

                    <script>
                        $(function() {
                            $('#doc-my-tabs').tabs();
                        })
                    </script>

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
                <em>? 2015-2025 Hengwang.com 版权所有</em>
            </p>
        </div>
    </div>
</body>
<script>
    //验证码
    function sendMobileCode() {
        var phone = $("#phone").val();
        var phoneTest = /^1\d{10}$/
        if(!phoneTest.test(phone)){
            alert("手机号格式不正确.");
            return ;
        }
        $.ajax({
            type:'get',
            url:'/yanZhengMa',
            data:{"user.userName":phone},
            dataType:'text',
            success:function (data) {
                alert(data);
            },
            error:function () {
                alert("系统错误！！")
            }
        });
    }
    //注册
    function onRegister() {
        var phone = $("#phone").val();
        var code = $("#code").val();
        var password = $("#password").val();
        var passwordRepeat = $("#passwordRepeat").val();
        var phoneTest = /^1\d{10}$/
        if(!phoneTest.test(phone)){
            alert("手机号格式不正确.");
            return ;
        }
        if(password != passwordRepeat){
            alert("两次密码不正确.");
            return ;
        }
        $.ajax({
            type:'post',
            url:'/addUser',
            data:{"userName":phone,"msg":code,"userPhone":passwordRepeat},
            dataType:'json',
            success:function (data) {
                if(data.code==200){
                    alert(data.msg);
                    location.href="login";
                }else{
                    alert(data.msg);
                }
            },
            error:function () {
                alert("系统错误！！")
            }
        });
    }
</script>
</html>