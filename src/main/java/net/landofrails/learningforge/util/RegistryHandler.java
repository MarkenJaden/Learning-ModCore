package net.landofrails.learningforge.util;

import net.landofrails.learningforge.block.BlockBasic;
import net.landofrails.learningforge.block.Fahrkartenautomat_DB;
import net.landofrails.learningforge.block.Test;
import net.landofrails.learningforge.init.TutorialBlocks;
import net.landofrails.learningforge.item.ItemBasic;
import net.landofrails.learningforge.item.ItemTutorialArmor;
import net.landofrails.learningforge.item.ItemTutorialAxe;
import net.landofrails.learningforge.item.ItemTutorialHoe;
import net.landofrails.learningforge.item.ItemTutorialPickaxe;
import net.landofrails.learningforge.item.ItemTutorialShovel;
import net.landofrails.learningforge.item.ItemTutorialSword;
import net.landofrails.learningforge.materials.TutorialMaterials;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event) {
		final Block[] blocks = {
				new BlockBasic(Material.ROCK, "blockBasic", "basic_block"),
				new Test(Material.ROCK, "test", "test"),
				new Fahrkartenautomat_DB(Material.ROCK, "fahrkartenautomatdb", "fahrkartenautomat_db")
		};
		
		event.getRegistry().registerAll(blocks);
	}
	
	@SubscribeEvent
	public static void registerItems(Register<Item> event) {
		final Item[] items = {
				new ItemBasic("itemBasic", "basic_item"),
				new ItemTutorialAxe(TutorialMaterials.TUTORIAL_TOOL, "axeTutorial", "tutorial_axe"),
				new ItemTutorialPickaxe(TutorialMaterials.TUTORIAL_TOOL, "pickaxeTutorial", "tutorial_pickaxe"),
				new ItemTutorialHoe(TutorialMaterials.TUTORIAL_TOOL, "hoeTutorial", "tutorial_hoe"),
				new ItemTutorialShovel(TutorialMaterials.TUTORIAL_TOOL, "shovelTutorial", "tutorial_shovel"),
				new ItemTutorialSword(TutorialMaterials.TUTORIAL_TOOL, "swordTutorial", "tutorial_sword"),
				new ItemTutorialArmor(TutorialMaterials.TUTORIAL_ARMOR, EntityEquipmentSlot.HEAD, "helmetTutorial", "tutorial_helmet"),
				new ItemTutorialArmor(TutorialMaterials.TUTORIAL_ARMOR, EntityEquipmentSlot.CHEST, "chestplateTutorial", "tutorial_chestplate"),
				new ItemTutorialArmor(TutorialMaterials.TUTORIAL_ARMOR, EntityEquipmentSlot.LEGS, "leggingsTutorial", "tutorial_leggings"),
				new ItemTutorialArmor(TutorialMaterials.TUTORIAL_ARMOR, EntityEquipmentSlot.FEET, "bootsTutorial", "tutorial_boots")
		};
		
		final Item[] itemBlocks = {
				new ItemBlock(TutorialBlocks.BASIC_BLOCK).setRegistryName(TutorialBlocks.BASIC_BLOCK.getRegistryName()),
				new ItemBlock(TutorialBlocks.TEST).setRegistryName(TutorialBlocks.TEST.getRegistryName()),
				new ItemBlock(TutorialBlocks.FAHRKARTENAUTOMAT_DB).setRegistryName(TutorialBlocks.FAHRKARTENAUTOMAT_DB.getRegistryName())
		};
		
		event.getRegistry().registerAll(items);
		event.getRegistry().registerAll(itemBlocks);
	}
	
}
