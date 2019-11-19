package net.landofrails.lmc.blocks;

import cam72cam.mod.block.BlockEntity;
import cam72cam.mod.block.BlockEntityTickable;
import cam72cam.mod.entity.Player;
import cam72cam.mod.item.ItemStack;
import cam72cam.mod.math.Vec3d;
import cam72cam.mod.math.Vec3i;
import cam72cam.mod.util.Facing;
import cam72cam.mod.util.Hand;
import cam72cam.mod.util.TagCompound;

public class Fahrkartenautomat_DB extends BlockEntityTickable {
    public Fahrkartenautomat_DB() {
    }

    @Override
    public void update() {

    }

    @Override
    public void load(TagCompound nbt) {

    }

    @Override
    public void save(TagCompound nbt) {

    }

    @Override
    public void writeUpdate(TagCompound nbt) {

    }

    @Override
    public void readUpdate(TagCompound nbt) {

    }

    @Override
    public void onBreak() {

    }

    @Override
    public boolean onClick(Player player, Hand hand, Facing facing, Vec3d hit) {
        return false;
    }

    @Override
    public ItemStack onPick() {
        return null;
    }

    @Override
    public void onNeighborChange(Vec3i neighbor) {

    }
}
