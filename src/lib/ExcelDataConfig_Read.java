/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package lib;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author mhd
 */
public class ExcelDataConfig_Read {

    HSSFWorkbook workbook;
    HSSFSheet sheet;
    File f;
    FileInputStream fis;

    public ExcelDataConfig_Read(String excelPath) {
        try {
            f = new File(excelPath);
            fis = new FileInputStream(f);
            workbook = new HSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDataString(int sheetNumber, int rowNumber, int columnNumber) {

        sheet = workbook.getSheetAt(sheetNumber);

        String data = sheet.getRow(rowNumber).getCell(columnNumber).getStringCellValue();

        return data;

    }

    public Number getDataNumeric(int sheetNumber, int rowNumber, int columnNumber) {
        sheet = workbook.getSheetAt(sheetNumber);

        Number data = sheet.getRow(rowNumber).getCell(columnNumber).getNumericCellValue();

        return data;

    }

    public int lengthCellInRow(int sheetNumber, int rowNumber) {
        sheet = workbook.getSheetAt(sheetNumber);

        int a = sheet.getRow(rowNumber).getLastCellNum();
        return a;

    }

}
