package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class DelayReducer extends Reducer<Text, IntWritable, Text, Text> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int max = 0, min = 2147483647;
        int accum = 0;
        int count = 0;
        for (IntWritable val : values) {
            accum += val.get();
            count += 1;
            if (val.get() > max) {
                max = val.get();
            }
            if (val.get() < min) {
                min = val.get();
            }
        }
        int avg = accum / count;
        context.write(key, new Text("average: " + avg + ", min: " + min + ", max: " + max));
    }
}
