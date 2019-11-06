package net.landofrails.lmc;

import cam72cam.mod.ModCore;
import cam72cam.mod.ModEvent;

@net.minecraftforge.fml.common.Mod(modid = LearningModCore.MODID, name = LearningModCore.NAME, version = LearningModCore.VERSION, dependencies = "required-before:modcore", acceptedMinecraftVersions = "[1.12,1.13)")
public class LearningModCore extends ModCore.Mod {
    public static final String MODID = "lmc";
    public static final String NAME = "LearningModCore";
    public static final String VERSION = "0.0.1";

    static {
        try {
            Class<ModCore.Mod> cls = (Class<ModCore.Mod>) Class.forName("net.landofrails.lmc.LearningModCore");
            ModCore.register(() -> {
                try {
                    return cls.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException("Could not construct mod " + MODID, e);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("Could not load mod " + MODID, e);
        }
    }

    @Override
    public String modID() {
        return null;
    }

    @Override
    public void commonEvent(ModEvent event) {

    }

    @Override
    public void clientEvent(ModEvent event) {

    }

    @Override
    public void serverEvent(ModEvent event) {

    }
}

