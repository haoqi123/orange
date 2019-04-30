package com.mr.order.pojo;

/**
 * Created by shangpengyu on 2019/4/29.
 */

public class Order {
    public static void main(String[] args) {
        //俩个for
        /*for(int k = 1;k<=9;k++){         //外循环用于控制行数
            for(int j = 1;j<=k;j++){
                System.out.print(j+"*"+k+"="+(j*k)+"\t");     //"\t"为制表符
            }
            System.out.println();  //换行
        }*/
        //一个for
        for(int i=1,j=1;i<=9;j++){
            System.out.print(j+"*"+i+"="+i*j+"\t");
            if (j==i){
                i++;
                j=0;
                System.out.println();
            }
        }

    }



}
