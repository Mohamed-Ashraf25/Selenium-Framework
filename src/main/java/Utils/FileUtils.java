package Utils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class FileUtils {
    private FileUtils() {
        super();    // Private constructor to prevent instantiation
    }

    public static File getLatestfile(String FolderPath) {
        File directory = new File(FolderPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null && files.length > 0) {
                File latestFile = files[0];
                for (File file : files) {
                    if (file.lastModified() > latestFile.lastModified()) {
                        latestFile = file;
                    }
                }
                return latestFile;
            } else {
                LogsUtils.Error("No files found in the directory: ", FolderPath);
                return null;
            }
        } else {
            LogsUtils.Error("Directory does not exist or is not a directory: ", FolderPath);
            return null;
        }

    }



    public static void DeleteFiles(File FilePath) {

        if (FilePath==null || !FilePath.exists()) {
            LogsUtils.Error("File does not exist: ", FilePath.getAbsolutePath());
            return;
        }
        File[] filelist= FilePath.listFiles();
        if(filelist==null){
            LogsUtils.Error("File list is null: ", FilePath.getAbsolutePath());
            return;

        }
        for ( File file : filelist) {
            if (file.isDirectory()) {
                DeleteFiles(file);
            } else { try {

               file.delete();
                LogsUtils.Info("File deleted successfully: ", file.getAbsolutePath());

            }catch (  SecurityException e) {
                LogsUtils.Error("Error deleting file: ",e.getMessage());
            }
        }

}}

    public static Collection<File> ListFiles(File file, String[] strings, boolean b) {
        if (file.isDirectory()) {
            return org.apache.commons.io.FileUtils.listFiles(file, strings, b);
        } else {
            LogsUtils.Error("File is not a directory: ", file.getAbsolutePath());
            return null;
        }

    }
    }
