package employeeID.client;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.*;

import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class FileManager {

    public static ArrayList excelReader(String path) {
      try
      {
        FileInputStream file = new FileInputStream(new File(path));

        //Create Workbook instance holding reference to .xlsx file
        HSSFWorkbook workbook = new HSSFWorkbook(file);

        //Get first/desired sheet from the workbook
        HSSFSheet sheet = workbook.getSheetAt(0);

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        ArrayList<ArrayList<String>> all = new ArrayList<>();
        while (rowIterator.hasNext())
        {
          Row row = rowIterator.next();
          ArrayList<String> names = new ArrayList<>();
          //For each row, iterate through all the columns
          Iterator<Cell> cellIterator = row.cellIterator();

          while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            //Check the cell type and format accordingly
            switch (cell.getCellType()) {
              case Cell.CELL_TYPE_NUMERIC:
                names.add(Integer.toString((int) cell.getNumericCellValue()));
                break;
              case Cell.CELL_TYPE_STRING:
                names.add(cell.getStringCellValue());
                break;
            }
          }
          all.add(names);
        }
        file.close();
        System.out.println(all);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
      return null;
    }

    public static void main(String[] args) {
      excelReader("/Users/marvinchui/Documents/Test.xls");
    }
  }
