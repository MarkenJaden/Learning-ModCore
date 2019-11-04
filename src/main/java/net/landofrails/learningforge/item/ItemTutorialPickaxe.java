package net.landofrails.learningforge.item;

import net.landofrails.learningforge.LearningForge;

import net.minecraft.item.ItemPickaxe;

public class ItemTutorialPickaxe extends ItemPickaxe {
	
	public ItemTutorialPickaxe(ToolMaterial material, String unlocalizedName, String registryName) {
		super(material);
		
		setTranslationKey(LearningForge.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(LearningForge.LEARN_TAB);
	}

}
