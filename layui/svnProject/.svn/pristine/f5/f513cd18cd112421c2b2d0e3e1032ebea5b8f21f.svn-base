package com.practis.utils;


import com.practis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CodeHelper {
    private int width=115;
    private int height=35;
    private int count=4;    //验证码个数
    private int xx=15;      //x轴的间隔数
    private int fontsize=50;
    private int codeY=16;   //y轴间隔数
    private char[] codes="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();
    /*
     * 获取生成的验证码图片 以及对应的验证码字符串
     */
    @Autowired
    private UserService userService;
    public Map<String,Object> createCodeAndPic(){
        Map<String,Object> map=new HashMap<String, Object>();
        //自定义一个画板
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        //定义一个画笔(从画板中获取)
        Graphics g=image.getGraphics();
        //定义一个随机类 用于取随机值
        Random r=new Random();
        //获取随机生成验证码
        StringBuffer sb=new StringBuffer();

        g.setColor(Color.getColor("F8F8F8"));
        //设置绘画的位置
        g.fillRect(0,0,width,height);
        //绘画边框
        g.setColor(Color.BLACK);
        g.drawRect(0,0,width-1,height-1);
        //设置绘画字体
        Font font=new Font("Comic Sans MS",Font.BOLD,fontsize);
        //生成随机干扰线
        int distrubCount=r.nextInt(30)+20;
        for(int i=0;i<distrubCount;i++){
            int x=r.nextInt(width);
            int y=r.nextInt(height);
            //控制线条的长度和倾斜角度
            int xl=r.nextInt(20);
            int yl=r.nextInt(20);
            g.drawLine(x,y,x+xl,y+yl);
        }
        for(int i=0;i<count;i++){
            g.setColor(new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
            //绘画字符  (传入随机的字符,设置x轴的位置,设置y轴的位置)
            String str=String.valueOf(codes[r.nextInt(codes.length)]);
            g.drawString(str,(i+1)*xx,codeY);
            sb.append(str);//添加到验证字符串
        }
        //存放验证码
        map.put("verify",sb);
        //存放对象图像
        map.put("image",image);
        return map;
    }
}
