package me.topilom.mainplugin.testClasses;

import me.topilom.mainplugin.MainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ChangeTeamGUI implements CommandExecutor {

    public Inventory inv;

    public ChangeTeamGUI(MainPlugin mainPlugin) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("changeteam")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }
                Player player = (Player) sender;

                inv = Bukkit.createInventory(null, 9, "Выбор команды");

                ItemStack item = new ItemStack(Material.BLUE_CONCRETE);
                ItemMeta meta = item.getItemMeta();

                //BLUE TEAM
                meta.setDisplayName(ChatColor.DARK_BLUE + "BLUE TEAM");
                List<String> lore = new ArrayList<String>();
                lore.add(ChatColor.GRAY + "Нажми чтобы присоедениться к команде");
                meta.setLore(lore);
                item.setItemMeta(meta);
                inv.setItem(0, item);

                // RED TEAM
                item.setType(Material.RED_CONCRETE);
                meta.setDisplayName(ChatColor.DARK_RED + "RED TEAM");
                item.setItemMeta(meta);
                inv.setItem(1, item);

                // GREEN TEAM
                item.setType(Material.LIME_CONCRETE);
                meta.setDisplayName(ChatColor.GREEN + "GREEN TEAM");
                item.setItemMeta(meta);
                inv.setItem(2, item);

                // ORANGE TEAM
                item.setType(Material.ORANGE_CONCRETE);
                meta.setDisplayName(ChatColor.GOLD + "ORANGE TEAM");
                item.setItemMeta(meta);
                inv.setItem(3, item);

                // PURPLE TEAM
                item.setType(Material.PURPLE_CONCRETE);
                meta.setDisplayName(ChatColor.DARK_PURPLE + "PURPLE TEAM");
                item.setItemMeta(meta);
                inv.setItem(4, item);

                // CYAN TEAM
                item.setType(Material.CYAN_CONCRETE);
                meta.setDisplayName(ChatColor.BLUE + "CYAN TEAM");
                item.setItemMeta(meta);
                inv.setItem(5, item);

                // BLACK TEAM
                item.setType(Material.BLACK_CONCRETE);
                meta.setDisplayName(ChatColor.DARK_GRAY + "BLACK TEAM");
                item.setItemMeta(meta);
                inv.setItem(6, item);

                // CLOSE BUTTON
                item.setType(Material.BARRIER);
                meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Закрыть меню");
                lore.clear();
                meta.setLore(lore);
                item.setItemMeta(meta);
                inv.setItem(8, item);

                //open the GUI
                player.openInventory(inv);
                return true;

            }
        return true;
    }
    }
