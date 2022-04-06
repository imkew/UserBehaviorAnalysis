package com.bi.taobao;

import com.bi.taobao.source.KafkaSource;
import com.bi.taobao.source.MockSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

/**
 * @Author: kewang
 * @Date: 2022/4/6 17:09
 */
public class GenerateUserBehavior {
    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        final StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env);
        env.setParallelism(1);
        MockSource mockSource = new MockSource();
        KafkaSource kafkaSource = new KafkaSource();

        executeCreateSql(tableEnv,mockSource.ods_user_behavior(),kafkaSource.dwd_user_behavior());
        tableEnv.executeSql("insert into dwd_user_behavior select * from user_behavior").print();

    }
    private static void executeCreateSql(StreamTableEnvironment tableEnv, String ods_user_behavior, String dwd_user_behavior) {
        tableEnv.executeSql(ods_user_behavior);
        tableEnv.executeSql(dwd_user_behavior);
    }
}
