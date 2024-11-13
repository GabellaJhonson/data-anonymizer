package izobar.dao;

import java.util.ArrayList;
import java.util.Collections;

public abstract class ChangeableDB {
    protected static String inputFile;
    protected static ArrayList<String> fields;
    protected static ArrayList<fieldsType> type;
    protected static ArrayList<String> masking;
    public enum fieldsType {

        PERMANENT,
        DELETE,
        MASKING
     }

    protected ChangeableDB(String fileName) {

        inputFile = fileName;
        //this method should fill FieldsList by implemented methods
        firstReadDB(fileName);
        //after this fill TypeList and MaskingList with the same size FieldsList
        type = new ArrayList<fieldsType>(Collections.nCopies(fields.size(), fieldsType.PERMANENT));
        masking = new ArrayList<String>(Collections.nCopies(fields.size(), ""));
     }
    public static ArrayList<String> getFields() {
        return fields;
    }

    public static void setFields(ArrayList<String> fields) {
        ChangeableDB.fields = fields;
    }

    public static ArrayList<fieldsType> getType() {
        return type;
    }

    public static void setType(ArrayList<fieldsType> type) {
        ChangeableDB.type = type;
    }

    public static ArrayList<String> getMasking() {
        return masking;
    }

    public static void setMasking(ArrayList<String> masking) {
        ChangeableDB.masking = masking;
    }

    public abstract void firstReadDB(String fileName);

    public abstract void writeFinalDB(String fileName);
}
