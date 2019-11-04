package net.landofrails.learningforge.item;

import net.landofrails.learningforge.LearningForge;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemTutorialArmor extends ItemArmor {

	public ItemTutorialArmor(ArmorMaterial material, EntityEquipmentSlot equipmentSlot, String unlocalizedName, String registryName) {
		super(material, 0, equipmentSlot);
		
		setTranslationKey(LearningForge.MODID + "." + unlocalizedName);
		setRegistryName(registryName);
		setCreativeTab(LearningForge.LEARN_TAB);
	}
	
}
