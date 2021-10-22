package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.commons.lang3.StringUtils;

public class AirportMapper extends Mapper<LongWritable, Text, Key, CustomWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) {
        if (key.get() != 0) {
            String[] airport = StringUtils.strip()
        }
    }
}
