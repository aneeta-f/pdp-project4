package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

public abstract class ACommand {
    protected IEnhancedImageBuilder enhancedImageBuilder;

    public ACommand(IEnhancedImageBuilder enhancedImageBuilder) {
        this.enhancedImageBuilder = enhancedImageBuilder;
    }

    public abstract String execute();
}
