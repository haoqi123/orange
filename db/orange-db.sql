/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/4/29 16:14:24                           */
/*==============================================================*/


drop table if exists t_car;

drop table if exists t_comment;

drop table if exists t_commodity;

drop table if exists t_feet;

drop table if exists t_goodsType;

drop table if exists t_logistics;

drop table if exists t_logs;

drop table if exists t_master;

drop table if exists t_order;

drop table if exists t_order_goods;

drop table if exists t_parameter;

drop table if exists t_pic;

drop table if exists t_quan;

drop table if exists t_seckill;

drop table if exists t_user;

drop table if exists t_useraddress;

drop table if exists t_usercar;

drop table if exists t_userquan;

drop table if exists t_xzqy;

/*==============================================================*/
/* Table: t_car                                                 */
/*==============================================================*/
create table t_car
(
   c_id                 int not null auto_increment comment '主键',
   c_goods_sn           int not null comment '商品主键',
   t_usercar_id         int not null comment '主键',
   c_information varchar(255) not null comment '商品信息',
   c_unit_price         decimal(10,2) not null comment '单价',
   c_number             int not null,
   c_createTime         timestamp not null DEFAULT CURRENT_TIMESTAMP,
   primary key (c_id)
);

alter table t_car comment '购物车';

/*==============================================================*/
/* Table: t_comment                                             */
/*==============================================================*/
create table t_comment
(
   t_comment_id         int not null comment '商品主键',
   c_goods_sn           int not null comment '商品主键',
   u_id                 int not null comment '用户ID',
   c_star               int not null comment '打分',
   c_content            varchar(200) not null comment '评论内容',
   c_pic_urls           varchar(200) not null comment '评论图片',
   c_add_time           timestamp not null DEFAULT CURRENT_TIMESTAMP comment '创建时间',
   c_type               int not null comment '类型',
   primary key (t_comment_id)
);

alter table t_comment comment '商品评论表';

/*==============================================================*/
/* Table: t_commodity                                           */
/*==============================================================*/
create table t_commodity
(
   t_commodity_id       int not null auto_increment comment '商品主键',
   gt_id                int not null comment '类目id',
   c_goods_sn           int not NULL unique comment '商品编号',
   c_name               varchar(200) not null comment '商品名称',
   c_counter_price      decimal(10,2) not null comment '专柜价格',
   c_retail_price       decimal(10,2) not null comment '当前价格',
   c_is_hot             int not null comment ' 1 新品 2非新品 是否新品',
   c_is_new             int not null comment '1 热品  2非热品   是否热品 ',
   c_is_on_sale         int not null comment '是否在售 1在售 2非在售',
   c_keywords           varchar(200) not null comment '关键字',
   c_unit               int not null comment '商品单位',
   c_brief              varchar(200) not null comment '商品介绍',
   c_add_time           timestamp not null DEFAULT CURRENT_TIMESTAMP comment '创建时间',
   c_update_time        timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '修改时间',
   c_spec               varchar(255) not null,
   primary key (t_commodity_id)
);

alter table t_commodity comment '商品管理表';

/*==============================================================*/
/* Table: t_feet                                                */
/*==============================================================*/
create table t_feet
(
   t_feet_id            int not null comment '主键',
   `user_id`              int not null,
   c_goods_sn           int not null comment '商品主键',
   f_createTime         timestamp not null DEFAULT CURRENT_TIMESTAMP comment '添加时间',
   primary key (t_feet_id)
);

alter table t_feet comment '用户足迹表';

/*==============================================================*/
/* Table: t_goodsType                                           */
/*==============================================================*/
create table t_goodsType
(
   t_goodsType_id       int not null auto_increment comment '主键',
   gt_id                int not null unique comment '类目id',
   gt_name              varchar(20) not null comment '类目名',
   gt_iconUrl           varchar(255) not null comment '类目图标',
   gt_picUrl            varchar(255) not null comment '类目图片',
   gt_keywords          varchar(20) not null comment '关键字',
   gt_desc              varchar(50) not null comment '简介',
   gt_level             int not null comment '级别',
   primary key (t_goodsType_id)
);

alter table t_goodsType comment '商品类目表';

/*==============================================================*/
/* Table: t_logistics                                           */
/*==============================================================*/
create table t_logistics
(
   logi_id              int not null auto_increment comment '物流编号（主键）',
   order_no             int not null comment '订单编号',
   logi_name            varchar(50) not null comment '物流名称',
   logi_no              varchar(100) not null comment '物流单号',
   primary key (logi_id)
);

alter table t_logistics comment '物流表';

