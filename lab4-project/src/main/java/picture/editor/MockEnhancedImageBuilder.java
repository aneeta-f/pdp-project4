package picture.editor;

import picture.editor.model.EColorDensity;
import picture.editor.model.EColorTransformation;
import picture.editor.model.EFilterType;

import java.io.IOException;

public class MockEnhancedImageBuilder implements IEnhancedImageBuilder{
    @Override
    public EnhancedImageBuilder loadImage(String imgFilePath) throws IOException {
        return null;
    }

    @Override
    public EnhancedImageBuilder addFilter(EFilterType eFilterType) {
        return null;
    }

    @Override
    public EnhancedImageBuilder addColorDensity(EColorDensity eColorDensity, boolean isEssence, int totalColors) {
        return null;
    }

    @Override
    public EnhancedImageBuilder addColorTransformation(EColorTransformation eColorTransformation) {
        return null;
    }

    @Override
    public EnhancedImageBuilder saveImage(String fileName) throws IllegalArgumentException, IOException {
        return null;
    }

    @Override
    public EnhancedImageBuilder build() {
        return null;
    }
}
