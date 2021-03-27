package picture.editor.model;

/**
 * This class represents enumeration EOperationType. A 
 * enumeration EOperationType has a FILTER, COLOR_TRANSFORMATION, 
 * DITHER, MOSAIC, PATTERN_GEN and PIXELATION operations.
 * 
 */
public enum  EOperationType {
  FILTER("Image Filter"),
  COLOR_TRANSFORMATION("Color Transformation"),
  DITHER("Image Dither"),
  MOSAIC("Image Mosaic"),
  PATTERN_GEN("Pattern Generation"),
  PIXELATION("Image Pixelation");

  private final String value;

  private EOperationType(String value) {
    this.value = value;
  }

  /**
   * Return the value of this EOperationType.
   *
   * @return the value of this EOperationType.
   */
  public String getValue() {
    return value;
  }
}
