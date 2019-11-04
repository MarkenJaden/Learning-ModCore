package net.landofrails.learningforge.tabs;

import net.landofrails.learningforge.LearningForge;
import net.landofrails.learningforge.init.TutorialItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LearnTab extends CreativeTabs {

	public LearnTab(String name) {
		super(LearningForge.MODID + "." + name);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack createIcon() {
		return new ItemStack(TutorialItems.BASIC_ITEM);
	}

}
