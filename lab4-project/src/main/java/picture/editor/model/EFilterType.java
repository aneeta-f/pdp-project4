package picture.editor.model;

/**
 * This class represents enumeration EFilterType. A enumeration EFilterType
 * has a BLUR_FILTER and SHARP_FILTER filters.
 * 
 */
public enum EFilterType {
  BLUR_FILTER("Blur Filter"),
  SHARP_FILTER("Sharp Filter");

  private final String value;

  private EFilterType(String value) {
    this.value = value;
  }

  /**
   * Return the value of this EFilterType.
   *
   * @return the value of this EFilterType.
   */
  public String getValue() {
    return value;
  }
}
