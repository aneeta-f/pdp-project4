package picture.editor.model;

/**
 * Performs color transformation
 */
public enum EColorTransformation {
  GREY_SCALE("Grey Scale"),
  SEPIA_TONE("Sepia Tone");

  private final String value;

  private EColorTransformation(String value) {
      this.value = value;
  }

  /**
   * Return value for color transformation.
   * @return value for enum
   */
  public String getValue() {
        return value;
    }
}
