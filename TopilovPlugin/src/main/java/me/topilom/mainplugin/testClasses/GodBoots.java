package me.topilom.mainplugin.testClasses;

import me.topilom.mainplugin.MainPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GodBoots implements CommandExecutor {
    public GodBoots(MainPlugin mainPlugin) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("godboots")) {
            if (!(sender instanceof Player)) return true;

            Player player = (Player) sender;
            if (player.getInventory().firstEmpty() == -1) {
                Location loc  = player.getLocation();
                World world = player.getWorld();

                world.dropItemNaturally(loc, getItem());
                player.sendMessage(ChatColor.GOLD + "Инвентарь был полон поэтому предмет был брошен");
                return true;
            }
            player.getInventory().addItem(getItem());
            player.sendMessage(ChatColor.GOLD + "Выданы ботинки бога");
            return true;
        }
        return true;
    }


    public ItemStack getItem() {

        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = boots.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + "Ботинки для прыжков");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.GOLD + "Ботинки");
        meta.setLore(lore);

        meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);

        boots.setItemMeta(meta);

        return boots;

    }
}
