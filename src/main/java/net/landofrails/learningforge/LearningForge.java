package net.landofrails.learningforge;

import net.landofrails.learningforge.world.gen.TutorialWorldGen;
import org.apache.logging.log4j.Logger;

import net.landofrails.learningforge.proxy.IProxy;
import net.landofrails.learningforge.recipes.TutorialRecipes;
import net.landofrails.learningforge.tabs.LearnTab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = LearningForge.MODID, name = LearningForge.NAME, version = LearningForge.VERSION, acceptedMinecraftVersions = LearningForge.MC_VERSION)
public class LearningForge {
	
	public static final String MODID = "learningforge";
	public static final String NAME = "LearningForge Mod";
	public static final String VERSION = "0.0.5";
	public static final String MC_VERSION = "[1.12.2]";
	
	public static final String CLIENT = "net.landofrails.learningforge.proxy.ClientProxy";
	public static final String SERVER = "net.landofrails.learningforge.proxy.ServerProxy";
	
	public static final CreativeTabs LEARN_TAB = new LearnTab("tabLearningForge");
	
	@SidedProxy(clientSide = LearningForge.CLIENT, serverSide = LearningForge.SERVER)
	public static IProxy proxy;
	
	public static Logger logger;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
		TutorialRecipes.initSmelting();
		GameRegistry.registerWorldGenerator(new TutorialWorldGen(), 0);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
	
}
