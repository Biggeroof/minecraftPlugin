package dev.cibmc.spigot.minecraftplugin.LuckyBlocks;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;

public class LuckyBlockListen implements Listener
{
    String[] enchs = {"ENCHANTMENT.DAMAGE_ALL", "ENCHANTMENT.DURABILITY", "ENCHANTMENT.DAMAGE_ARTHOPODS", "ENCHANTMENT.DAMAGE_UNDEAD", "ENCHANTMENT.LOOT_BONUS_MOBS", "ENCHANTMENT.FIRE_ASPECT", "ENCHANTMENT.MENDING"};
    
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
            case 3:
                location.getBlock().setType(Material.TNT);
                Location fire = event.getBlock().getLocation().add(0, 1, 0);
                fire.getBlock().setType(Material.FIRE);
                
        }
    }

    public void addEnch(ItemStack stack)
    {
        ArrayList<Integer> addedEnch = new ArrayList<>();
        for(int i = 0; i < 3; i++)
        {
            Random rand = new Random();
            int randEnch = rand.nextInt(6);
            int level = rand.nextInt(5) + 1;
            while(addedEnch.contains(randEnch))
            {
                randEnch = rand.nextInt(6);
            }
            addedEnch.add(randEnch);
            if(enchs[randEnch].equals("ENCHANTMENT.FIRE_ASPECT"))
            {
                level = rand.nextInt(2) + 1;
                stack.addEnchantment(Enchantment.getByName(enchs[randEnch]), level);
            }
            else if(enchs[randEnch].equals("ENCHANTMENT.MENDING"))
            {
                stack.addEnchantment(Enchantment.getByName(enchs[randEnch]), 1);
            }
            else
            {
                stack.addEnchantment(Enchantment.getByName(enchs[randEnch]), level);
            }
        }
    }
}