/*==============================================================*/
/* Table: t_logs                                                */
/*==============================================================*/
create table t_logs
(
   t_logs_id            int not null comment '主键',
   t_master_id          int not null comment '操作管理员',
   l_ip                 int not null comment 'ip地址',
   l_createTime         timestamp not null DEFAULT CURRENT_TIMESTAMP comment '操作时间',
   l_type               int not null comment '操作类别',
   l_action             varchar(10) not null comment '操作动作',
   l_status             int not null comment '操作状态',
   l_result             varchar(10) not null comment '操作结果',
   l_comment            varchar(50) not null comment '备注',
   primary key (t_logs_id)
);

alter table t_logs comment '操作日志表';

/*==============================================================*/
/* Table: t_master                                              */
/*==============================================================*/
create table t_master
(
   t_master_id          int not null auto_increment comment '管理员id',
   m_name               varchar(8) not null comment '管理员名称',
   m_picUrl             varchar(255) not null comment '管理员头像',
   m_level              int not null comment '管理员角色',
   m_pass               varchar(8) not null comment '管理员密码',
   primary key (t_master_id)
);

alter table t_master comment '管理员表';

/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
create table t_order
(
   order_id             int not null auto_increment comment '订单主键',
   `user_id`              int not null comment '用户编号',
   order_no             int not null unique comment '订单编号',
   order_postage        double(5,2) not null comment '邮费',
   order_money          double(10,2) not null comment '总金额',
   order_ganeration_time timestamp not null DEFAULT CURRENT_TIMESTAMP comment '订单生成时间',
   order_force_time     timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '订单付款时间',
   order_type           int not null comment '订单状态',
   order_Invalid        int not null comment '是否失效(查看订单是否过时)',
   primary key (order_id)
);

alter table t_order comment '订单表';

/*==============================================================*/
/* Table: t_order_goods                                         */
/*==============================================================*/
create table t_order_goods
(
   order_goods_id       int not null auto_increment comment '订单商品编号(主键)',
   order_no             int not null comment '订单编号',
   c_goods_sn           int not null comment '商品主键',
   order_goods_introduce varchar(250) not null comment '订单商品介绍',
   order_goods_describe varchar(200) not null comment '订单商品描述（商品颜色，大小）',
   order_goods_money    double(10,2) not null comment '价格',
   primary key (order_goods_id)
);

alter table t_order_goods comment '订单介绍';

/*==============================================================*/
/* Table: t_parameter                                           */
/*==============================================================*/
create table t_parameter
(
   p_id                 int not null auto_increment,
   c_goods_sn           int not null comment '商品主键',
   p_name               varchar(255) not null comment '商品参数名称',
   p_value              varchar(255) not null comment '商品参数值',
   primary key (p_id)
);

alter table t_parameter comment '商品参数';

/*==============================================================*/
/* Table: t_pic                                                 */
/*==============================================================*/
create table t_pic
(
   t_pic_id             int not null auto_increment comment '主键',
   c_goods_sn           int not null comment '商品id',
   pic_url              varchar(255) not null,
   pic_type             int not null comment '图片类型',
   pic_addTime          timestamp not null DEFAULT CURRENT_TIMESTAMP comment '加入时间',
   primary key (t_pic_id)
);

alter table t_pic comment '图片表';

/*==============================================================*/
/* Table: t_quan                                                */
/*==============================================================*/
create table t_quan
(
   t_quan_id            int not null auto_increment comment '主键',
   q_id                 int not null unique comment '优惠券id',
   q_name               varchar(20) not null comment '优惠券名称',
   q_desc               varchar(255) not null comment '介绍',
   q_tag                int not null comment '标签',
   q_min                int not null comment '最低消费',
   q_discount           int not null comment '满减金额',
   q_limit              int not null comment '每人限领',
   q_about              int not null comment '商品使用范围',
   q_type               int not null comment '优惠券类型',
   q_status             int not null comment '状态',
   q_createTime         timestamp  null comment '开始时间',
   q_endTIme            timestamp  null comment '结束时间',
   q_number             int not null comment '优惠券数量',
   primary key (t_quan_id)
);

alter table t_quan comment '优惠券表';

/*==============================================================*/
/* Table: t_seckill                                             */
/*==============================================================*/
create table t_seckill
(
   t_seckill_id         int not null auto_increment comment '编号',
   c_goods_sn           int not null comment '商品主键',
   sk_name              varchar(20) not null comment '活动名称',
   sk_createTime        timestamp not null DEFAULT CURRENT_TIMESTAMP comment '创建时间',
   sk_startTime         timestamp null comment '活动开始时间',
   sk_endTime           timestamp null comment '结束时间',
   sk_number            int not null,
   primary key (t_seckill_id)
);

alter table t_seckill comment '秒杀活动表';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   t_user_id            int not null auto_increment,
   `user_id`            int not null unique comment '用户编号',
   `user_name`          varchar(20) not null comment '用户名',
   user_phone           varchar(11) not null comment '手机号',
   user_sex             int not null,
   user_birthday        date not null comment '生日',
   user_level           int not null comment '用户等级',
   user_status          int not null comment '状态',
   primary key (t_user_id)
);

