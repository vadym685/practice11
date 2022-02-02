package org.example.controlers;

import org.example.dao.DAO;
import org.example.model.Employer;
import org.example.view.MainView;

public class ShowControllerImpl implements Controller{
    DAO dao;
    MainView mainView;

    public ShowControllerImpl(MainView view, DAO dao) {
        this.dao = dao;
        this.mainView = view;
    }

    @Override
    public void start() {
        int id = mainView.getId();
        Employer employer = dao.getEmployer(id);
        if(employer == null) {
            System.out.println("Employer with id " + id + " not found\n");
        } else {
            System.out.println(employer + "\n");
        }
        Controller controller = new MainControllerImpl(mainView, dao);
        controller.start();
    }
}
