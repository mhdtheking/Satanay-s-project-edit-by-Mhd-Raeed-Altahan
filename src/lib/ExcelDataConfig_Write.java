/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author mhd
 */


public class ExcelDataConfig_Write {

        public File f;
	public FileInputStream fis;
	public Workbook workbook;
	public Sheet sheet;
	
	
	
	
	private FileOutputStream outputStream;
	
	
	
	public ExcelDataConfig_Write(String fileName,String sheetName) throws FileNotFoundException, IOException{
            
            f = new  File(fileName);
            fis = new FileInputStream(f);
            workbook = new HSSFWorkbook(fis);
            
            
            sheet = workbook.getSheet(sheetName);
		
	}
        
 public void setDataString( int rowNum, int cellNum,String word) {

                Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
                
                cell.setCellValue(word);
                
                try
                {
                        fis.close();
			outputStream = new FileOutputStream(f);
			workbook.write(outputStream);
			outputStream.close();
                }
                        
                        catch(FileNotFoundException e) {
			   System.out.println(e.getMessage());
		}
		catch(IOException e) {
			 System.out.println(e.getMessage());
		}
     
     
        //sheet.getRow(rowNumber).getCell(columnNumber).getStringCellValue();

        

    }
        
	
	
    
}
