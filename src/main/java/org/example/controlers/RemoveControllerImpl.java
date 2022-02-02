package org.example.controlers;

import org.example.dao.DAO;
import org.example.view.MainView;


public class RemoveControllerImpl implements Controller{
    DAO dao;
    MainView mainView;

    public RemoveControllerImpl(MainView view, DAO dao) {
        this.dao = dao;
        this.mainView = view;
    }

    @Override
    public void start() {
        int id = mainView.getId();
        dao.removeEmployer(id);
        System.out.println("Employer with id " + id + " is removed successfully");
        Controller controller = new MainControllerImpl(mainView, dao);
        controller.start();
    }
}
