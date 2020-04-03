package Base;

import org.testng.annotations.DataProvider;

public class ExcelToDataProvider {

    String xlFilePath = "/Users/Sasha/Documents/Selenium_projects/testng_maven/Allure/src/test/java/Data/testdata.xlsx";
    String xlFilePathLogin = "/Users/Sasha/Documents/Selenium_projects/testng_maven/Allure/src/test/java/Data/testdatalogin.xlsx";
    String sheetName = "Credentials";
    ExcelUtility eat = null;


    @DataProvider(name="userData")
    public Object[][] userFormData() throws Exception
    {
        Object[][] data = testData(xlFilePath, sheetName);
        return data;
    }

    @DataProvider(name="userDataLogin")
    public Object[][] userFormDataLogin() throws Exception
    {
        Object[][] data = testData(xlFilePathLogin, sheetName);
        return data;
    }

    public Object[][] testData(String xlFilePath, String sheetName) throws Exception
    {
        Object[][] excelData;
        eat = new ExcelUtility(xlFilePath);
        int rows = eat.getRowCount(sheetName);
        int columns = eat.getColumnCount(sheetName);

        excelData = new Object[rows-1][columns];

        for(int i=1; i<rows; i++)
        {
            for(int j=0; j<columns; j++)
            {
                excelData[i-1][j] = eat.getCellData(sheetName, j, i);
            }

        }
        return excelData;
    }
}
