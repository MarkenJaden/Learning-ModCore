package net.landofrails.learningforge.proxy;

import net.landofrails.learningforge.LearningForge;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements IProxy {
	
	public void preInit(FMLPreInitializationEvent event) {

		OBJLoader.INSTANCE.addDomain(LearningForge.MODID);
		
	}

	public void init(FMLInitializationEvent event) {
		
	}

	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
