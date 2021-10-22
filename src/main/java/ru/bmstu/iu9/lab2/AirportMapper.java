package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, Key, CustomWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() != 0) {
            final String separator = ",";
            final String trimmer = "\"";
            String[] airport = value.toString().split(separator, 2);
            airport[0] = StringUtils.strip(airport[0], trimmer);
            airport[1] = StringUtils.strip(airport[1], trimmer);
            CustomWritable val = new CustomWritable();
            val.setAirportName(airport[1]);
            println(airport[1]);
            Key k = new Key(Integer.parseInt(airport[0]), 0);
            context.write(k, val);
        }
    }
}