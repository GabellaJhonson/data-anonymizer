package izobar.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class TextFileDAO extends ChangeableDB{
    
    public TextFileDAO(String fileName) throws CsvValidationException{
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String[] header = reader.readNext();
            if (header != null) {

                fields = new ArrayList<String> (Arrays.asList(header));
                
                System.out.println("Field names: " + fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setFields(){

    }
    
}
