package me.topilov.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class DonateGUI implements CommandExecutor {

     public Inventory donate = Bukkit.getServer().createInventory(null, 9, "Донат-магазин");

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        if(cmd.getName().equalsIgnoreCase("donate")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "You cannot use this");
                return true;
            }

            Player player = (Player) sender;

            setItems();
            player.openInventory(donate);
        }
        return true;
    }















    void setItems () {
        ItemStack autosell = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta meta_autosell = autosell.getItemMeta();

        meta_autosell.setDisplayName(ChatColor.GREEN + "Автоматическая продажа");
        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add(ChatColor.WHITE + "Возможность автоматически продавать блоки в рюкзаке");
        lore.add(ChatColor.WHITE + "Стоимость: " + ChatColor.AQUA + "100 Кристаликов");

        meta_autosell.setLore(lore);
        autosell.setItemMeta(meta_autosell);
        donate.setItem(4, autosell);

        // SPEED
        ItemStack speed = new ItemStack(Material.MELON_SLICE);
        ItemMeta meta_speed = speed.getItemMeta();

        meta_speed.setDisplayName(ChatColor.AQUA + "Скорость");
        List<String> lore2 = new ArrayList<>();

        lore2.add("");
        lore2.add(ChatColor.WHITE + "Эффект скорости х10");
        lore2.add(ChatColor.WHITE + "Стоимость: " + ChatColor.AQUA + "100 Кристаликов");

        meta_speed.setLore(lore2);
        speed.setItemMeta(meta_speed);
        donate.setItem(3, speed);

        // SUPER PICKAXE
        ItemStack pickaxe = new ItemStack(Material.GOLDEN_PICKAXE);
        ItemMeta itemMeta = pickaxe.getItemMeta();

        itemMeta.setDisplayName(ChatColor.GOLD + "Супер Кирка");
        List<String> lore3 = new ArrayList<>();

        lore3.add("");
        lore3.add(ChatColor.WHITE + "Супер кирка, которая дает уникальные способности");
        lore3.add(ChatColor.WHITE + "Стоимость: " + ChatColor.AQUA + "100 Кристаликов");

        itemMeta.addEnchant(Enchantment.DIG_SPEED, 300, true);
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.setLore(lore3);
        pickaxe.setItemMeta(itemMeta);
        donate.setItem(2, pickaxe);
    }
}