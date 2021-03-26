package picture.editor;

import picture.editor.model.EColorTransformation;
import picture.editor.model.EFilterType;

import java.io.IOException;

public interface IEnhancedImageBuilder {
    IEnhancedImageBuilder loadImage(final String imgFilePath) throws IOException;

    IEnhancedImageBuilder addFilter(final EFilterType eFilterType);

    IEnhancedImageBuilder addDither(final boolean isEssence, final int totalColors);

    IEnhancedImageBuilder addColorTransformation(final EColorTransformation eColorTransformation);

    IEnhancedImageBuilder saveImage(String fileName) throws IllegalArgumentException, IOException;

    IEnhancedImageBuilder addMosaic(final int seeds);

    IEnhancedImageBuilder addPixelation(final int square);

    IEnhancedImageBuilder build();
}
