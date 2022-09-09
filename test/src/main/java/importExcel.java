import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
//import com.sun.xml.internal.ws.util.StringUtils;
import com.sun.deploy.util.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;

import java.io.File;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class importExcel {
    public void importExcel(DBCollection collection,String path)throws Exception{
        List<List<String>> result = new ExcelUtil().readXls(path,collection);
    }
}

class ExcelUtil{
    public List<List<String>> readXls(String path,DBCollection collection)throws Exception{
        InputStream ins = new FileInputStream(path);
        XSSFWorkbook xssfwk = new XSSFWorkbook(ins);
        List<List<String>> result = new ArrayList<List<String>>();
        int size = xssfwk.getNumberOfSheets();
        XSSFRow nameRow = xssfwk.getSheetAt(0).getRow(0);
        for(int numSheet=0;numSheet<size;numSheet++){
            XSSFSheet xssfSheet = ((XSSFWorkbook) xssfwk).getSheetAt(numSheet);
//            if(xssfSheet==null){
//                continue;
//            }
            for(int rowNum = 1;rowNum <=xssfSheet.getLastRowNum();rowNum++){
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                int minColIx = xssfRow.getFirstCellNum();
                int maxColIx = xssfRow.getLastCellNum();
                List<String> rowList = new ArrayList<>();
                BasicDBObject document = new BasicDBObject();
                for(int colIx=minColIx;colIx<maxColIx;colIx++){
                    XSSFCell cell = xssfRow.getCell(colIx);
                    String value = String.valueOf(cell);
                    document.put(String.valueOf(nameRow.getCell(colIx)),value);
                    System.out.println("插入+"+String.valueOf(nameRow.getCell(colIx))+":"+value);
                    rowList.add(value);
                }
                collection.insert(document);
                result.add(rowList);
            }
        }
        return result;
    }
}