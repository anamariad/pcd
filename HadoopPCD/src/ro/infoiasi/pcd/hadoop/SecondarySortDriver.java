package ro.infoiasi.pcd.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class SecondarySortDriver extends Configured implements Tool {

    @Override
    public int run(String[] args) throws Exception {

        Job job = new Job(getConf(), "word count");

        job.setJarByClass(SecondarySortDriver.class);
        job.setMapperClass(SecondarySortMapper.class);
        job.setReducerClass(SecondarySortReducer.class);

        job.setGroupingComparatorClass(SubjectAndGradeKeyGroupComparator.class);
        job.setPartitionerClass(SubjectAndGradeKeyPartitioner.class);
        job.setSortComparatorClass(SubjectAndGradeKeyComparator.class);

        job.setNumReduceTasks(2);

        job.setMapOutputKeyClass(SubjectAndGradeKey.class);
        job.setMapOutputValueClass(StudentAndGradeValue.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        return job.waitForCompletion(true) ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        System.exit(ToolRunner.run(conf, new SecondarySortDriver(), args));
    }
}