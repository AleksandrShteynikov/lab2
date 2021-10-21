package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {
    protected Comparator() {
        super(Key.class, true);
    }

    @Override
    public int compare(WritableComparable k1, WritableComparable k2) {
        Key key1 = (Key) k1;
        Key key2 = (Key) k2;
        return key1.compareFirst(key2);
    }
}