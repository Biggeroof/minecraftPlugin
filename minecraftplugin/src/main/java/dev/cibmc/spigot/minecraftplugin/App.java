package dev.cibmc.spigot.minecraftplugin;
import org.bukkit.plugin.java.JavaPlugin;

import dev.cibmc.spigot.minecraftplugin.LuckyBlocks.LuckyBlockListen;

public class App extends JavaPlugin {
    @Override
    public void onEnable() 
    {
        getLogger().info("Hello, SpigotMC!");
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new LuckyBlockListen(), this);
        this.getCommand("test").setExecutor(new CommandExec());
        this.getCommand("testItem").setExecutor(new CommandExec());
        
    }

    @Override
    public void onDisable() 
    {
        getLogger().info("See you again, SpigotMC!");
    }
}
