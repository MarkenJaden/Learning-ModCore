package net.landofrails.lmc;

import cam72cam.mod.ModCore;
import cam72cam.mod.ModEvent;
import cam72cam.mod.text.Command;
import net.landofrails.lmc.commands.CommandTest;

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
        return MODID;
    }

    @Override
    public void commonEvent(ModEvent event) {
        switch (event){
            case CONSTRUCT:
                LMCItems.register();
                LMCBlocks.register();
                //Commands
                Command.register(new CommandTest());
                break;

            case INITIALIZE:
                break;

            case FINALIZE:
                break;
        }
    }

    @Override
    public void clientEvent(ModEvent event) {

    }

    @Override
    public void serverEvent(ModEvent event) {

    }
}

