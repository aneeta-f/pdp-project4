package picture.editor.model;

/**
 * This is responsible for holding enum for chunking strategy.
 */
public enum EChunkingStrategy {
  MOSAIC("Mosaic"),
  PIXELATION("Pixelation");

  private final String value;

  private EChunkingStrategy(String value) {
    this.value = value;
  }

  /**
   * Return value for enum.
   * @return
   */
  public String getValue() {
    return value;
  }
}
