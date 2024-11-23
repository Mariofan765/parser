package org.mariofan765.parser.controller;

import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mariofan765.parser.service.ParserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("parser")
@AllArgsConstructor
public class ParserController {

    private final ParserService service;

    @PostMapping
    public void uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        service.uploadFile(file);

    }
}

