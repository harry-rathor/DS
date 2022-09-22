package ds;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class FlinkDemo {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env= ExecutionEnvironment.getExecutionEnvironment();
        DataSet<String> text=env.fromElements("harish","My dataset API Flink Program");
        DataSet<Tuple2<String,Integer>> wordcount=text.flatMap(new LineSplitter()).groupBy(0).sum(1);
        wordcount.print();
    }
    public static class LineSplitter implements FlatMapFunction<String,Tuple2<String,Integer>> {


        @Override
        public void flatMap(String line, Collector<Tuple2<String, Integer>> out) throws Exception {
            for (String s:line.split(" ")){
                out.collect(new Tuple2<>(s,1));
            }
        }
    }
}
