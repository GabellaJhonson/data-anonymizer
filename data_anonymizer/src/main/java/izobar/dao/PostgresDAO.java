package izobar.dao;

public class PostgresDAO extends ChangeableDB{
    
     public PostgresDAO(String fileName) {
        super(fileName);
    }

    public void firstReadDB(String fileName) {

        // this method should reading fields from your DB and writing them to ArrayList fields
        // see example in TextFileDAO

    }

    public void writeFinalDB(String filename) {
        
        // this method should filtering your data considering DELETE, PERMANENT and MASKING data.
        // this become possible by providing 3 lists: fields, masking, fieldsType

        // switch fieldsType[i]:
        //  case DELETE:
        //      just delete fields[i] column
        //  case PERMANENT:
        //      just leave fields[i] column and transfer to a new DataBase
        //  case MASKING:
        //      go to masking[i] and change all data from fields[i] column to masking[i]
        //      for example: field Phone --> "3751234567" if masking[i] = 3751234567 (and this have to work for all cells!)


        // see example in TextFileDAO
    }   
}
