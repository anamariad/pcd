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
        int compare = key1.getSubject().compareTo(key2.getSubject());

        if (compare == 0) {
            // only if we are in the same input group should we try and sort by student name
            return -Double.compare(key1.getGrade(), key2.getGrade());
        }

        return compare;
    }
}
