package org.example.controlers;

import org.example.dao.DAO;
import org.example.view.MainView;

public class UpdateEmployerControllerImpl implements Controller{
    DAO dao;
    MainView mainView;

    public UpdateEmployerControllerImpl(MainView view, DAO dao) {
        this.dao = dao;
        this.mainView = view;
    }

    @Override
    public void start() {
        int id = mainView.getId();
        String name = mainView.getName();
        dao.updateEmployer(id, name);
        System.out.println("Update is successfully\n");
        Controller controller = new MainControllerImpl(mainView, dao);
        controller.start();
    }
}
