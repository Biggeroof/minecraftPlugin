package dev.cibmc.spigot.minecraftplugin.customRecipes;

import dev.cibmc.spigot.minecraftplugin.App;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class recipes 
{
    public static ShapelessRecipe sponge()
    {
        NamespacedKey key = new NamespacedKey(App.getPlugin(App.class), "crafting_bucket_wood_sponge");
        ShapelessRecipe spongeR = new ShapelessRecipe(key, new ItemStack(Material.SPONGE));
        spongeR.addIngredient(1, Material.WATER_BUCKET);
        spongeR.addIngredient(1, Material.WOODEN_AXE);
        return spongeR;
    }

}
