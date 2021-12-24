package dev.cibmc.spigot.minecraftplugin.LuckyBlocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LuckyBlockListen implements Listener
{
    String[] enchs = {"DAMAGE_ALL", "DURABILITY", "DAMAGE_ARTHOPODS", "DAMAGE_UNDEAD", "LOOT_BONUS_MOBS", "FIRE_ASPECT", "MENDING"};
    //String[] enchs = {"SHARPNESS", "UNBREAKING", "BANE_OF_ARTHOPODS", "SMITE", "LOOTING", "FIRE_ASPECT", "MENDING"};
    
    @EventHandler
    public void onBreak(BlockBreakEvent event)
    {
        if(event.getBlock().getType() != Material.SPONGE)
        {
            return;
        }
        Location location  = event.getBlock().getLocation().add(0.5, 0, 0.5);
        event.setCancelled(true);
        event.getBlock().setType(Material.AIR);

        int rand = new Random().nextInt(4);
        ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);

        switch(rand)
        {
            case 0:
                Villager villager = location.getWorld().spawn(location, Villager.class);
                Cow cow = location.getWorld().spawn(location, Cow.class);
                cow.setPassenger(villager);
                villager.setGravity(false);
                cow.setGravity(false);
                cow.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 40, 3));
                villager.setFireTicks(Integer.MAX_VALUE);
                break;
            case 1:
                addEnch(sword);
                location.getWorld().dropItemNaturally(location, sword);
                break;
            case 2:
                addEnch(sword);
                Zombie zombie = location.getWorld().spawn(location, Zombie.class);
                zombie.getEquipment().setItemInMainHand(sword);
                break;
            case 3:
                for(int i = 0; i < 5; i++)
                {
                    location.getWorld().spawn(location, Creeper.class);
                    location.getWorld().spawn(location, LightningStrike.class);
                }
                
                break;
                
        }
    }

    public void addEnch(ItemStack item) 
    {
        ArrayList<Enchantment> possible = new ArrayList<Enchantment>();
        Random rand = new Random();
     
        for (Enchantment ench : Enchantment.values()) 
        {
            if (ench.canEnchantItem(item)) 
            {
                possible.add(ench);
            }
        }
     
        for(int i = 0; i < 3; i++)
        {
            if (possible.size() >= 1) 
            {
            Collections.shuffle(possible);
            Enchantment chosen = possible.get(0);
            possible.remove(0);
            item.addEnchantment(chosen, rand.nextInt(chosen.getMaxLevel()) + 1);
        }
    }
    }
}
