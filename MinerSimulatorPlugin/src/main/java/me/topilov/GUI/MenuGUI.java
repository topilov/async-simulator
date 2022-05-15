package me.topilov.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class MenuGUI implements CommandExecutor {
    public ItemStack upgradeItem = new ItemStack(Material.LIME_CONCRETE);
    public ItemStack rebirthItem = new ItemStack(Material.YELLOW_CONCRETE);
    public ItemStack locationsItem = new ItemStack(Material.PURPLE_CONCRETE);

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command cmd, @Nonnull String label, @Nonnull String[] args) {
        if(cmd.getName().equalsIgnoreCase("menu")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.DARK_RED + "В консоли нельзя использовать эту команду");
                return true;
            }

            Player player = (Player) sender;
            Inventory menu = Bukkit.getServer().createInventory(null, 45, "Меню");
            ArrayList<String> lore_upgrade = new ArrayList<>();
            ArrayList<String> lore_locations = new ArrayList<>();
            ArrayList<String> lore_rebirth = new ArrayList<>();

            // NEW SLOT
            ItemMeta metaref_upgrade = upgradeItem.getItemMeta();

            lore_upgrade.add("");
            lore_upgrade.add("§e§lНажми");
            metaref_upgrade.setLore(lore_upgrade);
            metaref_upgrade.setDisplayName("§cУлучшение вещей");

            metaref_upgrade.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

            upgradeItem.setItemMeta(metaref_upgrade);
            menu.setItem(16, upgradeItem);

            //NEW SLOT
            ItemMeta metaref_rebirth = rebirthItem.getItemMeta();


            lore_rebirth.add("");
            lore_rebirth.add("§e§lНажми");
            metaref_rebirth.setLore(lore_rebirth);
            metaref_rebirth.setDisplayName("§cПерерождение");


            metaref_rebirth.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

            rebirthItem.setItemMeta(metaref_rebirth);
            menu.setItem(22, rebirthItem);

            //NEW SLOT
            ItemMeta metaref_locations = locationsItem.getItemMeta();


            lore_locations.add("");
            lore_locations.add("§e§lНажми");
            metaref_locations.setLore(lore_locations);
            metaref_locations.setDisplayName("§cЛокации");


            metaref_rebirth.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

            locationsItem.setItemMeta(metaref_locations);
            menu.setItem(10, locationsItem);

            player.openInventory(menu);
        }
        return true;
    }
}
