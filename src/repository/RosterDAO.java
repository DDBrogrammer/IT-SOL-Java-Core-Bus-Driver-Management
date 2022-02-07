package repository;

import entity.Driver;
import entity.Roster;
import entity.Route;
import main.MainRun;

import java.io.*;
import java.util.*;

public class RosterDAO implements DataAccessible<Roster,Integer> {
    private File ROSTER_DATA_FILE = new File("RosterData.txt");

    @Override
    public boolean save(Roster roster) {
        boolean checkSave = false;
        ArrayList<Roster> newRosterArrayList = new ArrayList();
        int driverId=roster.getDriver().getId();
        if( ROSTER_DATA_FILE.length()!=0 ) {
                // Read objects
                ArrayList<Roster> fileRosterArrayList = getAll();
                if(findById(driverId).getDriver().getId()==roster.getDriver().getId()){
                    for(Roster ros:fileRosterArrayList){
                        if(ros.getDriver().getId()==roster.getDriver().getId()){
                            ros.setRouteList(roster.getRouteList());
                            ros.setDriver(roster.getDriver());
                        }
                    }
                }else {
                    fileRosterArrayList.add(roster);
                }
                deleteAll();
                checkSave = MainRun.fileUtil.writeDataToFile(fileRosterArrayList,ROSTER_DATA_FILE);
        }else {
            newRosterArrayList.add(roster);
            checkSave = MainRun.fileUtil.writeDataToFile(newRosterArrayList,ROSTER_DATA_FILE);
        }
        return checkSave;
    }

    public boolean deleteAll() {
        return MainRun.fileUtil.deleteFileData(ROSTER_DATA_FILE);
    }

    public ArrayList<Roster> getAll() {
        ArrayList<Roster> rosterArrayList = new ArrayList();
        if(ROSTER_DATA_FILE.length()!=0){
            rosterArrayList= (ArrayList<Roster>) MainRun.fileUtil.readDataFromFile(ROSTER_DATA_FILE,rosterArrayList);
        }return rosterArrayList;
    }

    public Roster findById(Integer id) {
        ArrayList<Roster> rosterArrayList = getAll();
        Driver driver = new Driver("","","",0,"");
        Route route =new Route(0,0,0);
        int totalRoute=0;
        Map<Route,Integer> routeList= new HashMap<Route,Integer>();
        routeList.put(route,totalRoute);
        Roster roster = new Roster(driver,routeList);
        for (Roster d : rosterArrayList) {
            if (d.getDriver().getId()==id) {
                roster = d;
                break;
            }
        }
        return roster;

    }

}
