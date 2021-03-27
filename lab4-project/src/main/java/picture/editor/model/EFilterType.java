package picture.editor.model;

/**
 * This class hold enum for filter type.
 */
public enum EFilterType {
  BLUR_FILTER( "Blur Filter" ),
  SHARP_FILTER("Sharp Filter");

  private final String value;

  private EFilterType(String value) {
    this.value = value;
  }

  /**
   * Returns filter type value.
   * @return
   */
  public String getValue() {
    return value;
  }
}
