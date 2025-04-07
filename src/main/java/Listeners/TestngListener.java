package Listeners;

import Utils.AllureUtils;
import Utils.LogsUtils;
import Utils.ScreenshotUtils;
import io.qameta.allure.util.PropertiesUtils;
import org.testng.*;

import static Utils.PropertiesUtils.loadProperties;

public class TestngListener implements IExecutionListener, ITestListener, IInvokedMethodListener {


    @Override
    public void onExecutionFinish() {
        AllureUtils.AttachLogstoAllureReport();
        AllureUtils.AttachScreenshotstoAllureReport("Test Execution", "test-outputs/screenshots/TestExecution.png");
    }

    @Override
    public void onExecutionStart() {
        // Code to execute at the start of the test execution

        AllureUtils.AttachLogstoAllureReport();
        AllureUtils.AttachScreenshotstoAllureReport("Test Execution", "test-outputs/screenshots/TestExecution.png");
        LogsUtils.Info( "Test Execution started");
        PropertiesUtils.loadAllureProperties();
        loadProperties();
        LogsUtils.Info( "Properties loaded successfully");
        AllureUtils.AttachLogstoAllureReport();
        AllureUtils.AttachScreenshotstoAllureReport("Test Execution", "test-outputs/screenshots/TestExecution.png");
        LogsUtils.Info( "Test Execution started");
        AllureUtils.AttachLogstoAllureReport();
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        AllureUtils.AttachLogstoAllureReport();
        AllureUtils.AttachScreenshotstoAllureReport("Test Execution", "test-outputs/screenshots/TestExecution.png");
        LogsUtils.Info( "Test Execution started");
        AllureUtils.AttachLogstoAllureReport();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        AllureUtils.AttachLogstoAllureReport();
        AllureUtils.AttachScreenshotstoAllureReport("Test Execution", "test-outputs/screenshots/TestExecution.png");
        LogsUtils.Info( "Test Execution started");
        AllureUtils.AttachLogstoAllureReport();
    }


    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            switch (testResult.getStatus()){

                case ITestResult.SUCCESS -> ScreenshotUtils.Takescreenshot("Passed" + testResult.getName());
                case ITestResult.FAILURE -> ScreenshotUtils.Takescreenshot("Failed" + testResult.getName());
                case ITestResult.SKIP -> ScreenshotUtils.Takescreenshot("Skipped" + testResult.getName());
            }
            AllureUtils.AttachLogstoAllureReport();

        }
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

        if (method.isTestMethod()) {
            AllureUtils.AttachLogstoAllureReport();
            AllureUtils.AttachScreenshotstoAllureReport("Test Execution", "test-outputs/screenshots/TestExecution.png");
            LogsUtils.Info( "Test Execution started");
            AllureUtils.AttachLogstoAllureReport();
        }
    }

}
