package ro.infoiasi.pcd.hadoop;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class SubjectAndGradeKeyGroupComparator extends WritableComparator {

    protected SubjectAndGradeKeyGroupComparator() {

        super(SubjectAndGradeKey.class, true);
    }

    @Override
    public int compare(WritableComparable w1, WritableComparable w2) {

        SubjectAndGradeKey key1 = (SubjectAndGradeKey) w1;
        SubjectAndGradeKey key2 = (SubjectAndGradeKey) w2;

        // (check on subject)
        return key1.getSubject().compareTo(key2.getSubject());
    }
}
