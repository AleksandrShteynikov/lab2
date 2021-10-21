package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.Text;

import java.io.DataOutput;
import java.io.IOException;

public class CustomWritable implements Writable {
    private String airportName;
    private int delayTime;

    public CustomWritable() {}

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(delayTime);
        dataOutput.writeUTF(airportName);
    }

    public void readFields(DataIn dataIn) {
        
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
