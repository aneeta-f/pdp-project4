package picture.editor.model;

/**
 * This class represents enumeration EPatternGenStrategy. A 
 * enumeration EPatternGenStrategy has a CLOSEST_COLOR 
 * and TEXT_PATTERN operations.
 * 
 */
public enum EPatternGenStrategy {
  CLOSEST_COLOR("Closest Color"),
  TEXT_PATTERN("Text Pattern");

  private final String value;

  private EPatternGenStrategy(String value) {
    this.value = value;
  }

  /**
   * Return the value of this EPatternGenStrategy .
   *
   * @return the value of this EPatternGenStrategy .
   */
  public String getValue() {
    return value;
  }
}
