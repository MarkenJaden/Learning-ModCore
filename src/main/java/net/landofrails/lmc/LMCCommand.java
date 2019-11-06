package net.landofrails.lmc;

import cam72cam.mod.text.Command;
import cam72cam.mod.text.PlayerMessage;
import cam72cam.mod.world.World;

import java.util.function.Consumer;

public class LMCCommand extends Command {

    @Override
    public String getPrefix(){
        return LearningModCore.MODID;
    }
    @Override
    public String getUsage(){
        return "Dieser Command kann nichts!";
    }

    @Override
    public boolean opRequired() {
        return false;
    }

    @Override
    public boolean execute(World world, Consumer<PlayerMessage> sender, String[] args){
        if (args.length != 1){
            return false;
        }
        if (args[0].equals("geheim")){
            LearningModCore.warn("Oh mein Gott, jemand hat diesen geheimen Befehl gefunden!");
            return true;
        } return false;
    }
}
