package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Key implements WritableComparable<Key> {
    private int id;
    private int dataType;

    public Key(int id, int dataType) {
        this.id = id;
        this.dataType = dataType;
    }

    public int getId() {
        return id;
    }

    public int getDataType() {
        return dataType;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
        dataOutput.writeInt(dataType);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readInt();
        this.dataType = dataInput.readInt();
    }

    @Override
    public int compareTo(Key key) {
        if (this.id < key.id) {
            return -1;
        }
        if (this.id > key.id) {
            return 1;
        }
        if (this.dataType < key.dataType) {
            return -1;
        }
        if (this.dataType > key.dataType) {
            return 1;
        }
        return 0;
    }

    public int compareFirst(Key key) {
        return (this.id < key.id ? -1 : (this.id > key.id ? 1 : 0));
    }
}
