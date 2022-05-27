package me.topilov.GUI;

import me.topilov.App;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class MenuGUI implements CommandExecutor {

    ItemStack upgradeItem = new ItemStack(Material.LIME_CONCRETE);

    Inventory menu = Bukkit.getServer().createInventory(null, 45, "Меню");

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {

        if(cmd.getName().equalsIgnoreCase("menu")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }
            Player player = (Player) sender;

            setMeta();

            menu.setItem(16, upgradeItem);
            player.openInventory(menu);
        }
        return true;
    }














    public void setMeta() {
        ItemMeta itemMeta = upgradeItem.getItemMeta();
        ArrayList<String> lore_upgrade = new ArrayList<>();

        lore_upgrade.add("");
        lore_upgrade.add("§e§lНажми");
        itemMeta.setLore(lore_upgrade);
        itemMeta.setDisplayName("§cУлучшение вещей");

        upgradeItem.setItemMeta(itemMeta);
    }
}
