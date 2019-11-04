package net.landofrails.learningforge.item;

import net.landofrails.learningforge.LearningForge;

import net.minecraft.item.ItemAxe;

public class ItemTutorialAxe extends ItemAxe {
	
	public ItemTutorialAxe(ToolMaterial material, float damage, float speed, String unlocalizedName, String registryName) {
		super(material, damage, speed);
		
		setTranslationKey(LearningForge.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(LearningForge.LEARN_TAB);
	}

	public ItemTutorialAxe(ToolMaterial material, String unlocalizedName, String registryName) {
		this(material, 8.0F, -3.1F, unlocalizedName, registryName);
	}
	
}
