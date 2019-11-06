package net.landofrails.lmc.items;

import cam72cam.mod.item.CreativeTab;
import cam72cam.mod.item.ItemStack;
import net.landofrails.lmc.LMCItems;
import net.landofrails.lmc.LearningModCore;
import net.minecraft.item.Item;

public class ItemTabs {

    public static CreativeTab MAIN_TAB;

    static {
        MAIN_TAB = new CreativeTab(LearningModCore.MODID+".main", () -> new ItemStack(LMCItems.ITEM_TEST,1));
    };
}
