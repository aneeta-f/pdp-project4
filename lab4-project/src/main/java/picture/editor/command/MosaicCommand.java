package picture.editor.command;

import picture.editor.IEnhancedImageBuilder;

public class MosaicCommand extends ACommand{

    private final int seeds;

    public MosaicCommand(IEnhancedImageBuilder enhancedImageBuilder, final int seeds) {
        super(enhancedImageBuilder);
        this.seeds = seeds;
    }

    @Override
    public String execute() {
        try {
            enhancedImageBuilder.addChunkingStrategyMosaic(seeds);
        }catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return "";
    }
}
