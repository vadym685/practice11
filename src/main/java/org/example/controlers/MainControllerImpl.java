package org.example.controlers;

import org.example.dao.DAO;
import org.example.model.Employer;
import org.example.view.MainView;

import java.util.List;

public class MainControllerImpl implements Controller{
    MainView mainView;
    DAO dao;
    Controller controller;

    public MainControllerImpl(MainView view, DAO dao) {
        this.dao = dao;
        this.mainView = view;

    }

    public void start() {
        int select = mainView.show();
        switch (select) {
            case 1:
                showAllEmployers();
            case 2:
                controller = new ShowControllerImpl(mainView, dao);
                controller.start();
            case 3:
                controller = new AddControllerImpl(mainView, dao);
                controller.start();
            case 4:
                controller = new UpdateEmployerControllerImpl(mainView, dao);
                controller.start();
            case 5:
                controller = new RemoveControllerImpl(mainView, dao);
                controller.start();
            case 6:
                System.exit(0);
        }

    }

    private void showAllEmployers() {
        System.out.println("ID\tName\tJob\tManager\tHiredate\tSalary\tDeptNumber\tLocation\tDeptName\tGrade");
        List<Employer> employerList = dao.getAllEmployers();
        employerList.forEach(System.out::println);
        System.out.println("");
        start();
    }
}
