package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

public class PixelateCommand extends ACommand{
    private final int squares;

    public PixelateCommand(IEnhancedImageBuilder enhancedImageBuilder, final int squares) {
        super(enhancedImageBuilder);
        this.squares = squares;
    }

    @Override
    public String execute() {
        enhancedImageBuilder.addPixelation(this.squares);
        return "";
    }
}
