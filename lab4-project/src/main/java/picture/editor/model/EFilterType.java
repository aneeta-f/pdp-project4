package picture.editor.model;

public enum EFilterType {
    BLUR_FILTER ("Blur Filter"),
    SHARP_FILTER ("Sharp Filter");

    private final String value;

    private EFilterType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
