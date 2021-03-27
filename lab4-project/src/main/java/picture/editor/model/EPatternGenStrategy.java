package picture.editor.model;

/**
 * This class is responsible for pattern gen enums.
 */
public enum EPatternGenStrategy {
  CLOSEST_COLOR("Closest Color"),
  TEXT_PATTERN("Text Pattern");

  private final String value;

  private EPatternGenStrategy(String value) {
    this.value = value;
  }

  /**
   * Returns value.
   * @return
   */
  public String getValue() {
    return value;
  }
}
