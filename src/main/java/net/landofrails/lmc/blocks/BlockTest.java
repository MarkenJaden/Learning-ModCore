package net.landofrails.lmc.blocks;

import cam72cam.mod.block.BlockSettings;
import cam72cam.mod.block.BlockType;
import cam72cam.mod.entity.Player;
import cam72cam.mod.item.ItemStack;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;
import cam72cam.mod.util.Facing;
import cam72cam.mod.util.Hand;
import cam72cam.mod.world.World;
import net.landofrails.lmc.LearningModCore;

public class BlockTest extends BlockType {

    public BlockTest() {
        super(new BlockSettings(LearningModCore.MODID, "block_test"));
    }

    @Override
    public boolean tryBreak(World world, Vec3i pos, Player player) {
        return player.isCreative();
    }

    @Override
    public void onBreak(World world, Vec3i pos) {
    }

    @Override
    public boolean onClick(World world, Vec3i pos, Player player, Hand hand, Facing facing, Vec3d hit) {
        return false;
    }

    @Override
    public ItemStack onPick(World world, Vec3i pos) {
        return null;
    }

    @Override
    public void onNeighborChange(World world, Vec3i pos, Vec3i neighbor) {

    }
}
