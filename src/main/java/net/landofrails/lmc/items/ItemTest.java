package net.landofrails.lmc.items;

import cam72cam.mod.item.Fuzzy;
import cam72cam.mod.item.ItemBase;
import cam72cam.mod.item.Recipes;
import net.landofrails.lmc.LearningModCore;

public class ItemTest extends ItemBase {
    public ItemTest(){
        super(LearningModCore.MODID, "item_test",32,ItemTabs.MAIN_TAB);

        Recipes.register(this,1, Fuzzy.DIRT);
    }
}
