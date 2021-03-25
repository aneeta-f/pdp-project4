package picture.editor.utils;

import java.io.File;

public class FileUtils {
    public static boolean isFileExist(String filePath){
        return new File(filePath).exists() && new File(filePath).isFile();
    }

    public static String getFileNameFromPath(String filePath){
        return new File(filePath).getName();
    }

    public static String getDirFromPath(String filePath){
        return new File(filePath).getParent();
    }
}
