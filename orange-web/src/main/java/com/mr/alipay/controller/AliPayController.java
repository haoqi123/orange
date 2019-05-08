package com.mr.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.mr.commont.order.OrderGoodsVo;
import com.mr.commont.order.SuccessVo;
import com.mr.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by shangpengyu on 2019/5/8.
 */
@Controller
public class AliPayController {
    private final String APP_ID = "2016092700607051";
    private final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCHrielyqLT2/BA/xLGUg4XA1R967Jkf5S+oDpAnJ8eljIJRsj40dOUEIqxeBW/eVXNQsl8sN+xkvb8mJc09+Qo2XRyUi7OUi79zvdtVNp36BG3RyR5VYH2hHyxHGbhvB83YNDEoJyFV2QEX8YouFUeajPa0PPvug8FvDSWBQDwTCMsuUOM1s4Xax9L20lpRDur6lJiU8XCXFAserF3UePEjT9y0hg4U99bPYc0dqc5E8VkuO9DEYYu2ezTr9EkNMdD4EHDSp1k51mz1lGOpAjLQMAHUFmfCxYz+SSk0+DRPPCt83UWfFQOH9UhQJJNe+eCIFTf/xTlTDUBn06ExzUxAgMBAAECggEAH7b2r4tBKlJzw02cPt05S+nMWy634UPtKe3cD/RMQWMMSRzRp0+srCR9tuQB+WLMSpF89XeGokRfFUY5ufjjzSSfUoWhSTrunwc80MKP2o1VbsjjXrU9DrmDSAcCiWtmxJQN2JhOXeDCkT8t26DSzKw4eMJ08qlED6whgpuiz4g1DAircAqZJ5gOSnJLIfwWRKpZLhqMGdHg2KqFBN9UVwNLszgadOId2qjOyb7/ucKm13nYjLRoaTj1ckGarHxsWnfXW7kCrZLZM9Ip9vZDmP9mTmxuYGa0WhI8PFyUeAUaAYy0vl8daQ/hBcTxVsAI2IJQPFcwu26URZh9e5dnPQKBgQDLp9JEpNX/cPLXps9+xtPhdsZ0VvsO4dc96y8aBJdsSI7RInVt6p4EQWuyahH6/TDpDzQ3qzS2qlTvGfewrPGmWNEfTX2yRympz7mbRWS6BrkqX5Th1Ks/ETRg6r3+BDavDGvLfXaB8cwnerdfj4mswbjAS0WxnA/JLXb03e0FdwKBgQCqja4z8+JfarTxlwhBev8hF7OFIf6v89JZjY817mteZR9KQlPp+UaDVkUdZE7BpSTpCFFL0CFO5awziDx/fBLNYV8mrb5fd44lscFFhC8jduObxkSndDFnZCqudc5qJvR5ouNrUEOjrwwJIkiS66UygPuQH/ST9KNq8KvIdn3klwKBgQChZMkFL2CMRBWfg4nS3X0So89YaYoi3CV444X7Z4IdBU9xO462YgWCN9pClT7UmoyFVlA6gcqPrGMM7ZZWhGgpPR/VX9LqUu0Yrw9XluHhbuyVQRQ6+BASNe89kyqoQOyZQw22QSKGjnoNG3pxF86ygv+IHN8JhzUXaJlqKunotwKBgAjxxzoIR03zvauR3Sf5+FlW8d5AiyfVJKn3p5QPfegEa6CsW9RAc3c91gAVm5/CNm5WNlVAhA6sMty8/1c8PYwx2BiiMgK1tWm6qcUoioRUntkzi7QwfsrKUQa3PO0KP/YFGeIt4m46JupvttilrRM5+ndzhZMg2FUqbAfmVvHfAoGAXZC0mDkcCg9ctD4x0fpCfKJ+VJewZOjBfw6I+a8PrwBKcXBdaOgF6MSBI4MEjlNSNlAvvGwpqkJ9CXz4HTMPbcKk5DJlLlxZLZbVDIns/CyrjJmXXUWn9x01ii+EaPKZx11s4YAtS5FLJEbWFfskLrkO8kuQkFjYrh+atj5YsWM=";
    private final String CHARSET = "UTF-8";
    private final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwM48lzy+n+ymAVrlFKCWc71G1uZ2kKGXx0PFDhtX6rTC1/IZ1+/S/qbpHiy7Z0gQ8JY1ZA6EYU+Kponm3AgJ2pCJj2+KSgfJ2j3ndAydBqzIb0Xn577XOTsp6Xi/3GqLgIWZ6xt/fa/DFYAEBJhU4MoyHMS6GZi+Wn+Y6JQfbM5hfpdNeOoBROovnLrJRHbsRI39SvG8Tr7I3CU13Yj5WLcypFUoStnMNukQIM3Wf/ddGDTC5J8QceUmAYWsNakkyE8UjPU/dxBgZ4Q6nvI/UftNGG/MDx0gcZKlQm7LpdvdD+xp9oq62NGQXU5ogtW2Nn5s18BHmycUso/urURHjQIDAQAB";
    //这是沙箱接口路径,正式路径为https://openapi.alipay.com/gateway.do
    private final String GATEWAY_URL ="https://openapi.alipaydev.com/gateway.do";
    private final String FORMAT = "JSON";
    //签名方式
    private final String SIGN_TYPE = "RSA2";
    //支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
    private final String NOTIFY_URL = "http://公网地址/notifyUrl";
    //支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
    private final String RETURN_URL = "http://localhost:8765/AliPayController/returnUrl";

    @Autowired
    private OrderService orderService;

    @RequestMapping("alipay")
    public void alipay(OrderGoodsVo orderGoodsVo, HttpServletResponse httpResponse) throws IOException {
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(RETURN_URL);
        request.setNotifyUrl(NOTIFY_URL);
        //根据订单编号,查询订单相关信息
        OrderGoodsVo orderGoodsVo1 = orderService.addOrder(orderGoodsVo);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orderGoodsVo1.getOrderNo().toString();
        //付款金额，必填
        String total_amount = orderGoodsVo1.getOrderMoney().toString();
        //订单名称，必填
        String subject = orderGoodsVo1.getOrderGoodsIntroduce();
        //商品描述，可空
        String body = orderGoodsVo1.getOrderGoodsDescribe()+"\t"+"数量:"+orderGoodsVo1.getOrderGoodsNum().toString();
        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }



    @RequestMapping(value = "returnUrl", method = RequestMethod.GET)
    public ModelAndView returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        ModelAndView mo = new ModelAndView();

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些
        boolean signVerified = AlipaySignature.rsaCheckV1(params, ALIPAY_PUBLIC_KEY, CHARSET, SIGN_TYPE); // 调用SDK验证签名
        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            //去后台修改状态
            orderService.updateOrderStart(out_trade_no);


            System.out.println("商户订单号="+out_trade_no);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);


            //将数据带入前台
            SuccessVo successVo = new SuccessVo();
            //将数据放入successVo
            successVo.setUserName("冯璤君");
            successVo.setOrderPhone("1324523211");
            successVo.setOrderMoney(total_amount);
            mo.addObject("success",successVo);
            mo.setViewName("/order/success");

            return mo;//跳转付款成功页面
        }else{
            mo.setViewName("/order/error");
            return mo;//跳转付款失败页面
        }

    }

}
