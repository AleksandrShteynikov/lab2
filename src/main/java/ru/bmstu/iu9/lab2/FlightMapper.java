package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlightMapper extends Mapper<LongWritable, Text, Key, CustomWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) {

    }
}
