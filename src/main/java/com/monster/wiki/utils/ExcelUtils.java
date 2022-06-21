package com.monster.wiki.utils;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

@Getter
@Setter
public class ExcelUtils {
    private String filePath;
    private int dataPosition;
    private Map<String, Object> workflowData;
    private static final Logger LOG = Logger.getLogger(ElementWeb.class.getName());

    public ExcelUtils(String fileNameXlxs, String testFlowName) {
        this.filePath = "src/test/resources/data/" + fileNameXlxs;
        this.workflowData = new HashMap<>();
        getExcelData(testFlowName);
    }

    public String getTestFlowCode(String testFlowName) {
        String[] testFlowNameArray = testFlowName.split("_"); // split the test flow name in an array
        LOG.info("Get the flow id: [" + testFlowNameArray[0] + "] from the test flow name: [" + testFlowNameArray[1] + "]");
        return testFlowNameArray[0];
    }

    public synchronized void getExcelData(String testFlowName) {
        String sheetName = "data";
        String fieldName, fieldValue;
        DataFormatter formatter = new DataFormatter();

        try {
            FileInputStream file = new FileInputStream(new File(this.filePath));
            XSSFWorkbook workbook = new XSSFWorkbook(file); // Create Workbook instance holding reference to .xlsx file
            XSSFSheet sheet = workbook.getSheet(sheetName); // Get first sheet from the workbook
            int position = getRowPosition(getTestFlowCode(testFlowName), sheet);
            dataPosition = position;
            int numberToError = -1;
            if (position != numberToError) {
                Row rowFields = sheet.getRow(0); // get first row where is the name of the fields
                Row rowValues = sheet.getRow(position); // get the row with the values
                Iterator<Cell> cellIterator = rowFields.cellIterator(); // get the iterator of the first row

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next(); // get the next cell
                    fieldName = formatter.formatCellValue(cell); // get the value of the cell
                    fieldValue = formatter.formatCellValue(rowValues.getCell(cell.getColumnIndex())); // get the value of the cell in the row with the values

                    if (!fieldValue.equals("") && !fieldValue.equals(" ")) { // if the value is not empty
                        workflowData.put(fieldName, fieldValue); // add the value to the map
                        LOG.info("Get the field: [" + fieldName + "] with the value: [" + fieldValue + "]");
                    }
                }
            }
            workbook.close();
            file.close();
        }catch (Exception e){
            e.getMessage();
        }
    }

    public synchronized void updateExcelData(String strValueName) throws Exception {
        File outputFile = new File(this.filePath);
        FileInputStream excelFileInputStream = new FileInputStream(outputFile);
        XSSFWorkbook workbook = new XSSFWorkbook(excelFileInputStream);
        XSSFSheet sheet = workbook.getSheet("data");

        int numberToError = -1;
        if (dataPosition != numberToError) {
            XSSFCell newValueCellState = sheet.getRow(dataPosition).createCell(0); // create a new cell in the row with the values
            if (strValueName.equals("free")) {
                newValueCellState.setCellValue("busy");
                LOG.info("Update the value of the cell: [" + newValueCellState.getAddress() + "] with the value: [" + newValueCellState.getStringCellValue() + "]");
            } else if (strValueName.equals("busy")) {
                newValueCellState.setCellValue("free");
                LOG.info("Update the value of the cell: [" + newValueCellState.getAddress() + "] with the value: [" + newValueCellState.getStringCellValue() + "]");
            }
            excelFileInputStream.close();
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            workbook.write(outputStream);
            workbook.close();
        }
    }

    private int getRowPosition(String testFlowCode, XSSFSheet sheet) {
        int finalPosition = -1;
        boolean isFound = false;
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext() && !isFound) {
            Row row = rowIterator.next(); // get next row
            Cell cell = row.getCell(0); // get first cell
            if (cell != null && cell.getStringCellValue().equals(testFlowCode)) { // if first cell is not null and equals to the test flow code
                finalPosition = cell.getRowIndex();
                isFound = true;
            }
        }
        return finalPosition;
    }
}
