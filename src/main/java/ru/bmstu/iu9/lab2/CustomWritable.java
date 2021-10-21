package ru.bmstu.iu9.lab2;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.Text;

import java.io.DataOutput;
import java.io.IOException;

public class CustomWritable implements Writable {
    private Text airportName;
    private IntWritable delayTime;

    public CustomWritable() {}

    public void write(DataOutput dataOutput) throws IOException {
        
    }

    public Text getAirportName() {
        return airportName;
    }
    public void setAirportName(Text airportName) {
        this.airportName = airportName;
    }

    public IntWritable getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(IntWritable delayTime) {
        this.delayTime = delayTime;
    }


}
