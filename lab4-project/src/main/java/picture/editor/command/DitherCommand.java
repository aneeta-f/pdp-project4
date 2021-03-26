package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

public class DitherCommand extends ACommand{
    final boolean isEssence;
    final int totalColors;
    public DitherCommand(IEnhancedImageBuilder enhancedImageBuilder, final int totalColors, final boolean isEssence) {
        super(enhancedImageBuilder);
        this.isEssence = isEssence;
        this.totalColors = totalColors;
    }

    @Override
    public String execute() {
        enhancedImageBuilder.addDither(isEssence, totalColors);
        return "";
    }
}
