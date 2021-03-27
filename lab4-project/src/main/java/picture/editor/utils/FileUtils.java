package picture.editor.utils;

import java.io.File;

/**
 * This is an utility class responsible for performing file related operations.
 */
public class FileUtils {
  /**
   * Method this responsible for checking either file exists or no.
   *
   * @param filePath
   * @return
   */
  public static boolean isFileExist(String filePath) {
    return new File(filePath).exists() && new File(filePath).isFile();
  }

  /**
   * Return file name from path.
   *
   * @param filePath
   * @return
   */
  public static String getFileNameFromPath(String filePath) {
    return new File(filePath).getName();
  }

  /**
   * Return directory from path.
   *
   * @param filePath
   * @return
   */
  public static String getDirFromPath(String filePath) {
    return new File(filePath).getParent();
  }
}
