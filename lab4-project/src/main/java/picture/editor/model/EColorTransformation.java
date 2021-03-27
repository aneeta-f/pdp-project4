package picture.editor.model;

/**
 * This class represents enumeration EColorTransformation. 
 * A enumeration EColorTransformation has a functionality of
 * GREY_SCALE and SEPIA_TONE.
 * 
 */
public enum EColorTransformation {
  GREY_SCALE("Grey Scale"),
  SEPIA_TONE("Sepia Tone");

  private final String value;

  private EColorTransformation(String value) {
    this.value = value;
  }

  /**
   * Return the value of this EColorTransformation.
   *
   * @return the value of this EColorTransformation.
   */
  public String getValue() {
    return value;
  }
}
