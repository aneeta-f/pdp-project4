package picture.editor.model;

/**
 * Operation type enums.
 */
public enum  EOperationType {
  FILTER ("Image Filter"),
  COLOR_TRANSFORMATION ("Color Transformation"),
  DITHER("Image Dither"),
  MOSAIC("Image Mosaic"),
  PATTERN_GEN("Pattern Generation"),
  PIXELATION("Image Pixelation");

  private final String value;

  private EOperationType(String value) {
    this.value = value;
  }

  /**
   * Return operation value.
   * @return
   */
  public String getValue() {
    return value;
  }
}
