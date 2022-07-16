package cn.thinkmoon.blog.utils;

public class TimeUtils {
    public static int getNow(){
        return (int) (System.currentTimeMillis() / 1000);
    }
}
