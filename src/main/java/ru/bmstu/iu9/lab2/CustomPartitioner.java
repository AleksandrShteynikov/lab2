package ru.bmstu.iu9.lab2;

import org.apache.hadoop.mapreduce.Partitioner;

public class CustomPartitioner extends Partitioner<Key, CustomWritable> {
    @Override
    public int getPartition(Key key, CustomWritable value, int numPartitions) {
        return (key.getId() & Integer.MAX_VALUE) % numPartitions;
    }
}
