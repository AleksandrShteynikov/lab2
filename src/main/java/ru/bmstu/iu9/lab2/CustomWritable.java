package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.Text;

public class CustomWritable implements Writable {
    private Text airportName;
    private IntWritable delayTime;
}
