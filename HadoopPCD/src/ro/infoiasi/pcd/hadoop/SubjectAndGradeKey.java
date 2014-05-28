package ro.infoiasi.pcd.hadoop;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class SubjectAndGradeKey implements WritableComparable<SubjectAndGradeKey> {

    private String subject;
    private double grade;

    public SubjectAndGradeKey() {
    }

    public SubjectAndGradeKey(String subject, double grade) {

        this.subject = subject;
        this.grade = grade;
    }



    @Override
    public void readFields(DataInput in) throws IOException {

        subject = WritableUtils.readString(in);
        grade = in.readDouble();
    }

    @Override
    public void write(DataOutput out) throws IOException {

        WritableUtils.writeString(out, subject);
        out.writeDouble(grade);
    }

    @Override
    public int compareTo(SubjectAndGradeKey o) {

        int result = subject.compareTo(o.subject);
        if (0 == result) {
            result = -Double.compare(grade, o.grade);
        }
        return result;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CompositeKey{");
        sb.append("subject='").append(subject).append('\'');
        sb.append(", grade='").append(grade).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubjectAndGradeKey that = (SubjectAndGradeKey) o;

        if (Double.compare(that.grade, grade) != 0) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = subject != null ? subject.hashCode() : 0;
        temp = Double.doubleToLongBits(grade);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}