alter table t_user comment '会员表';

/*==============================================================*/
/* Table: t_useraddress                                         */
/*==============================================================*/
create table t_useraddress
(
   t_useraddress_id     int not null comment '主键',
   `user_id`            int not null,
   qu_id                int not null comment '主键',
   us_name              varchar(20) not null comment '收货人名称',
   us_phone             varchar(11) not null comment '收货地址手机号',
   us_status            int not null comment '是否默认',
   primary key (t_useraddress_id)
);

alter table t_useraddress comment '收货地址表';

/*==============================================================*/
/* Table: t_usercar                                             */
/*==============================================================*/
create table t_usercar
(
   t_usercar_id         int not null auto_increment comment '主键',
   `user_id`              int,
   primary key (t_usercar_id)
);

alter table t_usercar comment '用户的购物车';

/*==============================================================*/
/* Table: t_userquan                                            */
/*==============================================================*/
create table t_userquan
(
   t_userquan           int not null auto_increment comment '主键',
   `user_id`              int not null,
   q_id                 int not null comment '主键',
   userquan_status      int not null,
   userquan_addtime     timestamp not null DEFAULT CURRENT_TIMESTAMP comment '领取时间',
   userquan_updatetime  timestamp NULL comment '使用时间',
   primary key (t_userquan)
);

alter table t_userquan comment '优惠券-用户表';

/*==============================================================*/
/* Table: t_xzqy                                                */
/*==============================================================*/
create table t_xzqy
(
   t_xzqy_id            int not null auto_increment comment '主键',
   qy_name              varchar(20) not null comment '区域名称',
   qy_type              int not null comment '区域类型',
   qu_id                int not null comment '区域编码',
   primary key (t_xzqy_id)
);

alter table t_xzqy comment '行政区域';

alter table t_car add constraint FK_Reference_18 foreign key (t_usercar_id)
      references t_usercar (t_usercar_id) on delete restrict on update restrict;

alter table t_car add constraint FK_Reference_20 foreign key (c_goods_sn)
      references t_commodity (c_goods_sn) on delete restrict on update restrict;

alter table t_comment add constraint FK_Reference_13 foreign key (c_goods_sn)
      references t_commodity (c_goods_sn) on delete restrict on update restrict;

alter table t_commodity add constraint FK_Reference_4 foreign key (gt_id)
      references t_goodsType (gt_id) on delete restrict on update restrict;

alter table t_feet add constraint FK_Reference_1 foreign key (`user_id`)
      references t_user (`user_id`) on delete restrict on update restrict;

alter table t_feet add constraint FK_Reference_21 foreign key (c_goods_sn)
      references t_commodity (c_goods_sn) on delete restrict on update restrict;

alter table t_logistics add constraint FK_Reference_8 foreign key (order_no)
      references t_order (order_no) on delete restrict on update restrict;

alter table t_logs add constraint FK_Reference_14 foreign key (t_master_id)
      references t_master (t_master_id) on delete restrict on update restrict;

alter table t_order add constraint FK_Reference_10 foreign key (`user_id`)
      references t_user (`user_id`) on delete restrict on update restrict;

alter table t_order_goods add constraint FK_Reference_12 foreign key (c_goods_sn)
      references t_commodity (c_goods_sn) on delete restrict on update restrict;

alter table t_order_goods add constraint FK_Reference_9 foreign key (order_no)
      references t_order (order_no) on delete restrict on update restrict;

alter table t_parameter add constraint FK_Reference_17 foreign key (c_goods_sn)
      references t_commodity (c_goods_sn) on delete restrict on update restrict;

alter table t_pic add constraint FK_Reference_16 foreign key (c_goods_sn)
      references t_commodity (c_goods_sn) on delete restrict on update restrict;

alter table t_seckill add constraint FK_Reference_5 foreign key (c_goods_sn)
      references t_commodity (c_goods_sn) on delete restrict on update restrict;

alter table t_useraddress add constraint FK_Reference_11 foreign key (`user_id`)
      references t_user (`user_id`) on delete restrict on update restrict;

alter table t_useraddress add constraint FK_Reference_15 foreign key (qu_id)
      references t_xzqy (t_xzqy_id) on delete restrict on update restrict;

alter table t_usercar add constraint FK_Reference_19 foreign key (`user_id`)
      references t_user (`user_id`) on delete restrict on update restrict;

alter table t_userquan add constraint FK_Reference_6 foreign key (`user_id`)
      references t_user (`user_id`) on delete restrict on update restrict;

alter table t_userquan add constraint FK_Reference_7 foreign key (q_id)
      references t_quan (q_id) on delete restrict on update restrict;

