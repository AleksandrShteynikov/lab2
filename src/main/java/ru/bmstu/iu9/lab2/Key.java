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

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
        dataOutput.writeInt(dataType);
    }

    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readInt();
        this.dataType = dataInput.readInt();
    }


}
