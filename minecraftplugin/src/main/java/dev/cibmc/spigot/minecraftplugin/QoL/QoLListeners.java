package dev.cibmc.spigot.minecraftplugin.QoL;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class QoLListeners implements Listener
{
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) 
    {
        Player p = e.getEntity();
        double x = p.getLocation().getX();
        double y = p.getLocation().getY();
        double z = p.getLocation().getZ();
        p.sendMessage(ChatColor.GREEN + "Your Death Coordinates: " + ChatColor.RED + "X: " + x + " Y: " + y + " Z: " + z);
    }
}
