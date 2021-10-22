package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, Key, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() != 0) {
            final String separator = ",";
            String[] flight = value.toString().split(separator, -1);
            if (!flight[17].equals("") && Float.parseFloat(flight[17]) > 0) {
                Key k = new Key(Integer.parseInt(flight[14]), 1);
                //CustomWritable val = new CustomWritable();
                //val.setAirportName(flight[14]);
                //val.setDelayTime((int) Float.parseFloat(flight[17]));
                context.write(k, new Text(String.valueOf((int) Float.parseFloat(flight[17]))));
            }
        }
    }
}