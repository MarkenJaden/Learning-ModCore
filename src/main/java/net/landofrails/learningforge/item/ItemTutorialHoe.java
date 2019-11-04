package net.landofrails.learningforge.item;

import net.landofrails.learningforge.LearningForge;

import net.minecraft.item.ItemHoe;

public class ItemTutorialHoe extends ItemHoe {
	
	public ItemTutorialHoe(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);
		
		setTranslationKey(LearningForge.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(LearningForge.LEARN_TAB);
	}

}
