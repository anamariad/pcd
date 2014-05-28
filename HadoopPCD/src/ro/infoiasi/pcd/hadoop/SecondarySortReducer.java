package ro.infoiasi.pcd.hadoop;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class SecondarySortReducer extends Reducer<SubjectAndGradeKey, StudentAndGradeValue, Text, Text> {

    private Text subject = new Text();
    private Text best = new Text();

    @Override
    protected void reduce(SubjectAndGradeKey key, Iterable<StudentAndGradeValue> values, Context context) throws IOException, InterruptedException {

        // output first 3 names of best students
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (StudentAndGradeValue value : values) {

            if (i < 3) {
                sb.append(value.getStudent());
                sb.append(",");
            }
            else {
                break;
            }
            ++i;
        }
        subject.set(key.getSubject());
        best.set(sb.toString());
        context.write(subject, best);

    }
}
