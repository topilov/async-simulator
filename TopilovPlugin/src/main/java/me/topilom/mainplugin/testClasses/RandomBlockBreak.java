package me.topilom.mainplugin.testClasses;

import me.topilom.mainplugin.MainPlugin;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Random;

public class RandomBlockBreak implements Listener {

    MainPlugin main;

    public RandomBlockBreak(MainPlugin main) {
        this.main = main;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        main.getConfig().getConfigurationSection("blocks").getKeys(false).forEach(key -> {
            // sandstone
            if (key.equalsIgnoreCase(event.getBlock().getType().toString())) {
                ItemStack[] items = new ItemStack[main.getConfig().getStringList("blocks." + key).size()];
                ItemStack item = null;
                int position = 0;
                Random r = new Random();
                for (String i: main.getConfig().getStringList("blocks." + key)) {
                    // DIRT DIR
                    try {
                        item = new ItemStack(Objects.requireNonNull(Material.matchMaterial(i)), r.nextInt(16) + 1)  ;
                    } catch (Exception e) {
                        item = new ItemStack(Objects.requireNonNull(Material.matchMaterial(key)));
                    }
                    items[position] = item;
                    position++;
                }
                int num = r.nextInt(items.length);
                event.setDropItems(false);
                World world = event.getPlayer().getWorld();
                world.dropItemNaturally(event.getBlock().getLocation(), items[num]);
            }
        });
    }
}
