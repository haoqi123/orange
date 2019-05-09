<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
             xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Hello World!</title>
    <link rel="stylesheet" href="/js/layui/css/layui.css">
    <script src="/js/layui/layui.js"></script>
    <script src="/js/jquery-1.11.3.js"></script>
</head>
<body>

    <form class="layui-form">
        <div class="layui-form-item">
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <input type="text" name="name" autocomplete="off" class="layui-input" placeholder="请输入优惠券标题">
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <select name="type">
                        <option value="0">请选择优惠券类型</option>
                        <optgroup label="优惠券类型">
                            <option value="1">通用领券</option>
                            <option value="2">注册赠券</option>
                            <option value="3">兑换码</option>
                        </optgroup>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-inline">
                    <select name="status" lay-verify="required" lay-search="">
                        <option value="0">请选择优惠券状态</option>
                        <optgroup label="优惠券状态">
                        <option value="1">正常</option>
                        <option value="2">已过期</option>
                        <option value="3">已下架</option>
                    </select>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="couponsDemo">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </div>
    </form>

    <div class="site-demo-button" id="layerDemo" style="margin-bottom: 0;">
        <button data-method="notice" class="layui-btn">
            <i class="layui-icon">&#xe608;</i> 添加
        </button>
    </div>

    <table id="couponsTable" lay-filter="test"></table>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="sele">详情</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

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
                elem: '#couponsTable'
                ,height: 312
                ,url: '/CouponsController/selectCouponsList' //数据接口
                ,page: true //开启分页
                ,cols: [[ //表头
                    {field: 'quanId', title: 'id', width:30, sort: true}
                    ,{field: 'id', title: '券编号', width:80}
                    ,{field: 'name', title: '名称', width:80}
                    ,{field: 'desc', title: '介绍', width:80}
                    ,{field: 'tag', title: '标签', width: 80}
                    ,{field: 'min', title: '最低消费', width:100, sort: true}
                    ,{field: 'discount', title: '满减金额', width: 100, sort: true}
                    ,{field: 'limit', title: '每人限领', width: 100}
                    ,{field: 'about', title: '商品适用范围', width: 135}
                    ,{field: 'type', title: '类型', width: 80}
                    ,{field: 'status', title: '状态', width: 80}
                    ,{field: 'createTime', title: '开始时间', width: 135, sort: true}
                    ,{field: 'endTIme', title: '结束时间', width: 135, sort: true}
                    ,{field: 'number', title: '数量', width: 80, sort: true}
                    ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
                ]]
            });

            //监听提交
            form.on('submit(couponsDemo)', function(data){
                layer.msg(JSON.stringify(data.field));
                table.reload('couponsTable', {
                    url: '/CouponsController/selectCouponsList'
                    ,where: data.field //设定异步数据接口的额外参数
                    //,height: 300
                });
                return false;
            });

            //监听行工具事件
            table.on('tool(test)', function(obj){
                var data = obj.data;
                var str = "id=" +data.id
                        +"&name=" +data.name
                        +"&desc="+data.desc
                        +"&tag="+data.tag
                        +"&min="+data.min
                        +"&discount=+"+data.discount
                        +"&limit="+data.limit
                        +"&about="+data.about
                        +"&type="+data.type
                        +"&status="+data.status
                        +"&createTime="+data.createTime
                        +"&endTIme="+data.endTIme
                        +"&number="+data.number;
                //console.log(obj)
                if(obj.event === 'del'){
                    layer.confirm('真的删除行么', function(index){
                        $.get("/CouponsController/deleteCoupons",{"id":data.id},function (data) {
                            layer.msg(data.msg);
                            obj.del();
                            layer.close(index);
                        })
                    });
                }else if(obj.event === 'sele'){
                    //查询详情
                    location.href="http://localhost:8082/PromoteController/couponSeleFtl?"+str;
                } else if(obj.event === 'edit'){
                    layer.open({
                        type: 2
                        , title: "修改" //不显示标题栏
                        , closeBtn: false
                        , area: ['800px', '700px']
                        , shade: 0.8
                        , id: 'LAY_layuipro' //设定一个id，防止重复弹出
                        , btn: ['确定', '取消']
                        , btnAlign: 'c'
                        , moveType: 1 //拖拽模式，0或者1
                        , content: '/PromoteController/couponUpdateFtl?'+str
                        , yes: function (index, layero) {
                            var data = {};
                            var body = layer.getChildFrame('body', index);
                            var form = body.find("#couponsUpdateId").serializeArray();//获取指定id的表单
                            $.each(form, function () {
                                data[this.name] = this.value;
                            });
                            var content = data;
                            $.get("/CouponsController/updateCoupons",content,function (data) {
                                layer.msg(data.msg);
                                layer.closeAll();
                            })
                            return false;
                        }
                    });
                }
            });
            /*//单击事件
            $(document).on('click','#btAdd',function(){
                layer.alert('hello');
            });*/
            var active = {
                notice: function () {
                    //示范一个公告层
                    layer.open({
                        type: 2
                        , title: "创建" //不显示标题栏
                        , closeBtn: false
                        , area: ['800px', '700px']
                        , shade: 0.8
                        , id: 'LAY_layuipro' //设定一个id，防止重复弹出
                        , btn: ['确定', '取消']
                        , btnAlign: 'c'
                        , moveType: 1 //拖拽模式，0或者1
                        , content: '/PromoteController/couponAddFtl'
                        , yes: function (index, layero) {
                            var data = {};
                            var body = layer.getChildFrame('body', index);
                            var form = body.find("#couponsAddId").serializeArray();//获取指定id的表单
                            $.each(form, function () {
                                data[this.name] = this.value;
                            });
                            var content = data;
                                $.get("/CouponsController/insertCoupons",content,function (data) {
                                    layer.msg(data.msg);
                                    layer.closeAll();
                                })
                            return false;
                            }
                    });
                }
            }
            $('#layerDemo .layui-btn').on('click', function(){
                var othis = $(this), method = othis.data('method');
                active[method] ? active[method].call(this, othis) : '';
            });

            form.render();
        });
    </script>
</body>
</html>