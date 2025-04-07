package Listeners;

import Utils.*;
import io.qameta.allure.Step;
import io.qameta.allure.util.PropertiesUtils;
import org.testng.*;
import org.testng.annotations.Test;

import java.io.File;

import static Utils.PropertiesUtils.loadProperties;

public class TestngListener implements IExecutionListener, ITestListener, IInvokedMethodListener {

    File Allure_Results = new File("test-outputs/allure-results");
    File Logs_Results = new File("test-outputs/logs");

    @Step( "Test is Started")
    @Override
    public void onExecutionStart() {
        // Code to execute at the start of the test execution

        LogsUtils.Info("Test Execution started");
        loadProperties();
        LogsUtils.Info("Properties loaded successfully");
        FileUtils.DeleteFiles(Allure_Results);
        FileUtils.DeleteFiles(Logs_Results);
    }
@Step( "Test is Successed")
    @Override
    public void onTestSuccess(ITestResult result) {

        LogsUtils.Info( "Test is Successed"+result.getName());
        ScreenshotUtils.Takescreenshot( "Passed"+result.getName());
        AllureUtils.AttachScreenshotstoAllureReport("Passed"+result.getName(), "test-outputs/screenshots/");

    }
@Step( "Test is Failed")
    @Override
    public void onTestFailure(ITestResult result) {

        LogsUtils.Info( " Test is failed"+result.getName());
        ScreenshotUtils.Takescreenshot( "Failed" + result.getName());
        AllureUtils.AttachScreenshotstoAllureReport("Failed" + result.getName(), "test-outputs/screenshots/");


    }
    @Step( "Test is Finished")
    @Override
    public void onExecutionFinish() {
        AllureUtils.AttachLogstoAllureReport();
        ScreenshotUtils.Takescreenshot("Test Execution Is Done");
        AllureUtils.AttachScreenshotstoAllureReport("Test Execution Is Done", "test-outputs/screenshots/");
    }

//    @Override
//    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
//        if (method.isTestMethod()) {
//            switch (testResult.getStatus()){
//
//                case ITestResult.SUCCESS -> ScreenshotUtils.Takescreenshot("Passed" + testResult.getName());
//                case ITestResult.FAILURE -> ScreenshotUtils.Takescreenshot("Failed" + testResult.getName());
//                case ITestResult.SKIP -> ScreenshotUtils.Takescreenshot("Skipped" + testResult.getName());
//            }
//            AllureUtils.AttachLogstoAllureReport();
//
//        }
//
//    }

//    @Override
//    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
//
//        if (method.isTestMethod()) {
//            LogsUtils.Info( "Test Execution started");
//
//        }
//    }



}
