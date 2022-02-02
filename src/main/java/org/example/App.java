package org.example;

import org.example.controlers.Controller;
import org.example.controlers.MainControllerImpl;
import org.example.dao.DAO;
import org.example.dao.DAOImpl;
import org.example.view.MainView;


public class App 
{
    public static void main(String[] args){

        DAO dao = new DAOImpl();
        MainView view = new MainView();
        Controller controller = new MainControllerImpl(view, dao);
        controller.start();
    }
}
