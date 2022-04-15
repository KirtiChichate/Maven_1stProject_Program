package utility_Classes_Package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ListenerUtility_KiteClass {

	
static Sheet GetSheet;  //we make sheet declare as globally becz due to this we can able to use it in another class
	
	public static String ReadExcel(int rowindex, int columnindex) throws EncryptedDocumentException, IOException
	{
		  FileInputStream ObjFIS= new FileInputStream("C:\\Users\\OWNER\\Desktop\\VELOCITY DATA\\Automation Excel sheet\\IntroExcel.xlsx");
          GetSheet = WorkbookFactory.create(ObjFIS).getSheet("DDF Data");
          String value = GetSheet.getRow(rowindex).getCell(columnindex).getStringCellValue();
	      return value;
        
	}
	
}
