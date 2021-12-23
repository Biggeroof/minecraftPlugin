package dev.cibmc.spigot.minecraftplugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener
{
    @EventHandler
    public void playerJoin(PlayerJoinEvent event)
    {
        Bukkit.broadcastMessage("Aye, " + event.getPlayer().getName() + " has logged in!");
    }
    
    @EventHandler
    public void playerLeave(PlayerQuitEvent event) 
    {
        Bukkit.broadcastMessage(event.getPlayer().getName() + " has dcd");
    }
}
