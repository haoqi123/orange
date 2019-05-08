package com.mr.utils;

import java.util.Random;

/**
 * Created by 师利梅 on 2019/5/8.
 */
public class MsgUtil {

    private static Random r = new Random();

    public static String sendMsg(String mobile) {

        /*Client client = Client.create();
        client.addFilter(new HTTPBasicAuthFilter(
                "api","key-1ad69e657482fd15d103b82f99b4b775"));
        WebResource webResource = client.resource(
                "http://sms-api.luosimao.com/v1/send.json");
        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        formData.add("mobile", mobile);*/
        String str = String.format("%6d", r.nextInt(999999)).replace(" ", "0");
        /*formData.add("message", "验证码：" + str + "【明瑞教育】");
        ClientResponse response =  webResource.type( MediaType.APPLICATION_FORM_URLENCODED ).
                post(ClientResponse.class, formData);
        String textEntity = response.getEntity(String.class);
        int status = response.getStatus();
        //System.out.print(status);
        return textEntity;*/
        System.err.print("验证码：" + str + "【明瑞教育】");
        return str;
    }
}
