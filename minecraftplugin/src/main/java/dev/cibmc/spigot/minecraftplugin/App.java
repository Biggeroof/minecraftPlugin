package dev.cibmc.spigot.minecraftplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import dev.cibmc.spigot.minecraftplugin.LuckyBlocks.LuckyBlockListen;
import dev.cibmc.spigot.minecraftplugin.QoL.QoLListeners;
import dev.cibmc.spigot.minecraftplugin.WeatherEvents.WeatherListen;
import dev.cibmc.spigot.minecraftplugin.customRecipes.recipes;

public class App extends JavaPlugin {
    @Override
    public void onEnable() 
    {
        getLogger().info("Hello, SpigotMC!");
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new LuckyBlockListen(), this);
        getServer().getPluginManager().registerEvents(new QoLListeners(), this);

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                WeatherListen.checkPlayers();
            }
        }, 20, 100);

        this.getCommand("test").setExecutor(new CommandExec());
        this.getCommand("testItem").setExecutor(new CommandExec());

        getServer().addRecipe(recipes.sponge());
        
    }

    @Override
    public void onDisable() 
    {
        getLogger().info("See you again, SpigotMC!");
    }
}
