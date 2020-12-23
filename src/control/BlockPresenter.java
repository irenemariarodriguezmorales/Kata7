package control;

import view.BlockDisplay;
import model.Block;
import view.BlockDisplay.Moved;

public class BlockPresenter implements Block.Observer  {
    private final Block block;
    private final BlockDisplay blockDisplay;

    public BlockPresenter(Block block, BlockDisplay blockdisplay){
        this.block = block;
        this.blockDisplay = blockdisplay;
        this.blockDisplay.on(new Moved() {
            @Override
            public void to(int x, int y) {
                block.moveTo(x / 100 + 1, Block.MAX - y / 100);
            }
        });
        this.block.register(this);
        this.refresh();
    }
    
    private void refresh(){
        blockDisplay.paintBlock((block.x()-1)*blockDisplay.SIZE, (Block.MAX - block.y())*blockDisplay.SIZE);
    }

    @Override
    public void changed() {
        refresh();
    }
}
