package net.landofrails.learningforge.item;

import net.landofrails.learningforge.LearningForge;

import net.minecraft.item.ItemSword;

public class ItemTutorialSword extends ItemSword {
	
	public ItemTutorialSword(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);
		
		setTranslationKey(LearningForge.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(LearningForge.LEARN_TAB);
	}

}
