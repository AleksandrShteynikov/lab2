package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
import java.util.Iterator;

public class DelayReducer extends Reducer<Key, Text, Text, Text> {
    @Override
    protected void reduce(Key key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //int max = 0, min = 2147483647;
        int max = 0, min = 1000;
        int accum = 0;
        int count = 0;
        String airportName;
        Iterator<Text> itr = values.iterator();
        airportName = itr.next().toString();
        while (itr.hasNext()) {
            int val = Integer.parseInt(itr.next().toString());
            accum += val;
            count += 1;
            if (val > max) {
                max = val;
            }
            if (val < min) {
                min = val;
            }
        }
        if (count != 0) {
            int avg = accum / count;
            context.write(new Text(String.valueOf(key.getId())), new Text("average: " + avg + ", min: " + min + ", max: " + max));
        }
    }
}