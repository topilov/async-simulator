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

public class TridentGod implements CommandExecutor {
    public TridentGod(MainPlugin mainPlugin) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("boost")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "You cannot use this command");
                return true;
            }

            Player player = (Player) sender;
            if (player.getInventory().firstEmpty() == -1) {
                Location loc  = player.getLocation();
                World world = player.getWorld();

                world.dropItemNaturally(loc, getItem());
                player.sendMessage(ChatColor.GOLD + "Инвентарь был полон поэтому предмет был брошен");
                return true;
            }
            player.getInventory().addItem(getItem());
            player.sendMessage(ChatColor.GOLD + "Выдан требзубец");
            return false;
        }
        return false;
    }


    public ItemStack getItem() {

        ItemStack item = new ItemStack(Material.TRIDENT);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.GREEN + "Требзубец бога");
        List<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add(ChatColor.GOLD + "(ПКМ) Спавн зомби");
        lore.add(ChatColor.GOLD + "(ЛКМ) Фаербол");
        meta.setLore(lore);

        meta.addEnchant(Enchantment.LOYALTY, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);

        item.setItemMeta(meta);

        return item;

    }
}