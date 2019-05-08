<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
             xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Hello World!</title>
    <link rel="stylesheet" href="/js/layui/css/layui.css">
    <script src="/js/layui/layui.js"></script>
    <script src="/js/jquery-1.11.3.js"></script>
    <script src="/js/jquery.cookie.js"></script>
    <style>
        .layui-tab ul.layui-tab-title li:nth-child(1) i {
            display: none;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">orange内部管理</div>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">首页</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">会员管理</a></dd>
                        <dd><a href="javascript:;">收货地址</a></dd>
                        <dd><a href="">会员足迹</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">商场管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">行政区域</a></dd>
                        <dd><a href="javascript:;">商品类别</a></dd>
                        <dd><a href="">订单管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">商品管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">商品列表</a></dd>
                        <dd><a href="javascript:;">商品评价</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">推广管理</a>
                    <dl class="layui-nav-child">
                        <dd><a class="site-demo-active" data-type="tabAddYouhuiquan">优惠券管理</a></dd>
                        <dd><a class="site-demo-active" data-type="tabAddMiaosha">秒杀活动</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">系统管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">操作记录</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">配置管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">运费管理</a></dd>
                        <dd><a href="javascript:;">订单配置</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">统计报表</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="layui-tab" lay-filter="demo" lay-allowclose="true">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="11">网站设置</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">内容1</div>
            </div>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script>
    layui.use('element', function(){
        var $ = layui.jquery
                ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        //触发事件
        var active = {
            tabAddYouhuiquan: function(){
                var exist=$("li[lay-id='701']").length;
                if(exist==0){
                    //新增一个Tab项
                    element.tabAdd('demo', {
                        title: '优惠券' //用于演示
                        ,content: "<iframe src='"+'/PromoteController/couponsFtl'+"' style='width: 100%;height: 78%'></iframe>"
                        ,id: 701 //实际使用一般是规定好的id，这里以时间戳模拟下
                    });
                }
                element.tabChange('demo', '701');
            }
            ,tabAddMiaosha: function(){
                var exist=$("li[lay-id='702']").length;
                if(exist==0) {
                    //新增一个Tab项
                    element.tabAdd('demo', {
                        title: '秒杀' //用于演示
                        , content: "<iframe src='"+'/PromoteController/killFtl'+"' style='width: 100%;height: 78%'></iframe>"
                        , id: 702 //实际使用一般是规定好的id，这里以时间戳模拟下
                    });
                }
                element.tabChange('demo', '702');
            }

        };

        $('.site-demo-active').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        //Hash地址的定位
        var layid = location.hash.replace(/^#test=/, '');
        element.tabChange('test', layid);

        element.on('tab(test)', function(elem){
            location.hash = 'test='+ $(this).attr('lay-id');
        });

    });
</script>
</body>
</html>