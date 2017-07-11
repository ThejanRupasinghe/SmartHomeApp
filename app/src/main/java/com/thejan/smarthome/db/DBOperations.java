package com.thejan.smarthome.db;

public class DBOperations {
    private static DBOperations instance;   // singleton instance
    private static DBHelper dbHelper;

    private DBOperations(){
        // TODO:: Initialize DBHelper instance
    }

    public static DBOperations getInstance(){
        instance = new DBOperations();
        return instance;
    }

    public void addRecord(){
        // TODO:: Implement Logic
    }

    public void getAllRecords(){
        // TODO:: Implement Logic
    }

    public void getRecord(int id){
        // TODO:: Implement Logic
    }

    public void removeRecord(){
        // TODO:: Implement Logic
    }
}
