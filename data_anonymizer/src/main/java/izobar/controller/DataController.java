package izobar.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.exceptions.CsvValidationException;

import izobar.dao.ChangeableDB;
import izobar.service.DataService;

@RestController
public class DataController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private DataService dataService;

    @RequestMapping("/setDataBase")
    public String setDataBase(@RequestParam String dataBaseType, @RequestParam String fileName)
            throws CsvValidationException {

        dataService.setDataBase(dataBaseType, fileName);
        return "create succefully";
    }

    @RequestMapping("/writeDataBase")
    String writeDataBase(@RequestParam String fileName) {

        dataService.writeDataBase(fileName);

        return "write succefully";
    }

    @RequestMapping("/getFields")
    String getFields() {

        ArrayList<String> list = dataService.getFields();

        return list.toString();
    }
    
    @RequestMapping("/getType")
    String getType() {

        ArrayList<ChangeableDB.fieldsType> list = dataService.getType();

        return list.toString();
    }
    @RequestMapping("/getMasking")
    String getMasking() {

        ArrayList<String> list = dataService.getMasking();

        return list.toString();
    }

    @PostMapping("/setMasking")
    public ResponseEntity<String> setMasking(@RequestBody ArrayList<String> data) {
        try {
            dataService.setMasking(data); // Предполагается, что этот метод обрабатывает данные
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving data: " + e.getMessage());
        }
    }

    @PostMapping("/setFields")
    public ResponseEntity<String> setFields(@RequestBody ArrayList<String> data) {
        try {
            dataService.setFields(data); // Предполагается, что этот метод обрабатывает данные
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving data: " + e.getMessage());
        }
    }

    @PostMapping("/setType")
    public ResponseEntity<String> setType(@RequestBody ArrayList<ChangeableDB.fieldsType> data) {
        try {
            dataService.setType(data); // Предполагается, что этот метод обрабатывает данные
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving data: " + e.getMessage());
        }
    }

}
