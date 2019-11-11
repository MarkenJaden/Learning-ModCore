package net.landofrails.lmc.items;

import cam72cam.mod.entity.Player;
import cam72cam.mod.item.ClickResult;
import cam72cam.mod.item.Fuzzy;
import cam72cam.mod.item.ItemBase;
import cam72cam.mod.item.Recipes;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;
import cam72cam.mod.util.Facing;
import cam72cam.mod.util.Hand;
import cam72cam.mod.world.World;
import net.landofrails.lmc.LMCBlocks;
import net.landofrails.lmc.LearningModCore;

public class ItemTest extends ItemBase {
    public ItemTest(){
        super(LearningModCore.MODID, "item_test",32,ItemTabs.MAIN_TAB);

        Recipes.register(this,1, Fuzzy.DIRT);
    }

    @Override
    public ClickResult onClickBlock(Player player, World world, Vec3i pos, Hand hand, Facing facing, Vec3d hit){
        switch (facing){
            case UP:
                world.setBlock(pos.up(),LMCBlocks.BLOCK_TEST);
                break;
            case DOWN:
                world.setBlock(pos.down(),LMCBlocks.BLOCK_TEST);
                break;
            case EAST:
                world.setBlock(pos.east(),LMCBlocks.BLOCK_TEST);
                break;
            case WEST:
                world.setBlock(pos.west(),LMCBlocks.BLOCK_TEST);
                break;
            case NORTH:
                world.setBlock(pos.north(),LMCBlocks.BLOCK_TEST);
                break;
            case SOUTH:
                world.setBlock(pos.south(),LMCBlocks.BLOCK_TEST);
                break;
            default: world.setBlock(pos.up(),LMCBlocks.BLOCK_TEST);
        }
        return ClickResult.PASS;
    }
}
