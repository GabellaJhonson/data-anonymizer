package izobar.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvDAO extends ChangeableDB {

    public CsvDAO(String fileName) {
        super(fileName);
    }

    public void firstReadDB(String fileName) {
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            String[] header = reader.readNext();
            if (header != null) {

                fields = new ArrayList<String>(Arrays.asList(header));

                System.out.println("Field names: " + fields);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public void writeFinalDB(String filename) {
        
    }

}
