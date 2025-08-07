package co.com.empresa.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;

public class ExcelData {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    public String excelData(String filepath, int rowNumber, int columnNumber, int numberSheet) {
        XSSFCell cell = null;
        try {
            File file = new File(filepath);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(numberSheet);
            XSSFRow row = sheet.getRow(rowNumber);
            cell = row.getCell(columnNumber);
        }  catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        assert cell != null;
        return cell.getStringCellValue();
    }
}
