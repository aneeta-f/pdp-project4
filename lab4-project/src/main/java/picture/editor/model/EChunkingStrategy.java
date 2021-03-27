package picture.editor.model;

/**
 * This class represents enumeration EChunkingStrategy. 
 * A enumeration EChunkingStrategy has a functionality of
 * MOSAIC and PIXELATION.
 * 
 */
public enum EChunkingStrategy {
  MOSAIC("Mosaic"),
  PIXELATION("Pixelation");

  private final String value;

  private EChunkingStrategy(String value) {
    this.value = value;
  }

  /**
   * Return the value of this EChunkingStrategy.
   *
   * @return the value of this EChunkingStrategy.
   */
  public String getValue() {
    return value;
  }
}
