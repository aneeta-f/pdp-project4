package picture.editor;

import picture.editor.model.EColorDensity;
import picture.editor.model.EColorTransformation;
import picture.editor.model.EFilterType;

import java.io.IOException;

public interface IEnhancedImageBuilder {
    EnhancedImageBuilder loadImage(final String imgFilePath) throws IOException;

    EnhancedImageBuilder addFilter(final EFilterType eFilterType);

    EnhancedImageBuilder addColorDensity(final EColorDensity eColorDensity, final boolean isEssence, final int totalColors);

    EnhancedImageBuilder addColorTransformation(final EColorTransformation eColorTransformation);

    EnhancedImageBuilder saveImage(String fileName) throws IllegalArgumentException, IOException;

    EnhancedImageBuilder build();
}
