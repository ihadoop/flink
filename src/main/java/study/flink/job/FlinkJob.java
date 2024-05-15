package study.flink.job;

import jakarta.annotation.PostConstruct;
import org.apache.flink.api.common.JobExecutionResult;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kinesis.FlinkKinesisConsumer;
import org.apache.flink.streaming.connectors.kinesis.config.AWSConfigConstants;
import org.apache.flink.streaming.connectors.kinesis.config.ConsumerConfigConstants;
import org.springframework.stereotype.Service;

import java.util.Properties;
@Service
public class FlinkJob {

    @PostConstruct
    public  void init() throws Exception {

        Properties consumerConfig = new Properties();
        consumerConfig.put(AWSConfigConstants.AWS_REGION, "us-east-1");
        consumerConfig.put(AWSConfigConstants.AWS_ACCESS_KEY_ID, "aws_access_key_id");
        consumerConfig.put(AWSConfigConstants.AWS_SECRET_ACCESS_KEY, "aws_secret_access_key");
        consumerConfig.put(ConsumerConfigConstants.STREAM_INITIAL_POSITION, "LATEST");

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> kinesis = env.addSource(new FlinkKinesisConsumer<>(
                "kinesis_stream_name", new SimpleStringSchema(), consumerConfig));




//
//        kinesis.map().
//        data
//                .filter(new FilterFunction<String>() {
//                    public boolean filter(String value) {
//                        return true;
//                    }
//                })
//                .writeAsText("file:///Users/sunshine/Downloads/1.json");

       // kinesis.addSink()
        JobExecutionResult res = env.execute();
    }
}
