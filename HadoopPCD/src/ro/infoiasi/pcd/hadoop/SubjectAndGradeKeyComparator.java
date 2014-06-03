package ro.infoiasi.pcd.hadoop;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class SubjectAndGradeKeyComparator extends WritableComparator {

    protected SubjectAndGradeKeyComparator() {
        super(SubjectAndGradeKey.class, true);
    }
    @Override
    public int compare(WritableComparable w1, WritableComparable w2) {

        SubjectAndGradeKey key1 = (SubjectAndGradeKey) w1;
        SubjectAndGradeKey key2 = (SubjectAndGradeKey) w2;

        // (first check on subject)
        return key1.compareTo(key2);

    }
}
