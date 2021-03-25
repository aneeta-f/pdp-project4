package picture.editor.model;

public enum EChunkingStrategy {
    MOSAIC ("Mosaic"),
    PIXELATION ("Pixelation");

    private final String value;

    private EChunkingStrategy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
