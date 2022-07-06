package hrm.com.testscripts;

import java.io.FileInputStream;
//import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import hrm.com.pages.HRMLogin;
import hrm.com.utils.Browser;

public class ExcellExample {

	public static void main(String[] args) throws Exception {
		String filepath=".//resources//info.xlsx";
		FileInputStream instream=new FileInputStream(filepath);
		
		XSSFWorkbook workbook=new XSSFWorkbook(instream);
		 XSSFSheet sheet = workbook.getSheet("Sheet1");
		 int lastrow= sheet.getLastRowNum();
		 System.out.println("Last Row Number : "+lastrow);
		 int totalcells = sheet.getRow(0).getLastCellNum();
		System.out.println("Total Cells : "+totalcells);
		
		System.out.println("Getting particular cells value : ");
		String data = sheet.getRow(3).getCell(1).getStringCellValue();
		System.out.println(data);
		
		System.out.println("Row values ");
		int row=3;
		for(int j=0;j<totalcells;j++)
		{
		    data = sheet.getRow(row).getCell(j).getStringCellValue();
			System.out.println(data+" ");
		}
		System.out.println("Col values");
		int cell=0;
		for(int i=0;i<=lastrow;i++) {
			data = sheet.getRow(i).getCell(cell).getStringCellValue();
			System.out.println(data+" ");
		}
		System.out.println("Login : ");
		String login[]=new String[2];
		for(int i=0;i<=lastrow;i++) {
			int k=0;
			for(int j=0;j<totalcells;j++) {
				data = sheet.getRow(i).getCell(j).getStringCellValue();
				login[k++]=data; //post increment
			}
		   WebDriver driver = Browser.LaunchBrowser("edge");
		   Browser.openURL("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		   HRMLogin log=new HRMLogin(driver);
		   log.hrmLogin(login[0], login[1], "validation2");
		   Browser.closeBrowser();
		}
		/*sheet.getRow(0).createCell(2).setCellValue("hello");
		FileOutputStream f=new FileOutputStream(filepath);
		f.write(0);*/
	}
}
/*
Workbook
Sheet
Rows
cells
data
*/