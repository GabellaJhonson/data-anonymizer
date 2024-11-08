package izobar.dao;

import java.util.LinkedList;

public abstract class ChangeableDB {
    private static LinkedList<String> fields;

    public LinkedList<String> getFields(){
        if(fields == null){
            setFields();
        }
        return fields;
    }

    public abstract void setFields();
} 