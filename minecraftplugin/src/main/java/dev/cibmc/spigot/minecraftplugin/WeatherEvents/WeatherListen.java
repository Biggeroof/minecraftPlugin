package dev.cibmc.spigot.minecraftplugin.WeatherEvents;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WeatherListen implements Listener
{
    
    public static void checkPlayers() {
        Random rand = new Random();
        for(Player p : Bukkit.getOnlinePlayers()) {
            if(p.getLocation().getWorld().isThundering() || p.getLocation().getWorld().hasStorm()) {
                int blockLocation = p.getLocation().getWorld().getHighestBlockYAt(p.getLocation());
                if(blockLocation <= p.getLocation().getY()){
                    if(rand.nextInt(5) == 1)
                    {
                        p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20, 1));
                    }
                }
            }
        }
    }
}
