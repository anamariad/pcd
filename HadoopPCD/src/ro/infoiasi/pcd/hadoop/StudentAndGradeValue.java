package ro.infoiasi.pcd.hadoop;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class StudentAndGradeValue implements Writable {

    private double grade;
    private String student;

    public StudentAndGradeValue() {
    }

    public StudentAndGradeValue(double grade, String student) {

        this.grade = grade;
        this.student = student;
    }


    @Override
    public void readFields(DataInput in) throws IOException {

        grade = in.readDouble();
        student = WritableUtils.readString(in);
    }

    @Override
    public void write(DataOutput out) throws IOException {

        out.writeDouble(grade);
        WritableUtils.writeString(out, student);
    }

    /**
     * Gets the student.
     *
     * @return Datetime
     */
    public String getStudent() {

        return student;
    }

    public void setStudent(String student) {

        this.student = student;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CompositeKey{");
        sb.append("grade='").append(grade).append('\'');
        sb.append(", student='").append(student).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentAndGradeValue that = (StudentAndGradeValue) o;

        if (Double.compare(that.grade, grade) != 0) return false;
        if (student != null ? !student.equals(that.student) : that.student != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(grade);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (student != null ? student.hashCode() : 0);
        return result;
    }
}