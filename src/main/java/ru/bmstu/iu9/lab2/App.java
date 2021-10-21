package ru.bmstu.iu9.lab2;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Usage: App <input path1> <input path2> <output path>");
            System.exit(-1);
        }
        Job job = Job.getInstance();
        job.setJarByClass(App.class);
        job.setJobName("App");
        MultipleInputs.addInputPath(job, new Path(args[0], TextInputFormat.class, ))
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setReducerClass(DelayReducer.class);
        job.setPartitionerClass(CustomPartitioner.class);
        job.setGroupingComparatorClass(Comparator.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
    }
}
