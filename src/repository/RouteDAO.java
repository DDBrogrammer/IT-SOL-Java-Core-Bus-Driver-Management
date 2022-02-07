package repository;
import entity.Route;
import main.MainRun;
import util.file.FileUtil;

import java.io.*;
import java.util.ArrayList;

public class RouteDAO implements DataAccessible<Route,Integer>{

    private final File ROUTE_DATA_FILE = new File("RouteData.txt");
    public boolean save(Route route) {
        boolean ok = false;
        ArrayList<Route> newRouteArrayList = new ArrayList<>();
        if( ROUTE_DATA_FILE.length()!=0 ) {
            newRouteArrayList=getAll();
            deleteAll();
            route.setId(newRouteArrayList.size()+100);
            newRouteArrayList.add(route);
            ok= MainRun.fileUtil.writeDataToFile(newRouteArrayList,ROUTE_DATA_FILE);

        }else {
                route.setId(100);
                newRouteArrayList.add(route);
                ok =MainRun.fileUtil.writeDataToFile(newRouteArrayList,ROUTE_DATA_FILE);
        }
        return ok;

    }
    public boolean deleteAll() {
       return MainRun.fileUtil.deleteFileData(ROUTE_DATA_FILE);
    }
    public ArrayList<Route> getAll() {
        ArrayList<Route> routeArrayList =new ArrayList<Route>();
        if(ROUTE_DATA_FILE.length()!=0){
            routeArrayList= (ArrayList<Route>) MainRun.fileUtil.readDataFromFile(ROUTE_DATA_FILE);
        }
        return routeArrayList;
    }
    public Route findById(Integer id) {
        ArrayList<Route> routeArrayList = getAll();
        Route driver = new Route();
        for (Route d : routeArrayList) {
            if (d.getId()==id) {
                driver = d;
                break;
            }
        }
        return driver;

    }

}
