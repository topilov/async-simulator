package me.topilov.GUIEvent;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class MenuGUIEvent implements Listener {

    @Deprecated
    @EventHandler
    public void onItemDrag (InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        Inventory inventory = e.getInventory();

        if(inventory.getTitle().contains("Меню")) {
            if (clicked == null) return;
            if(clicked.getType() == Material.LIME_CONCRETE) {
                player.closeInventory();
                player.chat("/upgrade");
            }
            if(clicked.getType() == Material.YELLOW_CONCRETE) {
                player.closeInventory();
                player.chat("/rebirth");
            }
            if(clicked.getType() == Material.PURPLE_CONCRETE) {
                player.closeInventory();
                player.chat("/locations");
            }
        }
    }
}

