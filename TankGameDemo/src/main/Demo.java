package main;

public class Demo {
    //        String StringBuilder StringBuffer的区别，写出拼接4万个字符串的效率对比
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        for (int i = 0; i <= 40000; i++) {
            StringBuilder sql = new StringBuilder();
            sql.append("");
            sql.append("");
            sql.append("");
            sql.append("");
        }
        System.out.println("StringBuilder拼接四万个字符串所耗的时间为:" + (System.currentTimeMillis() - start1) + "ms");
        long start2 = System.currentTimeMillis();
        for (int i = 0; i <= 40000; i++) {
            StringBuffer sql = new StringBuffer();
            sql.append("");
            sql.append("");
            sql.append("");
            sql.append("");
        }
        System.out.println("StringBuffer拼接四万个字符串所耗的时间为:" + (System.currentTimeMillis() - start2) + "ms");
        long start3 = System.currentTimeMillis();
        String str= "";
        for (int i = 0; i <=40000; i++) {
            str+=i;
        }
        System.out.println("string拼接四万个字符串所耗的时间为:" + (System.currentTimeMillis() - start3) + "ms");
    }
    }

