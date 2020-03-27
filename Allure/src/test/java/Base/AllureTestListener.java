package Base;

import Helper.Waiters;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;


public class AllureTestListener implements ITestListener {

    private String local;

    //Screenshot attachments for Allure
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for Allure
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }


    // Video attachments for Allure

    /*@Attachment(value = "{0}", type = "video/mp4")
    public byte[] attachVideo(){
        try{
            String tmpDir = ".\\Videos\\tmp";
            String workDir = ".\\Videos";
            File video = copyVideo(tmpDir, workDir);

            return Files.toByteArray(video);
        } catch (Exception ignored) {
            return new byte[0];
        }
    }

    public File copyVideo(String tmpDir, String workDir){
        File tmpFolder = new File(tmpDir);
        File tmpVideo;
        File workVideo = null;
        String[] listFiles = tmpFolder.list();

        for(String file : listFiles){
            tmpVideo = new File(tmpDir + "\\" + file);
            workVideo = new File(workDir + "\\" + file);
            try {
                FileUtils.copyFile(tmpVideo, workVideo);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(workVideo.exists() && tmpVideo.length() == workVideo.length()){
                tmpVideo.delete();
            }
        }

        return workVideo;
    }*/

    public void onStart(ITestContext context) {
        local = context.getCurrentXmlTest().getParameter("local");
        if (local.equals("true")) {
            System.out.println(context.getName() + " started locally ***");
        } else if (local.equals("false")) {
            System.out.println(context.getName() + " started on server/remotely ***");
        }
    }

    public void onFinish(ITestContext context) {

        System.out.println((context.getName() + " ending ***"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
        /*saveTextLog("*** Running test method " + result.getMethod().getMethodName() + "...");*/

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("*** Executed " + result.getMethod().getMethodName() + " test method successfully...");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("*** Execution of a test method" + result.getMethod().getMethodName() + " of a test class " + result.getMethod().getRealClass().getName() + " failed...");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((TestBase) testClass).getDriver(Boolean.parseBoolean(local));

        saveScreenshotPNG(webDriver);
        saveTextLog(result.getMethod().getMethodName() + " failed and screenshot taken!");
        System.out.println("Screenshot captured for test case: " + (result.getMethod().getMethodName()));
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("*** Tests " + result.getMethod().getMethodName() + " skipped...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("*** Tests failed but within percentage % " + result.getMethod().getMethodName());
    }
}