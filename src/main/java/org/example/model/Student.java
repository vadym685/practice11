package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String lastname;
    private String groupnumber;
    private String firstname;
    private double average;
    private double fixAverage = 0;
    private ArrayList<Subject> subjectList;

    public Student(String lastname, String groupnumber, String firstname, double average, ArrayList<Subject> subjectList) {
        this.lastname = lastname;
        this.groupnumber = groupnumber;
        this.firstname = firstname;
        this.average = average;
        this.subjectList = subjectList;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGroupnumber() {
        return groupnumber;
    }

    public void setGroupnumber(String groupnumber) {
        this.groupnumber = groupnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(ArrayList<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public double getFixAverage() {
        return fixAverage;
    }

    public void setFixAverage(double fixAverage) {
        this.fixAverage = fixAverage;
    }
}
