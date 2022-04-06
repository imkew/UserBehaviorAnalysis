package com.bi.taobao.source;

/**
 * @Author: kewang
 * @Date: 2022/4/6 18:26
 */
public class MockSource {

    public String ods_user_behavior() {
        return "CREATE TABLE ods_user_behavior (\n" +
                "    user_id bigint,\n" +
                "    item_id bigint,\n" +
                "    category_id bigint,\n" +
                "    behavior string,\n" +
                "    ts string\n" +
                ")\n" +
                "WITH (\n" +
                "    'connector' = 'filesystem',\n" +
                "    'path' = 'D:\\code\\user-behavior-analysis\\user-behavior-analysis\\src\\main\\resources\\UserBehavior.csv',\n" +
                "    'format' = 'csv'\n" +
                ")";
    }

}
