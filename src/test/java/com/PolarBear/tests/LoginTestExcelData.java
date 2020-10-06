package com.PolarBear.tests;


import com.PolarBear.utilities.ExcelUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestExcelData extends BaseTest{

    @Test(dataProvider="data-provider")

    public void login(String username, String password){
        extentTest = extentReports.createTest("Verify page Title with Excel data");
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA3-short";
        ExcelUtil excelUtil = new ExcelUtil (path, spreadSheet);
        extentTest.pass("Page Title verified!");

    }
    @DataProvider(name="data-provider")
    public Object[][] dataProviderMethod(){
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA3-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadSheet);
        return excelUtil.getDataArray();
    }
}

