package izobar.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    public void writeFinalDB(String outputFile) {

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;

            while ((line = reader.readLine()) != null) {
                // Разделим строку на поля по запятой
                String[] line_fields = line.split(",");

                // Используем StringBuilder для формирования новой строки
                StringBuilder newLine = new StringBuilder();

                // Проходим по полям и исключаем те, которые указаны в массиве columnsToRemove
                for (int i = 0; i < line_fields.length; i++) {
                    
                    switch (type.get(i)) {
                        case PERMANENT:
                            newLine.append(line_fields[i]).append(";");
                            break;

                        case MASKING:
                            newLine.append(masking.get(i)).append(";");

                        case DELETE:    
                            break;

                        default:
                            break;
                    }
                }

                // Удаляем последнюю запятую, если строка не пустая
                if (newLine.length() > 0) {
                    newLine.setLength(newLine.length() - 1); // Удаляем последнюю запятую
                }

                // Записываем новую строку в выходной файл
                writer.write(newLine.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
