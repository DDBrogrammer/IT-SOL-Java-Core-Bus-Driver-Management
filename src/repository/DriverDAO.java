package repository;



import entity.Driver;
import main.MainRun;

import java.io.*;
import java.util.ArrayList;

public class DriverDAO implements DataAccessible<Driver,Integer> {
    private  File DRIVER_DATA_FILE = new File("DriverData.txt");
    public boolean save(Driver driver) {
        boolean ok;
        ArrayList<Driver> newDriverArrayList = new ArrayList();
        if( DRIVER_DATA_FILE.length()!=0 ) {
                newDriverArrayList= getAll();
                deleteAll();
                driver.setId(newDriverArrayList.size()+1);
                ok = MainRun.fileUtil.writeDataToFile(newDriverArrayList,DRIVER_DATA_FILE);
        }else {
            driver.setId(10000);
            newDriverArrayList.add(driver);
            ok=MainRun.fileUtil.writeDataToFile(newDriverArrayList,DRIVER_DATA_FILE);
        }
       return ok;
    }

    public boolean deleteAll() {
      return MainRun.fileUtil.deleteFileData(DRIVER_DATA_FILE);
    }

    public ArrayList<Driver> getAll() {
        ArrayList<Driver> driverArrayList = new ArrayList();
        if(DRIVER_DATA_FILE.length()!=0){
            driverArrayList= (ArrayList<Driver>) MainRun.fileUtil.readDataFromFile(DRIVER_DATA_FILE);
        }
        return driverArrayList;
    }

    public Driver findById(Integer id) {
        ArrayList<Driver> driverArrayList = getAll();
        Driver driver = new Driver();
        for (Driver d : driverArrayList) {
            if (d.getId()==id) {
                driver = d;
                break;

            }
        }
        return driver;

    }




}
