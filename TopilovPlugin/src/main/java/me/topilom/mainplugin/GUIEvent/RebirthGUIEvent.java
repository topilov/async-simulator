package me.topilom.mainplugin.GUIEvent;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RebirthGUIEvent implements Listener {
    @EventHandler
    public void OnItemDrag(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();

        if (inventory.getTitle().contains("Перерождение")) {
            if (clicked.getType() == Material.PINK_CONCRETE) {
                player.chat("/rebirth create");
                player.closeInventory();
            }
        }
    }
}
