package org.mariofan765.parser.service;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ParserService {

    private final List<String> namesOfSheets = new ArrayList<>();


    public void uploadFile(MultipartFile file) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        setNamesOfSheets();
        List<Object> allNames = getBaseNameList(workbook);
    }

    public void setNamesOfSheets() {
        namesOfSheets.add("Сводная  (копия)");
        namesOfSheets.add("Наставники");
    }

    private List<Object> getBaseNameList(XSSFWorkbook workbook) {
        List<Object> allNames = new ArrayList<>();
        Sheet sheet = workbook.getSheet(namesOfSheets.get(0));
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            if(!sheet.getRow(i).getCell(0).getStringCellValue().isEmpty()) {
                parseMentorsSheet(workbook, sheet.getRow(i).getCell(0).getStringCellValue());
            }
            if(sheet.getRow(i+1).getCell(0).getStringCellValue().equals("Всего отдадим в СДЭК")) break;
        }

        return allNames;
    }

    private Map<String, Object> parseMentorsSheet(XSSFWorkbook workbook, String stringCellValue) {
        Sheet sheet = workbook.getSheet(namesOfSheets.get(1));
        for (int i = 2; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if(row.getCell(0).getStringCellValue().equals(stringCellValue)) {
                Map<String, Object> result = new HashMap<>();
                result.put("name", stringCellValue);
                result.put("")
            }

        }
    }

}
