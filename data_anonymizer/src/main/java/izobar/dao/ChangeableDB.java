package izobar.dao;

import java.util.ArrayList;

public abstract class ChangeableDB {
    protected static ArrayList<String> fields;
    protected static ArrayList<String> type;
    protected static ArrayList<String> masking;

    public ArrayList<String> getFields(){
        if(fields == null){
            setFields();
        }
        return fields;
    }

    public abstract void setFields();
} 