package util.file;

import entity.Roster;

import java.io.*;
import java.util.ArrayList;

public class FileUtil implements DataReadable,DataWriteable,DataDeletable{
    public  boolean writeDataToFile(Object obj, File file){
        boolean ok=false;
        try {
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(obj);
            o.flush();
            o.close();
            ok = true;
        } catch (EOFException eof) {
            // end of file reached, do nothing
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Error initializing stream");
        } finally {
            return ok;
        }
    }
    public  Object readDataFromFile(File file){
        Object obj=new Object();
        if(file.length()!=0){
            try {
                FileInputStream fi = new FileInputStream(file);
                ObjectInputStream oi = new ObjectInputStream(fi);
                // Read objects
                obj = oi.readObject();
                oi.close();
                fi.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (EOFException e) {
            } catch (IOException e) {
                System.out.println("Error initializing stream");
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                return obj;
            }

        }
        return obj;
    }


    public  ArrayList<Roster> readDataFromFile(File file, ArrayList<Roster> arrayList){
        ArrayList<Roster> rosterList=new ArrayList<Roster>();
        if(file.length()!=0){
            try {
                FileInputStream fi = new FileInputStream(file);
                ObjectInputStream oi = new ObjectInputStream(fi);
                // Read objects
                rosterList= (ArrayList<Roster>) oi.readObject();
                oi.close();
                fi.close();
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (EOFException e) {
            } catch (IOException e) {
                System.out.println("Error initializing stream");
                System.out.println(e);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                return rosterList;
            }

        }
        return rosterList;
    }
    public  boolean deleteFileData(File file){
        boolean ok = false;
        try {
            new FileOutputStream(file).close();
            ok=true;}
        catch (EOFException eof) {
            // end of file reached, do nothing
        } catch (FileNotFoundException e) {
            ok = false;
            System.out.println("File not found");
        } catch (IOException e) {
            ok = false;
            System.out.println(e);
            System.out.println("Error initializing stream");
        } finally {
            return ok;
        }
    }


}
