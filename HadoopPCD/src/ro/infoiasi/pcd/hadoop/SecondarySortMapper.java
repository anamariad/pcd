package ro.infoiasi.pcd.hadoop;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SecondarySortMapper extends Mapper<LongWritable, Text, SubjectAndGradeKey, StudentAndGradeValue> {

    private static final String DELIM = ",";
    private SubjectAndGradeKey compositeKey = new SubjectAndGradeKey();
    private StudentAndGradeValue markValue = new StudentAndGradeValue();


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(DELIM);

        double grade = Double.parseDouble(fields[2]);
        compositeKey.setGrade(grade);
        compositeKey.setSubject(fields[0]);

        markValue.setStudent(fields[1]);
        markValue.setGrade(grade);

        context.write(compositeKey, markValue);
    }
}
