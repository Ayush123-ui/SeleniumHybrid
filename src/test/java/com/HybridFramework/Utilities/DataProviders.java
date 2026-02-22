package com.HybridFramework.Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

		
			
		
		@DataProvider(name="LoginData")
		public String [][] getData(){
			String path = ".\\testData\\excelData.xlsx";
			ExcelReader xlutil = new ExcelReader(path);
			int totalrows = xlutil.getRowCount("Sheet1");
			int totalcols = xlutil.getColumnCount("Sheet1");
			
			String data [][] =  new String[totalrows-1][totalcols];
			for(int rowNum=2;rowNum<=totalrows;rowNum++) {
				for(int colNum=0;colNum<totalcols;colNum++) {
					data[rowNum-2][colNum]= xlutil.getCellData("Sheet1", colNum, rowNum);
					}
				}
			
			return data;
			
			
			
			
			
		
	}

}
