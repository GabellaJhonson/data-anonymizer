package izobar.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.exceptions.CsvValidationException;

import izobar.service.DataService;

@RestController
public class DataController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    
    @Autowired
    private DataService dataService;

    @RequestMapping("/setDataBase")
    public String setDataBase(@RequestParam String dataBaseType, @RequestParam String fileName) throws CsvValidationException {
       
        dataService.setDataBase(dataBaseType, fileName);
        return "create succefully";
    }
    @RequestMapping("/getFields")
    String getFields() throws CsvValidationException {

        ArrayList<String> list = dataService.getFields();

        return list.toString();
    }
}
