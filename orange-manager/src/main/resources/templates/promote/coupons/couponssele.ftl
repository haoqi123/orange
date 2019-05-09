<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
             xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Hello World!</title>
    <link rel="stylesheet" href="/js/layui/css/layui.css">
    <script src="/js/layui/layui.js"></script>
    <script src="/js/jquery-1.11.3.js"></script>
</head>
<body>
<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">券编号</div>
                <div class="layui-card-body">
                    ${coupons.id}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">优惠券名称</div>
                <div class="layui-card-body">
                    ${coupons.name}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">介绍</div>
                <div class="layui-card-body">
                ${coupons.desc}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">标签</div>
                <div class="layui-card-body">
                ${coupons.tag}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">最低消费</div>
                <div class="layui-card-body">
                ${coupons.min}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">满减金额</div>
                <div class="layui-card-body">
                ${coupons.discount}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">每人限领</div>
                <div class="layui-card-body">
                ${coupons.limit}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">商品适用范围</div>
                <div class="layui-card-body">
                ${coupons.about}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">优惠券类型</div>
                <div class="layui-card-body">
                ${coupons.type}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">当前状态</div>
                <div class="layui-card-body">
                ${coupons.status}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">开始时间</div>
                <div class="layui-card-body">
                ${coupons.createTime?string('yyyy.MM.dd HH:mm:ss')}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">结束时间</div>
                <div class="layui-card-body">
                ${coupons.endTIme?string('yyyy.MM.dd HH:mm:ss')}
                </div>
            </div>
        </div>
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-header">发行数量</div>
                <div class="layui-card-body">
                ${coupons.number}
                </div>
            </div>
        </div>
    </div>
</div>

<form class="layui-form">
    <div class="layui-form-item">
        <div class="layui-inline">
            <div class="layui-input-inline">
                <input type="text" name="userId" autocomplete="off" class="layui-input" placeholder="请输入用户ID">
            </div>
        </div>

        <div class="layui-inline">
            <div class="layui-input-inline">
                <select name="quanStatus" lay-verify="required" lay-search="">
                    <option value="0">请选择使用状态</option>
                    <optgroup label="使用状态">
                        <option value="1">未使用</option>
                        <option value="2">已使用</option>
                        <option value="3">已过期</option>
                        <option value="4">已下架</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="couponsuserDemo">查找</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>
</form>

<table id="couponsuserTable" lay-filter="test"></table>

<script>
    layui.use(['layer', 'form', 'element','table'], function(){
        var table = layui.table
                ,element = layui.element
                ,$ = layui.$
                ,layer = layui.layer
                ,form = layui.form
                ,layedit = layui.layedit;

        //第一个实例
        table.render({
            elem: '#couponsuserTable'
            ,height: 312
            ,url: '/CouponsUserController/selectCouponsUserList' //数据接口
            ,page: true //开启分页
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度
            ,cols: [[ //表头
                {field: 'quanId', title: '优惠券id', sort: true}
                ,{field: 'userId', title: '用户id'}
                ,{field: 'quanStatus', title: '使用状态'}
                ,{field: 'addTime', title: '领取时间', sort: true}
                ,{field: 'updateTime', title: '使用时间', sort: true}
            ]]
        });

        //监听提交
        form.on('submit(couponsuserDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            table.reload('couponsuserTable', {
                url: '/CouponsUserController/selectCouponsUserList'
                ,where: data.field //设定异步数据接口的额外参数
                //,height: 300
            });
            return false;
        });
    });
</script>
</body>
</html>