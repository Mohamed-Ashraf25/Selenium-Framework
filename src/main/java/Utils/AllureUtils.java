package Utils;

import io.qameta.allure.Allure;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {
//    public static final String Allure_Results = "test-outputs/allure-results";
    private AllureUtils(){super();}

  public static void AttachLogstoAllureReport(){
      try {
          File logfile =FileUtils.getLatestfile(LogsUtils.LOGS_PATH);
            if (!logfile.exists()) {
               LogsUtils.Info( "Log file not found: "+LogsUtils.LOGS_PATH);
               return;
            }

            Allure.addAttachment("Logs.log", Files.readString(Path.of(logfile.getPath())));
            LogsUtils.Info("Log file attached to Allure report: " + logfile.getName());
            }
        catch (Exception e) {
            LogsUtils.Error("Failed to attach log file to Allure report: " + e.getMessage());
        }
      }




   public static void AttachScreenshotstoAllureReport(String Screenshotname,String screenshotPath) {
         try {
              Allure.addAttachment(Screenshotname,Files.newInputStream(Path.of(screenshotPath)));
         }
          catch (Exception e) {
             LogsUtils.Error( "Failed to attach screenshot to Allure report: " + e.getMessage());
         }}}



