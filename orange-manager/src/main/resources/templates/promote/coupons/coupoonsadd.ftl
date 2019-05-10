<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
             xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Hello World!</title>
    <link rel="stylesheet" href="/js/layui/css/layui.css">
    <script src="/js/layui/layui.js"></script>
    <script src="/js/jquery-1.11.3.js"></script>
</head>
<body>
<form class="layui-form layui-form-pane" id="couponsAddId">
    <div class="layui-form-item">
        <label class="layui-form-label">优惠券名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" autocomplete="off" placeholder="请输入标题" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">介绍</label>
        <div class="layui-input-block">
            <input type="text" name="desc" autocomplete="off" placeholder="请输入" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标签</label>
        <div class="layui-input-block">
            <input type="text" name="tag" autocomplete="off" placeholder="请输入" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">最低消费</label>
            <div class="layui-input-inline">
                <input type="text" name="min" value="0" placeholder="￥" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">满减金额</label>
            <div class="layui-input-inline">
                <input type="text" name="discount" value="0" placeholder="￥" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">每人限领</label>
            <div class="layui-input-inline">
                <input type="text" name="limit" value="1" placeholder="张" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">分发类型</label>
        <div class="layui-input-block">
            <select name="type" lay-filter="aihao">
                <option value="1" selected="">通用领券</option>
                <option value="2">注册赠券</option>
                <option value="3">兑换码</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">优惠券数量</label>
            <div class="layui-input-inline">
                <input type="text" name="number" placeholder="张" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">开始时间</label>
            <div class="layui-input-block">
                <input type="text" name="createTime" id="date1" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">结束时间</label>
            <div class="layui-input-block">
                <input type="text" name="endTIme" id="date1" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item" pane="">
        <label class="layui-form-label">适用范围</label>
        <div class="layui-input-block">
            <input type="radio" name="about" value="1" title="全场通用" checked="">
            <input type="radio" name="about" value="2" title="指定分类">
            <input type="radio" name="about" value="3" title="指定商品">
        </div>
    </div>
</form>
<script>
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
                ,layer = layui.layer
                ,layedit = layui.layedit
                ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date1'
            ,type: 'datetime'
        });

    });
</script>
</body>
</html>