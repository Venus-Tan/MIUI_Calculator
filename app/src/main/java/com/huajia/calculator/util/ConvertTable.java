package com.huajia.calculator.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇率表
 *
 * @author: huajia
 * @date: 2023/8/6 18:32
 */

public class ConvertTable {

    public static final List<ConvertBean> list = new ArrayList<>();

    static {
        //汇率表
        list.add(new ConvertBean("人民币","美元",0.1395,7.1708));
        list.add(new ConvertBean("人民币","欧元",0.1267,7.8952));
        list.add(new ConvertBean("美元","欧元",0.9082,1.1011));

        //长度表
        list.add(new ConvertBean("米","厘米",1,100));
    }

    public static double findRateValue(String key1,String key2){
        for (ConvertBean convertBean : list) {
            double value = convertBean.findValue(key1, key2);
            if (value != 0){
                return value;
            }
        }
        return 0;
    }


}

class ConvertBean{
    private String key1;  //货币一
    private String key2;  //货币二
    private double value1; //key1 -> key2 汇率
    private double value2; //key2 -> key1 汇率

    public ConvertBean(String key1,String key2,double value1,double value2){
        this.key1 = key1;
        this.key2 = key2;
        this.value1 = value1;
        this.value2 = value2;
    }


    public double findValue(String key1,String key2){
        if (key1 == this.key1 && key2 == this.key2){
            return value1;
        } else if (key1 == this.key2 && key2 == this.key1) {
            return value2;
        }else{
            return 0;
        }
    }
}
