package hu.unideb.inf;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Student {
        private StringProperty name = new SimpleStringProperty();
        private int credits;
        private LocalDate dateOfBirth;

    public Student(String name, int credits, LocalDate dateOfBirth) {
        this.name.setValue(name);
        this.credits = credits;
        this.dateOfBirth = dateOfBirth;
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public StringProperty nameProperty(){
        return name;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String getName() {
        return name.getValue();
    }

    public int getCredits() {
        return credits;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
