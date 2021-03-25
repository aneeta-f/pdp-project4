package picture.editor.model;

public enum EColorTransformation {
    GREY_SCALE("Grey Scale"),
    SEPIA_TONE("Sepia Tone");

    private final String value;

    private EColorTransformation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
