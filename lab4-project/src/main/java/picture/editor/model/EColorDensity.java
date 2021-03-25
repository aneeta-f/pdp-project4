package picture.editor.model;

public enum EColorDensity {
    REDUCE("Reduce");

    private final String value;

    private EColorDensity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
