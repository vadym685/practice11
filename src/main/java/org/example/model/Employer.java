package org.example.model;

import java.util.Objects;

public class Employer {
    private int id;
    private String name;
    private String job;
    private int mgr;
    private String hiredate;
    private int sal;
    private int deptno;
    private String location;
    private String depName;
    private int grade;

    public Employer(int id, String name, String job, int mgr, String hiredate, int sal, int deptno, String location, String depName, int grade) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.deptno = deptno;
        this.location = location;
        this.depName = depName;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "\t"
                + name + "\t"
                + job + "\t"
                + mgr + "\t"
                + hiredate + "\t"
                + sal + "\t"
                + deptno + "\t"
                + location + "\t"
                + depName + "\t"
                + grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return id == employer.id && mgr == employer.mgr && sal == employer.sal
                && deptno == employer.deptno && Objects.equals(name, employer.name)
                && Objects.equals(job, employer.job) && Objects.equals(hiredate, employer.hiredate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, job, mgr, hiredate, sal, deptno);
    }
}
