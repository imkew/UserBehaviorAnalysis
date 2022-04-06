package com.bi.taobao.source;

/**
 * @Author: kewang
 * @Date: 2022/4/6 18:49
 */
public class KafkaSource {
    public String dwd_user_behavior() {
        return "CREATE TABLE space_gateway_log (\n" +
                "    log_time string,\n" +
                "    level string ,\n" +
                "    message string\n" +
                ")\n" +
                "WITH (\n" +
                "    'connector' = 'kafka',\n" +
                "    'topic' = 'dwd_user_behavior',\n" +
                "    'properties.bootstrap.servers' = 'kafka1:9092,kafka2:9092,kafka3:9092',\n" +
                "    'properties.group.id' = 'dwd_user_behavior ',\n" +
                "    'format' = 'json',\n" +
                "    'scan.startup.mode' = 'earliest-offset',\n" + //'earliest-offset', 'latest-offset'
                "    'json.fail-on-missing-field' = 'false',\n" + //Whether to fail if a field is missing or not.
                "    'json.ignore-parse-errors' = 'true'\n" + //Skip fields and rows with parse errors instead of failing. Fields are set to null in case of errors.
                ")";
    }
}
