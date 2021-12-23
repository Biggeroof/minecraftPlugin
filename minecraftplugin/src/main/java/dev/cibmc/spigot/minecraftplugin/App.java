package dev.cibmc.spigot.minecraftplugin;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {
    @Override
    public void onEnable() 
    {
        getLogger().info("Hello, SpigotMC!");
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        this.getCommand("test").setExecutor(new CommandExec());
        this.getCommand("testItem").setExecutor(new CommandExec());
        
    }

    @Override
    public void onDisable() 
    {
        getLogger().info("See you again, SpigotMC!");
    }
}
