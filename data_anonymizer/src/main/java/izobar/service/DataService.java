package izobar.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import izobar.dao.ChangeableDB;
import izobar.dao.ChangeableDB.fieldsType;
import izobar.dao.CsvDAO;
import izobar.dao.MongodbDAO;
import izobar.dao.PostgresDAO;
import izobar.dao.SqliteDAO;

@Service
public class DataService {
    static ChangeableDB dataBase;

    public void setDataBase(String dataBaseType, String fileName){
        switch (dataBaseType) {
            case "csv":
                dataBase = new CsvDAO(fileName);
                break;
            case "postgres":
                dataBase = new PostgresDAO(fileName);
                break;
            case "sqlite":
                dataBase = new SqliteDAO(fileName);
                break;  
            case "mongodb":
                dataBase = new MongodbDAO(fileName);
                break;  
            default:
                // throw exception
                break;
        }
    }

    public void writeDataBase(String fileName){
        dataBase.writeFinalDB(fileName);
    }

    public ArrayList<String> getFields() {
        return ChangeableDB.getFields();
    }

    public void setFields(ArrayList<String> fields) {
        ChangeableDB.setFields(fields);
    }

    public ArrayList<fieldsType> getType() {
        return ChangeableDB.getType();
    }

    public void setType(ArrayList<fieldsType> type) {
        ChangeableDB.setType(type);
    }

    public ArrayList<String> getMasking() {
        return ChangeableDB.getMasking();
    }

    public void setMasking(ArrayList<String> masking) {
        ChangeableDB.setMasking(masking);
    }
}
