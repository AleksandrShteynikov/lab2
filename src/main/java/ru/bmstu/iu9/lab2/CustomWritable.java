package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.Writable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class CustomWritable implements Writable {
    private String airportName;
    private int delayTime;

    public CustomWritable() {
        this.delayTime = 0;
        this.airportName = "";
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(delayTime);
        dataOutput.writeUTF(airportName);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.airportName = dataInput.readUTF();
        this.delayTime = dataInput.readInt();
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public int getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }
}