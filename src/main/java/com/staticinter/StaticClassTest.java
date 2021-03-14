package com.staticinter;

/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2020-4-30 22:52:56
 */
public class StaticClassTest {
    public static void main(String[] args) {
        StaticClass.StaticInteriorClass staticInteriorClass = StaticClass.getStaticInteriorClass();
        staticInteriorClass.setSonAge(10);
        staticInteriorClass.setSonName("TOM");
        staticInteriorClass.setSonSex("男");

        //StaticClass staticClass = new StaticClass();
        //通过外部类直接去获取内部类的属性
        System.out.println(staticInteriorClass.getSonAge());
        StaticClass.StaticInteriorClass aClass = new StaticClass.StaticInteriorClass("张三", "男", 1);
        //数据显示思路
        //尝试1、把搜索框做好后，先把向左查看的结果复制一份放在点击搜索事件下面，在这上面进行修改
        //2、
    }
}
