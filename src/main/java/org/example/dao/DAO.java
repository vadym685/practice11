package org.example.dao;

import org.example.model.Employer;

import java.util.List;

public interface DAO {
    void connect() throws ClassNotFoundException;

    void disconnect();

    void addEmployer(int id, String name, String job, int mgr, String hiredate, int sal, int deptno);

    void updateEmployer(int number, String name);

    List<Employer> getAllEmployers();
    Employer getEmployer(int id);

    void removeEmployer(int number);

}
