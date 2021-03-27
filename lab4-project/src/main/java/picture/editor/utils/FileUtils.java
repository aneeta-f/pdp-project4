package picture.editor.utils;

import java.io.File;

/**
 * The class represents a FileUtils that has a method for file path.
 * 
 */
public class FileUtils {

  /**
   * This method is responsible for accessing the file path .
   *
   * @return the file path of this FileUtils.
   */
  public static boolean isFileExist(String filePath) {
    if (filePath == null || filePath.trim().isEmpty()) {
      throw new IllegalArgumentException("File path cannot be null or empty");
    }
    return new File(filePath).exists() && new File(filePath).isFile();
  }

  /**
   * This method is responsible for getting the file name from the path.
   *
   * @return the name of this FileUtils.
   */
  public static String getFileNameFromPath(String filePath) {
    if (filePath == null || filePath.trim().isEmpty()) {
      throw new IllegalArgumentException("File path cannot be null or empty");
    }
    return new File(filePath).getName();
  }

  /**
   * This method is responsible for getting the file directory.
   *
   * @return the parent file of this FileUtils.
   */
  public static String getDirFromPath(String filePath) {
    if (filePath == null || filePath.trim().isEmpty()) {
      throw new IllegalArgumentException("File path cannot be null or empty");
    }
    return new File(filePath).getParent();
  }
}
