package hu.unideb.inf;

import java.time.LocalDate;
import java.time.Month;

public class Model {
    private Student student;

    public Model() {
        student = new Student("Rob Smith", 55, LocalDate.of(1991, Month.DECEMBER,3));
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
