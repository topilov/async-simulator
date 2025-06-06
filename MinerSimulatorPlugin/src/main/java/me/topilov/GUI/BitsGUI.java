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

public class BitsGUI implements CommandExecutor {

    public ItemStack money = new ItemStack(Material.EMERALD);
    public ItemStack exp = new ItemStack(Material.EXPERIENCE_BOTTLE);
    public ItemStack blocks = new ItemStack(Material.GRASS_BLOCK);
    public ItemStack artefacts = new ItemStack(Material.GOLD_NUGGET);
    public Inventory bits = Bukkit.getServer().createInventory(null, 9, "Магазин за Битсы");

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        if (label.equalsIgnoreCase("bits")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }
            Player player = (Player) sender;

            setItems();
            player.openInventory(bits);

        }
        return true;
    }














    void setItems() {
        setItem("LocalMoneyBooster");
        setItem("LocalExpBooster");
        setItem("LocalBlocksBooster");
        setItem("LocalArtefactsBooster");
        setItem("GlobalMoneyBooster");
        setItem("GlobalExpBooster");
        setItem("GlobalBlocksBooster");
        setItem("GlobalArtefactsBooster");
    }
    void setItem(String index) {
        if (index.equalsIgnoreCase("LocalMoneyBooster")) {
            ItemMeta meta_money = money.getItemMeta();
            meta_money.setDisplayName(ChatColor.GREEN + "Локальный бустер Денег");
            List<String> lore2 = new ArrayList<>();
            lore2.add("");
            lore2.add(ChatColor.WHITE + "Бустер " + ChatColor.GREEN + "x2 Денег");
            lore2.add(ChatColor.WHITE + "Длительность: " + ChatColor.GRAY + "30 минут");
            lore2.add(ChatColor.WHITE + "Цена: " + ChatColor.LIGHT_PURPLE + "150 Битсов");

            meta_money.setLore(lore2);
            money.setItemMeta(meta_money);
            bits.setItem(0, money);
        }

        if (index.equalsIgnoreCase("LocalExpBooster")) {
            ItemMeta meta_exp = exp.getItemMeta();
            meta_exp.setDisplayName(ChatColor.AQUA + "Локальный бустер Опыта");
            List<String> lore = new ArrayList<>();
            lore.add("");
            lore.add(ChatColor.WHITE + "Бустер " + ChatColor.AQUA + "x2 Опыта");
            lore.add(ChatColor.WHITE + "Длительность: " + ChatColor.GRAY + "30 минут");
            lore.add(ChatColor.WHITE + "Цена: " + ChatColor.LIGHT_PURPLE + "150 Битсов");

            meta_exp.setLore(lore);
            exp.setItemMeta(meta_exp);
            bits.setItem(1, exp);
        }

        if (index.equalsIgnoreCase("LocalBlocksBooster")) {
            ItemMeta meta_blocks = blocks.getItemMeta();
            meta_blocks.setDisplayName(ChatColor.YELLOW + "Локальный бустер Блоков");
            List<String> lore3 = new ArrayList<>();
            lore3.add("");
            lore3.add(ChatColor.WHITE + "Бустер " + ChatColor.YELLOW + "x2 Блоков");
            lore3.add(ChatColor.WHITE + "Длительность: " + ChatColor.GRAY + "30 минут");
            lore3.add(ChatColor.WHITE + "Цена: " + ChatColor.LIGHT_PURPLE + "150 Битсов");

            meta_blocks.setLore(lore3);
            blocks.setItemMeta(meta_blocks);
            bits.setItem(2, blocks);
        }

        if (index.equalsIgnoreCase("LocalArtefactsBooster")) {
            ItemMeta meta_artefacts = artefacts.getItemMeta();
            meta_artefacts.setDisplayName(ChatColor.GOLD + "Локальный бустер Артефактов");
            List<String> lore4 = new ArrayList<>();
            lore4.add("");
            lore4.add(ChatColor.WHITE + "Бустер " + ChatColor.GOLD + "x2 Артефактов");
            lore4.add(ChatColor.WHITE + "Длительность: " + ChatColor.GRAY + "30 минут");
            lore4.add(ChatColor.WHITE + "Цена: " + ChatColor.LIGHT_PURPLE + "150 Битсов");

            meta_artefacts.setLore(lore4);
            artefacts.setItemMeta(meta_artefacts);
            bits.setItem(3, artefacts);
        }

        if (index.equalsIgnoreCase("GlobalMoneyBooster")) {
            ItemMeta meta_money = money.getItemMeta();
            meta_money.setDisplayName(ChatColor.GREEN + "Глобальный бустер Денег");
            meta_money.addEnchant(Enchantment.WATER_WORKER, 1, true);
            meta_money.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            List<String> lore5 = new ArrayList<>();
            lore5.add("");
            lore5.add(ChatColor.WHITE + "Бустер: " + ChatColor.GREEN + "x2 Денег");
            lore5.add(ChatColor.WHITE + "Длительность: " + ChatColor.GRAY + "30 минут");
            lore5.add(ChatColor.WHITE + "Цена: " + ChatColor.LIGHT_PURPLE + "150 Битсов");

            meta_money.setLore(lore5);
            money.setItemMeta(meta_money);
            bits.setItem(5, money);
        }

        if (index.equalsIgnoreCase("GlobalExpBooster")) {
            ItemMeta meta_exp = exp.getItemMeta();
            meta_exp.setDisplayName(ChatColor.AQUA + "Глобальный бустер Опыта");
            meta_exp.addEnchant(Enchantment.WATER_WORKER, 1, true);
            meta_exp.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            List<String> lore6 = new ArrayList<>();
            lore6.add("");
            lore6.add(ChatColor.WHITE + "Бустер: " + ChatColor.AQUA + "x2 Опыта");
            lore6.add(ChatColor.WHITE + "Длительность: " + ChatColor.GRAY + "30 минут");
            lore6.add(ChatColor.WHITE + "Цена: " + ChatColor.LIGHT_PURPLE + "150 Битсов");

            meta_exp.setLore(lore6);
            exp.setItemMeta(meta_exp);
            bits.setItem(6, exp);
        }

        if (index.equalsIgnoreCase("GlobalBlocksBooster")) {
            ItemMeta meta_blocks = blocks.getItemMeta();
            meta_blocks.setDisplayName(ChatColor.YELLOW + "Глобальный бустер Блоков");
            meta_blocks.addEnchant(Enchantment.WATER_WORKER, 1, true);
            meta_blocks.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            List<String> lore7 = new ArrayList<>();
            lore7.add("");
            lore7.add(ChatColor.WHITE + "Бустер: " + ChatColor.YELLOW + "x2 Блоков");
            lore7.add(ChatColor.WHITE + "Длительность: " + ChatColor.GRAY + "30 минут");
            lore7.add(ChatColor.WHITE + "Цена: " + ChatColor.LIGHT_PURPLE + "150 Битсов");

            meta_blocks.setLore(lore7);
            blocks.setItemMeta(meta_blocks);
            bits.setItem(7, blocks);
        }

        if (index.equalsIgnoreCase("GlobalArtefactsBooster")) {
            ItemMeta meta_artefacts = artefacts.getItemMeta();
            meta_artefacts.setDisplayName(ChatColor.GOLD + "Глобальный бустер Артефактов");
            meta_artefacts.addEnchant(Enchantment.WATER_WORKER, 1, true);
            meta_artefacts.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            List<String> lore8 = new ArrayList<>();
            lore8.add("");
            lore8.add(ChatColor.WHITE + "Бустер: " + ChatColor.GOLD + "x2 Артефактов");
            lore8.add(ChatColor.WHITE + "Длительность: " + ChatColor.GRAY + "30 минут");
            lore8.add(ChatColor.WHITE + "Цена: " + ChatColor.LIGHT_PURPLE + "150 Битсов");

            meta_artefacts.setLore(lore8);
            artefacts.setItemMeta(meta_artefacts);
            bits.setItem(8, artefacts);
        }
    }
}
