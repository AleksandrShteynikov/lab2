package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class CustomPartitioner extends Partitioner<Key, Text> {
    @Override
    public int getPartition(Key key, Text value, int numPartitions) {
        return (key.getId() & Integer.MAX_VALUE) % numPartitions;
    }
}