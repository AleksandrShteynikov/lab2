package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.WritableComparator;

public class Comparator extends WritableComparator {
    protected Comparator() {
        super(Key.class, true);
    }

    @Override
    public int compare() {
        
    }
}
