package com.imooc.ad.dump;

public class DConstant {
//    定义最终的存放的地方
    public static  final String DATA_ROOT_DIR = "D:\\code\\java\\imooc-ad-spring-cloud\\data";

//    定义每一个表名字
// 各个数据表的文件名称
    public static final String AD_PLAN = "ad_plan.data";
    public static final String AD_UNIT = "ad_unit.data";
    public static final String AD_CREATIVE = "ad_creative.data";
    public static final String AD_CREATIVE_UNIT = "ad_creative_unit.data";
    public static final String AD_UNIT_IT = "ad_unit_it.data";
    public static final String AD_UNIT_DISTRICT = "ad_unit_district.data";
    public static final String AD_UNIT_KEYWORD = "ad_unit_keyword.data";
    public static void main(String[] args) {
        System.out.println(String.format("%s%s", DConstant.DATA_ROOT_DIR, DConstant.AD_PLAN));
    }
}
