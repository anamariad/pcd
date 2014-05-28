package ro.infoiasi.pcd.hadoop;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;


public class SubjectAndGradeKeyPartitioner extends Partitioner<SubjectAndGradeKey, StudentAndGradeValue> {

    Partitioner<Text, StudentAndGradeValue> hashPartitioner = new HashPartitioner<>();
    Text newKey = new Text();

    @Override
    public int getPartition(SubjectAndGradeKey key, StudentAndGradeValue value, int numReduceTasks) {

        try {
            newKey.set(key.getSubject());
            return hashPartitioner.getPartition(newKey, value, numReduceTasks);
        } catch (Exception e) {
            e.printStackTrace();
            return (int) (Math.random() * numReduceTasks);
        }
    }
}
