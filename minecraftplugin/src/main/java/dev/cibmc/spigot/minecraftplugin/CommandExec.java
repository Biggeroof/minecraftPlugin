package dev.cibmc.spigot.minecraftplugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandExec implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        
        if (sender instanceof Player) {
            if(cmd.getName().equalsIgnoreCase("testitem"))
            {
                            Player player = (Player) sender;

            ItemStack bucket = new ItemStack(Material.BUCKET, 10);

            player.getInventory().addItem(bucket);
            return true;
            }
        }
        else
        {
            sender.sendMessage("This doesent work in console");
        }

        if(cmd.getName().equalsIgnoreCase("test"))
        {
            sender.sendMessage("yay it works");
            return true;
        }
        return false;
    }
}
