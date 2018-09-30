package com.wangchao.icebearbc.utils;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Auther: Kaijun
 * @Date: 2018/9/25 11:51
 * @Description: 描述
 */
public class BallUtils {

    public static String randomRedBall(){
        //在33个球的范围内,只要6个不一样的数字可以了
        Set<Integer> sets = new TreeSet<>(); // 有序,唯一
        //生成6个数
        while(sets.size()<6){
            //随机产生一个数字 1~33
            int i = new Random().nextInt(33)+1;
            sets.add(i);
        }
        //拼接字符串 : 02,06,13,22,29,31
        String redBalls ="";
        for (Integer i : sets) {
            redBalls += "," + String.format("%02d", i);
           /* String result="";
            if(i < 10){
                result ="0" + i;
            }else{
                result = i+"";
            }*/
        }
        redBalls = redBalls.substring(1);
        System.out.println(redBalls);

        return redBalls;
    }

    /**
     * 随机产生蓝球
     * @return
     */
    public static String randomBlueBall(){
        int i = new Random().nextInt(16)+1;
        return String.format("%02d", i);
    }
}
