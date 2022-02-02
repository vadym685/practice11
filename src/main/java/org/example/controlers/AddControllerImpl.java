package org.example.controlers;

import org.example.dao.DAO;
import org.example.model.Employer;
import org.example.view.MainView;

public class AddControllerImpl implements Controller{
    MainView mainView;
    DAO dao;

    public AddControllerImpl(MainView view, DAO dao) {
        this.mainView = view;
        this.dao = dao;
    }

    @Override
    public void start() {
        int id = mainView.getId();
        Employer employer = dao.getEmployer(id);
        if(employer != null) {
            System.out.println("Employer id is no unique. Try again!");
            start();
        }
        String name = mainView.getName();
        String job = mainView.getJob();
        int mgr = mainView.getMgr();
        String hiredate = mainView.getHireDate();
        int sal = mainView.getSalary();
        int deptno = mainView.getDeptNo();
        dao.addEmployer(id, name, job, mgr, hiredate, sal, deptno);
        Controller controller = new MainControllerImpl(mainView, dao);
        controller.start();
    }
}
