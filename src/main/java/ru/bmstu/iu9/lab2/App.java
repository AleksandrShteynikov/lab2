package ru.bmstu.iu9.lab2;

import org.apache.hadoop.mapreduce.Job;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: App <input path> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(App.class);
        job.setJobName("App");
    }
}
