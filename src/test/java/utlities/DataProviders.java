package utlities;

import java.io.IOException;

public class DataProviders {
	
	@org.testng.annotations.DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		String path = ".\\src\\test\\resources\\testData\\LoginTestData.xlsx";
		ExcelUtlities excelUtility = new ExcelUtlities(path);
		
		int total_Rows = excelUtility.getRowCount("Sheet1");
		int total_Clmns = excelUtility.getCellCount("Sheet1", 1);
	
		String[][] loginData = new String[total_Rows][total_Clmns];
		for(int i=1; i<=total_Rows; i++) {
			for(int j=0; j<total_Clmns; j++) {
				loginData[i-1][j] = excelUtility.getCellData("Sheet1", i, j);
			}
		}	
		return loginData;
	}	
}
